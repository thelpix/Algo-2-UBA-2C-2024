package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
//la clase listaEnlazada esta constitiuda de nodos o.O
//empieza con un nodo con null y acaba con nodo con null
    private Nodo primerNodo;
    private Nodo ultimoNodo;
    private int longitud; //para contar los nodos

    private class Nodo {
        //como es un solo nodo?
        //tiene un valor tipo T, y luego dos punteros, uno que va al 1er elemento y otro al siguiente.
        private T valor;
        private Nodo anterior;
        private Nodo siguiente;

        Nodo(T valor) {
            //va a empezar solo hasta que añadas otro nodo
            this.valor = valor;
            anterior = null;
            siguiente = null;
        }
    }


    public ListaEnlazada() {
        primerNodo = null;
        ultimoNodo = null;
        longitud = 0;
    }

    public int longitud() {
        return longitud;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (primerNodo == null) {
            primerNodo = nuevo;
            ultimoNodo = nuevo;
        }
        else {
            nuevo.siguiente = primerNodo;
            primerNodo.anterior = nuevo;
            primerNodo = nuevo;
        }
        longitud += 1;
    }

    public void agregarAtras(T elem) {
        //uso el primernodo como reemplazo al nuevo nodo que contenga T elem
        //luego preguntar si el ultimo nodo esta vacio o hay otro nodo para conectarlos
        //cuando esta sin ningun elemento
        Nodo nuevo = new Nodo(elem);
        //cuando ya el nuevo.sguiente tiene otro nuevo elemento
        //pero como le digo al anterior nodo que su ultimoNodo ahora es el que puse?
        //podria separar en casos
        if (ultimoNodo == null) {
            //dos variables para llamar una sola posicion de memoria (objeto)
            primerNodo = nuevo;
            ultimoNodo = nuevo;
        }
        else {
            nuevo.anterior = ultimoNodo;
            ultimoNodo.siguiente = nuevo;
            // Actualizar el último nodo para que sea el nuevo nodo
            ultimoNodo = nuevo;
        }
        longitud += 1;
    }

    public T obtener(int i) {
        //recorrer de primerNodo hasta ultimo
        //empezar con el primer nodo
        //desde final hasta atras
        Nodo elegido = primerNodo;
        //primero recorrer todos los nodos hasta que sea i
        for (int j = 0; j < i; j++) {
            //llegar al nodo i 
            elegido = elegido.siguiente;
        }
        return elegido.valor;
    }

    public void eliminar(int i) {
        //similar a la primera parte de obtener 
        Nodo borrado = primerNodo;
        //primero recorrer todos los nodos hasta que sea 
        for (int j = 0; j < i; j++) {
            //llegar al nodo i 
            borrado = borrado.siguiente;
        }
        if (borrado == primerNodo && borrado == ultimoNodo) {
            primerNodo = null;
            ultimoNodo = null;
        }
        else if (borrado == primerNodo) {
            primerNodo = borrado.siguiente;
            primerNodo.anterior = null;
        }
        else if (borrado == ultimoNodo) {
            ultimoNodo = borrado.anterior;
            ultimoNodo.siguiente = null;
        }
        else {
            (borrado.anterior).siguiente = borrado.siguiente;
            (borrado.siguiente).anterior = borrado.anterior;
        }
        longitud -= 1;
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo modificado = primerNodo;
        //primero recorrer todos los nodos hasta que sea 
        for (int j = 0; j < indice; j++) {
            //llegar al nodo i 
            modificado = modificado.siguiente;
        }
        modificado.valor = elem;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        //a la listaEnlazada que estoy creando le asigno estos valores:
        this.longitud = 0;
        this.primerNodo = null;
        this.ultimoNodo = null;
        //a la listaEnlazada que estoy creando le asigno estos nodos copiados de lista
        for (int i = 0; i < lista.longitud(); i++) {
            this.agregarAtras(lista.obtener(i));
        }
    }
    
    @Override
    public String toString() {
        //puedo hacer como en agenda otra funcion para imprimir cada elem de los nodos + ","
        String stringLista = "[" + imprimirNodos(this);
        stringLista += "]";
        return stringLista;
    }

    private String imprimirNodos(ListaEnlazada<T> listaEnlazada) {
        String imprimir = "";
        for (int i = 0; i < longitud() - 1; i++) {
            imprimir += String.valueOf(this.obtener(i)) + ", ";
        }
        //no me sale usar substring :(
        imprimir += String.valueOf(this.obtener(this.longitud()-1));
        return imprimir;
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados
        private int i;
        public ListaIterador(){
            i = 0;
        }

        public boolean haySiguiente() {
            //que i sea menor al tamaño
	        return i < longitud;
        }
        
        public boolean hayAnterior() {
	        return i-1 >= 0;
        }

        public T siguiente() {
	        //devuelve sig nodo
            T elem = obtener(i);
            //suma i
            i++;
            return elem;
        }
        

        public T anterior() {
	        //devuelve sig nodo
            i--;
            T elem = obtener(i);
            return elem;
        }
    }

    public Iterador<T> iterador() {
        //tendria que devolver listaIterador (Iterador de la lista)
        return new ListaIterador();
    }

}
