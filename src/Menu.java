import java.util.*;

public class Menu {

    List<Empleado> listaEmpleados = new ArrayList<>();
    Integer id;
    String nombre;
    String apellido;
    Integer salario;


    public Menu(){
        System.out.println("______________________");
    }

    public void agregarEmpleado(){

        boolean flag = false;

        Iterator<Empleado> it= listaEmpleados.iterator();

        Scanner entrada = new Scanner(System.in);

        System.out.println("AGREGANDO EMPLEADO");
        System.out.println("Ingresa el ID: ");
        id = entrada.nextInt();

        while (it.hasNext()) {

            if (it.next().getId().equals(id)) {
                flag = true;
                System.err.println("El ID digitado ya existe. Realice el proceso de nuevo.");

            }

        }

        if (!flag) {
            System.out.println("Ingresa el nombre: ");
            nombre = entrada.next();
            System.out.println("Ingresa el apellido: ");
            apellido = entrada.next();
            System.out.println("Ingresa el salario: ");
            salario = entrada.nextInt();
            System.out.println("Empleado agregado correctamente.");

            listaEmpleados.add(new Empleado(id, nombre, apellido, salario));

        }

    }

    public void actualizarEmpleado(){


        Integer id2;

        boolean flag = false;

        Iterator<Empleado> it= listaEmpleados.iterator();

        Scanner entrada = new Scanner(System.in);

        System.out.println("_______________________");
        System.out.println("ACTUALIZANDO EMPLEADO");
        System.out.println("Ingresa el ID del empleado a editar: ");
        id2 = entrada.nextInt();

        while (it.hasNext()) {

            if (it.next().getId().equals(id2)) {
                flag = true;
                System.out.println("Ingresa el ID nuevo: ");
                id = entrada.nextInt();
                System.out.println("Ingresa el nombre nuevo: ");
                nombre = entrada.next();
                System.out.println("Ingresa el apellido nuevo: ");
                apellido = entrada.next();
                System.out.println("Ingresa el salario nuevo: ");
                salario = entrada.nextInt();

                Integer finalSalario = salario;
                listaEmpleados.stream().filter(empleado -> empleado.getId().equals(id2)).forEach(empleado -> {
                    empleado.setId(id);
                    empleado.setNombre(nombre);
                    empleado.setApellido(apellido);
                    empleado.setSalario(salario);
                    System.out.println("Se actualizo correctamente.");
                    System.out.println(empleado);
                });

            }

        }

        if (!flag) {
            System.err.println("El ID digitado no existe. Cancelando actualización...");

        }

    }

    public void eliminarEmpleado(){

        Scanner entrada = new Scanner(System.in);
        System.out.println("___________________________________________");
        System.out.println("Ingresa el ID del empleado a eliminar: ");
        Integer id = entrada.nextInt();
        Iterator<Empleado> it= listaEmpleados.iterator();

        boolean flag = false;
        while (it.hasNext()) {

            if (it.next().getId().equals(id)) {
                it.remove();
                flag = true;
                System.out.println("Se Elimino el Empleado correctamente.");
            }

        }

        if (!flag) {
            System.err.println("El ID digitado no existe.");

        }


    }

    public void mostrarEmpleados(){
        listaEmpleados.stream().forEach(empleado -> System.out.println(empleado));

    }

    public void mostrarMayorSalario(){
        System.out.println(listaEmpleados.stream()
                .max(Comparator.comparing(Empleado::getSalario))
                .map(empleado -> empleado.toString())
                .orElse("No hay empleados"));

    }

    public void mostrarMenorSalario(){
        System.out.println(listaEmpleados.stream()
                .min(Comparator.comparing(Empleado::getSalario))
                .map(empleado -> empleado.toString())
                .orElse("No hay empleados"));
    }

    public void mostrarNombresOrdenados(){
        listaEmpleados.stream().sorted(Comparator.comparing(Empleado::getNombre)).forEach(empleado -> System.out.println(empleado));
    }

    public void mostrarSumaSalarios(){
        long total = listaEmpleados.stream().filter(empleado -> empleado.getSalario() > 700000).mapToInt(Empleado::getSalario).reduce(0, (a,b) -> a + b);
        System.out.println(total);
    }

    public void mostrarEmpleadosConA(){
        long total = listaEmpleados.stream().filter(empleado -> empleado.getApellido().toUpperCase().startsWith("A")).count();
        System.out.println(total);
    }

    public void mostrarTopSalarios(){
        listaEmpleados.stream().sorted(Comparator.comparing(Empleado::getSalario, Comparator.reverseOrder())).limit(5).forEach(empleado -> System.out.println(empleado));
    }
}
