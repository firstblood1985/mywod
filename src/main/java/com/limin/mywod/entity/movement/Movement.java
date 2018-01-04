package com.limin.mywod.entity.movement;

import javax.persistence.*;

@Entity
@Table(name="MOVEMENT")
public class Movement {

    @Id
    @Column(name="MOVEMENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="NAME")
    private String name;

    @Column(name="TYPE")
    @Enumerated(EnumType.STRING)
    private MovementType type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MovementType getType() {
        return type;
    }

    public void setType(MovementType type) {
        this.type = type;
    }

}
