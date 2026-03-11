package ksga.crudapi.model;

import lombok.Data;

import java.util.Date;


@Data

public class Tickets {
    private int ticketId;
    private String passengerName;
    private String travelDate;
    private String sourceStation;
    private String destinationStation;

    public int getTicketId() {
        return ticketId;
    }

    private double price;
    private boolean paymentStatus;
    private StautsTicket ticketStatus;
    private int seatNumber;





    public Tickets(){

    }

    public Tickets(int ticketId, String passengerName, String travelDate, String sourceStation, String destinationStation, double price, boolean paymentStatus, StautsTicket ticketStatus, int seatNumber) {
        this.ticketId = ticketId;
        this.passengerName = passengerName;
        this.travelDate = travelDate;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
        this.price = price;
        this.paymentStatus = paymentStatus;
        this.ticketStatus = ticketStatus;
        this.seatNumber = seatNumber;
    }




}
