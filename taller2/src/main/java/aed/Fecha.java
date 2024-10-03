package aed;

public class Fecha {
    private int dia;
    private int mes;

    public Fecha(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
    }

    public Fecha(Fecha fecha) {
        // Implementar
    }

    public Integer dia() {
        return dia;
    }

    public Integer mes() {
        return mes;
    }

    @Override
    public String toString() {
        return dia + "/" + mes;
    }

    @Override
    public boolean equals(Object otra) {
        // primero que no este vacio
        // si es una clase distinta
        boolean isNull = (otra == null);
        boolean differentClass = otra.getClass() != this.getClass();
        
        if (isNull || differentClass) {return false;}
        // hacer casting
        Fecha otraFecha = (Fecha) otra;
        //recien ahi preguntar
        return this.dia == otraFecha.dia && this.mes == otraFecha.mes;
    }

    public void incrementarDia() {
        dia+=1;
        if (dia > diasEnMes(mes)) {
            dia = 1;
            mes+= 1;
        }
        //cuando termina el año, dia = 1, y mes = 13(no existe)
        if (mes > 12) {
            mes = 1;
        }
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
