package Larionov.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Location {
    @GeneratedValue
    @Id
    private long id;
    private String nome;
    private String citta;

    @ManyToMany
    @JoinTable(name = "gestioneeventi_location",
            joinColumns = @JoinColumn(name = "location"),
            inverseJoinColumns = @JoinColumn(name = "gestioneeventi_id")
    )

    private List<GestioneEventi> gestioneEventiList;

    public Location() {
    }

    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCitta() {
        return citta;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}
