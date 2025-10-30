import javax.swing.JOptionPane;
import clases.ModeloDatos;
import clases.Paciente;
import clases.Empleado.EmpleadoEventual;
import clases.Empleado.EmpleadoPlanilla;
import clases.Empleado.Medico;

public class Procesos {
    ModeloDatos miModeloDatos;
    
    public Procesos() {
        miModeloDatos=new ModeloDatos();
        presentarMenuOpciones();
    }

    private void presentarMenuOpciones() {
        
        String menu="MENU HOSPITAL\n\n";
        menu+="1. Registrar Paciente\n";
        menu+="2. Registrar Empleado\n";
        menu+="3. Registrar Cita Medica\n";
        menu+="4. Imprimir Información\n";
        menu+="5. Salir\n\n";
        menu+="Ingrese una Opción\n";

        int opcion = 0;
        do {
        opcion=Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                case 1:registrarPaciente(); break;
                case 2:registrarEmpleado();break;
                case 3: registarCitaMedica(); break;
                case 4: imprimirInformacion(); break;
                case 5: System.out.println("El sistema ha terminado!"); break;
                default:System.out.println("No existe el código o la entrada es inválida, verifique nuevamente."); break;
            }

        } while (opcion != 5);
    }
    

    private void registrarPaciente() {
        Paciente miPaciente= new Paciente();
        miPaciente.registrarDatos();

        miModeloDatos.registrarPersona(miPaciente);
        
        System.out.println("Iniciando registro de paciente...");
        
    }

    private void registrarEmpleado() {
        String menuTipoEmpleado="registro de empleado\n";
        menuTipoEmpleado+="1. Empleado Evaluar\n";
        menuTipoEmpleado+="2. Empleado Planilla\n";
        menuTipoEmpleado+="Seleccione el tipo de empleado a registrar\n";

        
        int tipoEmpleado = Integer.parseInt(JOptionPane.showInputDialog(menuTipoEmpleado));
        
        switch (tipoEmpleado) {
            case 1:
                EmpleadoEventual miEmpleadoEvaluar = new EmpleadoEventual();
                miEmpleadoEvaluar.registrarDatos();
                miModeloDatos.registrarPersona(miEmpleadoEvaluar);
                 break;
            case 2:
            String rest=JOptionPane.showInputDialog("ingrese si,si es un tipo de lo contrario es otro tipo de empleado");
            if (rest.equalsIgnoreCase("si")) {
                Medico miMedico=new Medico();
                miModeloDatos.registrarPersona(miMedico);
                
            }else{
                
              EmpleadoPlanilla miEmpleadoPlanilla = new EmpleadoPlanilla();
                miEmpleadoPlanilla.registrarDatos();
                miModeloDatos.registrarPersona(miEmpleadoPlanilla);
            }
                break;
                
            default: System.out.println("El tipo de empleado ingresado no es válido. Inténtelo nuevamente");
                break;
        }
    }

private void imprimirInformacion() {

    String menuImprimir="MENU IMPRESIONES\n";
    menuImprimir+="1. Listar Pacientes\n";
    menuImprimir+="2. Listar Empleados Eventuales\n";
    menuImprimir+="3. Listar Empleados Por Planilla\n";
    menuImprimir+="4. Listar Medicos\n";
    menuImprimir+="Ingrese una opción\n";

    System.out.println("******************************************");
    int opcion=Integer.parseInt(JOptionPane.showInputDialog(menuImprimir));
    
    switch (opcion) {
        case 1: miModeloDatos.imprimirPacientes(); break;
        case 2: miModeloDatos.imprimirEmpleadosEventuales(); break;
        case 3: miModeloDatos.imprimirEmpleadosPorPlanilla(); break;
        case 4: miModeloDatos.imprimirMedicos(); break;
        default: System.out.println("No exite esa opción");
        break;
    }
}

    
    private void registarCitaMedica() {
        System.out.println("Iniciando registro de cita...");
    }
}