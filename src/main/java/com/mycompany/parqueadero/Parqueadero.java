/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.parqueadero;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Parqueadero {
    private List<Vehiculo> listaVehiculos;

    public Parqueadero() {
        listaVehiculos = new ArrayList<>();
    }

    public void registrarEntrada(Vehiculo vehiculo) {
        listaVehiculos.add(vehiculo);
        System.out.println("Entrada registrada: " + vehiculo);
    }

    public double registrarSalida(String placa) {
        Vehiculo vehiculo = buscarVehiculo(placa);
        if (vehiculo != null) {
            LocalDateTime salida = LocalDateTime.now();
            long minutos = Duration.between(vehiculo.getHoraEntrada(), salida).toMinutes();
            double costo = vehiculo.calcularCosto(minutos);
            listaVehiculos.remove(vehiculo);
            System.out.println("Salida registrada: " + vehiculo + " | Tiempo: " + minutos + " min | Costo: $" + costo);
            return costo;
        } else {
            System.out.println("Vehículo no encontrado.");
            return 0;
        }
    }

    public List<Vehiculo> consultarEstado() {
        return listaVehiculos;
    }

    public Vehiculo buscarVehiculo(String placa) {
        for (Vehiculo v : listaVehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }
}