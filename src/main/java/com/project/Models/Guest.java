package com.project.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "guests")
public class Guest {
    @Id
    @Column(name = "id_quest", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int guestID;
    @ManyToOne(targetEntity = Room.class)
    @JoinColumn(name = "id_room")
        private Room roomID;
//    @Column(name = "firstname")
//        private String firstName;
    @Column(name = "name")
        private String name;
//    @Column(name = "lastname")
//        private String lastName;
    @Column(name = "email")
        private String email;
    @Column(name = "phone")
        private long phone;
   @Column(name = "date_start")
        private Date date_start;
    @Column(name = "date_end")
        private Date date_end;
    @Column(name = "number_of_days")
        private int numberOfDays;
    @Column(name = "fees")
        private double fees;


    public Guest(Room roomID, String name, String email, long phone, Date date_start, Date date_end, int numberOfDays, double fees) {
        this.roomID = roomID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.date_start = date_start;
        this.date_end = date_end;
        this.numberOfDays = numberOfDays;
        this.fees = fees;
    }

    public Guest() {

    }

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

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }
}
