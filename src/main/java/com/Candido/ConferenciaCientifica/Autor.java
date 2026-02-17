package com.Candido.ConferenciaCientifica;

import java.util.List;

public class Autor {
    String nome;
    int idade;
    List<ArtigoCientifico> artigoPresentados;
    public ArtigoCientifico xera(){
        ArtigoCientifico novoArtigo = new ArtigoCientifico();
        novoArtigo.autor = this;
        return novoArtigo;
    }
}
