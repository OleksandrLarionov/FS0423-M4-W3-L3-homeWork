package Larionov.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue
    private long Id;
    @Column(name = "titolo")
    private String titolo;
    @Column(name = "dataevento")
    private LocalDate dataEvento;
    @Column(name = "descrizione")
    private String descrizione;
    @Column(name = "tipoevento")
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    @Column(name = "numeromassimopartecipanti")
    private int numeroMassimoPartecipanti;
    @OneToMany(mappedBy = "evento")
    private List<Partecipazione> partecipazioneList;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "location_id")
    private Location location;
    public Evento() {
    }

    public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.location = location;
    }

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public List<Partecipazione> getPartecipazioneList() {
        return partecipazioneList;
    }

    public long getId() {
        return Id;
    }

    public Location getLocation() {
        return location;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }


    public void setLocation(Location location) {
        this.location = location;
    }


    @Override
    public String toString() {
        return "Evento{" +
                "Id=" + Id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                ", persone=" +
                ", location=" + location +
                ", locationList=" +
                '}';
    }
}
