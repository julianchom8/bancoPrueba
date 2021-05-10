
package co.banco.dto;

import java.io.Serializable;

/**
 *
 * @author Julian Medina
 * @version 1.2.0
 */
public class UsuarioDto implements  Serializable{
    
    private Integer id;
    
    private String nombre;
    
    private String apellido;
    
    private String ocupacion;
    
    private String sexo;
    
    private String cedula;

    public UsuarioDto(Integer id, String nombre, String apellido, String ocupacion, String sexo, String cedula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ocupacion = ocupacion;
        this.sexo = sexo;
        this.cedula =cedula;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

   
}
