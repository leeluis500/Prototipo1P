package administracion.controlador;


import administracion.modelo.UsuarioAplicacionDAO;
import administracion.vista.MDI_Administracion;
import java.util.List;

/**
 * @author leeluis
 */
public class GenerarPermisos {

    UsuarioAplicacion permisos = new UsuarioAplicacion();
    UsuarioAplicacionDAO permisosDAO = new UsuarioAplicacionDAO();

    public void cargarAplicaciones(String id) {
        MDI_Administracion.MnI_UsuarioAplicacion.setVisible(false);

        permisos.setIdUsuario(id);
        List<UsuarioAplicacion> listadoPermisos = permisosDAO.selectUA(permisos);
        for (UsuarioAplicacion permiso : listadoPermisos) {
            switch (Integer.parseInt(permiso.getIdAplicacion())) {
                case 30:MDI_Administracion.MnI_UsuarioAplicacion.setVisible(true);break;
                case 9:MDI_Administracion.Mnt_Producto.setVisible(true);break;
            }
        }

    }
    
    
}
