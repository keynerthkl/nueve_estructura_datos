/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nodobinario1;

/**
 *
 * @author USER
 */
import java.util.HashMap;
import java.util.Map;

public class PruebaHuffman {
    public static void main(String[] args) {
        // Datos de entrada
        String datos = "hola";
        
        // Calcular frecuencia de cada caracter en los datos de entrada
        Map<Character, Integer> frecuencias = new HashMap<>();
        for (char c : datos.toCharArray()) {
            frecuencias.put(c, frecuencias.getOrDefault(c, 0) + 1);
        }

        // Crear el compresor Huffman y construir el árbol de Huffman
        CompresorHuffman compresor = new CompresorHuffman();
        NodoBinario1 raiz = compresor.construirArbolHuffman(frecuencias);

        // Generar tabla de códigos basada en el árbol de Huffman
        Map<Character, String> tablaCodigos = compresor.generarTablaCodigos(raiz);

        // Comprimir los datos de entrada utilizando la tabla de códigos
        String datosComprimidos = compresor.comprimirDatos(datos, tablaCodigos);
        System.out.println("Datos comprimidos: " + datosComprimidos);

        // Descomprimir los datos comprimidos utilizando el árbol de Huffman
        String datosDescomprimidos = compresor.descomprimirDatos(datosComprimidos, raiz);
        System.out.println("Datos descomprimidos: " + datosDescomprimidos);
    }
}
