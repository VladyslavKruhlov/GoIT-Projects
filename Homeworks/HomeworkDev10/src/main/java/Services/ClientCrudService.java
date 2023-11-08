package Services;

import Entity.Client;
import Entity.Ticket;
import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class ClientCrudService {
    public void createClient(String name){
        try {
            Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            Client newClient = new Client();
            newClient.setName(name);
            session.persist(newClient);
            System.out.println(newClient);

            transaction.commit();
            session.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void editClient(long id, String name){
        try {
            Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            Client editingClient= session.get(Client.class, id);
            editingClient.setName(name);
            session.persist(editingClient);

            System.out.println(editingClient);

            transaction.commit();
            session.close();

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void deleteClient(long id) {

        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Client deletedClient = session.get(Client.class, id);

        if (deletedClient != null) {
            if (deletedClient != null) {
                List<Ticket> tickets = session.createQuery("from Ticket where client = :client", Ticket.class)
                        .setParameter("client", deletedClient)
                        .list();
                for (Ticket ticket : tickets) {
                    session.delete(ticket);
                }
                session.delete(deletedClient);
                System.out.println("Client with ID = " + id + " deleted");
            } else {
                System.out.println("Client not found");
            }
            transaction.commit();
            session.close();
        }
    }

    public void findAll(){
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        List<Client> clients = session.createQuery("from Client", Client.class).list();
        System.out.println(clients);
        session.close();
    }

    public Client findClientbyId(long id){
            Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
            List<Client> clients = session.createQuery("from Client", Client.class).list();
            Client filteredClients = clients.stream().filter(client -> client.getId()==id)
                    .findFirst().orElse(null);
            session.close();
            return filteredClients;
    }
}
