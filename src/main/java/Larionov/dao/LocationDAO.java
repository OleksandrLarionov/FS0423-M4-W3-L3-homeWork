package Larionov.dao;

import Larionov.entities.GestioneEventi;
import Larionov.entities.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Location location){

        EntityTransaction transazione =  em.getTransaction();

        transazione.begin();

        em.persist(location);

        transazione.commit();

        System.out.println("Evento" + location.getNome() + "è stato salvato con successo");
    };
    public Location getById(long id){
        Location found = em.find(Location.class, id);
        return found;
    };
    public void findByIdAndDelete(long id){
        Location found = this.getById(id);

        if (found != null){
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("Location cancellat1");

        } else {
            System.out.println("Location non trovato");
        }

    };
    public List<Location> getAllLocations() {
        List<Location> listaLocations = em.createQuery("SELECT e FROM Location e", Location.class).getResultList();
        return listaLocations;
    }
}
