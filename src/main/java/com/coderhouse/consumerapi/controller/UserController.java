package com.coderhouse.consumerapi.controller;

import com.coderhouse.consumerapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getUsers() {
        List<String> users = userService.getUsuarios();
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getUser(@PathVariable String id) {
        String user = userService.getUsuarioById(id);
        return ResponseEntity.ok(user);
    }


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> postUser(@RequestBody String user) {
        String userGuardado = userService.guardarUsuario(user);
        return ResponseEntity.created(null).body(userGuardado);
    }

    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> putUser(@PathVariable String id, @RequestBody String user) {
        userService.modificarUsuario(id, user);
        return ResponseEntity.noContent().build();
    }

}
