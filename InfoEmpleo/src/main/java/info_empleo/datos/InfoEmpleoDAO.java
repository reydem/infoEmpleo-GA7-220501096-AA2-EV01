// /webapps/infoEmpleo-GA7-220501096-AA2-EV01/InfoEmpleo/src/main/java/info_empleo/datos/InfoEmpleoDAO.java
package info_empleo.datos;

import info_empleo.dominio.InfoEmpleo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static info_empleo.conexion.Conexion.getConexion;

public class InfoEmpleoDAO implements IInfoEmpleoDAO {

    @Override
    public List<InfoEmpleo> listarInfoEmpleos() {
        List<InfoEmpleo> infoEmpleos = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM info_empleo ORDER BY id";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                var infoEmpleo = new InfoEmpleo();
                infoEmpleo.setId(rs.getInt("id"));
                infoEmpleo.setNombre(rs.getString("nombre"));
                infoEmpleo.setEmpresa(rs.getString("empresa")); // se asigna el valor de empresa
                infoEmpleo.setDescripcion(rs.getString("descripcion"));
                infoEmpleo.setSalario(rs.getDouble("salario"));
                infoEmpleos.add(infoEmpleo);
            }
        } catch (Exception e) {
            System.out.println("Error al listar infoEmpleos: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return infoEmpleos;
    }

    @Override
    public boolean buscarInfoEmpleoPorId(InfoEmpleo infoEmpleo) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM info_empleo WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, infoEmpleo.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                infoEmpleo.setNombre(rs.getString("nombre"));
                infoEmpleo.setEmpresa(rs.getString("empresa")); // se asigna el valor de empresa
                infoEmpleo.setDescripcion(rs.getString("descripcion"));
                infoEmpleo.setSalario(rs.getDouble("salario"));
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error al buscar infoEmpleo: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean agregarInfoEmpleo(InfoEmpleo infoEmpleo) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "INSERT INTO info_empleo(nombre, empresa, descripcion, salario) VALUES(?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, infoEmpleo.getNombre());
            ps.setString(2, infoEmpleo.getEmpresa());
            ps.setString(3, infoEmpleo.getDescripcion());
            ps.setDouble(4, infoEmpleo.getSalario());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al agregar infoEmpleo: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean modificarInfoEmpleo(InfoEmpleo infoEmpleo) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "UPDATE info_empleo SET nombre=?, empresa=?, descripcion=?, salario=? WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, infoEmpleo.getNombre());
            ps.setString(2, infoEmpleo.getEmpresa());
            ps.setString(3, infoEmpleo.getDescripcion());
            ps.setDouble(4, infoEmpleo.getSalario());
            ps.setInt(5, infoEmpleo.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al modificar infoEmpleo: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean eliminarInfoEmpleo(InfoEmpleo infoEmpleo) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "DELETE FROM info_empleo WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, infoEmpleo.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar infoEmpleo: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return false;
    }
}
