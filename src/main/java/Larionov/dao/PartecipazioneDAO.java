package Larionov.dao;

import Larionov.entities.Partecipazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class PartecipazioneDAO {
    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Partecipazione partecipante){

        EntityTransaction transazione =  em.getTransaction();

        transazione.begin();

        em.persist(partecipante);

        transazione.commit();

        System.out.println("Partecipante"  + " è stato salvato con successo");
    };
    public Partecipazione getById(long id){
        Partecipazione found = em.find(Partecipazione.class, id);
        return found;
    };
    public void findByIdAndDelete(long id){
        Partecipazione found = this.getById(id);

        if (found != null){
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("Partecipante elliminato");

        } else {
            System.out.println("Partecipante non trovato");
        }

    };
    public List<Partecipazione> tuttiIPartecipanti() {
        List<Partecipazione> listaPartecipanti = em.createQuery("SELECT e FROM Partecipazione e", Partecipazione.class).getResultList();
        return listaPartecipanti;
    }
}
