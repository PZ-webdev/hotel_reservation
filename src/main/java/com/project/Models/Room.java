package com.project.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "rooms")
public class Room {
    @Id
    @Column(name = "id_room", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer roomID;
    @Column(name = "room_type")
        private String room_type;
    @Column(name = "room_capacity")
        private String room_capacity;
    @Column(name = "room_fee")
        private double room_fee;
    @OneToMany(mappedBy = "roomID",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Room> roomSet = new HashSet<>();

    public Room(String room_type, String room_capacity, double room_fee) {
        this.room_type = room_type;
        this.room_capacity = room_capacity;
        this.room_fee = room_fee;
    }

    @Override
    public String toString() {
        return room_type;
    }
}
