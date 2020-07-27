import java.util.*;


public class Main {

    public static void main(String args[]){
        Scanner sn = new Scanner(System.in);
        Integer num = 0;
        Menu menu1 = new Menu();

        while (num!=11){
            System.out.println ("_________________________________");
            System.out.println ("Menu del programa de Nomina:");
            System.out.println ("1. Agregar Empleado.");
            System.out.println ("2. Eliminar Empleado.");
            System.out.println ("3. Actualizar Empleado.");
            System.out.println ("4. Mostrar todos los Empleados.");
            System.out.println ("5. Mostrar Empleado con mayor salario.");
            System.out.println ("6. Mostrar Empleado con menor salario.");
            System.out.println ("7. Mostrar Empleados ordenados por el nombre.");
            System.out.println ("8. Mostrar la suma total de los salarios de los empleados que tengan un sueldo superior a 700000.");
            System.out.println ("9. Mostrar el número total de empleados cuyo apellido comienza por A o a.");
            System.out.println ("10. Mostrar el top 5 de empleados con mayor salario.");
            System.out.println ("11. SALIR.");
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
                        System.out.println("Empleado con mayor salario:");
                        menu1.mostrarMayorSalario();
                        break;
                    case 6:
                        System.out.println("Empleado con menor salario:");
                        menu1.mostrarMenorSalario();
                        break;
                    case 7:
                        System.out.println("Empleados ordenados por el nombre:");
                        menu1.mostrarNombresOrdenados();
                        break;
                    case 8:
                        System.out.println("Suma total de los salarios mayores de 700.000:");
                        menu1.mostrarSumaSalarios();
                        break;
                    case 9:
                        System.out.println("Número total de empleados que apellido empieza por A o a:");
                        menu1.mostrarEmpleadosConA();
                        break;
                    case 10:
                        System.out.println("TOP 5 empleados con mayor salario:");
                        menu1.mostrarTopSalarios();
                        break;
                    case 11:
                        System.out.println ("SALIENDO...");
                        break;
                    default:
                        System.out.println ("Por favor ingrese un número entre las opciones 1-11.");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println ("Verifique que ingreso un número...");
                sn.next();
            }

        }



    }

}
