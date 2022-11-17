package kg.megacom.sts.models;

import kg.megacom.sts.models.enums.Status;

public class Order {
    private long id;
    private User user;
    private User recipientId;
    private boolean match;
    private String message;
    private Status status;


    public Order(User user, User recipientId, boolean match, String message, Status status) {
        this.user = user;
        this.recipientId = recipientId;
        this.match = match;
        this.message = message;
        this.status = status;
    }

    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(User recipientId) {
        this.recipientId = recipientId;
    }

    public boolean isMatch() {
        return match;
    }

    public void setMatch(boolean match) {
        this.match = match;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", recipientId=" + recipientId +
                ", match=" + match +
                ", message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
