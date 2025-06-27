package com.funsoba.ms_funsoba.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateUserRequest {
    private String nombre;
    private String apellido;
    private String email;
    private String direccion;
    private String telefono;
    private String password;
    private String genero;

}
