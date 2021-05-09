/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.banco.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Julian Medina
 * @version 1.0
 */
public class UsuarioDto implements  Serializable{
    
    private Integer id;
    
    private String nombre;
    
    private String apellido;
    
    private String ocupacion;
    
    private String sexo;

    public UsuarioDto(Integer id, String nombre, String apellido, String ocupacion, String sexo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ocupacion = ocupacion;
        this.sexo = sexo;
    }
    public UsuarioDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

   
}
