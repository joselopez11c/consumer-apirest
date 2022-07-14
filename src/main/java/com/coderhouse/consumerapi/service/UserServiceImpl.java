package com.coderhouse.consumerapi.service;

import com.coderhouse.consumerapi.external.UserRestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRestApi userRestApi;

    @Override
    public List<String> getUsuarios() {
        return userRestApi.getUsuarios();
    }

    @Override
    public String getUsuarioById(String id) {
        return userRestApi.getUserById(id);
    }

    @Override
    public String guardarUsuario(String user) {
        return userRestApi.guardarUsuario(user);
    }

    @Override
    public void modificarUsuario(String id, String user) {
        userRestApi.modificarUsuario(id, user);
    }

}
