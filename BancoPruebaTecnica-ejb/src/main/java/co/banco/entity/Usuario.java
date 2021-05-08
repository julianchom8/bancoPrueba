
package co.banco.entity;

import java.io.Serializable;
import java.util.Date;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Julian Medina
 * @version 1.0
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull(message = "Campo requerido: nombre!")
    @Column(name = "nombre", length = 25, nullable = false)
    private String nombre;
    
    @NotNull(message = "Campo requerido: Apellido!")
    @Column(name = "apellido", length = 25, nullable = false)
    private String apellido;
    
    @NotNull(message = "Campo requerido: Fecha!")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonbDateFormat(value = "dd-mm-yyyy",locale = "es")
    private Date fecha;
    
    @NotNull(message = "Campo requerido: Sexo!")
    @Column(name = "sexo", length = 2, nullable = false)
    private String sexo;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String apellido, Date fecha, String sexo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.sexo = sexo;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
}
