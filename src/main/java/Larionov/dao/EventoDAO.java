package Larionov.dao;

import Larionov.entities.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Evento evento){

        EntityTransaction transazione =  em.getTransaction();

        transazione.begin();

        em.persist(evento);

        transazione.commit();

        System.out.println("Evento" + evento.getTitolo() + "è stato salvato con successo");
    };
    public Evento getById(long id){
        Evento found = em.find(Evento.class, id);
        return found;
    };
    public void findByIdAndDelete(long id){
        Evento found = this.getById(id);

        if (found != null){
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("Evento cancellato");

        } else {
            System.out.println("Evento non trovato");
        }

    };
    public List<Evento> getAllEvents() {
        List<Evento> listaEventi = em.createQuery("SELECT e FROM Evento e", Evento.class).getResultList();
        return listaEventi;
    }
}
