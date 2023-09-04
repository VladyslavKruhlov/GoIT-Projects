package org.example;


import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ClientService clientService = new ClientService();

            long id = clientService.create("User");
            System.out.println("Client ID: " + id);

            String clientName = clientService.getById(id);
            System.out.println("Client name: " + clientName);

            clientService.setName(id, "New Client");
            System.out.println("UPDATED");

            clientService.deleteById(id);
            System.out.println("DELETED");

            System.out.println("All clients:");
            clientService.listAll().forEach(client -> System.out.println("ID: " + client.getId() + ", NAME: " + client.getName()));
    }
}
