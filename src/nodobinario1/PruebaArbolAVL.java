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
public class PruebaArbolAVL {
    public static void main(String[] args) {
        // Crear un árbol binario AVL
        NodoBinario1 raiz = new NodoBinario1(50);
        raiz = raiz.insertarAVL(30);
        raiz = raiz.insertarAVL(70);
        raiz = raiz.insertarAVL(20);
        raiz = raiz.insertarAVL(40);
        raiz = raiz.insertarAVL(60);
        raiz = raiz.insertarAVL(80);

        // Probar la búsqueda
        System.out.println("Búsqueda:");
        int claveBuscada = 40;
        NodoBinario1 nodoEncontradoPorClave = raiz.buscarPorClave(claveBuscada);
        if (nodoEncontradoPorClave != null) {
            System.out.println("Nodo encontrado por clave " + claveBuscada + ": " + nodoEncontradoPorClave.valor);
        } else {
            System.out.println("No se encontró ningún nodo con la clave " + claveBuscada);
        }

        // Probar la eliminación
        System.out.println("\nEliminación:");
        raiz = raiz.eliminarAVL(20);
        raiz = raiz.eliminarAVL(30);

        // Probar la búsqueda después de la eliminación
        System.out.println("\nBúsqueda después de la eliminación:");
        int valorBuscado = 40;
        List<NodoBinario1> nodosConValor = raiz.buscarPorValor(valorBuscado);
        System.out.println("Nodos encontrados con valor " + valorBuscado + ":");
        for (NodoBinario1 nodo : nodosConValor) {
            System.out.print(nodo.valor + " ");
        }

        // Probar la inserción después de la eliminación
        System.out.println("\n\nInserción después de la eliminación:");
        raiz = raiz.insertarAVL(35);

        // Probar la búsqueda después de la inserción
        System.out.println("\nBúsqueda después de la inserción:");
        nodosConValor = raiz.buscarPorValor(35);
        System.out.println("Nodos encontrados con valor 35:");
        for (NodoBinario1 nodo : nodosConValor) {
            System.out.print(nodo.valor + " ");
        }
    }
}
    
