package com.funsoba.ms_funsoba.data;

import org.springframework.stereotype.Repository;

import com.funsoba.ms_funsoba.model.pojo.Usuario;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Repository
@RequiredArgsConstructor

public class UsuarioRepository {
    private final UsuarioJpaRepository repository;

    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = repository.findAll();
        return usuarios.isEmpty() ? null : usuarios;
    }

    public Usuario getUsuarioById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Usuario createUsuario(Usuario usuario) {
        try {
            return repository.save(usuario);
        } catch (Exception e) {
            // Log the error
            return null;
        }
    }

    public void deleteUsuario(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}
