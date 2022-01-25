package com.cliente.dr.controllers;


import com.cliente.dr.dao.UsuarioDao;
import com.cliente.dr.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public void login(@RequestBody Usuario usuario){
        usuarioDao.verificarDatos(usuario);
    }
}
