package com.cliente.dr.controllers;


import com.cliente.dr.dao.UsuarioDao;
import com.cliente.dr.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios() {
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void deleteUsuarios(@PathVariable long id) {
        usuarioDao.deleteUsuario(id);
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void postUsuarios(@RequestBody Usuario usuario){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hashPassword =  argon2.hash(1,1024,1, usuario.getPassword());
        usuario.setPassword(hashPassword);
        usuarioDao.postUsuario(usuario);
    }



}
