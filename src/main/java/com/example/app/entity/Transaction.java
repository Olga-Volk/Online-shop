package com.example.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    date

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn (name = "client_id")
    private Client clientId;

    @Column (name = "full_price")
    private long fullPrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public long getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(long fullPrice) {
        this.fullPrice = fullPrice;
    }
}
