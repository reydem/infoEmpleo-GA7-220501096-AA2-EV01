package info_empleo.dominio;

import java.util.Objects;

public class InfoEmpleo {
    private int id;
    private String nombre;
    private String apellido;
    private int membresia;
    // Nuevos atributos:
    private String descripcion;
    private double salario;

    public InfoEmpleo() {}

    public InfoEmpleo(int id) {
        this.id = id;
    }

    public InfoEmpleo(String nombre, String apellido, int membresia, String descripcion, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.membresia = membresia;
        this.descripcion = descripcion;
        this.salario = salario;
    }

    public InfoEmpleo(int id, String nombre, String apellido, int membresia, String descripcion, double salario) {
        this(nombre, apellido, membresia, descripcion, salario);
        this.id = id;
    }

    // Getters y setters existentes...
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getMembresia() {
        return membresia;
    }
    public void setMembresia(int membresia) {
        this.membresia = membresia;
    }
    // Nuevos getters y setters:
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "InfoEmpleo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", membresia=" + membresia +
                ", descripcion='" + descripcion + '\'' +
                ", salario=" + salario +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoEmpleo that = (InfoEmpleo) o;
        return id == that.id && membresia == that.membresia &&
                Double.compare(that.salario, salario) == 0 &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(apellido, that.apellido) &&
                Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, membresia, descripcion, salario);
    }
}
