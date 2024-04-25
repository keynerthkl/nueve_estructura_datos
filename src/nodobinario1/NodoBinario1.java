/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nodobinario1;

/**
 *
 * @author keyne
 */

import java.util.ArrayList;
import java.util.List;

public class NodoBinario1 {
    int valor;
    int altura;
    NodoBinario1 izquierdo, derecho;
   

    public NodoBinario1(int valor) {
        this.valor = valor;
        this.altura = 1;
        izquierdo = derecho = null;
    }

    // Método para insertar un nuevo nodo
    public void insertar(int valor) {
        if (valor < this.valor) {
            if (izquierdo == null) {
                izquierdo = new NodoBinario1(valor);
            } else {
                izquierdo.insertar(valor);
            }
        } else {
            if (derecho == null) {
                derecho = new NodoBinario1(valor);
            } else {
                derecho.insertar(valor);
            }
        }
    }

    // Método para buscar un valor en el árbol
    public boolean buscar(int valor) {
        if (valor == this.valor) {
            return true;
        } else if (valor < this.valor && izquierdo != null) {
            return izquierdo.buscar(valor);
        } else if (valor > this.valor && derecho != null) {
            return derecho.buscar(valor);
        }
        return false;
    }

    // Método para eliminar un nodo
    public NodoBinario1 eliminar(int valor) {
        // Implementar lógica de eliminación
        return null;
    }

    // Métodos de recorrido en profundidad (Preorden, Inorden, Postorden)
    public void recorrerPreorden() {
        System.out.print(this.valor + " ");
        if (izquierdo != null) {
            izquierdo.recorrerPreorden();
        }
        if (derecho != null) {
            derecho.recorrerPreorden();
        }
    }

    public void recorrerInorden() {
        if (izquierdo != null) {
            izquierdo.recorrerInorden();
        }
        System.out.print(this.valor + " ");
        if (derecho != null) {
            derecho.recorrerInorden();
        }
    }

    public void recorrerPostorden() {
        if (izquierdo != null) {
            izquierdo.recorrerPostorden();
        }
        if (derecho != null) {
            derecho.recorrerPostorden();
        }
        System.out.print(this.valor + " ");
    }
    
    // Método para buscar un nodo por su valor o clave
    public NodoBinario1 buscarPorClave(int clave) {
        if (clave == this.valor) {
            return this;
        } else if (clave < this.valor && izquierdo != null) {
            return izquierdo.buscarPorClave(clave);
        } else if (clave > this.valor && derecho != null) {
            return derecho.buscarPorClave(clave);
        }
        return null;
    }
    
    public List<NodoBinario1> buscarPorRango(int min, int max) {
        List<NodoBinario1> nodosEnRango = new ArrayList<>();
        buscarPorRangoRecursivo(this, min, max, nodosEnRango);
        return nodosEnRango;
    }

    private void buscarPorRangoRecursivo(NodoBinario1 nodo, int min, int max, List<NodoBinario1> nodosEnRango) {
        if (nodo == null) {
            return;
        }
        // Si el valor del nodo está dentro del rango, lo agregamos a la lista de nodos en rango
        if (nodo.valor >= min && nodo.valor <= max) {
            nodosEnRango.add(nodo);
        }
        // Si el valor del nodo es mayor que el valor mínimo del rango, buscamos en el subárbol izquierdo
        if (nodo.valor > min) {
            buscarPorRangoRecursivo(nodo.izquierdo, min, max, nodosEnRango);
        }
        // Si el valor del nodo es menor que el valor máximo del rango, buscamos en el subárbol derecho
        if (nodo.valor < max) {
            buscarPorRangoRecursivo(nodo.derecho, min, max, nodosEnRango);
        }
    }
    
    public List<NodoBinario1> buscarPorValor(int valorBuscado) {
        List<NodoBinario1> nodosEncontrados = new ArrayList<>();
        buscarPorValorRecursivo(this, valorBuscado, nodosEncontrados);
        return nodosEncontrados;
    }

    private void buscarPorValorRecursivo(NodoBinario1 nodo, int valorBuscado, List<NodoBinario1> nodosEncontrados) {
        if (nodo == null) {
            return;
        }
        // Si el valor del nodo coincide con el valor buscado, lo agregamos a la lista de nodos encontrados
        if (nodo.valor == valorBuscado) {
            nodosEncontrados.add(nodo);
        }
        // Luego, realizamos una búsqueda en los subárboles izquierdo y derecho
        buscarPorValorRecursivo(nodo.izquierdo, valorBuscado, nodosEncontrados);
        buscarPorValorRecursivo(nodo.derecho, valorBuscado, nodosEncontrados);
    }
    
    // Método para insertar un nuevo nodo en un árbol binario AVL
    public NodoBinario1 insertarAVL(int valor) {
        NodoBinario1 nuevoNodo = new NodoBinario1(valor);
        return insertarAVLRecursivo(this, nuevoNodo);
    }

    private NodoBinario1 insertarAVLRecursivo(NodoBinario1 nodo, NodoBinario1 nuevoNodo) {
        if (nodo == null) {
            return nuevoNodo;
        }

        // Realizar la inserción del nuevo nodo
        if (nuevoNodo.valor < nodo.valor) {
            nodo.izquierdo = insertarAVLRecursivo(nodo.izquierdo, nuevoNodo);
        } else if (nuevoNodo.valor > nodo.valor) {
            nodo.derecho = insertarAVLRecursivo(nodo.derecho, nuevoNodo);
        } else {
            // No se permiten duplicados, simplemente retornamos el nodo actual
            return nodo;
        }

        // Actualizar la altura del nodo actual
        nodo.altura = 1 + Math.max(obtenerAltura(nodo.izquierdo), obtenerAltura(nodo.derecho));

        // Calcular el factor de balance del nodo actual
        int balance = obtenerBalance(nodo);

        // Realizar las rotaciones según sea necesario para mantener el balance del árbol
        if (balance > 1 && nuevoNodo.valor < nodo.izquierdo.valor) {
            return rotarDerecha(nodo);
        }
        if (balance < -1 && nuevoNodo.valor > nodo.derecho.valor) {
            return rotarIzquierda(nodo);
        }
        if (balance > 1 && nuevoNodo.valor > nodo.izquierdo.valor) {
            nodo.izquierdo = rotarIzquierda(nodo.izquierdo);
            return rotarDerecha(nodo);
        }
        if (balance < -1 && nuevoNodo.valor < nodo.derecho.valor) {
            nodo.derecho = rotarDerecha(nodo.derecho);
            return rotarIzquierda(nodo);
        }

        // Si no se requieren rotaciones, simplemente retornamos el nodo actual
        return nodo;
    }

    // Métodos auxiliares para obtener la altura y el factor de balance de un nodo
    private int obtenerAltura(NodoBinario1 nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.altura;
    }

    private int obtenerBalance(NodoBinario1 nodo) {
        if (nodo == null) {
            return 0;
        }
        return obtenerAltura(nodo.izquierdo) - obtenerAltura(nodo.derecho);
    }

    // Métodos auxiliares para realizar las rotaciones
    private NodoBinario1 rotarDerecha(NodoBinario1 y) {
        NodoBinario1 x = y.izquierdo;
        NodoBinario1 T2 = x.derecho;

        // Realizar rotación
        x.derecho = y;
        y.izquierdo = T2;

        // Actualizar alturas
        y.altura = Math.max(obtenerAltura(y.izquierdo), obtenerAltura(y.derecho)) + 1;
        x.altura = Math.max(obtenerAltura(x.izquierdo), obtenerAltura(x.derecho)) + 1;

        // Retornar nueva raíz
        return x;
    }

    private NodoBinario1 rotarIzquierda(NodoBinario1 x) {
        NodoBinario1 y = x.derecho;
        NodoBinario1 T2 = y.izquierdo;

        // Realizar rotación
        y.izquierdo = x;
        x.derecho = T2;

        // Actualizar alturas
        x.altura = Math.max(obtenerAltura(x.izquierdo), obtenerAltura(x.derecho)) + 1;
        y.altura = Math.max(obtenerAltura(y.izquierdo), obtenerAltura(y.derecho)) + 1;

        // Retornar nueva raíz
        return y;
    }

    



}

