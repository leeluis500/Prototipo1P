package administracion.modelo;

import administracion.controlador.UsuarioAplicacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author leeluis
 */
public class UsuarioAplicacionDAO {

    private static final String SQL_SELECTV = "SELECT * FROM Asignacion_Usuario_aplicacion WHERE  fpkidusuario=? AND fpkidaplicacion=?";
    private static final String SQL_SELECT = "SELECT * FROM Asignacion_Usuario_aplicacion WHERE  fpkidusuario=?";
    private static final String SQL_INSERT = "INSERT INTO Asignacion_Usuario_aplicacion VALUES (?,?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE from Asignacion_Usuario_aplicacion where fpkidusuario=? AND fpkidaplicacion=?";
    private static final String SQL_UPDATE = "UPDATE Asignacion_Usuario_aplicacion SET Ingresarua=?, Consultarua=?, Modificarua=?, Eliminarua=? WHERE fpkidusuario=? AND fpkidaplicacion=?";

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public UsuarioAplicacion selectV(UsuarioAplicacion usuarios) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECTV);
            stmt.setString(1, usuarios.getIdUsuario());
            stmt.setString(2, usuarios.getIdAplicacion());
            //System.out.println(stmt);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idUsuario = rs.getString("fpkidusuario");
                String idApp = rs.getString("fpkidaplicacion");
                String Guardar = rs.getString("Ingresarua");
                String Buscar = rs.getString("Consultarua");
                String Modificar = rs.getString("Modificarua");
                String Eliminar = rs.getString("Eliminarua");
                usuarios.setIdUsuario(idUsuario);
                usuarios.setIdAplicacion(idUsuario);
                usuarios.setGuardar(Guardar);
                usuarios.setEliminar(Eliminar);
                usuarios.setModificar(Modificar);
                usuarios.setBuscar(Buscar);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuarios;
    }

    public List<UsuarioAplicacion> selectUA(UsuarioAplicacion usuarios) {
        List<UsuarioAplicacion> listaAsignacion = new ArrayList<UsuarioAplicacion>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setString(1, usuarios.getIdUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idUsuario = rs.getString("fpkidusuario");
                String idApp = rs.getString("fpkidaplicacion");
                String Guardar = rs.getString("Ingresarua");
                String Buscar = rs.getString("Consultarua");
                String Modificar = rs.getString("Modificarua");
                String Eliminar = rs.getString("Eliminarua");
                usuarios = new UsuarioAplicacion();
                usuarios.setIdUsuario(idUsuario);
                usuarios.setIdAplicacion(idApp);
                usuarios.setGuardar(Guardar);
                usuarios.setBuscar(Buscar);
                usuarios.setModificar(Modificar);
                usuarios.setEliminar(Eliminar);
                listaAsignacion.add(usuarios);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return listaAsignacion;
    }

    public int insert(UsuarioAplicacion asignacion) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, asignacion.getIdUsuario());
            stmt.setString(2, asignacion.getIdAplicacion());
            stmt.setString(3, asignacion.getGuardar());
            stmt.setString(4, asignacion.getBuscar());
            stmt.setString(5, asignacion.getModificar());
            stmt.setString(6, asignacion.getEliminar());
            //System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            //System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int delete(UsuarioAplicacion asignacion) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, asignacion.getIdUsuario());
            stmt.setString(2, asignacion.getIdAplicacion());
            //System.out.println(stmt);
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int update(UsuarioAplicacion asignacion) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, asignacion.getGuardar());
            stmt.setString(2, asignacion.getBuscar());
            stmt.setString(3, asignacion.getModificar());
            stmt.setString(4, asignacion.getEliminar());
            stmt.setString(5, asignacion.getIdUsuario());
            stmt.setString(6, asignacion.getIdAplicacion());
            //System.out.println(stmt + " "+rows);
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

}
