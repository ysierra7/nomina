import java.util.*;


public class Main {

    public static void main(String args[]){
        Scanner sn = new Scanner(System.in);
        Integer num = 0;
        Menu menu1 = new Menu();

        while (num!=5){
            System.out.println ("_________________________________");
            System.out.println ("Menu del programa de Nomina:");
            System.out.println ("1. Agregar Empleado.");
            System.out.println ("2. Eliminar Empleado.");
            System.out.println ("3. Actualizar Empleado.");
            System.out.println ("4. Mostrar todos los Empleados.");
            System.out.println ("5. Salir.");
            System.out.println ("_________________________________");

            try {

                System.out.println ("Por favor indique con un número del menú lo que quiere hacer:");
                num = sn.nextInt();

                switch (num){
                    case 1:
                        menu1.agregarEmpleado();
                        break;
                    case 2:
                        System.out.println ("Eliminar Empleado.");
                        menu1.eliminarEmpleado();
                        break;
                    case 3:
                        menu1.actualizarEmpleado();
                        break;
                    case 4:
                        System.out.println ("Empleados:");
                        menu1.mostrarEmpleados();
                        System.out.println ("_______________");
                        break;
                    case 5:
                        System.out.println ("SALIENDO...");
                        break;
                    default:
                        System.out.println ("Por favor ingrese un número entre las opciones 1-5.");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println ("Verifique que ingreso un número...");
                sn.next();
            }

        }



    }

}
