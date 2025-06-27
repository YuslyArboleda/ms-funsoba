package com.funsoba.ms_funsoba.service;

import java.util.List;

import com.funsoba.ms_funsoba.model.pojo.Usuario;
import com.funsoba.ms_funsoba.model.request.CreateUserRequest;

public interface UsuarioService {

    List<Usuario> getUsuarios();

    Usuario getUsuarioById(Long id);

    Usuario createUsuario(CreateUserRequest request);

    Usuario updateUsuario(Long id, CreateUserRequest request);

    void deleteUsuario(Long id);
}
