package aed;

public class Recordatorio {
    private String mensaje;
    private Fecha fecha;
    private Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = fecha.clonar(); 
        this.horario = horario.clonar();
    }

    public Horario horario() {
        return horario;
    }

    public Fecha fecha() {
        return fecha.clonar();
    }

    public String mensaje() {
        // Implementar
        return mensaje;
    }

    @Override
    public String toString() {
        return mensaje + " @ " + fecha.dia() + "/" + fecha.mes() + " " + horario.hora() + ":" + horario.minutos(); 
    }

    @Override
    public boolean equals(Object otro) {
        //chequear que el objeto no sea nulo ni diferente
        boolean isNull = otro == null;
        boolean isDifferentClass = otro.getClass() != this.getClass();

        //if (this == otro) {return true;}
        if (isDifferentClass || isNull) {return false;}
        //castear nuevo objeto referencial
        Recordatorio otroRecordatorio = (Recordatorio) otro;
        //preguntar mensaje y dentro de cada objeto? o objeto directo?
        return this.mensaje.equals(otroRecordatorio.mensaje) && this.fecha.equals(otroRecordatorio.fecha) && this.horario.equals(otroRecordatorio.horario);
    }

}
