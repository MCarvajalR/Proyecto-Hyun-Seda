
package co.com.hyunseda.market.presentation;

import co.com.hyunseda.market.access.CategoryRepository;
import co.com.hyunseda.market.access.ProductRepository;
import co.com.hyunseda.market.service.Category;
import co.com.hyunseda.market.service.CategoryService;
import co.com.hyunseda.market.service.Product;
import co.com.hyunseda.market.service.ProductService;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que representa la aplicación de consola.
 */
public class Main {

    private ProductService productService;
    private CategoryService categoryService;

    public static void main(String[] args) {
        Main main = new Main();
        main.iniciarServicios();
        main.menuPrincipal();
    }

    public void iniciarServicios() {
        // Inicializar servicios y repositorios
        ProductRepository productRepository = new ProductRepository();
        productService = new ProductService(productRepository);

        CategoryRepository categoryRepository = new CategoryRepository();
        categoryService = new CategoryService(categoryRepository);
    }

    public void menuPrincipal() {
        int opcion;
        do {
            System.out.println("---------------------------------------\n");
            System.out.println("1. Gestionar productos");
            System.out.println("2. Gestionar categorías");
            System.out.println("3. Salir");
            opcion = InputUtil.getInt("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    gestionarProductos();
                    break;
                case 2:
                    gestionarCategorias();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 3);
    }

    public void gestionarProductos() {
        int opcion;
        do {
            System.out.println("---------------------------------------\n");
            System.out.println("Gestionando productos...");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar nuevo producto");
            System.out.println("2. Eliminar producto por ID");
            System.out.println("3. Editar producto");
            System.out.println("4. Encontrar Productos");
            System.out.println("0. Volver al menú principal");

            opcion = InputUtil.getInt("Ingrese el número de la opción que desea realizar: ");

            switch (opcion) {
                case 1:
                    registrarNuevoProducto();
                    break;
                case 2:
                    eliminarProductoPorId();
                    break;
                case 3:
                    editarProducto();
                    break;
                case 4:
                    encontrarProductos();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 0);
    }

    public void registrarNuevoProducto() {
        System.out.println("---------------------------------------\n");
        System.out.println("Registrando nuevo producto...");
        String nombre = InputUtil.getString("Ingrese el nombre del producto: ");
        String descripcion = InputUtil.getString("Ingrese la descripción del producto: ");
        long idCategoria = seleccionarCategoria();

        boolean registrado = productService.saveProduct(nombre, descripcion, idCategoria);
        if (registrado) {
            System.out.println("Producto registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el producto.");
        }
    }

    public Long seleccionarCategoria() {
        Long opcion;
        while (true) {
            List<Category> categories = categoryService.findAllCategories();
            System.out.println("---------------------------------------\n");
            categories = imprimirCategorias(categories);
            opcion = InputUtil.getLong("Ingrese el número de la opcion elegida: ");
            if (opcion > 0 && opcion < categories.size()) {
                break;
            } else if (opcion == categories.size()) {
                registrarCategoria();
            } else {
                System.out.println("Opcion invalida intente de nuevo");
            }
        }

        return opcion;
    }

    public List<Category> imprimirCategorias(List<Category> categories) {
        Category ultimaOpcion = new Category();
        ultimaOpcion.setName("Aniadir nueva categoria");

        if (categories.isEmpty()) {
            categories = new ArrayList<>();
            ultimaOpcion.setCategoryId(1L);
            System.out.println("No hay categorías registradas, debe registrar una nueva");
        } else {
            ultimaOpcion.setCategoryId((long) categories.size() + 1);
            System.out.println("Categorías disponibles:");

        }
        categories.add(ultimaOpcion);
        for (Category category : categories) {
            System.out.println(category.getCategoryId() + ". " + category.getName());
        }
        return categories;
    }

    public void eliminarProductoPorId() {
        System.out.println("---------------------------------------\n");
        System.out.println("Eliminar producto por ID...");
        long id = InputUtil.getLong("Ingrese el ID del producto que desea eliminar: ");
        boolean eliminado = productService.deleteProduct(id);
        if (eliminado) {
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el producto.");
        }
    }

    private void editarProducto() {
        long productId = InputUtil.getLong("Ingrese el ID del producto a editar: ");
        // Buscar el producto por su ID
        Product existingProduct = productService.findProductById(productId);
        if (existingProduct == null) {
            System.out.println("No se encontró ningún producto con ese ID.");
            return; // Salir del método si el producto no existe
        }
        String newName = InputUtil.getString("Ingrese el nuevo nombre del producto: ");
        String newDescription = InputUtil.getString("Ingrese la nueva descripción del producto: ");
        long idCategoria = seleccionarCategoria();
        // Crear un objeto Product con los datos ingresados
        Product updatedProduct = new Product();
        updatedProduct.setName(newName);
        updatedProduct.setDescription(newDescription);
        Category updatedCategory = new Category();
        updatedCategory.setCategoryId(idCategoria);
        updatedProduct.setCategory(updatedCategory);

        // Llamar a la función editProduct del servicio
        boolean success = productService.editProduct(productId, updatedProduct);

        if (success) {
            System.out.println("Producto editado correctamente.");
        } else {
            System.out.println("No se pudo editar el producto.");
        }
    }

    public void encontrarProductos() {
        int opcion;
        do {
            System.out.println("---------------------------------------\n");
            System.out.println("Buscar productos...");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Buscar producto por ID");
            System.out.println("2. Buscar producto por nombre");
            System.out.println("3. Buscar producto por categorias");
            System.out.println("4. Lista todos los productos");
            System.out.println("0. Volver al gestionar productos");

            opcion = InputUtil.getInt("Ingrese el número de la opción que desea realizar: ");

            switch (opcion) {
                case 1:
                    buscarProductoPorId();
                    break;
                case 2:
                    buscarProductoPorNombre();
                    break;
                case 3:
                    buscarProductosporCategoria();
                    break;
                case 4:
                    listarProductos();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 0);
    }

    private void buscarProductoPorId() {
        long productId = InputUtil.getLong("Ingrese el ID del producto a buscar: ");

        // Llamar a la función findProductById del servicio
        Product foundProduct = productService.findProductById(productId);

        if (foundProduct != null) {
            System.out.println("Producto encontrado:");
            System.out.println("ID: " + foundProduct.getProductId());
            System.out.println("Nombre: " + foundProduct.getName());
            System.out.println("Descripción: " + foundProduct.getDescription());
            System.out.println("Categoria: " + foundProduct.getCategory().getName());
        } else {
            System.out.println("No se encontró ningún producto con ese ID.");
        }
    }

    private void buscarProductoPorNombre() {
        String name = InputUtil.getString("Ingrese el nombre del producto a buscar: ");

        // Llamar a la función findProductById del servicio
        Product foundProduct = productService.findProductByName(name);

        if (foundProduct != null) {
            System.out.println("Producto encontrado:");
            System.out.println("ID: " + foundProduct.getProductId());
            System.out.println("Nombre: " + foundProduct.getName());
            System.out.println("Descripción: " + foundProduct.getDescription());
            System.out.println("Categoria: " + foundProduct.getCategory().getName());
        } else {
            System.out.println("No se encontró ningún producto con ese ID.");
        }
    }

    void buscarProductosporCategoria() {
        long idCategoria = seleccionarCategoria();
        List<Product> products = productService.findProductsByCategory(idCategoria);
        System.out.println("---------------------------------------\n");
        if (products.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            System.out.println("Lista de productos con la categoria " + idCategoria + " :");
            for (Product product : products) {
                System.out.println("ID: " + product.getProductId());
                System.out.println("Nombre: " + product.getName());
                System.out.println("Descripción: " + product.getDescription());
                System.out.println("ID Categoría: " + product.getCategory().getCategoryId());
                System.out.println("Categoría: " + product.getCategory().getName());
                System.out.println("----------------------------------------");
            }
        }
    }

    void listarProductos() {
        List<Product> products = productService.findAllProducts();
        System.out.println("---------------------------------------\n");
        if (products.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            System.out.println("Lista de productos:");
            for (Product product : products) {
                System.out.println("ID: " + product.getProductId());
                System.out.println("Nombre: " + product.getName());
                System.out.println("Descripción: " + product.getDescription());
                System.out.println("Categoría: " + product.getCategory().getName());
                System.out.println("----------------------------------------");
            }
        }
    }

    public void gestionarCategorias() {
        int opcion;
        do {
            System.out.println("---------------------------------------\n");
            System.out.println("Gestionando categorías...");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar nueva categoria");
            System.out.println("2. Eliminar categoria por ID");
            System.out.println("3. Editar categoria");
            System.out.println("4. Buscar  categoria por id");
            System.out.println("5. Listar todas las categorias");
            System.out.println("0. Volver al menú principal");

            opcion = InputUtil.getInt("Ingrese el número de la opción que desea realizar: ");

            switch (opcion) {
                case 1:
                    registrarCategoria();
                    break;
                case 2:
                    eliminarCategoria();
                    break;
                case 3:
                    editarCategoria();
                    break;
                case 4:
                    getCategoriaPorId();
                    break;
                case 5:
                    getTodasCategorias();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 0);
    }

    public void registrarCategoria() {
        System.out.println("---------------------------------------\n");
        System.out.println("Registrar una nueva categoría:");
        String nombreCategoria = InputUtil.getString("Ingrese el nombre de la categoría: ");

        if (categoryService.saveCategory(nombreCategoria)) {
            System.out.println("Categoría registrada correctamente.");
        } else {
            System.out.println("Error al registrar la categoría. Asegúrese de ingresar un nombre válido.");
        }
    }

    public void eliminarCategoria() {
        
        System.out.println("---------------------------------------\n");
        System.out.println("Eliminar categoria por ID...");
        Long categoryId = InputUtil.getLong("Ingrese el ID de la categoria que desea eliminar: ");
        boolean eliminada = categoryService.deleteCategory(categoryId);
        if (eliminada) {
            System.out.println("La categoría con ID " + categoryId + " ha sido eliminada correctamente.");
        } else {
            System.out.println("No se pudo eliminar la categoría con ID " + categoryId + ". Verifique que exista.");
        }
    }

    public void editarCategoria() {
        long categoryId = InputUtil.getLong("Ingrese el ID de la categoría a editar: ");
        // Buscar la categoría por su ID
        Category existingCategory = categoryService.findCategoryById(categoryId);
        if (existingCategory == null) {
            System.out.println("No se encontró ninguna categoría con ese ID.");
            return; // Salir del método si la categoría no existe
        }
        String newName = InputUtil.getString("Ingrese el nuevo nombre de la categoría: ");

        // Crear un objeto Category con el nuevo nombre
        Category updatedCategory = new Category();
        updatedCategory.setCategoryId(categoryId);
        updatedCategory.setName(newName);

        // Llamar a la función editCategory del servicio
        boolean success = categoryService.editCategory(categoryId, updatedCategory);

        if (success) {
            System.out.println("Categoría editada correctamente.");
        } else {
            System.out.println("No se pudo editar la categoría.");
        }
    }

    public void getCategoriaPorId() {
        long categoryId = InputUtil.getLong("Ingrese el ID de la categoría: ");
        // Buscar la categoría por su ID
        Category category = categoryService.findCategoryById(categoryId);
        if (category == null) {
            System.out.println("No se encontró ninguna categoría con ese ID.");
        } else {
            System.out.println("Categoría encontrada:");
            System.out.println("ID: " + category.getCategoryId());
            System.out.println("Nombre: " + category.getName());
        }
    }

    public void getTodasCategorias() {

        List<Category> categories = categoryService.findAllCategories();
        System.out.println("---------------------------------------\n");
        if (categories.isEmpty()) {
            System.out.println("No hay categorías registradas, debe registrar una nueva");
        } else {
            System.out.println("Categorías disponibles:");

        }
        for (Category category : categories) {
            System.out.println(category.getCategoryId() + ". " + category.getName());
        }
    }

}
