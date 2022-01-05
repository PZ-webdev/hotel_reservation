package com.project.Models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "guests")
public class Guest {
    @Id
    @Column(name = "id_quest", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int guestID;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Room.class)
    @JoinColumn(name = "id_room")
        private Room roomID;
    @Column(name = "name")
        private String name;
    @Column(name = "email")
        private String email;
    @Column(name = "phone")
        private long phone;
   @Column(name = "date_start")
        private LocalDate date_start;
    @Column(name = "date_end")
        private LocalDate date_end;
    @Column(name = "fees")
        private double fees;


    public Guest(Room roomID, String name, String email, long phone, LocalDate date_start, LocalDate date_end, double fees) {
        this.roomID = roomID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.date_start = date_start;
        this.date_end = date_end;
        this.fees = fees;
    }

    public Guest() {}

    public int getGuestID() {
        return guestID;
    }

    public void setGuestID(int guestID) {
        this.guestID = guestID;
    }

    public Room getRoomID() {
        return roomID;
    }

    public void setRoomID(Room roomID) {
        this.roomID = roomID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public LocalDate getDate_start() {
        return date_start;
    }

    public void setDate_start(LocalDate date_start) {
        this.date_start = date_start;
    }

    public LocalDate getDate_end() {
        return date_end;
    }

    public void setDate_end(LocalDate date_end) {
        this.date_end = date_end;
    }

    public double getFees() { return fees;}

    public void setFees(double fees) {
        this.fees = fees;
    }
}
