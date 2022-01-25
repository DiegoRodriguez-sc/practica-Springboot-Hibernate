package com.cliente.dr.dao;

import com.cliente.dr.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();

    void deleteUsuario(long id);

    void postUsuario(Usuario usuario);

    boolean verificarDatos(Usuario usuario);
}
