package entity;

import enums.ClientOrAdmin;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String email;

    @Column (name = "hash_code")
    private String hashCode;

    @Enumerated (EnumType.ORDINAL)
    @Column (name = "access_level")
    private ClientOrAdmin accessLevel;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }

    public ClientOrAdmin getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(ClientOrAdmin accessLevel) {
        this.accessLevel = accessLevel;
    }
}
