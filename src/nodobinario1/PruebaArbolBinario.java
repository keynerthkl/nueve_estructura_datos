/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nodobinario1;

/**
 *
 * @author keyne
 */
public class PruebaArbolBinario {
    public static void main(String[] args) {
        // Crear un árbol binario
        NodoBinario1 raiz = new NodoBinario1(50);
        raiz.insertar(30);
        raiz.insertar(70);
        raiz.insertar(20);
        raiz.insertar(40);
        raiz.insertar(60);
        raiz.insertar(80);

        // Probar la búsqueda
        System.out.println("Búsqueda:");
        System.out.println("¿El valor 40 está en el árbol? " + raiz.buscar(40));
        System.out.println("¿El valor 90 está en el árbol? " + raiz.buscar(90));

        // Probar recorridos
        System.out.println("\nRecorrido Preorden:");
        raiz.recorrerPreorden();

        System.out.println("\n\nRecorrido Inorden:");
        raiz.recorrerInorden();

        System.out.println("\n\nRecorrido Postorden:");
        raiz.recorrerPostorden();

        // Probar la eliminación
        System.out.println("\n\nEliminación del valor 30:");
        raiz.eliminar(30);
        System.out.println("Recorrido Inorden después de la eliminación:");
        raiz.recorrerInorden();
    }
}
