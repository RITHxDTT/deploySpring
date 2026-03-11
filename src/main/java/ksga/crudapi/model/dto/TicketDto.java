package ksga.crudapi.model.dto;

import ksga.crudapi.model.StautsTicket;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class TicketDto {
    private String passengerName;
    private String travelDate;
    private String sourceStation;
    private String destinationStation;
    private double price;
    private boolean paymentStatus;
    private int seatNumber;
    private StautsTicket ticketStatus;

//    public String getPassengerName() {
//        return passengerName;
//    }
//
//    public Date getTravelDate() {
//        return travelDate;
//    }
//
//    public String getSourceStation() {
//        return sourceStation;
//    }
//
//    public String getDestinationStation() {
//        return destinationStation;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public boolean isPaymentStatus() {
//        return paymentStatus;
//    }
//
//    public boolean isTicketStatus() {
//        return ticketStatus;
//    }
//
//    public int getSeatNumber() {
//        return seatNumber;
//    }

//    public TicketDto(String passengerName, String travelDate, String sourceStation, String destinationStation, double price, boolean paymentStatus, StautsTicket ticketStatus ,int seatNumber) {
//
//        this.passengerName = passengerName;
//        this.travelDate = travelDate;
//        this.sourceStation = sourceStation;
//        this.destinationStation = destinationStation;
//        this.price = price;
//        this.paymentStatus = paymentStatus;
//        this.seatNumber = seatNumber;
//
//
//    }
}
