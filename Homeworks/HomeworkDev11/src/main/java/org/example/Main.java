package org.example;

import Entity.Client;
import Entity.Planet;
import Services.ClientCrudService;
import Services.PlanetCrudService;
import Services.TicketCrudService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ClientCrudService clientCrudService = new ClientCrudService();

//        clientCrudService.createClient("Tom");
//        clientCrudService.editClient(4, "Jerry");
//        System.out.println(clientCrudService.findClientById(4));;
//        clientCrudService.deleteClient(4);
//        clientCrudService.findAll();

        PlanetCrudService planetCrudService = new PlanetCrudService();

//        planetCrudService.createPlanet("KEPLER90U", "Moon");
//        planetCrudService.editPlanetName("KEPLER90U", "Sun");
//        System.out.println(planetCrudService.findPlanetByName("Mars"));
//        planetCrudService.deletePlanet("KEPLER90U");
//        planetCrudService.findAll();

        TicketCrudService ticketCrudService = new TicketCrudService();

//        ticketCrudService.createTicket(clientCrudService.findClientById(10), planetCrudService.findPlanetByName("Earth"), planetCrudService.findPlanetByName("Mars"));
//        ticketCrudService.findAll();
//        System.out.println(ticketCrudService.findTicketById(2));
//        ticketCrudService.editTicket(1, clientCrudService.findClientById(1), planetCrudService.findPlanetByName("Saturn"), planetCrudService.findPlanetByName("Earth"));
//        ticketCrudService.deleteTicket(1);
    }
}
