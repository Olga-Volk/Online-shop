import entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import serivce.ClientService;

import static enums.ClientOrAdmin.USER;

@SpringBootApplication

public class Main {
    @Autowired
    private ClientService clientService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    private void testJpaMethods(){
        Client client = new Client();
        client.setAccessLevel(USER);
        client.setEmail("hfhfjf@gmail.com");

        clientService.findWhereEmailIsGmail().forEach(it-> System.out.println(it));
    }
}
