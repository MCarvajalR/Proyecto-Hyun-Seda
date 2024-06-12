package co.com.hyunseda.market.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class User {
    private Long usuario_id;

    /** Nombre del usuario */
    private String name;

    /** Correo electrónico del usuario */
    private String email;

    /** Contraseña del usuario */
    private String password;
    
    private List<Rol> roles = new ArrayList<>();

    
    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
    
    

}
