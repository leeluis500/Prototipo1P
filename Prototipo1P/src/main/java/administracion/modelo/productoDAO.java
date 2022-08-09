package administracion.modelo;

import administracion.controlador.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author leeluis
 */
public class UsuariosDAO {

    public static String codigoUsuario, nombreUsuario;
    private static final String SQL_INSERT = "INSERT into Usuarios(Nomuser,Apelluser,Username,Password,Emailuser,Estuser) values(?,?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE from Usuarios where pkidusuarios = ?";
    private static final String SQL_UPDATE = "UPDATE Usuarios SET Nomuser=?, Apelluser=?, Username=?, Password=?, Emailuser=?, Estuser=? WHERE pkidusuarios=?";
    private static final String SQL_SELECT = "SELECT * FROM Usuarios WHERE pkidusuarios = ?";
    private static final String SQL_UPDATEL = "UPDATE Usuarios SET Ultimacuser=? WHERE pkidusuarios=?";
    

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public List<Usuarios> select() {
        String SQL_SELECT = "SELECT * FROM Usuarios WHERE pkidusuarios LIKE '%" + codigoUsuario + "%' OR Nomuser LIKE '%" + nombreUsuario + "%'";
        Usuarios usuarios = null;
        List<Usuarios> listaUsuarios = new ArrayList<Usuarios>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("pkidusuarios");
                String nombre = rs.getString("Nomuser");
                String apellido = rs.getString("Apelluser");
                String usuario = rs.getString("Username");
                String password = rs.getString("Password");
                String email = rs.getString("Emailuser");
                String ultimac = rs.getString("Ultimacuser");
                String estado = rs.getString("Estuser");
                usuarios = new Usuarios();
                usuarios.setId(id);
                usuarios.setNombre(nombre);
                usuarios.setApellido(apellido);
                usuarios.setUser(usuario);
                usuarios.setPassword(password);
                usuarios.setEmail(email);
                usuarios.setUltimaConexion(ultimac);
                usuarios.setEstado(estado);
                listaUsuarios.add(usuarios);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return listaUsuarios;
    }

    public int insert(Usuarios usuario) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getUser());
            stmt.setString(4, usuario.getPassword());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getEstado());
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

    public int delete(Usuarios usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, usuario.getId());
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

    public int update(Usuarios usuario) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getUser());
            stmt.setString(4, usuario.getPassword());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getEstado());
            stmt.setString(7, usuario.getId());
//          System.out.println(stmt);
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public Usuarios selectUA(Usuarios usuarios) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setString(1, usuarios.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("pkidusuarios");
                String nombre = rs.getString("Nomuser");
                String apellido = rs.getString("Apelluser");
                String usuario = rs.getString("Username");
                String password = rs.getString("Password");
                String email = rs.getString("Emailuser");
                String ultimac = rs.getString("Ultimacuser");
                String estado = rs.getString("Estuser");
                usuarios = new Usuarios();
                usuarios.setId(id);
                usuarios.setNombre(nombre);
                usuarios.setApellido(apellido);
                usuarios.setUser(usuario);
                usuarios.setPassword(password);
                usuarios.setEmail(email);
                usuarios.setUltimaConexion(ultimac);
                usuarios.setEstado(estado);
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

    public int updateL(Usuarios usuario) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATEL);
            stmt.setString(1, usuario.getUltimaConexion());
            stmt.setString(2, usuario.getId());
//          System.out.println(stmt);
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
