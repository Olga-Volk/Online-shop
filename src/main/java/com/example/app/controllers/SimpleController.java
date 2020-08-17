package com.example.app.controllers;

import com.example.app.ResourceNotFoundException;
import com.example.app.entity.Client;
import com.example.app.enums.ClientOrAdmin;
import com.example.app.repository.ClientRepository;
import com.example.app.serivce.ClientService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Member;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class SimpleController {

    ClientService clientService;

    @GetMapping("/")
    public String start() {
        return "Comands: / ; /clients ; /findClient/{id}";
    }

    @GetMapping("/clients")
    public String allClients() {
        return String.valueOf(clientService.findAll());
    }

    @GetMapping("/findClient/{id}")
    public String getClientById(@PathVariable(value = "id") Long clientID) throws ResourceNotFoundException {
        return String.valueOf(clientService.clientById(clientID));
    }

    @PostMapping("/clients")
    public String createClient(@Valid @RequestBody Client client){
        return String.valueOf(clientService.saveClient(client));
    }

    @PutMapping("/updateClient/{id}")
    public String updateClient(@PathVariable(value = "id") Long clientID,
                                               @Valid @RequestBody @NotNull Client clientDetails) throws ResourceNotFoundException {
        return String.valueOf(clientService.update(clientID, clientDetails));
    }

    @DeleteMapping("/deleteClient/{id}")
    public String deleteClient(
            @PathVariable (value = "id") Long clientID) throws Exception{
        return String.valueOf(clientService.delete(clientID));
    }

    @GetMapping("/allGmails")
    List<Client> findWhereEmailIsGmail(){
        return clientService.whereEmailIsGmail();
    }
}
