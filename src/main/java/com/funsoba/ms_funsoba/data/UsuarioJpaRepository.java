package com.funsoba.ms_funsoba.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.funsoba.ms_funsoba.model.pojo.Usuario;

public interface UsuarioJpaRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {
    List<Usuario> findByNombre(String nombre);
}
