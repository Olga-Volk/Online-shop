package com.example.app.controllers;

import com.example.app.ResourceNotFoundException;
import com.example.app.entity.Client;
import com.example.app.serivce.ClientService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SimpleController {

    @Autowired
    ClientService clientService;

    @GetMapping("/")
    public String start() {
        return "Comands: / ; /clients ; /findClient/{id}";
    }

    @RequestMapping(value = "/clients/", method = RequestMethod.GET)
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

    @GetMapping("/allGmail")
    List<Client> findWhereEmailIsGmail(){
        return clientService.whereEmailIsGmail();
    }
}
