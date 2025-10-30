package clases.Empleado;

import javax.swing.JOptionPane;

public class EmpleadoPlanilla extends Empleado {
    
    private double salarioMensual;
    private double porcentajeAdicionalPorHoraExtra;

    public double getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    public double getPorcentajeAdicionalPorHoraExtra() {
        return porcentajeAdicionalPorHoraExtra;
    }

    public void setPorcentajeAdicionalPorHoraExtra(double porcentajeAdicionalPorHoraExtra) {
        this.porcentajeAdicionalPorHoraExtra = porcentajeAdicionalPorHoraExtra;
    }
    
    @Override
    public void registrarDatos() {
        super.registrarDatos(); 

        salarioMensual= Double.parseDouble(JOptionPane.showInputDialog("Ingrese su salario mensual"));
      porcentajeAdicionalPorHoraExtra= Double.parseDouble(JOptionPane.showInputDialog("ingrese porcentaje adicional por hora extra"));
    }

    @Override
    public void imprimirDatosPersona(String datos) {
        super.imprimirDatosPersona(datos);

        datos = "Salario Mensual: " + salarioMensual + "\n";
        datos += "Porcentaje Adicional Por Hora Extra: " + porcentajeAdicionalPorHoraExtra + "\n";

        System.out.println(datos);
    }
}