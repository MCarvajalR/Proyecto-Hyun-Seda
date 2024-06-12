package es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.input.rest;

import es.clubpenguin.sample.hexagonalarchitecture.application.ports.input.CreateCategoryUseCase;
import es.clubpenguin.sample.hexagonalarchitecture.application.ports.input.GetAllCategoryUseCase;
import es.clubpenguin.sample.hexagonalarchitecture.application.ports.input.GetCategoryUseCase;
import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Category;
import es.clubpenguin.sample.hexagonalarchitecture.domain.model.Product;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.input.rest.data.request.CategoryCreateRequest;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.input.rest.data.response.CategoryCreateResponse;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.input.rest.data.response.CategoryQueryResponse;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.input.rest.data.response.ProductQueryResponse;
import es.clubpenguin.sample.hexagonalarchitecture.infrastructure.adapters.input.rest.mapper.CategoryRestMapper;
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
public class CategoryRestAdapter {

    private final CreateCategoryUseCase createCategoryUseCase;

    private final GetCategoryUseCase getCategoryUseCase;

    private final GetAllCategoryUseCase getAllCategoryUseCase;

    private final CategoryRestMapper categoryRestMapper;

    /**
     * Listar todos
     *
     * @return listado de productos en json
     */
    @GetMapping(value = "/categories", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<CategoryQueryResponse>> findAll() {
        List<Category> categories = getAllCategoryUseCase.getAllCategories();
        List<CategoryQueryResponse> responseList = categories.stream()
                .map(categoryRestMapper::toCategoryQueryResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @PostMapping(value = "/categories")
    public ResponseEntity<CategoryCreateResponse> createCategory(@RequestBody @Valid CategoryCreateRequest categoryCreateRequest){
        // Request to domain
        Category category = categoryRestMapper.toCategory(categoryCreateRequest);

        category = createCategoryUseCase.createCategory(category);

        // Domain to response
        return new ResponseEntity<>(categoryRestMapper.toCategoryCreateResponse(category), HttpStatus.CREATED);
    }

    @GetMapping(value = "/categories/{id}")
    public ResponseEntity<CategoryQueryResponse> getCategory(@PathVariable Long id){
        Category category = getCategoryUseCase.getCategoryById(id);
        return new ResponseEntity<>(categoryRestMapper.toCategoryQueryResponse(category), HttpStatus.OK);
    }

}
