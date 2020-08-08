package com.example.app.serivce;

import javax.validation.Valid;

import com.example.app.ResourceNotFoundException;
import com.example.app.entity.Client;
import com.example.app.enums.ClientOrAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.app.repository.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Service
public class ClientService {

    @Autowired
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

//    public List<Client> findWhereEmailIsGmail() {
//        return clientRepository.findAll();
//    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @GetMapping("/clients")
    public String allClients() {
        return String.valueOf(findAll());
    }

    @GetMapping("/findClient/{id}")
    public ResponseEntity<Client> getClientById(
            @PathVariable(value = "id") Long clientID) throws ResourceNotFoundException {
        Client client = clientRepository.findById(clientID)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found on :: " + clientID));
        return ResponseEntity.ok().body(client);
    }

    @PostMapping("/clients")
    public Client createClient(@Valid @RequestBody Client client){
        return clientRepository.save(client);
    }

    @PutMapping("/updateClient/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable(value = "id") Long clientID,
                                               @Valid @RequestBody Client clientDetails) throws ResourceNotFoundException {
        Client client = clientRepository.findById(clientID)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found on :: " + clientID));

        client.setEmail(clientDetails.getEmail());
        client.setHashCode(clientDetails.getHashCode());
        client.setAccessLevel(clientDetails.getAccessLevel());
        Client updatedClient = clientRepository.save(client);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/deleteClient/{id}")
    public Map<String, Boolean> deleteClient(
            @PathVariable (value = "id") Long clientID) throws Exception{
        Client client = clientRepository.findById(clientID)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found on :: " + clientID));

        clientRepository.delete(client);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/allGmails")
    List<Client> findWhereEmailIsGmail(){
//        return clientRepository.findWhereEmailIsGmail();
        return null;
    }

//    @GetMapping("/addAccornedClient")//лучше через пост, и всю логику - в сервис (гугл PostMapping example)
//    public String addAccornedClient() {
//        Client client = new Client();
//        client.setEmail("acorned@gmail.com");
//        client.setAccessLevel(ClientOrAdmin.ADMIN);
//        client.setHashCode(1234);
//        createClient(client);
//        return "added";
//    }
}
