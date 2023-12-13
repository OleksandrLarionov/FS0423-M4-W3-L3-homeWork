package Larionov.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Partecipazione {
    @GeneratedValue
    @Id
    private long id;
    private List<Persona> persona;
    private List<GestioneEventi> evento;
    @Enumerated(EnumType.STRING)
    private Stato stato;

    public Partecipazione() {
    }
    public Partecipazione(List<Persona> persona, List<GestioneEventi> evento, Stato stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    public long getId() {
        return id;
    }

    public List<Persona> getPersona() {
        return persona;
    }

    public List<GestioneEventi> getEvento() {
        return evento;
    }

    public Stato getStato() {
        return stato;
    }

    public void setPersona(List<Persona> persona) {
        this.persona = persona;
    }

    public void setEvento(List<GestioneEventi> evento) {
        this.evento = evento;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }
}
