import com.example.app.Application;
import com.example.app.entity.Client;
import com.example.app.enums.ClientOrAdmin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class ApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {

    }
    @Test
    public void testGetAllClients(){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/clients",
                HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
    }

    @Test
    public void testShowGmails(){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/allGmails",
                HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
    }

    @Test
    public void testGetClientById() {
        Client client = restTemplate.getForObject(getRootUrl() + "/client/1", Client.class);
        System.out.println(client.getEmail());
        assertNotNull(client);
    }

    @Test
    public void testCreateClient() {
        Client client = new Client();
        client.setAccessLevel(ClientOrAdmin.USER);
        client.setHashCode(3578);
        client.setEmail("olga@mail.volk");

        ResponseEntity<Client> postResponse = restTemplate.postForEntity(getRootUrl() + "/clients", client, Client.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdate() {
        int id = 2;
        Client client = restTemplate.getForObject(getRootUrl() + "/clients/" + id, Client.class);
        client.setEmail("volk@mail.olga");
        client.setAccessLevel(ClientOrAdmin.ADMIN);

        restTemplate.put(getRootUrl() + "/clients/" + id, client);

        Client updatedClient = restTemplate.getForObject(getRootUrl() + "/clients/" + id, Client.class);
        assertNotNull(updatedClient);
    }

    @Test
    public void testDelete() {
        int id = 2;
        Client client = restTemplate.getForObject(getRootUrl() + "/clients/" + id, Client.class);
        assertNotNull(client);

        restTemplate.delete(getRootUrl() + "/clients/" + id);

        try {
            client = restTemplate.getForObject(getRootUrl() + "/clients/" + id, Client.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
