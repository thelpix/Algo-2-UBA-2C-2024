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
            nodoActual = nodoActual.der;
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
        Nodo nodoPadre = null;

        //buscar el nodo a borrar
        while(nodoActual != null && nodoActual.valor.compareTo(elem) != 0) {
            nodoPadre = nodoActual;
            if(elem.compareTo(nodoActual.valor) > 0){
                nodoActual = nodoActual.der;
            }
            else{
                nodoActual = nodoActual.izq;
            }
        }   
        if (nodoActual == null) {
            return;
        }
        //ineficaz, lo sé
        //una vez encontrado, reemplazar
        //cuando no tiene hijos (izq y der null), uso AND
        if(nodoActual.der == null && nodoActual.izq == null) {
            //cuando la raiz no tiene hijos
            if (nodoPadre == null){
                _raiz = null;
            }
            //¿como se que el nodoActual esta en la derecha o izq del nodoPadre?
            else if(nodoPadre.izq == nodoActual){
                nodoPadre.izq = null;
            }
            else{
                nodoPadre.der = null;
            }
        }
        //cuando tiene un hijo (alguno es no null), uso XOR
        else if (nodoActual.der == null ^ nodoActual.izq == null) {
            //asigno variable temporal hijo
            Nodo hijo;
            if(nodoActual.izq != null){
                hijo = nodoActual.izq;
            }
            else{
                hijo = nodoActual.der;
            }
            //cuando nodoPadre es null, o sea, nodoActual es la _raiz
            if (nodoPadre == null) {
                _raiz = hijo;
            } else if (nodoPadre.izq == nodoActual) {
                nodoPadre.izq = hijo;
            } else {
                nodoPadre.der = hijo;
            }

        }
        //cuando tiene 2 hijos (los dos no null), los anteriores fueron FALSOS
        //tengo que reemplazar el nodoActual por el máximo de nodoActual.izq
        //busco el maximo
        else{
            Nodo maxDelMinimo = nodoActual.izq;
            Nodo maxDelMinimoPadre = nodoActual;

            while(maxDelMinimo.der != null){
                maxDelMinimoPadre = maxDelMinimo;
                maxDelMinimo = maxDelMinimo.der;
            }

            //remplazo el valor del nodoActual con MaxDelMinimo
            nodoActual.valor = maxDelMinimo.valor;

            //si el Maximo del Minimo tiene un hijo izq, lo conecta al Padre
            if (maxDelMinimoPadre != nodoActual) {
                maxDelMinimoPadre.der = maxDelMinimo.izq;
            }
            else{
                maxDelMinimoPadre.izq = maxDelMinimo.izq;
            }
        }

        cardinal--;
    }

    public String toString(){
        //podria imprimir minimos, y luego borrar el minimo para que me de el siguiente hasta que este vacio

        String stringLista = "{" + imprimirNodos(this._raiz);
        //no esta vacio
        if (stringLista.length() > 1){
            stringLista = stringLista.substring(0, stringLista.length()-1);
        }
        stringLista += "}";
        return stringLista;
    }

    private String imprimirNodos(Nodo nodo){
        if(nodo == null){
            return "";
        }
        String imprimir = "";
        imprimir += String.valueOf(imprimirNodos(nodo.izq)); //primero por izq
        imprimir += String.valueOf(nodo.valor) + ","; //el del medio :#
        imprimir += String.valueOf(imprimirNodos(nodo.der)); //luego los der
        return imprimir;
    }

    private class ABB_Iterador implements Iterador<T> {
        //clase pila 
        private Stack<Nodo> pila = new Stack<Nodo>();
        private Nodo _actual;

        public ABB_Iterador(){
            _actual = _raiz;
            //cargo los nodos del subarbol izq.
            while(_actual != null){
                pila.push(_actual);
                _actual = _actual.izq;
            }
        }

        public boolean haySiguiente() {            
            return !pila.isEmpty();
        }
    
        public T siguiente() {
            // saco el sig. nodo de la pila
            Nodo nodo = pila.pop();
            T result = nodo.valor;

            // si tiene subarbol derecho, apilo los nodos izq.
            if (nodo.der != null){
                nodo = nodo.der;

                // apilo los nodos del subarbol izq. del nodo que agarre
                while(nodo != null){
                    pila.push(nodo);
                    nodo = nodo.izq;
                }
            }
            return result;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
