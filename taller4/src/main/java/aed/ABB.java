package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto, similar a lista doblemente enlazada
    private Nodo _raiz;
    private int cardinal;

    private class Nodo {
        // Agregar atributos privados del Nodo
        T valor;
        Nodo izq;
        Nodo der;

        // Crear Constructor del nodo
        public Nodo(T valor) {
            this.valor = valor;
            izq = null;
            der = null;
        }
    }

    public ABB() {
        _raiz = null;
        cardinal = 0;
    }

    public int cardinal() {
        return cardinal;
    }

    public T minimo(){
        Nodo nodoActual = _raiz;
        //si hay uno mas chico que el que tengo ahora
        while(nodoActual.izq != null){
            nodoActual = nodoActual.izq;
        }
        return nodoActual.valor;
    }

    public T maximo(){
        Nodo nodoActual = _raiz;
        //Si hay uno mas grande que el que tengo ahora
        while(nodoActual.der != null){
            nodoActual = nodoActual.izq;
        }
        return nodoActual.valor;
    }

    public void insertar(T elem){
        Nodo nodoActual = _raiz;
        Nodo nodoPadre = null;
        //tengo que ver si pertenece el nodo
        if(pertenece(elem)) {
            return;
        }
        if(_raiz == null) {
            _raiz = new Nodo(elem);
            cardinal++;
            return;
        }
        //no me gusta que haya copiado el while :(
        while(nodoActual != null){
            nodoPadre = nodoActual;
            //cuando elem < nodoActual.valor
            if(nodoActual.valor.compareTo(elem) > 0) {
                nodoActual = nodoActual.izq;
                
            }
            //cuando elem > nodoActual.valor
            else {
                nodoActual = nodoActual.der;
            }
        }
        //el nuevo nodo ya tiene el valor
        //debo hacer que el nuevo nodo este vinculado a su padre
        nodoActual = new Nodo(elem);
        if(elem.compareTo(nodoPadre.valor) > 0) {
            nodoPadre.der = nodoActual;
        }
        else{
            nodoPadre.izq = nodoActual;
        }
        cardinal++;
    }

    public boolean pertenece(T elem){
        //si no es t elem, seguir de forma recursiva
        //si es null, entonces es que no esta
        Nodo nodoActual = _raiz;
        while(nodoActual != null)
        {
            //cuando elem < nodoActual.valor
            if(nodoActual.valor.compareTo(elem) > 0) {
                nodoActual = nodoActual.izq;
                
            }
            //cuando elem > nodoActual.valor
            else if(nodoActual.valor.compareTo(elem) < 0) {
                nodoActual = nodoActual.der;
            }
            //cuando elem == nodoActual.valor
            else {
                return true;
            }
        }
        return false;
    }                       

    public void eliminar(T elem){
        //cuando no esta
        if(!pertenece(elem)){
            return;
        }
        Nodo nodoActual = _raiz;
        Nodo nodoHijoIzq = null; //no se si hace falta
        Nodo nodoHijoDer = null; //no se si hace falta, veo
        Nodo nodoPadre = null;
        //buscar el nodo a borrar
        while(nodoActual.valor != elem) {
            nodoPadre = nodoActual
            if(elem.compareTo(nodoActual.valor) > 0){
                nodoActual = nodoActual.der;
            }
            else{
                nodoActual = nodoActual.izq;
            }
        }
        //desvincular al nodo padre si su nodo hijo no tiene hijos
        if(nodoActual.izq == null && nodoActual.der == null){
            nodoActual = null;
        }
        //flojera luego corrijo esto
        if(nodoActual.izq != null && nodoActual.der == null){

        }
        if(elem.compareTo(nodoPadre.valor) > 0){
            nodoPadre.der = null;
        }
        else{
            nodoPadre.izq = null;
        }
            //cuando no tiene hijos
            //cuando tiene un hijo
            //cuando tiene 2 hijos
        cardinal--;
        throw new UnsupportedOperationException("No implementada aun");
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
