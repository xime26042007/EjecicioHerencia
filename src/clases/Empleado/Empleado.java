package clases.Empleado;
import clases.Persona;
import javax.swing.JOptionPane;

public class Empleado extends Persona{

    private String codigoDeEmpleado;
    private int numeroDeHorasExtras;
    private String fechaDeIngreso;
    private String area;
    private String cargo;

    public String getCodigoDeEmpleado() {
        return codigoDeEmpleado;
    }
    public void setCodigoDeEmpleado(String codigoDeEmpleado) {
        this.codigoDeEmpleado = codigoDeEmpleado;
    }

    public int getNumeroDeHorasExtras() {
        return numeroDeHorasExtras;
    }
    public void setNumeroDeHorasExtras(int numeroDeHorasExtras) {
        this.numeroDeHorasExtras = numeroDeHorasExtras;
    }

    public String getFechaDeIngreso() {
        return fechaDeIngreso;
    }
    public void setFechaDeIngreso(String fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public void registrarDatos() {
        super.registrarDatos(); 

      codigoDeEmpleado= JOptionPane.showInputDialog("ingrese el codigo de empleado");
      numeroDeHorasExtras= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de horas extras"));
      fechaDeIngreso= JOptionPane.showInputDialog("ingrese la fecha de ingreso (dd/mm/aa)");
      area=JOptionPane.showInputDialog("ingrese el area");
      cargo =JOptionPane.showInputDialog("ingrese el cargo");
        
    }
    
    @Override
    public void imprimirDatosPersona(String datos) {
        super.imprimirDatosPersona(datos);

        datos = "Codigo De Empleado: " + codigoDeEmpleado + "\n";
        datos += "Numero De Horas Extras: " + numeroDeHorasExtras + "\n";
        datos += "Fecha De Ingreso: " + fechaDeIngreso + "\n";
        datos += "Area: " + area + "\n";
        datos += "Cargo: " + cargo + "\n";

        System.out.println(datos);
    }
}