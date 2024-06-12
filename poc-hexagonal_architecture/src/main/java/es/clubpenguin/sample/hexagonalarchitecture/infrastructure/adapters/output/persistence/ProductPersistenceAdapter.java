package es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence;

import es.clubpenguin.sample.hexagonalarchitecture.domain.exception.ResourceNotFoundException;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.entity.ProductEntity;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.mapper.ProductPersistenceMapper;
import es.clubpenguin.sample.hexagonalarchitecture.application.ports.output.ProductOutputPort;
import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Product;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.output.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductOutputPort {

    private final ProductRepository productRepository;

    private final ProductPersistenceMapper productPersistenceMapper;

    @Override
    public Product saveProduct(Product product) {
        ProductEntity productEntity = productPersistenceMapper.toProductEntity(product);

        productEntity = productRepository.save(productEntity);
        return productPersistenceMapper.toProduct(productEntity);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);

        if(productEntity.isEmpty()) {
            return Optional.empty();
        }

        Product product = productPersistenceMapper.toProduct(productEntity.get());
        return Optional.of(product);
    }

    @Override
    public List<Product> getAllProducts() {
        List<ProductEntity> allProducts = productRepository.findAll();

        List<Product> productFinal = pasaraProductos(allProducts);
        return productFinal;
    }

    @Override
    public List<Product> findByCategory(Long categoryId) {
        List<ProductEntity> allProducts = productRepository.findByCategoriesCategoryId(categoryId);

        List<Product> productFinal = pasaraProductos(allProducts);

        return productFinal;
    }

    @Override
    public Product EditProduct(Long id, Product product) {
        ProductEntity productEntity = productRepository.findById(id).orElse(null);
        if(productEntity==null) {
            throw  new ResourceNotFoundException("No se encontro el producto");
        }
        ProductEntity auxProduct = productPersistenceMapper.toProductEntity(product);
        productEntity.setName(auxProduct.getName());
        productEntity.setPrice(auxProduct.getPrice());
        productEntity.setDescription(auxProduct.getDescription());
        productEntity.setStock(auxProduct.getStock());
        productEntity.setKeyWords(auxProduct.getKeyWords());
        productEntity.setCharacteristics(auxProduct.getCharacteristics());
        productEntity.setUrlImagen(auxProduct.getUrlImagen());
        productEntity.setCategories(auxProduct.getCategories()); // Asegúrate de que ProductEntity tenga este método
        productEntity = productRepository.save(productEntity);
        return productPersistenceMapper.toProduct(productEntity);
    }

    public List<Product> pasaraProductos(List<ProductEntity> allProducts) {
        List<Product> products = new ArrayList<>();
        for(ProductEntity i:allProducts){
            products.add(productPersistenceMapper.toProduct(i));
        }
        return products;
    }


}
