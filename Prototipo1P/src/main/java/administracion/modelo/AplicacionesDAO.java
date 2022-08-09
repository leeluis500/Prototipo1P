

package administracion.modelo;

import administracion.controlador.Aplicaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 /**
 * @author leeluis
 */

public class AplicacionesDAO {
    
    public static String codigoAplicaion, nombreAplicacion;
    private static final String SQL_INSERT = "INSERT into Aplicaciones(Nomapp,Descapp,Estapp) values(?,?,?)";
    private static final String SQL_DELETE = "DELETE from Aplicaciones where pkidaplicaciones = ?";
    private static final String SQL_UPDATE = "UPDATE Aplicaciones SET Nomapp=?, Descapp=?, Estapp=? WHERE pkidaplicaciones=?";
    private static final String SQL_SELECT = "SELECT * FROM Aplicaciones";
    
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public List<Aplicaciones> select() {
        String SQL_SELECT = "SELECT * FROM Aplicaciones WHERE pkidaplicaciones LIKE '%" + codigoAplicaion + "%' OR Nomapp LIKE '%" + nombreAplicacion + "%'";
        Aplicaciones servicio = null;
        List<Aplicaciones> servicios = new ArrayList<Aplicaciones>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("pkidaplicaciones");
                String nombre = rs.getString("Nomapp");
                String descripcion = rs.getString("Descapp");
                String estado = rs.getString("Estapp");
                servicio = new Aplicaciones();
                servicio.setId(id);
                servicio.setNombre(nombre);
                servicio.setDescripcion(descripcion);
                servicio.setEstado(estado);
                servicios.add(servicio);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return servicios;
    }
    
    public int insert(Aplicaciones app) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, app.getNombre());
            stmt.setString(2, app.getDescripcion());
            stmt.setString(3, app.getEstado());
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

    public int delete(Aplicaciones app) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, app.getId());
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
    
    public int update(Aplicaciones app) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, app.getNombre());
            stmt.setString(2, app.getDescripcion());
            stmt.setString(3, app.getEstado());
            stmt.setString(4, app.getId());
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
    
    public List<Aplicaciones> selectUA() {
        Aplicaciones servicio = null;
        List<Aplicaciones> servicios = new ArrayList<Aplicaciones>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("pkidaplicaciones");
                String nombre = rs.getString("Nomapp");
                String descripcion = rs.getString("Descapp");
                String estado = rs.getString("Estapp");
                servicio = new Aplicaciones();
                servicio.setId(id);
                servicio.setNombre(nombre);
                servicio.setDescripcion(descripcion);
                servicio.setEstado(estado);
                servicios.add(servicio);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return servicios;
    }
    
}
