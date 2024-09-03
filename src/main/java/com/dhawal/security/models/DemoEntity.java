package com.dhawal.security.models;

import jakarta.persistence.*;

@Entity
@Table(name = "demomaster")
public class DemoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "d_id")
    private long id;

    @Column
    private String demoitem;

    public DemoEntity() {};

    public DemoEntity(long id, String demoitem) {
        this.id = id;
        this.demoitem = demoitem;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDemoitem() {
        return demoitem;
    }

    public void setDemoitem(String demoitem) {
        this.demoitem = demoitem;
    }
}
