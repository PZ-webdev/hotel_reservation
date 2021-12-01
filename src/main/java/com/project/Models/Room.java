package com.project.Models;

import javax.persistence.*;

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
    @Column(name = "is_empty")
        private boolean is_empty;

    public Room() {
    }

    public Room(String room_type, String room_capacity, double room_fee, boolean is_empty) {
        this.room_type = room_type;
        this.room_capacity = room_capacity;
        this.room_fee = room_fee;
        this.is_empty = is_empty;
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

    public boolean isIs_empty() {
        return is_empty;
    }

    public void setIs_empty(boolean is_empty) {
        this.is_empty = is_empty;
    }
}
