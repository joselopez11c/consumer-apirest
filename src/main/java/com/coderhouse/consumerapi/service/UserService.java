package com.coderhouse.consumerapi.service;

import java.util.List;

public interface UserService {

    List<String> getUsuarios();

    String guardarUsuario(String user);

    void modificarUsuario(String id, String user);

    String getUsuarioById(String id);
}
