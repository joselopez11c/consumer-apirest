package com.coderhouse.consumerapi.service;

import com.coderhouse.consumerapi.external.UserRestApi;
import org.springframework.beans.factory.annotation.Autowired;
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
}
