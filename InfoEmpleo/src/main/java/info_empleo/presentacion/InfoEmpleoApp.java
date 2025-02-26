// /webapps/infoEmpleo-GA7-220501096-AA2-EV01/InfoEmpleo/src/main/java/info_empleo/presentacion/InfoEmpleoApp.java
package info_empleo.presentacion;

import info_empleo.datos.InfoEmpleoDAO;
import info_empleo.datos.IInfoEmpleoDAO;
import info_empleo.dominio.InfoEmpleo;

import java.util.Scanner;

public class InfoEmpleoApp {
    public static void main(String[] args) {
        infoEmpleoApp();
    }

    private static void infoEmpleoApp(){
        boolean salir = false;
        Scanner consola = new Scanner(System.in);
        // Creamos un objeto de la clase InfoEmpleoDAO
        IInfoEmpleoDAO infoEmpleoDAO = new InfoEmpleoDAO();
        while(!salir){
            try{
                int opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(consola, opcion, infoEmpleoDAO);
            } catch (Exception e){
                System.out.println("Error al ejecutar opciones: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static int mostrarMenu(Scanner consola){
        System.out.print("""
                *** Info.Empleo
                1. Listar Empleados
                2. Buscar Empleado
                3. Agregar Empleado
                4. Modificar Empleado
                5. Eliminar Empleado
                6. Salir
                Elije una opción: """);
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(Scanner consola, int opcion, IInfoEmpleoDAO infoEmpleoDAO){
        boolean salir = false;
        switch (opcion){
            case 1 -> { // 1. Listar Empleados
                System.out.println("--- Listado de Empleados ---");
                var infoEmpleos = infoEmpleoDAO.listarInfoEmpleos();
                infoEmpleos.forEach(System.out::println);
            }
            case 2 -> { // 2. Buscar Empleado por id
                System.out.print("Introduce el id del Empleado a buscar: ");
                int idEmpleado = Integer.parseInt(consola.nextLine());
                var empleado = new InfoEmpleo(idEmpleado);
                boolean encontrado = infoEmpleoDAO.buscarInfoEmpleoPorId(empleado);
                if(encontrado)
                    System.out.println("Empleado encontrado: " + empleado);
                else
                    System.out.println("Empleado NO encontrado: " + empleado);
            }
            case 3 -> { // 3. Agregar Empleado
                System.out.println("--- Agregar Empleado ---");
                System.out.print("Nombre: ");
                String nombre = consola.nextLine();
                System.out.print("Apellido: ");
                String apellido = consola.nextLine();
                System.out.print("Membresía: ");
                int membresia = Integer.parseInt(consola.nextLine());
                // Se pasan valores por defecto para descripcion y salario
                var empleado = new InfoEmpleo(nombre, apellido, membresia, "", 0.0);
                boolean agregado = infoEmpleoDAO.agregarInfoEmpleo(empleado);
                if(agregado)
                    System.out.println("Empleado agregado: " + empleado);
                else
                    System.out.println("Empleado NO agregado: " + empleado);
            }
            case 4 -> { // 4. Modificar Empleado
                System.out.println("--- Modificar Empleado ---");
                System.out.print("Id Empleado: ");
                int idEmpleado = Integer.parseInt(consola.nextLine());
                System.out.print("Nombre: ");
                String nombre = consola.nextLine();
                System.out.print("Apellido: ");
                String apellido = consola.nextLine();
                System.out.print("Membresía: ");
                int membresia = Integer.parseInt(consola.nextLine());
                // Se pasan valores por defecto para descripcion y salario
                var empleado = new InfoEmpleo(idEmpleado, nombre, apellido, membresia, "", 0.0);
                boolean modificado = infoEmpleoDAO.modificarInfoEmpleo(empleado);
                if(modificado)
                    System.out.println("Empleado modificado: " + empleado);
                else
                    System.out.println("Empleado NO modificado: " + empleado);
            }
            case 5 -> { // 5. Eliminar Empleado
                System.out.println("--- Eliminar Empleado ---");
                System.out.print("Id Empleado: ");
                int idEmpleado = Integer.parseInt(consola.nextLine());
                var empleado = new InfoEmpleo(idEmpleado);
                boolean eliminado = infoEmpleoDAO.eliminarInfoEmpleo(empleado);
                if(eliminado)
                    System.out.println("Empleado eliminado: " + empleado);
                else
                    System.out.println("Empleado NO eliminado: " + empleado);
            }
            case 6 -> { // 6. Salir
                System.out.println("¡Hasta pronto!");
                salir = true;
            }
            default -> System.out.println("Opción no reconocida: " + opcion);
        }
        return salir;
    }
}
