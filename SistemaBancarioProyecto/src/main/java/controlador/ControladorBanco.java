/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.util.ArrayList;
import modelo.Cuenta;
import modelo.CuentaAhorros;
import modelo.CuentaCorriente;
import modelo.Fecha;
/**
 *
 * @author juans
 */
public class ControladorBanco {
    private ArrayList<Cuenta> cuentas;

    public ControladorBanco() {
        cuentas = new ArrayList<>();
    }


    private Cuenta buscarCuenta(String numero) {
        for (Cuenta c : cuentas) {
            if (c.getNumero().equals(numero)) {
                return c;
            }
        }
        return null;
    }


    public String crearCuentaAhorros(String numero, String dueño, int dia, int mes, int año, double saldoInicial) {
        if (buscarCuenta(numero) != null) {
            return "Ya existe una cuenta con el número " + numero;
        }
        Fecha fecha = new Fecha(dia, mes, año);
        Cuenta nueva;
        if (saldoInicial == 0) {
            nueva = new CuentaAhorros(numero, dueño, fecha);
        } else {
            nueva = new CuentaAhorros(numero, dueño, fecha, saldoInicial);
        }
        cuentas.add(nueva);
        return "Cuenta de ahorros " + numero + " creada correctamente.";
    }


    public String crearCuentaCorriente(String numero, String dueño, int dia, int mes, int año, double saldoInicial, double cupoSobregiro) {
        if (buscarCuenta(numero) != null) {
            return "Ya existe una cuenta con el número " + numero;
        }
        Fecha fecha = new Fecha(dia, mes, año);
        Cuenta nueva;
        if (saldoInicial == 0) {
            nueva = new CuentaCorriente(numero, dueño, fecha, cupoSobregiro);
        } else {
            nueva = new CuentaCorriente(numero, dueño, fecha, saldoInicial, cupoSobregiro);
        }
        cuentas.add(nueva);
        return "Cuenta corriente " + numero + " creada correctamente.";
    }


    public String consignar(String numero, double valor) {
        Cuenta cuenta = buscarCuenta(numero);
        if (cuenta == null) {
            return "No se encontró la cuenta " + numero;
        }
        if (cuenta.consignar(valor)) {
            return "Consignación exitosa.\n" + cuenta.mostrarInformacion(true);
        }
        return "El valor a consignar debe ser mayor que 0.";
    }


    public String retirar(String numero, double valor) {
        Cuenta cuenta = buscarCuenta(numero);
        if (cuenta == null) {
            return "No se encontró la cuenta " + numero;
        }
        if (cuenta.retirar(valor)) {
            return "Retiro exitoso.\n" + cuenta.mostrarInformacion(true);
        }
        return "Retiro rechazado: fondos insuficientes o valor no válido.";
    }    
}
