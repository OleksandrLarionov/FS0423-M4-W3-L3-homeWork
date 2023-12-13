package Larionov.entities;

import javax.persistence.*;

@Entity
public class Partecipazione {
    @GeneratedValue
    @Id
    private long id;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "partecipante_id")
    private Persona partecipante;

    @Enumerated(EnumType.STRING)
    private Stato stato;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "evento_id")
    private Evento evento;

    public Partecipazione() {
    }

    public Partecipazione(Persona partecipante, Evento evento, Stato stato) {
        this.partecipante = partecipante;
        this.evento = evento;
        this.stato = stato;
    }

    public long getId() {
        return id;
    }

    public Persona getPartecipante() {
        return partecipante;
    }

    public Evento getEvento() {
        return evento;
    }

    public Stato getStato() {
        return stato;
    }


    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public void setPartecipantea(Persona persona) {
        this.partecipante = persona;
    }

    @Override
    public String toString() {
        return "Partecipazione {" +
                "id= " + id +
                ", partecipante= " + partecipante +
                ", evento= " + evento +
                ", stato= " + stato +
                ", persona= " + partecipante +
                '}';
    }
}
