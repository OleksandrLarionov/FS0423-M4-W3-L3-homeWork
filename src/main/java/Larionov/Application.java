package Larionov;

import Larionov.dao.EventoDAO;
import Larionov.dao.LocationDAO;
import Larionov.dao.PartecipazioneDAO;
import Larionov.dao.PersonaDAO;
import Larionov.entities.*;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("FS0423-M4-W3-L3-homeWork");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO ed = new EventoDAO(em);
        PersonaDAO pd = new PersonaDAO(em);
        LocationDAO ld = new LocationDAO(em);
        PartecipazioneDAO partd = new PartecipazioneDAO(em);

        Faker faker = new Faker();

//        ********************CREAZIONE LOCATION****************
        Location tokyo = new Location("Giappone","Tokyo");
//        ld.save(tokyo);

//        ********************CREAZIONE EVENTI****************
        Evento olimpiadi = new Evento("Nuoto", LocalDate.of(2024,2,25), "Olimpiadi di nuoto libero con lo skate",TipoEvento.PUBBLICO, 20000, tokyo);
//        ed.save(olimpiadi);

        System.out.println("********************CREAZIONE DEL PARTECIPANTE********************");
        Persona paolo = new Persona("Paolo","Marchetti","paolo@mail.com", LocalDate.of(1991,4,25), Gender.MALE);
        Persona marco = new Persona("Marco","Carta","sondicarta@mail.com", LocalDate.of(1985,1,11), Gender.MALE);

//        pd.save(paolo);
//        pd.save(marco);

        System.out.println("******************************CONFERMO LA PARTECIPAZIONE*******************");
        Partecipazione partUno = new Partecipazione(paolo, olimpiadi, Stato.CONFERMATA);
        Partecipazione partDue = new Partecipazione(marco, olimpiadi, Stato.CONFERMATA);

//        partd.save(partUno);
//        partd.save(partDue);

        System.out.println("********************LISTA EVENTI********************");

        List<Evento> listaEventi = ed.getAllEvents();
        listaEventi.forEach(System.out::println);

        System.out.println("********************NOME EVENTO CON ID********************");
        ed.getEventoNameById(33);

//        ********************DELETE EVENT****************
        System.out.println("********************EVENTI CANCELLATI********************");

//        ed.findByIdAndDelete(33);

        em.close();
        emf.close();
    }
}
