

package administracion.controlador;

 /**
 * @author H. Leonel Dominguez C.
 * @github https://github.com/leoneldc
 */

public class UsuarioAplicacion {
    private String idUsuario, idAplicacion, guardar, modificar, eliminar, buscar;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(String idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public String getGuardar() {
        return guardar;
    }

    public void setGuardar(String guardar) {
        this.guardar = guardar;
    }

    public String getModificar() {
        return modificar;
    }

    public void setModificar(String modificar) {
        this.modificar = modificar;
    }

    public String getEliminar() {
        return eliminar;
    }

    public void setEliminar(String eliminar) {
        this.eliminar = eliminar;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

}
