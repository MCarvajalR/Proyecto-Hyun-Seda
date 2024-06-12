/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.service;

import co.com.hyunseda.market.access.IUserRepository;
import co.com.hyunseda.market.entities.Order;
import co.com.hyunseda.market.entities.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import co.com.hyunseda.market.access.IOrderRepository;
import co.com.hyunseda.market.request.LoginRequest;
import java.io.IOException;

/**
 *
 * @author usuario
 */
public class UserService {
    private IUserRepository reposity;

    public UserService(IUserRepository reposity) {
        this.reposity = reposity;
    }

    public boolean saveUser(User user) {
        boolean respuesta = reposity.create(user);
        /*
        if(respuesta){
            notifyAllObserves();
        }
         */
        return respuesta;
    }

    public List<User> findAllUser() {
        List<User> usuarios = new ArrayList<>();
        usuarios = reposity.findAll();

        return usuarios;
    }

    public Optional<User> findUserById(Long id) {
        return reposity.findById(id);
    }
    
    public String Login(String email, String password) throws IOException{
        LoginRequest request = new LoginRequest(email,password);
        return reposity.login(request);
        
    }
}
