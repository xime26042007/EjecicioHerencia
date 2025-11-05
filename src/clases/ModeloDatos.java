package clases;

import java.util.HashMap;
import clases.Empleado.EmpleadoPlanilla;
import clases.Empleado.EmpleadoEventual;
import clases.Empleado.Medico;
import java.util.ArrayList;
import java.util.Map;

public class ModeloDatos {
    HashMap<String, Paciente> pacientesMap;
    HashMap<String, EmpleadoPlanilla> empleadosPlanillaMap;
    HashMap<String, EmpleadoEventual> empleadosEventualMap;
    HashMap<String, Medico> medicosMap;
    ArrayList<CitaMedica> citasList;

    public ModeloDatos() {
        pacientesMap = new HashMap<String, Paciente>();
        empleadosPlanillaMap = new HashMap<String, EmpleadoPlanilla>();
        medicosMap = new HashMap<String, Medico>();
        empleadosEventualMap = new HashMap<String, EmpleadoEventual>();
        citasList = new ArrayList<CitaMedica>();
    }

    public void registrarPersona(Paciente miPaciente) {
         String doc = miPaciente.getNumeroDeDNI();
        if (doc == null || doc.isEmpty()) { System.out.println("Documento inválido. No se registró el paciente."); return; }
        if (pacientesMap.containsKey(doc)) { System.out.println("Paciente duplicado. No se registró."); return; }
        pacientesMap.put(miPaciente.getNumeroDeDNI(), miPaciente);
        System.out.println("Se ha registrado el paciente "+miPaciente.getNombre()+" Satisfactoriamente");
    }

    public void registrarPersona(EmpleadoPlanilla miEmpPlanilla) {
         String doc = miEmpPlanilla.getNumeroDeDNI();
        if (doc == null || doc.isEmpty()) { System.out.println("Documento inválido. No se registró el empleado por planilla."); return; }
        if (empleadosPlanillaMap.containsKey(doc)) { System.out.println("Empleado por planilla duplicado. No se registró."); return; }
    empleadosPlanillaMap.put(miEmpPlanilla.getNumeroDeDNI(), miEmpPlanilla); 
    System.out.println("Se ha registrado el empleado por planilla "+miEmpPlanilla.getNombre()+" Satisfactoriamente");
}

    public void registrarPersona(EmpleadoEventual miEmpEventual) {
         String doc = miEmpEventual.getNumeroDeDNI();
        if (doc == null || doc.isEmpty()) { System.out.println("Documento inválido. No se registró el empleado eventual."); return; }
        if (empleadosEventualMap.containsKey(doc)) { System.out.println("Empleado eventual duplicado. No se registró."); return; }
        empleadosEventualMap.put(miEmpEventual.getNumeroDeDNI(), miEmpEventual);
        System.out.println("Se ha registrado el empleado eventual "+miEmpEventual.getNombre()+" Satisfactoriamente");
    }

    public void registrarPersona(Medico miMedico) {
        String doc = miMedico.getNumeroDeDNI();
        if (doc == null || doc.isEmpty()) { System.out.println("Documento inválido. No se registró el médico."); return; }
        if (medicosMap.containsKey(doc)) { System.out.println("Médico duplicado. No se registró."); return; }
        medicosMap.put(miMedico.getNumeroDeDNI(), miMedico);
        System.out.println("Se ha registrado el medico "+miMedico.getNombre()+" Satisfactoriamente");
    }

    public void registrarCitaMedica(CitaMedica miCita) {
        citasList.add(miCita);
        System.out.println("Se ha registrado la cita exitosamente\n");
        System.out.println(miCita.informacionCitaMedico());
    }

   public Paciente consultarPacientePorDocumento(String doc) { return pacientesMap.get(doc); }
    public EmpleadoEventual consultarEmpleadoEventualPorDocumento(String doc) { return empleadosEventualMap.get(doc); }
    public EmpleadoPlanilla consultarEmpleadoPlanillaPorDocumento(String doc) { return empleadosPlanillaMap.get(doc); }
    public Medico consultarMedicoPorDocumento(String doc) { return medicosMap.get(doc); 
    }

    public void imprimirPacientes() {
        if (pacientesMap.isEmpty()) { System.out.println("No hay pacientes registrados."); return; }
        String msj = "PACIENTES REGISTRADOS\n";
        for (Paciente p : pacientesMap.values()) p.imprimirDatosPersona(msj);
    }
    public void imprimirEmpleadosEventuales() {
        if (empleadosEventualMap.isEmpty()) { System.out.println("No hay empleados eventuales registrados."); return; }
        String msj = "EMPLEADOS EVENTUALES REGISTRADOS\n";
        for (EmpleadoEventual e : empleadosEventualMap.values()) e.imprimirDatosPersona(msj);
    }
    public void imprimirEmpleadosPorPlanilla() {
        if (empleadosPlanillaMap.isEmpty()) {
            System.out.println("No hay empleados por planilla registrados.");
        } else {
            String msj = "EMPLEADOS POR PLANILLA REGISTRADOS\n";
            for (EmpleadoPlanilla ep : empleadosPlanillaMap.values()) ep.imprimirDatosPersona(msj);
        }
        if (medicosMap.isEmpty()) {
            System.out.println("(No hay médicos registrados para mostrar junto con planilla).");
        } else {
            System.out.println("--- MÉDICOS REGISTRADOS (mostrados junto con planilla) ---");
            String msjMed = "MÉDICO\n";
            for (Map.Entry<String, Medico> elemento : medicosMap.entrySet()) {
                elemento.getValue().imprimirDatosPersona(msjMed);
            }
        }
    }
    public void imprimirMedicos() {
        if (medicosMap.isEmpty()) { System.out.println("No hay médicos registrados."); return; }
        String msj = "MEDICOS REGISTRADOS\n";
        for (Medico m : medicosMap.values()) m.imprimirDatosPersona(msj);
    }

    public void imprimirCitasMedicasProgramadas() {
        System.out.println("CITAS MÉDICAS PROGRAMADAS\n");
        if (citasList.isEmpty()) {
            System.out.println("No existen citas programadas");
            return;
        }
        for (CitaMedica c : citasList) System.out.println(c.informacionCitaMedico());
    }
}
