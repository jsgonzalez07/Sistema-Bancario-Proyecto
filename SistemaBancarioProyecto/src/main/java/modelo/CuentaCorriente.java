/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author alex
 */
public class CuentaCorriente extends Cuenta {
    private double cupoSobregiro;

    public CuentaCorriente(String numero, String dueño, Fecha fechaApertura, double saldoInicial, double cupoSobregiro) {
        super(numero, dueño, fechaApertura, saldoInicial);
        this.cupoSobregiro = cupoSobregiro;
    }


    public CuentaCorriente(String numero, String dueño, Fecha fechaApertura, double cupoSobregiro) {
        super(numero, dueño, fechaApertura);
        this.cupoSobregiro = cupoSobregiro;
    }


    public double getCupoSobregiro() {
        return cupoSobregiro;
    }


    @Override
    public boolean retirar(double valor) {
        if (valor <= 0) {
            return false;
        }
        if (valor <= saldo) {
            saldo = saldo - valor;
            return true;
        } else if (valor <= saldo + cupoSobregiro) {
            saldo = saldo - valor;
            return true;
        }
        return false;
    }


    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + "\n"
             + "Cupo de sobregiro: " + cupoSobregiro;
    }
    
}
