/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.access;

import co.com.hyunseda.market.entities.User;
import co.com.hyunseda.market.request.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author usuario
 */
public class UserRepository implements IUserRepository {

    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<User> findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean create(User user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String login(LoginRequest loginRequest)throws IOException{
        String token = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Definir la URL de la API de login
            String loginUrl = "http://localhost:8001/auth/login";

            // Crear una solicitud POST
            HttpPost postRequest = new HttpPost(loginUrl);


 // Crear un objeto ObjectMapper de Jackson
            ObjectMapper objectMapper = new ObjectMapper();

            // Convertir el objeto a JSON
            String jsonRequest = objectMapper.writeValueAsString(loginRequest);

            // Configurar la entidad de la solicitud con el JSON
            StringEntity entity = new StringEntity(jsonRequest);
            postRequest.setEntity(entity);

            // Configurar las cabeceras de la solicitud
            postRequest.setHeader("Content-Type", "application/json");
            // Si es necesario, puedes configurar otras cabeceras aquí

            // Ejecutar la solicitud y obtener la respuesta
            HttpResponse response = httpClient.execute(postRequest);


            // Verificar el código de estado de la respuesta
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // La solicitud fue exitosa, procesar la respuesta
                String jsonResponse = EntityUtils.toString(response.getEntity());

                // Suponiendo que la respuesta tiene un campo 'token'
                token = mapper.readTree(jsonResponse).get("token").asText();
            } else {
                // La solicitud falló, mostrar el código de estado
                System.err.println("Error al hacer login. Código de estado: " + statusCode);
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                throw e;
            }
        }
        return token;
    }
    
}
