/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author alex
 */
public class CuentaAhorros extends Cuenta {
    public CuentaAhorros(String numero, String dueño, Fecha fechaApertura, double saldoInicial) {
        super(numero, dueño, fechaApertura, saldoInicial);
    }

    
    public CuentaAhorros(String numero, String dueño, Fecha fechaApertura) {
        super(numero, dueño, fechaApertura);
    }


    @Override
    public boolean retirar(double valor) {
        if (valor <= 0) {
            return false;
        }
        if (valor <= saldo) {
            saldo = saldo - valor;
            return true;
        }
        return false;
    }
    
}
