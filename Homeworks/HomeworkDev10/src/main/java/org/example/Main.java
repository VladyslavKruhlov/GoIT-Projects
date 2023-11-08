package org.example;

import Services.ClientCrudService;
import Services.PlanetCrudService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ClientCrudService clientCrudService = new ClientCrudService();

//        clientCrudService.createClient("Tom");
//        clientCrudService.editClient(4, "Jerry");
//        System.out.println(clientCrudService.findClientbyId(4));;
//        clientCrudService.deleteClient(4);
//        clientCrudService.findAll();

        PlanetCrudService planetCrudService = new PlanetCrudService();

//        planetCrudService.createPlanet("KEPLER90U", "Moon");
//        planetCrudService.editPlanetName("KEPLER90U", "Sun");
//        System.out.println(planetCrudService.findPlanetbyName("Sun").toString());
//        planetCrudService.deletePlanet("KEPLER90U");
//        planetCrudService.findAll();

    }
}
