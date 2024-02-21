/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.presentation;
import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInt(String message) {
        int input;
        while (true) {
            try {
                System.out.print(message);
                input = Integer.parseInt(scanner.nextLine());
                break; // Salir del bucle si la entrada es válida
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número entero válido.");
            }
        }
        // Limpiar el buffer después de leer la entrada
        return input;
    }

    public static String getString(String message) {
        System.out.print(message);
        String input = scanner.nextLine();
        // Limpiar el buffer después de leer la entrada
        return input;
    }

    public static long getLong(String message) {
        long input;
        while (true) {
            try {
                System.out.print(message);
                input = Long.parseLong(scanner.nextLine());
                break; // Salir del bucle si la entrada es válida
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número entero válido.");
            }
        }
        // Limpiar el buffer después de leer la entrada
        return input;
    }

}


