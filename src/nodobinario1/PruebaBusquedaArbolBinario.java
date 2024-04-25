/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nodobinario1;

/**
 *
 * @author keyne
 */

import java.util.List;

public class PruebaBusquedaArbolBinario {
    public static void main(String[] args) {
        // Crear un árbol binario
        NodoBinario1 raiz = new NodoBinario1(50);
        raiz.insertar(30);
        raiz.insertar(70);
        raiz.insertar(20);
        raiz.insertar(40);
        raiz.insertar(60);
        raiz.insertar(80);

        // Caso de prueba: Búsqueda por clave
        int claveBuscada = 40;
        NodoBinario1 nodoEncontradoPorClave = raiz.buscarPorClave(claveBuscada);
        if (nodoEncontradoPorClave != null) {
            System.out.println("Nodo encontrado por clave " + claveBuscada + ": " + nodoEncontradoPorClave.valor);
        } else {
            System.out.println("No se encontró ningún nodo con la clave " + claveBuscada);
        }

        // Caso de prueba: Búsqueda por rango
        int min = 30;
        int max = 70;
        List<NodoBinario1> nodosEnRango = raiz.buscarPorRango(min, max);
        System.out.println("\nNodos encontrados en el rango [" + min + ", " + max + "]:");
        for (NodoBinario1 nodo : nodosEnRango) {
            System.out.print(nodo.valor + " ");
        }

        // Caso de prueba: Búsqueda por valor
        int valorBuscado = 80;
        List<NodoBinario1> nodosConValor = raiz.buscarPorValor(valorBuscado);
        System.out.println("\n\nNodos encontrados con valor " + valorBuscado + ":");
        for (NodoBinario1 nodo : nodosConValor) {
            System.out.print(nodo.valor + " ");
        }
    }
}