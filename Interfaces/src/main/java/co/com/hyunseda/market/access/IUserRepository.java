/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.hyunseda.market.access;

import co.com.hyunseda.market.entities.Order;
import co.com.hyunseda.market.entities.User;
import co.com.hyunseda.market.request.LoginRequest;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author usuario
 */
public interface IUserRepository {
    public List<User> findAll();
    public Optional<User> findById(Long id);
    public boolean create(User user);
    public void delete(Long id);
    public String login(LoginRequest loginRequest) throws IOException;
    
}
