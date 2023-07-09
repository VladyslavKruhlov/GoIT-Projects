package org.myName;

import com.google.gson.Gson;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        String json = "{\"firstName\":\"Vlad\",\"lastName\":\"Kruhlov\"}";
        Gson gson = new Gson();
        UserDTO user = gson.fromJson(json, UserDTO.class);
        System.out.println(user);
    }
}