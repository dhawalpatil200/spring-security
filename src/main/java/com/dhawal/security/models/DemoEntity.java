package com.dhawal.security.models;

import jakarta.persistence.*;

@Entity
@Table(name = "demomaster")
public class DemoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long d_id;

    @Column
    private String demoitem;

    public DemoEntity() {};

    public DemoEntity(long d_id, String demoitem) {
        this.d_id = d_id;
        this.demoitem = demoitem;
    }

    public long getD_id() {
        return d_id;
    }

    public void setD_id(long d_id) {
        this.d_id = d_id;
    }

    public String getDemoitem() {
        return demoitem;
    }

    public void setDemoitem(String demoitem) {
        this.demoitem = demoitem;
    }
}
