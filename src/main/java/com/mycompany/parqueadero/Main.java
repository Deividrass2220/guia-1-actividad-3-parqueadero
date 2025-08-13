/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parqueadero;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero();

        Vehiculo auto = new Automovil("ABC123", "Toyota", "Corolla", "Gasolina", LocalDateTime.now().minusMinutes(45));
        Vehiculo moto = new Motocicleta("XYZ789", "Yamaha", "FZ", 150, LocalDateTime.now().minusMinutes(3));
        Vehiculo camion = new Camion("LMN456", "Volvo", "FH", 18.5, LocalDateTime.now().minusMinutes(120));

        parqueadero.registrarEntrada(auto);
        parqueadero.registrarEntrada(moto);
        parqueadero.registrarEntrada(camion);

        System.out.println("\nEstado actual del parqueadero:");
        for (Vehiculo v : parqueadero.consultarEstado()) {
            System.out.println(v);
        }

        System.out.println("\nRegistrando salida de la motocicleta:");
        parqueadero.registrarSalida("XYZ789");
    }
}