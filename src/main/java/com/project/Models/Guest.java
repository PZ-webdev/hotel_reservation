package com.project.Models;

import javax.persistence.*;

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
    @Column(name = "firstname")
        private String firstName;
    @Column(name = "lastname")
        private String lastName;
    @Column(name = "email")
        private String email;
    @Column(name = "address")
        private String address;
    @Column(name = "city")
        private String city;
    @Column(name = "phone")
        private long phone;
    @Column(name = "card_number")
        private long cardNumber;
    @Column(name = "number_of_days")
        private int numberOfDays;
    @Column(name = "fees")
        private double fees;

    public Guest() {}

    public Guest(Room roomID, String firstName, String lastName, String email, String address, String city, long phone, long cardNumber, int numberOfDays, double fees) {
        this.roomID = roomID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.cardNumber = cardNumber;
        this.numberOfDays = numberOfDays;
        this.fees = fees;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
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

    @Override
    public String toString() {
        return "GuestsModel{" +
                "roomID=" + roomID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", phone=" + phone +
                ", cardNumber=" + cardNumber +
                ", numberOfDays=" + numberOfDays +
                ", fees=" + fees +
                '}';
    }

}
