package aed;

public class Horario {
    private int hora;
    private int minutos;

    public Horario(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }

    public int hora() {
        return hora;
    }

    public int minutos() {
        return minutos;
    }

    @Override
    public String toString() {
        return hora+":"+minutos;
    }

    @Override
    public boolean equals(Object otro) {
        //chequear que no este vacio ni sea otra clase
        boolean isNull = otro == null;
        boolean isDifferentClass = otro.getClass() != this.getClass();

        if (isNull || isDifferentClass) {return false;}
        //castear y forzar otra instancia
        Horario otroHorario = (Horario) otro;
        //preguntar
        return this.hora == otroHorario.hora && this.minutos == otroHorario.minutos;
    }

    public Horario clonar(){
        return new Horario(this.hora, this.minutos);
    }
}
