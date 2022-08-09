package administracion.modelo;

import administracion.controlador.Modulos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author leeluis
 */
public class ModulosDAO {

    public static String codigoModulo, nombreModulo;
    private static final String SQL_INSERT = "insert into Modulos values(?,?,?,?)";
    private static final String SQL_DELETE = "delete from Modulos where pkidmodulos = ?";
    private static final String SQL_UPDATE = "UPDATE Modulos SET Nommod=?, Descmod=?, Estmod=? WHERE pkidmodulos=?";
    

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public List<Modulos> select() {
        String SQL_SELECT = "SELECT * FROM Modulos WHERE pkidmodulos LIKE '%" + codigoModulo + "%' OR Nommod LIKE '%" + nombreModulo + "%'";
        Modulos modulo = null;
        List<Modulos> modulos = new ArrayList<Modulos>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("pkidmodulos");
                String nombre = rs.getString("Nommod");
                String descripcion = rs.getString("Descmod");
                String estado = rs.getString("Estmod");
                modulo = new Modulos();
                modulo.setId(id);
                modulo.setNombre(nombre);
                modulo.setDescripcion(descripcion);
                modulo.setEstado(estado);
                modulos.add(modulo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return modulos;
    }
    
    public int insert(Modulos modulo) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, modulo.getId());
            stmt.setString(2, modulo.getNombre());
            stmt.setString(3, modulo.getDescripcion());
            stmt.setString(4, modulo.getEstado());
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

    public int delete(Modulos modulo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, modulo.getId());
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
    
    public int update(Modulos modulo) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, modulo.getNombre());
            stmt.setString(2, modulo.getDescripcion());
            stmt.setString(3, modulo.getEstado());
            stmt.setString(4, modulo.getId());
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
