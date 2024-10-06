package aed;

public class Agenda {
    private Fecha fechaActual;
    private ArregloRedimensionableDeRecordatorios recordatorio = new ArregloRedimensionableDeRecordatorios();

    public Agenda(Fecha fechaActual) {
        this.fechaActual = fechaActual;
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        this.recordatorio.agregarAtras(recordatorio);
    }

    public String imprimirRecordatorios(ArregloRedimensionableDeRecordatorios listaRecordatorios) {
        String imprimir = "";
        //imprimir los recordatorios que coincidan fecha dentro del array de recordatorios
        for (int i=0; i < listaRecordatorios.longitud(); i++) { 
            //chequear si la fecha de un recordatorio i del array coincide con nuestra fecha
            if ((listaRecordatorios.obtener(i).fecha()).equals(fechaActual)) {
                imprimir += listaRecordatorios.obtener(i).toString() + "\n";
            }
        }
        return imprimir;
    }

    @Override
    public String toString() {
        return fechaActual.toString() + "\n" + "=====" + "\n" + imprimirRecordatorios(recordatorio);
    }

    public void incrementarDia() {
        fechaActual.incrementarDia();
    }

    public Fecha fechaActual() {
        return this.fechaActual.clonar();
    }

}
