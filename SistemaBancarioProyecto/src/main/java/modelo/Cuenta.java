/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author juans
 */
public abstract class Cuenta {
    private String numero;
    private String dueño;
    private Fecha fechaApertura;
    protected double saldo;

    public Cuenta(String numero, String dueño, Fecha fechaApertura, double saldo) {
        this.numero = numero;
        this.dueño = dueño;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
    }
    
    public Cuenta(String numero, String dueño, Fecha fechaApertura) {
        this(numero, dueño, fechaApertura, 0);
    }

    
    public String getNumero() {
        return numero;
    }

    public String getDueño() {
        return dueño;
    }

    public Fecha getFechaApertura() {
        return fechaApertura;
    }

    public double getSaldo() {
        return saldo;
    }
    
    
    public boolean consignar(double valor) {
        if (valor <= 0) {
            return false;
        }
        saldo = saldo + valor;
        return true;
    }
    
    public abstract boolean retirar(double valor);

    
    public String mostrarInformacion() {
        return "Numero: " + numero + "\n"
             + "Dueño: " + dueño + "\n"
             + "Fecha de apertura: " + fechaApertura + "\n"
             + "Saldo: " + saldo;
    }    
    
    
    public String mostrarInformacion(boolean soloSaldo) {
        if (soloSaldo) {
            return "Saldo: " + saldo;
        }
        return mostrarInformacion();
    }    
}
