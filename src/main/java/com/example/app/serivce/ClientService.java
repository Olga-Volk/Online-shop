package com.example.app.serivce;

import com.example.app.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.app.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public Client createClient(Client client){
        return clientRepository.save(client);
    }
    public List<Client> findWhereEmailIsGmail() {
        return clientRepository.findAll();
    }
}
