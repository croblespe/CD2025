package com.Candido.ConferenciaCientifica;

public class Publico extends Participante{
    public void asistir(Sesion sesion){
        sesion.presentes++;
    }
}
