package com.funsoba.ms_funsoba.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.funsoba.ms_funsoba.model.pojo.Usuario;
import com.funsoba.ms_funsoba.model.request.CreateUserRequest;
import com.funsoba.ms_funsoba.service.UsuarioService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService service;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getUsuarios(@RequestHeader Map<String, String> headers) {
        log.info("headers: {}", headers);
        List<Usuario> usuarios = service.getUsuarios();
        log.info("usuarios: {}", usuarios);
        if (usuarios == null || usuarios.isEmpty()) {
            log.info("No hay usuarios disponibles");
            return ResponseEntity.ok(Collections.emptyList());
        } else {
            return ResponseEntity.ok(usuarios);

        }
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable Long id) {
        log.info("Solicitud requerida el usuario: {}", id);
        Usuario usuario = service.getUsuarioById(id);
        if (usuario == null) {
            log.info("Usuario no encontrado con id: {}", id);
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(usuario);
        }
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        log.info("Solicitud de eliminación del usuario: {}", id);
        service.deleteUsuario(id);
        log.info("Usuario eliminado con éxito: {}", id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> getUsuario(@RequestBody CreateUserRequest request) {
        log.info("Solicitud de creación de usuario: {}", request);
        Usuario usuario = service.createUsuario(request);
        if (usuario == null) {
            log.error("Error al crear el usuario");
            return ResponseEntity.badRequest().build();
        } else {
            log.info("Usuario creado con éxito: {}", usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
        }
    }

}
