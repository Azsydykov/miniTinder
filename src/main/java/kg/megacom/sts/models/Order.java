package kg.megacom.sts.models;

public class Order {
    private long id;
    private User user;
    private Status status;
    private String message;
    private boolean match;


    public Order(User user, Status status, String message, boolean match) {
        this.id = id;
        this.user = user;
        this.status = status;
        this.message = message;
        this.match = match;
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
}
