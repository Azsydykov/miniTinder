package kg.megacom.sts.models;

import kg.megacom.sts.models.enums.Status;

public class Order {
    private long id;
    private User user;
    private long recipientId;
    private Status status;
    private boolean match;
    private String message;


    public Order(User user, long recipientId, Status status,boolean match ,String message) {
        this.id = id;
        this.user = user;
        this.recipientId = recipientId;
        this.status = status;
        this.match = match;
        this.message = message;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isMatch() {
        return match;
    }

    public void setMatch(boolean match) {
        this.match = match;
    }

    public long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(long receipentId) {
        this.recipientId = receipentId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user.getId() +
                ", status=" + status +
                ", message='" + message + '\'' +
                ", match=" + match +
                ", receipentId=" + recipientId +
                '}';
    }
}
