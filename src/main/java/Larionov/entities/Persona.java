package Larionov.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Persona {
    @GeneratedValue
    @Id
    private long id;
    private String nome;
    private String cognome;
    private String email;
    @Column(name="data_di_nascita")
    private LocalDate dataDiNascita;
    @Enumerated(EnumType.STRING)
    private Gender sesso;

    @ManyToOne
    @JoinColumn(name = "gestioneeventi_id")
    private GestioneEventi gestioneeventi;


    public Persona() {
    }
    public Persona(String nome, String cognome, String email, LocalDate dataDiNascita, Gender sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.sesso = sesso;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public Gender getSesso() {
        return sesso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public void setSesso(Gender sesso) {
        this.sesso = sesso;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", sesso=" + sesso +
                ", listaPartecipazioni=" +
                '}';
    }
}
