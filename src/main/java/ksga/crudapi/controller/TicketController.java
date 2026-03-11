package ksga.crudapi.controller;

import ksga.crudapi.model.ResponeTicket;
import ksga.crudapi.model.StautsTicket;
import ksga.crudapi.model.Tickets;
import ksga.crudapi.model.dto.TicketDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("api/v1/tickets")
public class TicketController {
    List<Tickets> tickets = new ArrayList<>();
//    List<TicketDto>  ticketDtos = new ArrayList<>();
    private AtomicInteger ticketId = new AtomicInteger(6);
    public TicketController(){
        tickets.add(new Tickets(1, "bunnarith", "12/12/12", "PP", "SR", 15,true, StautsTicket.BOOKED, 15));
        tickets.add(new Tickets(2, "bunnarith", "12/12/12", "PP", "SR", 15,true, StautsTicket.CANCELLED, 15));
        tickets.add(new Tickets(3, "bunnarith", "12/12/12", "PP", "SR", 15,true, StautsTicket.COMPLETED, 15));
        tickets.add(new Tickets(4, "bunnarith", "12/12/12", "PP", "SR", 15,true, StautsTicket.BOOKED, 15));
        tickets.add(new Tickets(5, "bunnarith", "12/12/12", "PP", "SR", 15,true, StautsTicket.CANCELLED, 15));

    }

//    add tickets
    @PostMapping
    public ResponseEntity<ResponeTicket> addticket(@RequestBody TicketDto ticketDto){
        Tickets ticket = new Tickets();
        ticket.setPassengerName(ticketDto.getPassengerName());
        ticket.setTravelDate(ticketDto.getTravelDate());
        ticket.setSourceStation(ticketDto.getSourceStation());
        ticket.setDestinationStation(ticketDto.getDestinationStation());
        ticket.setPrice(ticketDto.getPrice());
        ticket.setTicketId(ticketId.getAndIncrement());
        tickets.add(ticket);
        return ResponseEntity.ok( new ResponeTicket(true, "you have aleady create ticket successfully ", ticket));
    }

//    get alll tickets
    @GetMapping("/")
    public ResponseEntity<ResponeTicket> getTickets() {

            return ResponseEntity.ok( new ResponeTicket(true, "Ticket fetched successfully", tickets));
    }

//    get ticket by id
    @GetMapping("/{id}")
    public ResponseEntity<ResponeTicket> getTicketById(@PathVariable int id) {
        for(Tickets ticket:tickets){
            if(ticket.getTicketId() == id ){
                return ResponseEntity.ok( new ResponeTicket(true, "Ticket fetched successfully", ticket));
            }
        }
        return ResponseEntity.status(404).body(new ResponeTicket(false, " No tickets found with the given ID.", " 404 not found "));
    }

//    search ticket by name
    @GetMapping("search")
    public ResponseEntity<ResponeTicket> getTicketsByPassengerName(@RequestParam String name) {
        for(Tickets ticket:tickets){
            if(ticket.getPassengerName().equals(name)){
                return ResponseEntity.ok( new ResponeTicket(true, "Ticket fetched successfully", tickets));
            }
        }
        return ResponseEntity.status(404).body(new ResponeTicket(false, " No tickets found with the given ID.", " 404 not found"));
    }


//    update ticket
    @PutMapping("/{id}")
    public ResponseEntity<ResponeTicket> updateTicket(@PathVariable int id, @RequestBody Tickets requestTicket){
//        List<Tickets> tickets=new ArrayList<>();
        for(Tickets ticket:tickets){
            if(ticket.getTicketId()==id){
                ticket.setPassengerName(requestTicket.getPassengerName());
                ticket.setTravelDate(requestTicket.getTravelDate());
                ticket.setTicketStatus(requestTicket.getTicketStatus());
                ticket.setDestinationStation(requestTicket.getDestinationStation());
                ticket.setPrice(requestTicket.getPrice());
                ticket.setSourceStation(requestTicket.getSourceStation());


                return ResponseEntity.ok( new ResponeTicket(true, "Ticket fetched successfully", ticket));
            }
        }
        return ResponseEntity.status(404).body(new ResponeTicket(false, " No tickets found with the given ID.", " 404 not found"));
    }


//    delete ticket
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponeTicket> deleteTicketById(@PathVariable int id){
       for(Tickets ticket:tickets){
           if(ticket.getTicketId()==id){
               tickets.remove(ticket);
               return ResponseEntity.ok( new ResponeTicket(true, "Ticket fetched successfully", " You have already delete successfully "));
           }
       }

        return  ResponseEntity.status(404).body(new ResponeTicket(false, " No tickets found with the given ID.", " 404 not found"));

    }

//    create mutiple

    @PostMapping("/bulk")
    public ResponseEntity<ResponeTicket> addbulkTicket(@RequestBody List<TicketDto> ticketDtos){

        List<Tickets> newTickets = new ArrayList<>();

        for(TicketDto ticketDto : ticketDtos){

            Tickets ticket = new Tickets();
            ticket.setTicketId(ticketId.getAndIncrement());
            ticket.setPassengerName(ticketDto.getPassengerName());
             ticket.setTravelDate(ticketDto.getTravelDate());
            ticket.setSourceStation(ticketDto.getSourceStation());
             ticket.setDestinationStation(ticketDto.getDestinationStation());
                ticket.setPrice(ticketDto.getPrice());

            tickets.add(ticket);
            newTickets.add(ticket);
        }

        return ResponseEntity.ok(
                new ResponeTicket(true, "mutiple tickets create successfully", newTickets)
        );
    }


}
