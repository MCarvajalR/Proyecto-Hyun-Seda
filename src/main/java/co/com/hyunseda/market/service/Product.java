package co.com.hyunseda.market.service;

import java.util.ArrayList;

/**
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public class Product {

    // slug es una babosa y si toca hacer una clase de eso
    // keywords preguntar si es lista(string) o clase  *
    // imagenes preguntar si va a hacer en clase
    // stock preguntar porque cada producto es unico
    // preguntar lo del producto en varias categorias
    // caracteristicas no es lo mismo que descripcion

    private String slug;
    
    private ArrayList<String> keywords; 
    
    private ArrayList<String> imagenes; 
    
    private int stock;
    
    private String caracteristicas;

    private Long productId;

    private String name;
    
    private String description;
    
    private double price;
    
    private Category category;
    
    private Location location;
    
    private User user;

    public Product(Long productId, String name, String description, double price) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

    public ArrayList<String> getImagenes() {
        return imagenes;
    }

    public void setImagenes(ArrayList<String> imagenes) {
        this.imagenes = imagenes;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
    


}
