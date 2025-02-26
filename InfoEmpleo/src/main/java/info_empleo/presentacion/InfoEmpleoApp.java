package info_empleo.presentacion;

import info_empleo.datos.ClienteDAO;
import info_empleo.datos.IClienteDAO;
import info_empleo.dominio.Cliente;

import java.util.Scanner;

public class InfoEmpleoApp {
    public static void main(String[] args) {
        zonaFitApp();
    }

    private static void zonaFitApp(){
        var salir = false;
        var consola = new Scanner(System.in);
        // Creamos un objeto de la clase clienteDao
        IClienteDAO clienteDao = new ClienteDAO();
        while(!salir){
            try{
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(consola, opcion, clienteDao);
            }catch (Exception e){
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
                Elije una opcion:\s""");
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(Scanner consola, int opcion,
                                            IClienteDAO clienteDAO){
        var salir = false;
        switch (opcion){
            case 1 -> { // 1. Listar Empleados
                System.out.println("--- Listado de Empleados ---");
                var clientes = clienteDAO.listarClientes();
                clientes.forEach(System.out::println);
            }
            case 2 ->{ // 2. Buscar Empleado por id
                System.out.print("Introduce el id del Empleado a buscar: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                var cliente = new Cliente(idCliente);
                var encontrado = clienteDAO.buscarClientePorId(cliente);
                if(encontrado)
                    System.out.println("Empleado encontrado: " + cliente);
                else
                    System.out.println("Empleado NO encontrado: " + cliente);

            }
            case 3 -> { // 3. Agregar Empleado
                System.out.println("--- Agregar Empleado ---");
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Empresa: ");
                var membresia = Integer.parseInt(consola.nextLine());
                // Creamos el objeto Empleado (sin el id)
                var cliente = new Cliente(nombre, apellido, membresia);
                var agregado = clienteDAO.agregarCliente(cliente);
                if(agregado)
                    System.out.println("Empleado agregado: " + cliente);
                else
                    System.out.println("Empleado NO agregado: " + cliente);
            }
            case 4 -> { //4. Modificar Empleado
                System.out.println("--- Modificar Empleado ---");
                System.out.print("Id Empleado: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Empresa: ");
                var membresia = Integer.parseInt(consola.nextLine());
                // Creamos el objeto a modificar
                var cliente = new Cliente(idCliente, nombre, apellido, membresia);
                var modificado = clienteDAO.modificarCliente(cliente);
                if(modificado)
                    System.out.println("Cliente Empleado: " + cliente);
                else
                    System.out.println("Cliente NO Empleado: " + cliente);
            }
            case 5 -> { // 5. Eliminar Cliente
                System.out.println("--- Eliminar Empleado ---");
                System.out.print("Id Empleado: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                var cliente = new Cliente(idCliente);
                var eliminado = clienteDAO.eliminarCliente(cliente);
                if(eliminado)
                    System.out.println("Empleado Eliminado: " + cliente);
                else
                    System.out.println("Empleado NO eliminado: " + cliente);
            }
            case 6 -> { // 6. Salir
                System.out.println("Hasta pronto!");
                salir = true;
            }
            default -> System.out.println("Opcion no reconocida: " + opcion);
        }
        return salir;
    }
}
