package administracion.modelo;

import administracion.controlador.producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author leeluis
 */
public class productoDAO {

    public static String codigoProducto, nombreProducto;
    private static final String SQL_INSERT = "INSERT into producto(nombre,cantidad,estado) values(?,?,?)";
    private static final String SQL_DELETE = "DELETE from producto where pkidproducto = ?";
    private static final String SQL_UPDATE = "UPDATE producto SET nombre=?, cantidad=?, estado=? WHERE pkidproducto=?";
    private static final String SQL_SELECT = "SELECT * FROM producto WHERE pkidproducto = ?";
    

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public List<producto> select() {
        String SQL_SELECT = "SELECT * FROM producto WHERE pkidproducto LIKE '%" + codigoProducto + "%' OR nombre LIKE '%" + nombreProducto + "%'";
        producto prod = null;
        List<producto> listaUsuarios = new ArrayList<producto>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("pkidproducto");
                String nombre = rs.getString("nombre");
                String cant = rs.getString("cantidad");
                String est = rs.getString("estado");
                prod = new producto();
                prod.setId(id);
                prod.setNombre(nombre);
                prod.setCantidad(cant);
                prod.setEstado(est);
                listaUsuarios.add(prod);
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

    public int insert(producto prod) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, prod.getNombre());
            stmt.setString(2, prod.getCantidad());
            stmt.setString(3, prod.getEstado());
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

    public int delete(producto prod) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, prod.getId());
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

    public int update(producto prod) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, prod.getNombre());
            stmt.setString(2, prod.getCantidad());
            stmt.setString(3, prod.getEstado());
            stmt.setString(4, prod.getId());
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
