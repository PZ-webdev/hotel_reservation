package com.project.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
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

    public Room() {
    }

    public Room(String room_type, String room_capacity, double room_fee) {
        this.room_type = room_type;
        this.room_capacity = room_capacity;
        this.room_fee = room_fee;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getRoom_capacity() {
        return room_capacity;
    }

    public void setRoom_capacity(String room_capacity) {
        this.room_capacity = room_capacity;
    }

    public double getRoom_fee() {
        return room_fee;
    }

    public void setRoom_fee(double room_fee) {
        this.room_fee = room_fee;
    }

    public void getRoom_fee(String text) {
    }
}
