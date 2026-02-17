package com.Candido.ConferenciaCientifica;

import java.util.ArrayList;

public class Conferencia {
    ArrayList<Inscripcion> inscripciones;
    ArrayList<Sesion> sesiones;
    public void confirmar(Inscripcion inscripcion){
        inscripcion.confirmada = true;
        inscripcion.cancelada = false;
    }public void cancelar(Inscripcion inscripcion){
        inscripcion.confirmada = false;
        inscripcion.cancelada = true;
    }
}
