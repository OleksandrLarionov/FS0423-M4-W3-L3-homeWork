package Larionov.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Partecipazione {
    @GeneratedValue
    @Id
    private long id;
    @Enumerated(EnumType.STRING)
    private Stato stato;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;


    public Partecipazione() {
    }

    public Partecipazione( Stato stato, Persona persona) {

        this.stato = stato;
        this.persona = persona;
    }

    public long getId() {
        return id;
    }








    public Stato getStato() {
        return stato;
    }





    public void setStato(Stato stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" +
                ", evento=" +
                ", stato=" + stato +
                '}';
    }
}
