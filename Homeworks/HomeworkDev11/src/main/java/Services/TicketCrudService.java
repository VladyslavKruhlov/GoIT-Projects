package Services;

import Entity.Client;
import Entity.Planet;
import Entity.Ticket;
import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TicketCrudService {

    public void findAll(){
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        List<Ticket> tickets = session.createQuery("from Ticket", Ticket.class).list();
        System.out.println(tickets);
        session.close();
}
    public void createTicket(Client client, Planet from, Planet to){
        try {
            Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            Ticket newTicket = new Ticket();

            newTicket.setClientId(client);

            newTicket.setFrom(from);

            newTicket.setTo(to);

            session.persist(newTicket);

            transaction.commit();
            session.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public Ticket findTicketById(long id){
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        List<Ticket> tickets = session.createQuery("from Ticket", Ticket.class).list();
        Ticket filteredTickets = tickets.stream().filter(ticket -> ticket.getId()==id)
                .findFirst().orElse(null);
        session.close();
        return filteredTickets;
    }
    public void editTicket(long id, Client client, Planet planet1, Planet planet2){
        try {
            Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            Ticket editingTicket= session.get(Ticket.class, id);
            if (editingTicket!=null){
            editingTicket.setClientId(client);
            editingTicket.setFrom(planet1);
            editingTicket.setTo(planet2);

            session.persist(editingTicket);

            System.out.println(editingTicket);}

            transaction.commit();
            session.close();

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void deleteTicket(long id) {

        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Ticket deletedTicket = session.get(Ticket.class, id);

        if (deletedTicket != null) {
                session.delete(deletedTicket);
                System.out.println("Ticket with ID = " + id + " deleted");
            } else {
                System.out.println("Ticket not found");
            }
            transaction.commit();
            session.close();
        }
}
