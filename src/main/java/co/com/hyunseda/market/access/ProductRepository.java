package co.com.hyunseda.market.access;

import co.com.hyunseda.market.service.Category;
import co.com.hyunseda.market.service.Product;
import co.com.hyunseda.market.service.ProductService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JUAN CARLOS MELO
 */
public class ProductRepository implements IProductRepository {

    private Connection conn;

    public ProductRepository() {
        try {

            conn = DatabaseConnection.getConnection();
            initDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean save(Product newProduct) {
        try {
            if (newProduct == null || newProduct.getName().isEmpty() || newProduct.getCategory() == null) {
                return false;
            }

            String sql = "INSERT INTO products (name, description, categoryId) VALUES (?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newProduct.getName());
            pstmt.setString(2, newProduct.getDescription());

            pstmt.setInt(3, newProduct.getCategory().getCategoryId().intValue());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT p.*, c.name AS category_name FROM products p LEFT JOIN categories c ON p.categoryId = c.categoryId";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                // Crear un objeto Product y agregarlo a la lista
                Product product = new Product();
                product.setProductId(rs.getLong("productId"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));

                // Crear un objeto Category y establecer su ID y nombre
                Category category = new Category();
                category.setName(rs.getString("category_name"));

                // Establecer la categoría del producto
                product.setCategory(category);

                products.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    @Override
    public boolean edit(Long id, Product product) {
        try {
            if (id <= 0 || product == null || product.getName().isEmpty() || product.getCategory() == null) {
                return false;
            }

            String sql = "UPDATE products SET name=?, description=?, categoryId=? WHERE productId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getDescription());
            pstmt.setLong(3, product.getCategory().getCategoryId());
            pstmt.setLong(4, id);
            pstmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            //Validate product
            if (id <= 0) {
                return false;
            }
            //this.connect();

            String sql = "DELETE FROM products "
                    + "WHERE productId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Product findById(Long id) {
        try {
            String sql = "SELECT p.*, c.name AS category_name FROM products p LEFT JOIN categories c ON p.categoryId = c.categoryId WHERE p.productId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                Product product = new Product();
                product.setProductId(res.getLong("productId"));
                product.setName(res.getString("name"));
                product.setDescription(res.getString("description"));
                // Obtener el nombre de la categoría del producto
                String categoryName = res.getString("category_name");
                Category category = new Category();
                category.setName(categoryName);
                product.setCategory(category);
                return product;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Product findByName(String name) {
        try {
            String sql = "SELECT p.*, c.name AS category_name FROM products p LEFT JOIN categories c ON p.categoryId = c.categoryId WHERE p.name = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                Product product = new Product();
                product.setProductId(res.getLong("productId"));
                product.setName(res.getString("name"));
                product.setDescription(res.getString("description"));
                // Obtener el nombre de la categoría del producto
                String categoryName = res.getString("category_name");
                Category category = new Category();
                category.setName(categoryName);
                product.setCategory(category);
                return product;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Product> findByCategory(Long categoryId) {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT p.*, c.name AS category_name FROM products p LEFT JOIN categories c ON p.categoryId = c.categoryId WHERE c.categoryId = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, categoryId);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getLong("productId"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));

                // Crear un objeto Category y establecer su ID y nombre
                Category category = new Category();
                category.setCategoryId(rs.getLong("categoryId"));
                category.setName(rs.getString("category_name"));

                // Establecer la categoría del producto
                product.setCategory(category);

                products.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    private void initDatabase() {
        try {
            createCategoryTable();
            createProductTable();
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createCategoryTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS categories ("
                + "categoryId INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT NOT NULL"
                + ")";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    private void createProductTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS products ("
                + "productId INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT NOT NULL,"
                + "description TEXT NULL,"
                + "categoryId INTEGER NOT NULL,"
                + "FOREIGN KEY (categoryId) REFERENCES categories(categoryId)"
                + ")";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
