## Breve descripcion del proyecto

En este proyecto se buscaba que partiendo de un enunciado, se creara tanto las clases como sus relaciones con el lenguaje  
de programacion ***JAVA***, asi como su representacion grafica usando ***mermaid***. Para ello utililice ***Git*** e ***IntellijIDEA*** con sus respectivos plugins.   
Se crearon un total de 8 clases:
1. **Conferencia**
2. **Sesion**
3. **Participante**
4. **Orador**
5. **Publico**
6. **Inscripcion**
7. **ArtigoCientifico**
8. **Autor**

## Diagrama mermaid del proyecto
 ```mermaid
 classDiagram
    class Conferencia{
        +sesions: List[sesion]
        +inscripciones: List[Inscripcion]
        +confirmar(inscripcion: Inscripcion)
        +cancelar(inscripcion: Inscripcion)
    }
    class Sesion{
        +data: String
        +hora_inicio: Int
        +presentes: Int
    }
    class Participante{
        +edad : int
        +nombre : String
        +inscribir(conferencia : Conferencia): Inscripcion
    }
    class Orador{
        +presentar(artigoCientifico: ArtigoCientifico)
    }
    class Publico{
        +asistir(Sesion)
    }
    class Inscripcion{
        +conferencia: Conferencia
        +participante: Participante
        +confirmada: Boolean
        +cancelada: Boolean
    }
    class ArtigoCientifico{
        +tema: String
        +curto: Boolean
        +longo: Boolean
        +presentacion: String
    }
    class Autor{
        +nome : String
        +idade : int
        +artigosPresentados: List[ArtigoCientifico]
        +xera():ArtigoCientifico

    }

    Sesion "N" *-- "1" Conferencia : existir
    Participante "1" --> "N" Inscripcion : formula
    Conferencia "1" --> "N" Inscripcion : procesa
    ArtigoCientifico "N" *-- "1" Autor : xera
    Autor "1" --> "N" Conferencia : artigos presentados
    Participante <|-- Orador
    Participante <|-- Publico
    Participante "1" --> "N" Conferencia : inscribese
    Sesion "1" --> "N" ArtigoCientifico : presentase



```
## Codigo correspondiente a las clases

1. **Conferencia**: La clase conferencia por una parte mantiene un registro de las inscripciones a procesar y de las sesiones que contiene, asi como las funciones que procesan dichas inscripciones. 
```java
package com.Candido.ConferenciaCientifica;

import java.util.ArrayList;

public class Conferencia {
    ArrayList<Inscripcion> inscripciones;
    ArrayList<Sesion> sesiones;
    public void confirmar(Inscripcion inscripcion){
        inscripcion.confirmada = true;
        inscripcion.cancelada = false;
    }
    public void cancelar(Inscripcion inscripcion){
        inscripcion.confirmada = false;
        inscripcion.cancelada = true;
    }
}
```
2. **Sesion**: Es una clase simple, que mantiene un registro del estado de cada sesion. El atributo ***presentes***, iteracciona con la funcion ***asistir*** de **publico**, de tal modo que cada vez que  
 una instancia de **publico** decide asistir a una **sesion**, el atributo se actualiza, aumentando en 1.
```java
package com.Candido.ConferenciaCientifica;

public class Sesion {
    int data;
    int horaDeInicio;
    int presentes;
}

```
3. **Participante**: Su funcion principal es ***inscribir*** con un parametro **Conferencia**, a la cual se inscribira al participante en cuestion. Con ella, se genera una instancia de ***Inscripcion***  
 en la que el atributo ***Inscripcion.nombre*** es el propio nombre del objeto **Participante** que la invoca, tras eso, **conferencia** añade a la **Inscripcion** resultante en su lista de ***inscripciones***. 
```java
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

```
4. **Publico**: Es una extension de **Participante**, conteniendo el metodo ***asistir***, el cual tras su invocacion aumenta en uno el numero de ***Sesion.presentes***
```java
package com.Candido.ConferenciaCientifica;

public class Publico extends Participante{
    public void asistir(Sesion sesion){
        sesion.presentes++;
    }
}
```
5. **Inscripcion**: Es una clase "enlace" entre **Participante** y **Conferencia**, en ella se especifica que participante esta inscrito en que conferencia. Mantiene tambien el estado de la inscripcion  
detallando si esta cancelada o confirmada por **Conferencia**. Aparte, contiene un constructor, el cual permite crear instancias de **Inscripcion** especificando **Conferencia** y **Participante**
```java
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

```
6. **Orador**: Es otra extension de **Participante**, la cual se encarga de "presentar" el atributo ***presentacion*** de ***ArtigoCientifico***.
```java
package com.Candido.ConferenciaCientifica;

public class Orador extends Participante {
    public void presentar(ArtigoCientifico artigoCientifico){
        System.out.println(artigoCientifico.presentacion);
    }
}


```
7. **ArtigoCientifico**: Contiene datos de un articulo cientifico creado por un **Autor**, asi como una referencia a dicho **Autor**
```java
package com.Candido.ConferenciaCientifica;

public class ArtigoCientifico {
    String tema;
    String presentacion;
    Boolean curto;
    Boolean longo;
    Autor autor;
}

```
8. **Autor**: Es el creador del articulo cientifico. Contiene un registro de todos sus articulos asi como un metodo que los genera, asignado al atributo ***ArticuloCientifico.autor** su propia instancia.
```java
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

```