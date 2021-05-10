
package co.banco.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Julian Medina
 * @version 1.2.0
 */
public class UsuarioPaginadoDto implements Serializable{
  private Integer cantidad;
    
    private List<UsuarioDto> content;

    public UsuarioPaginadoDto(Integer cantidad, List<UsuarioDto> content) {
        this.cantidad = cantidad;
        this.content = content;
    }

    public UsuarioPaginadoDto() {
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public List<UsuarioDto> getContent() {
        return content;
    }

    public void setContent(List<UsuarioDto> content) {
        this.content = content;
    }
    
    
    
}

