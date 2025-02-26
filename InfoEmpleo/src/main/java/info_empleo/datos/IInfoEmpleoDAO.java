// /webapps/infoEmpleo-GA7-220501096-AA2-EV01/InfoEmpleo/src/main/java/info_empleo/datos/IClienteDAO.java
// IInfoEmpleoDAO.java
package info_empleo.datos;

import info_empleo.dominio.InfoEmpleo;
import java.util.List;

public interface IInfoEmpleoDAO {
    List<InfoEmpleo> listarInfoEmpleos();
    boolean buscarInfoEmpleoPorId(InfoEmpleo infoEmpleo);
    boolean agregarInfoEmpleo(InfoEmpleo infoEmpleo);
    boolean modificarInfoEmpleo(InfoEmpleo infoEmpleo);
    boolean eliminarInfoEmpleo(InfoEmpleo infoEmpleo);
}
