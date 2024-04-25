/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nodobinario1;

/**
 *
 * @author keyne
 */

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class menu {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NodoBinario1 arbol = null;

        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Insertar nodo");
            System.out.println("2. Buscar nodo");
            System.out.println("3. Eliminar nodo");
            System.out.println("4. Recorrer árbol (Preorden)");
            System.out.println("5. Recorrer árbol (Inorden)");
            System.out.println("6. Recorrer árbol (Postorden)");
            System.out.println("7. Buscar por clave");
            System.out.println("8. Buscar por rango");
            System.out.println("9. Buscar por valor");
            System.out.println("10. Insertar nodo en AVL");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el valor del nodo a insertar: ");
                    int valorInsertar = scanner.nextInt();
                    if (arbol == null) {
                        arbol = new NodoBinario1(valorInsertar);
                    } else {
                        arbol.insertar(valorInsertar);
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el valor a buscar: ");
                    int valorBuscar = scanner.nextInt();
                    System.out.println("El valor " + valorBuscar + (arbol.buscar(valorBuscar) ? " está presente en el árbol." : " no está presente en el árbol."));
                    break;
                case 3:
                    // Implementar eliminación de nodo
                    break;
                case 4:
                    System.out.print("Recorrido Preorden: ");
                    if (arbol != null) {
                        arbol.recorrerPreorden();
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Recorrido Inorden: ");
                    if (arbol != null) {
                        arbol.recorrerInorden();
                    }
                    System.out.println();
                    break;
                case 6:
                    System.out.print("Recorrido Postorden: ");
                    if (arbol != null) {
                        arbol.recorrerPostorden();
                    }
                    System.out.println();
                    break;
                case 7:
                    System.out.print("Ingrese la clave a buscar: ");
                    int claveBuscar = scanner.nextInt();
                    NodoBinario1 nodoEncontrado = arbol.buscarPorClave(claveBuscar);
                    if (nodoEncontrado != null) {
                        System.out.println("Nodo encontrado: " + nodoEncontrado.valor);
                    } else {
                        System.out.println("No se encontró ningún nodo con la clave " + claveBuscar);
                    }
                    break;
                case 8:
                    System.out.print("Ingrese el valor mínimo del rango: ");
                    int minRango = scanner.nextInt();
                    System.out.print("Ingrese el valor máximo del rango: ");
                    int maxRango = scanner.nextInt();
                    List<NodoBinario1> nodosEnRango = arbol.buscarPorRango(minRango, maxRango);
                    System.out.println("Nodos encontrados en el rango:");
                    for (NodoBinario1 nodo : nodosEnRango) {
                        System.out.print(nodo.valor + " ");
                    }
                    System.out.println();
                    break;
                case 9:
                    System.out.print("Ingrese el valor a buscar: ");
                    int valorBuscado = scanner.nextInt();
                    List<NodoBinario1> nodosEncontradosPorValor = arbol.buscarPorValor(valorBuscado);
                    System.out.println("Nodos encontrados con el valor " + valorBuscado + ":");
                    for (NodoBinario1 nodo : nodosEncontradosPorValor) {
                        System.out.print(nodo.valor + " ");
                    }
                    System.out.println();
                    break;
                case 10:
                    System.out.print("Ingrese el valor del nodo a insertar en AVL: ");
                    int valorInsertarAVL = scanner.nextInt();
                    arbol = arbol.insertarAVL(valorInsertarAVL);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
    
}
