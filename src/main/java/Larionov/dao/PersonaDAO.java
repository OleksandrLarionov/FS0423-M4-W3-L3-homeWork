package Larionov.dao;

import Larionov.entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class PersonaDAO {
    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Persona persona){

        EntityTransaction transazione =  em.getTransaction();

        transazione.begin();

        em.persist(persona);

        transazione.commit();

        System.out.println("Evento" + persona.getNome() + "è stato salvato con successo");
    };
    public Persona getById(long id){
        Persona found = em.find(Persona.class, id);
        return found;
    };
    public void findByIdAndDelete(long id){
        Persona found = this.getById(id);

        if (found != null){
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("La persona selezionata è stata cancellato");

        } else {
            System.out.println("Persona non trovato");
        }

    };
    public List<Persona> getAllEvents() {
        List<Persona> listaPersone = em.createQuery("SELECT e FROM Persona e", Persona.class).getResultList();
        return listaPersone;
    }
}
