package serivce;

import entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public void createClient(Client client){
        clientRepository.save(client);
    }
    public List<Client> findWhereEmailIsGmail() {
        return clientRepository.findWhereEmailIsGmail();
    }
}
