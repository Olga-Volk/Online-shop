package com.example.app.repository;

import com.example.app.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findAll();

    // здесь можно написать собственный запрос на SQL:
//    @Query("select * from \"public\".client where email like  '%@gmail.com%'")
//    List<Client> findWhereEmailIsGmail();
}
