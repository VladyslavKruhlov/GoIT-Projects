package Services;

import Entity.Client;
import Entity.Planet;
import Entity.Ticket;
import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetCrudService {
    public void createPlanet(String id, String name){
        try {
            Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            Planet newPlanet = new Planet();
            newPlanet.setName(name);
            newPlanet.setId(id);
            session.persist(newPlanet);
            System.out.println(newPlanet);

            transaction.commit();
            session.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void editPlanetName(String id, String name){
        try {
            Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            Planet editingPlanet = session.get(Planet.class, id);

            if(editingPlanet!=null){
                editingPlanet.setName(name);
                session.persist(editingPlanet);

            } else {
                System.out.println("Not found");
            }
            transaction.commit();
            session.close();

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void deletePlanet(String id) {
            try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();

                Planet deletedPlanet = session.get(Planet.class, id);

                if (deletedPlanet != null) {
                    List<Ticket> ticketsFromPlanet = session.createQuery("from Ticket where from = :planet", Ticket.class)
                            .setParameter("planet", deletedPlanet)
                            .list();

                    List<Ticket> ticketsToPlanet = session.createQuery("from Ticket where to = :planet", Ticket.class)
                            .setParameter("planet", deletedPlanet)
                            .list();

                    for (Ticket ticket : ticketsFromPlanet) {
                        session.delete(ticket);
                    }

                    for (Ticket ticket : ticketsToPlanet) {
                        session.delete(ticket);
                    }

                    session.delete(deletedPlanet);
                    transaction.commit();
                    System.out.println("Planet with id = " + id + " deleted");
                } else {
                    System.out.println("Planet not found");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public void findAll(){
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        List<Planet> planets = session.createQuery("from Planet", Planet.class).list();
        System.out.println(planets);
        session.close();
    }

    public Planet findPlanetbyName(String name){
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        List<Planet> planets = session.createQuery("from Planet", Planet.class).list();
        Planet filteredPlanets = planets.stream().filter(planet -> planet.getName().equals(name))
                .findFirst().orElse(null);
        session.close();
        return filteredPlanets;
    }
}
