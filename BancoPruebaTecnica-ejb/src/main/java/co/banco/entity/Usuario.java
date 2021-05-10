
package co.banco.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Julian Medina
 * @version 1.2.0
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.listar", query ="SELECT u FROM Usuario u"),
     @NamedQuery(name = "Usuario.validarCedula", query ="SELECT COUNT(p.cedula) FROM Usuario p WHERE p.cedula = :cedula AND p.id <> :id"),
    @NamedQuery(name = "Usuario.validarCedulaGuardar", query ="SELECT COUNT(p.cedula) FROM Usuario p WHERE p.cedula = :cedula "),
    @NamedQuery(name = "Usuario.cantidadTotal", query = "SELECT COUNT(a) FROM Usuario a")
})
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull(message = "Campo requerido: Cedula!")
    @Min(value = 10, message = "Formato incorrecto!")
    @Column(name = "cedula", length = 10    , nullable = false, unique = true)
    private String cedula;
    
    @NotNull(message = "Campo requerido: nombre!")
    @Column(name = "nombre", length = 25, nullable = false)
    private String nombre;
    
    @NotNull(message = "Campo requerido: Apellido!")
    @Column(name = "apellido", length = 25, nullable = false)
    private String apellido;
    
    @NotNull(message = "Campo requerido: Ocupacion!")
    @Column(name = "ocupacion", length = 30, nullable = false)
    private String ocupacion;
    
    @NotNull(message = "Campo requerido: Sexo!")
    @Column(name = "sexo", length = 2, nullable = false)
    private String sexo;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String apellido, String ocupacion, String sexo, String cedula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ocupacion = ocupacion;
        this.sexo = sexo;
        this.cedula = cedula;
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
