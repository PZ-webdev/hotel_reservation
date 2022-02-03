package com.project.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Getter @Setter @NoArgsConstructor
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

    public long getDays() {
        return ChronoUnit.DAYS.between(date_start,date_end);
    }

   public String getPriceReservation(){
        double price = getDays() *  roomID.getRoom_fee();
        return price + " zł";
   }
}
