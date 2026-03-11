package ksga.crudapi.model;

import lombok.Data;

@Data
public class ResponeTicket {
    private boolean success;
    private String message;
    private Object payload;

    private String Status;

//    public ResponeTicket(boolean success, String message, String status) {
//        this.success = success;
//        this.message = message;
//        this.Status = status;
//    }

    public ResponeTicket(boolean success, String message, Object payload) {
        this.success = success;
        this.message = message;
        this.payload = payload;
    }
}
