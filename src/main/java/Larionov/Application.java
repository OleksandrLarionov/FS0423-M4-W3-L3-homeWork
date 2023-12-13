package Larionov;

import Larionov.dao.GestioneEventiDAO;
import Larionov.entities.GestioneEventi;
import Larionov.entities.TipoEvento;
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
        GestioneEventiDAO ged = new GestioneEventiDAO(em);
        Faker faker = new Faker();

//        *****************************SUPPLIERS******************************
        Supplier<LocalDate> dateSupplier = () -> {
            Random rdm = new Random();
            int randomYear = rdm.nextInt(2000,2024);
            int randomDay = rdm.nextInt(1,30);
            int randomMonth = rdm.nextInt(1,12);
            return LocalDate.of(randomYear, randomMonth,randomDay);
        };

        Supplier<Integer> pplInvitationSupplier = () -> {
            Random rndm = new Random();
            int ppl = rndm.nextInt(1, 150);
            return  ppl;
        };

        Supplier<TipoEvento> supplierEventoRndm = () -> {
            Random rndm = new Random();
            int numRandom = rndm.nextInt(1,3);
            if (numRandom == 1) {
                return TipoEvento.PRIVATO;
            } else {
                return TipoEvento.PUBBLICO;
            }
        };

        Supplier<GestioneEventi> nuovoEventoSupplier = () -> new GestioneEventi(faker.name().title(), dateSupplier.get(), faker.gameOfThrones().city(), supplierEventoRndm.get(), pplInvitationSupplier.get());

//        ********************CREAZIONE EVENTI****************

//        for (int i = 0; i < 70; i++){
//            ged.save(nuovoEventoSupplier.get());
//        }

        System.out.println("********************LISTA EVENTI********************");

        List<GestioneEventi> listaEventi = ged.getAllEvents();
        listaEventi.forEach(System.out::println);


//        ********************DELETE EVENT****************
        System.out.println("********************EVENTI CANCELLATI********************");

        ged.findByIdAndDelete(3);

        em.close();
        emf.close();

    }
}
