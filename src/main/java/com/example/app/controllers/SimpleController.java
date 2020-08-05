package com.example.app.controllers;

import com.example.app.entity.Client;
import com.example.app.enums.ClientOrAdmin;
import com.example.app.serivce.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    @Autowired
    ClientService clientService;
    @GetMapping("/")
    public String index() {
        return String.valueOf(clientService.findWhereEmailIsGmail());
    }
    @GetMapping("/addClient")//лучше через пост, и всю логику - в сервис (гугл PostMapping example)
    public String addRandomClient() {
        Client client = new Client();
        client.setEmail("acorned@gmail.com");
        client.setAccessLevel(ClientOrAdmin.ADMIN);
        client.setHashCode("1234");
        clientService.createClient(client);
        return "added";
    }

}
