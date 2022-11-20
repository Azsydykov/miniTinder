package kg.megacom.sts.models;

import kg.megacom.sts.models.enums.OrderStatus;


public class Order {
    private long id;
    private User user;
    private User recipient;
    private boolean match;
    private String message;
    private OrderStatus status;


    public Order(User user, User recipient, boolean match, String message, OrderStatus status) {
        this.user = user;
        this.recipient = recipient;
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

    public User getRecipient() {
        return recipient;
    }

    public void setRecipientId(User recipient) {
        this.recipient = recipient;
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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
            //    "id=" + id +
                ", user=" + user +
                ", recipient=" + recipient +
             //   ", match=" + match +
                ", message='" + message + '\'' +
                ", status=" + status +
                '}'+"\n";
    }

}
