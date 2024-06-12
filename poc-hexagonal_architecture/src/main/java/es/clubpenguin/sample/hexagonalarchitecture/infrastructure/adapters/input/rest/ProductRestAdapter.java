package es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.input.rest;

import es.clubpenguin.sample.hexagonalarchitecture.application.ports.input.*;
import es.clubpenguin.sample.hexagonalarchitecture.domain.exception.ResourceNotFoundException;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.input.rest.data.request.ProductCreateRequest;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.input.rest.data.response.ProductCreateResponse;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.input.rest.data.response.ProductQueryResponse;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.input.rest.mapper.ProductRestMapper;
import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ProductRestAdapter {

    private final CreateProductUseCase createProductUseCase;

    private final GetProductUseCase getProductUseCase;

    private final GetAllProductUseCase getAllProductUseCase;

    private final GetProductsByCategoryUseCase getProductsByCategoryUseCase;

    private final ProductRestMapper productRestMapper;

    private final EditProductUseCase editProductUseCase;

    /**
     * Listar todos
     *
     * @return listado de productos en json
     */
    @GetMapping(value = "/products", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<ProductQueryResponse>> findAll() {
        List<Product> products = getAllProductUseCase.getAllProducts();
        List<ProductQueryResponse> responseList = products.stream()
                .map(productRestMapper::toProductQueryResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }


    @PostMapping(value = "/products")
    public ResponseEntity<ProductCreateResponse> createProduct(@RequestBody @Valid ProductCreateRequest productCreateRequest){
        // Request to domain
        Product product = productRestMapper.toProduct(productCreateRequest);
        product = createProductUseCase.createProduct(product);

        // Domain to response
        return new ResponseEntity<>(productRestMapper.toProductCreateResponse(product), HttpStatus.CREATED);
    }

    @GetMapping(value = "/products/{id}")
    public ResponseEntity<ProductQueryResponse> getProduct(@PathVariable Long id){
        Product product = getProductUseCase.getProductById(id);
        return new ResponseEntity<>(productRestMapper.toProductQueryResponse(product), HttpStatus.OK);
    }

    /**
     * Buscar productos por ID de categoría
     *
     * @param categoryId ID de la categoría
     * @return Lista de productos en formato JSON
     */
    @GetMapping("/products/category/{categoryId}")
    public ResponseEntity<List<ProductQueryResponse>> findProductsByCategory(@PathVariable Long categoryId) {
        List<Product> products = getProductsByCategoryUseCase.findByCategory(categoryId);
        List<ProductQueryResponse> responseList = products.stream()
                .map(productRestMapper::toProductQueryResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }
    /**
     * Editar
     *
     * @param product Producto a editar
     * @param product_id      identificador del producto
     * @return producto editado
     * @throws ResourceNotFoundException recurso no encontrado
     * @throws Exception                 Id no encontrado
     */
    @RequestMapping(value = "/products/{product_id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public ResponseEntity<ProductCreateResponse> update(@RequestBody Product product, @PathVariable Long product_id)
            throws ResourceNotFoundException {
        product = editProductUseCase.EditProduct(product_id, product);
        return new ResponseEntity<>(productRestMapper.toProductCreateResponse(product), HttpStatus.CREATED);
    }

}
