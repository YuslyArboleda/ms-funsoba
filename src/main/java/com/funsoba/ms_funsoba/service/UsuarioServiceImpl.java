package com.funsoba.ms_funsoba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funsoba.ms_funsoba.data.UsuarioRepository;
import com.funsoba.ms_funsoba.model.pojo.Usuario;
import com.funsoba.ms_funsoba.model.request.CreateUserRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> getUsuarios() {
        log.info("Muestra todos los usuarios");
        return usuarioRepository.getUsuarios();
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        log.info("Muestra el usuario con ID: {}", id);
        return usuarioRepository.getUsuarioById(id);
    }

    @Override

    public Usuario createUsuario(CreateUserRequest request) {
        log.info("Crea usuario: {}", request.getNombre());
        Usuario usuario = new Usuario();
        usuario.setNombre(request.getNombre());
        return usuarioRepository.createUsuario(usuario);
    }

    @Override
    public Usuario updateUsuario(Long id, CreateUserRequest request) {

        log.info("Actualiza el usuario con ID: {}", id);
        Usuario usuario = usuarioRepository.getUsuarioById(id);
        if (usuario != null) {
            usuario.setNombre(request.getNombre());
            return usuarioRepository.createUsuario(usuario);
        }
        return null;
    }

    @Override
    public void deleteUsuario(Long id) {
        log.info("Elimina el usuario con ID: {}", id);
        usuarioRepository.deleteUsuario(id);
    }

}
