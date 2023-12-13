package Larionov.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Partecipazione {
    @GeneratedValue
    @Id
    private long id;
    private Persona personaPartecipante;
    private List<GestioneEventi> eventoP;
    @Enumerated(EnumType.STRING)
    private Stato stato;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;


    public Partecipazione() {
    }

    public Partecipazione(Persona personaPartecipante, List<GestioneEventi> eventoP, Stato stato, Persona persona) {
        this.personaPartecipante = personaPartecipante;
        this.eventoP = eventoP;
        this.stato = stato;
        this.persona = persona;
    }

    public long getId() {
        return id;
    }

    public Persona getPersona() {
        return personaPartecipante;
    }

    public Persona getPersonaPartecipante() {
        return personaPartecipante;
    }

    public List<GestioneEventi> getEventoP() {
        return eventoP;
    }

    public void setPersonaPartecipante(Persona personaPartecipante) {
        this.personaPartecipante = personaPartecipante;
    }

    public void setEventoP(List<GestioneEventi> eventoP) {
        this.eventoP = eventoP;
    }

    public Stato getStato() {
        return stato;
    }

    public void setPersona(Persona persona) {
        this.personaPartecipante = persona;
    }



    public void setStato(Stato stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + personaPartecipante +
                ", evento=" + eventoP +
                ", stato=" + stato +
                '}';
    }
}
