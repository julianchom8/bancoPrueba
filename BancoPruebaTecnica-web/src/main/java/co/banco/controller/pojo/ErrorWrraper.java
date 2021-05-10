
package co.banco.controller.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 * @author Julian Medina
 * @version 1.2.0
 */
public class ErrorWrraper implements Serializable{
    private String error;
    private String codigo;
    private String nombreCodigo;
    private String fecha;

    public ErrorWrraper(String error, String codigo, String nombreCodigo) {
        this.error = error;
        this.codigo = codigo;
        this.nombreCodigo = nombreCodigo;
        this.fecha = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(new java.util.Date());
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreCodigo() {
        return nombreCodigo;
    }

    public void setNombreCodigo(String nombreCodigo) {
        this.nombreCodigo = nombreCodigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

  

   
    
}
