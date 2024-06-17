package entity;

import java.time.LocalDate;

public class Message {

    private Integer idMessage;
    private Integer idTo;
    private Integer idFrom;
    private String contentMessage;
    private LocalDate dateMessage;

    public Message(Integer idMessage, Integer idTo, Integer idFrom, String contentMessage, LocalDate dateMessage) {
        this.idMessage = idMessage;
        this.idTo = idTo;
        this.idFrom = idFrom;
        this.contentMessage = contentMessage;
        this.dateMessage = dateMessage;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public Integer getIdTo() {
        return idTo;
    }

    public Integer getIdFrom() {
        return idFrom;
    }

    public String getContentMessage() {
        return contentMessage;
    }

    public LocalDate getDateMessage() {
        return dateMessage;
    }

    public void setContentMessage(String contentMessage) {
        this.contentMessage = contentMessage;
    }
}
