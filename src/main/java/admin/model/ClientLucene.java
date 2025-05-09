package admin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTS")
public class ClientLucene {

    @Id
    @Column(name = "client", nullable = false)
    private String client;

    @Column(name = "name", nullable = false)
    private String name;

    public ClientLucene(){}

    public ClientLucene(String client, String name){
        this.client = client;
        this.name = name;
    }

    public String getClient() { return client; }
    public void setClient(String client) { this.client = client; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
