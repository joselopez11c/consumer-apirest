package com.coderhouse.consumerapi.external;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UserRestApi {

    public List<String> getUsuarios() {
        RestTemplate restTemplate = new RestTemplate();
        final String url = "https://jsonplaceholder.typicode.com/users";
        return restTemplate.getForObject(url, List.class);
    }

    public List<String> getClientes() {
        RestTemplate restTemplate = new RestTemplate();
        final String url = "localhost:9080/clientes";
        return restTemplate.getForObject(url, List.class);
    }


    public String guardarUsuario(String user) {
        RestTemplate restTemplate = new RestTemplate();
        final String url = "https://jsonplaceholder.typicode.com/users";
        return restTemplate.postForObject(url, user, String.class);
    }

    public void modificarUsuario(String id, String user) {
        RestTemplate restTemplate = new RestTemplate();
        final String url = "https://jsonplaceholder.typicode.com/users";
        final String urlById = url + "/" + id;
        restTemplate.put(urlById, user);
    }

    public String getUserById(String id) {
        RestTemplate restTemplate = new RestTemplate();
        final String url = "https://jsonplaceholder.typicode.com/users";
        final String urlById = url + "/" + id;
        return restTemplate.getForObject(urlById, String.class);
    }
}
