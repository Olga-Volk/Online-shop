package com.example.app.controllers;

import com.example.app.entity.Client;
import com.example.app.enums.ClientOrAdmin;
import com.example.app.repository.ClientRepository;
import com.example.app.serivce.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Member;
import java.util.List;

@RestController
public class SimpleController {

    @GetMapping("/")
    public String start() {
        return "Comands: \"/\" ; \"/allClients\" ; /findClient/{id} ;" +
                " \"/updateClient/{id}/{email}/{passwordWithNumbersOnly}\" ;" +
                " \"/createNewClient/{email}/{passwordWithNumbersOnly}\" ;" +
                " \"/createNewAdmin/{email}/{passwordWithNumbersOnly}\" ;" +
                " \"/deleteClient/{id}\"";
    }
}
