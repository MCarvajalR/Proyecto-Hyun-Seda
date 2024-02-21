package co.com.hyunseda.market.service;


import co.com.hyunseda.market.access.IProductRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public class ProductService {
    
    private IProductRepository repository;

    public ProductService(IProductRepository repository) { 
        this.repository = repository;
    }

    public boolean saveProduct(String name, String description, Long idCategory) {
        
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setDescription(description);
        Category newCategory = new Category();
        newCategory.setCategoryId(idCategory);
        newProduct.setCategory(newCategory);
        //Validate product
        if (newProduct.getName().isEmpty() ) {
            return false;
        }

        return repository.save(newProduct);

    }

    public List<Product> findAllProducts() {
        List<Product> products = new ArrayList<>();
        products = repository.findAll();

        return products;
    }
    
    public Product findProductById(Long id){
        return repository.findById(id);
    }
    
    public boolean deleteProduct(Long id){
        return repository.delete(id);
    }

    public boolean editProduct(Long productId, Product prod) {
        
        //Validate product
        if (prod == null || prod.getName().isEmpty() || prod.getCategory() == null ) {
            return false;
        }
        return repository.edit(productId, prod);
    }
    
    public Product findProductByName(String name) {
        return repository.findByName(name);
    }
    
    public List<Product> findProductsByCategory(Long categoryId) {
        List<Product> products = new ArrayList<>();
        products = repository.findByCategory(categoryId);

        return products;
    }
}
