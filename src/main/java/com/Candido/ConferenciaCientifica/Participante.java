package com.Candido.ConferenciaCientifica;

public class Participante {
    int edad;
    String nombre;
    public Inscripcion inscribir(Conferencia conferencia){
        Inscripcion inscripcion = new Inscripcion(this);
        conferencia.inscripciones.add(inscripcion);
        inscripcion.conferencia = conferencia;
        return inscripcion;
    }
}
