package repository;

import entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

// здесь можно написать собственный запрос на SQL:
@Query("select c from client c where c.email like '%@gmail.com%'")
List<Client> findWhereEmailIsGmail();

}
