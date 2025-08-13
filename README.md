Proyecto Parqueadero
Este proyecto es una aplicación sencilla para gestionar la entrada y salida de vehículos en un parqueadero. Está desarrollado en Java y utiliza programación orientada a objetos para modelar diferentes tipos de vehículos y las operaciones sobre ellos.


Descripción General
El sistema permite:

Registrar la entrada de vehículos (automóviles, motocicletas y camiones).

Registrar la salida de vehículos y calcular el costo de estacionamiento basado en el tiempo de estadía.

Consultar el estado actual del parqueadero mostrando los vehículos que están dentro.

El cálculo del costo se realiza de manera diferente según el tipo de vehículo y el tiempo que permaneció estacionado.

Clases Principales
1. Vehiculo (abstracta)
Clase base para representar un vehículo genérico. Contiene atributos comunes como placa, marca, modelo y hora de entrada, y define el método abstracto calcularCosto que cada tipo de vehículo debe implementar.

Atributos:

placa (String)

marca (String)

modelo (String)

horaEntrada (LocalDateTime)

Métodos principales:

calcularCosto(long minutosEstadia) (abstracto): calcula el costo de acuerdo al tiempo.

2. Automovil (extiende Vehiculo)
Representa un automóvil. Añade el atributo tipoCombustible y define el cálculo del costo con una tarifa específica.

Atributos:

tipoCombustible (String)

Métodos:

calcularCosto(long minutosEstadia): cobra $500 si la estadía es menor a 10 minutos; si no, cobra 100 por minuto.

3. Motocicleta (extiende Vehiculo)
Representa una motocicleta con atributo adicional cilindraje.

Atributos:

cilindraje (int)

Métodos:

calcularCosto(long minutosEstadia): cobra $500 si la estadía es menor a 10 minutos; si no, cobra 50 por minuto.

4. Camion (extiende Vehiculo)
Representa un camión, con atributo capacidadCarga.

Atributos:

capacidadCarga (double)

Métodos:

calcularCosto(long minutosEstadia): cobra $500 si la estadía es menor a 10 minutos; si no, cobra 150 por minuto.

5. Parqueadero
Clase principal que gestiona los vehículos dentro del parqueadero.

Atributos:

listaVehiculos (List<Vehiculo>): vehículos actualmente estacionados.

Métodos:

registrarEntrada(Vehiculo vehiculo): añade un vehículo a la lista.

registrarSalida(String placa): busca el vehículo por placa, calcula costo, lo elimina y devuelve el costo.

consultarEstado(): devuelve la lista de vehículos dentro.

buscarVehiculo(String placa): busca un vehículo por placa.

6. Main
Clase con el método principal que ejecuta un ejemplo de uso:

Registra la entrada de un automóvil, una motocicleta y un camión.

Muestra el estado actual del parqueadero.

Registra la salida de una motocicleta.

Muestra los costos y cambios en el parqueadero.

Ejemplo de ejecución
java
Copiar
Editar
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