/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.entities;

/**
 *
 * @author usuario
 */
public class Rol {
    private Long id_rol;
    private String name;

    public Long getId_rol() {
        return id_rol;
    }

    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rol(Long id_rol, String name) {
        this.id_rol = id_rol;
        this.name = name;
    }
    
    
}
