package com.Candido.ConferenciaCientifica;

public class Inscripcion {
    Conferencia conferencia;
    Participante participante;
    Boolean confirmada;
    Boolean cancelada;
    public Inscripcion(Participante participante, Conferencia conferencia){
        this.participante = participante;
        this.conferencia = conferencia;
    }
}
