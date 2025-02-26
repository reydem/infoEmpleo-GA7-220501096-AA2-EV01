// /webapps/infoEmpleo-GA7-220501096-AA2-EV01/InfoEmpleo/src/main/java/info_empleo/dominio/InfoEmpleo.java
package info_empleo.dominio;

import java.util.Objects;

public class InfoEmpleo {
    private int id;
    private String nombre;
    private String empresa;      // Se usa en lugar de membresia
    private String descripcion;
    private double salario;

    public InfoEmpleo() {}

    public InfoEmpleo(int id) {
        this.id = id;
    }

    public InfoEmpleo(String nombre, String empresa, String descripcion, double salario) {
        this.nombre = nombre;
        this.empresa = empresa;
        this.descripcion = descripcion;
        this.salario = salario;
    }

    public InfoEmpleo(int id, String nombre, String empresa, String descripcion, double salario) {
        this(nombre, empresa, descripcion, salario);
        this.id = id;
    }

    // Getters y setters:
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    @Override
    public String toString() {
        return "InfoEmpleo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", empresa='" + empresa + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", salario=" + salario +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InfoEmpleo)) return false;
        InfoEmpleo that = (InfoEmpleo) o;
        return id == that.id &&
               Double.compare(that.salario, salario) == 0 &&
               Objects.equals(nombre, that.nombre) &&
               Objects.equals(empresa, that.empresa) &&
               Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, empresa, descripcion, salario);
    }
}
