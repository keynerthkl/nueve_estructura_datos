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
    NodoBinario1 izquierdo, derecho;

    public NodoBinario1(int valor) {
        this.valor = valor;
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
    
    
}

