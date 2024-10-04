package aed;

class ArregloRedimensionableDeRecordatorios {
    private Recordatorio[] listaRecordatorios = new Recordatorio[0];//empieza vacio

    public ArregloRedimensionableDeRecordatorios() {
        //listaRecordatorios = new Recordatorio[0];
    }

    public int longitud() {
        return listaRecordatorios.length;
    }

    public void agregarAtras(Recordatorio i) {
        //agregar el elemento y aumentar un espacio, o sea, crear otro array
        Recordatorio[] nuevaListaRecordatorios = new Recordatorio[listaRecordatorios.length + 1];


        //añadir elementos antiguos + nuevos
        for (int j = 0; j < listaRecordatorios.length; j++) {
            nuevaListaRecordatorios[j] = listaRecordatorios[j];
        }
        nuevaListaRecordatorios[nuevaListaRecordatorios.length - 1] = i;

        //referenciar
        listaRecordatorios = nuevaListaRecordatorios;
    }

    public Recordatorio obtener(int i) {
        return listaRecordatorios[i];
    }

    public void quitarAtras() {
        //Saca el ultimo elemento del array, eliminando la posicion
        Recordatorio[] nuevaListaRecordatorios = new Recordatorio[listaRecordatorios.length - 1];

        for (int    i = 0; i < nuevaListaRecordatorios.length; i++) {
            nuevaListaRecordatorios[i] = listaRecordatorios[i];
        }

        listaRecordatorios = nuevaListaRecordatorios;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        listaRecordatorios[indice] = valor;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        ArregloRedimensionableDeRecordatorios clonArreglo = new ArregloRedimensionableDeRecordatorios();
        for (int i = 0; i < vector.listaRecordatorios.length; i++) {
            clonArreglo.agregarAtras(vector.listaRecordatorios[i]);
        }
        this.listaRecordatorios = clonArreglo.listaRecordatorios;
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        return new ArregloRedimensionableDeRecordatorios(this);
    }
}
