package Larionov.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Partecipazione {
    @GeneratedValue
    @Id
    private long id;
//    private List<Persona> persona;
//    private List<GestioneEventi> evento;
    @Enumerated(EnumType.STRING)
    private Stato stato;

    public Partecipazione() {
    }
    public Partecipazione(List<Persona> persona, Stato stato) {
        this.stato = stato;
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
