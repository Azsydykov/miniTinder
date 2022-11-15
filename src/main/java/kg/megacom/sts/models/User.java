package kg.megacom.sts.models;

public class User {
    private long id;
    private String name;
    private int age;
    private String diff;
    private String email;
    private String number;
    private Status status;
    private boolean isActive;

    public User(String name, int age, String diff, String email, String number, Status status, boolean isActive) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.diff = diff;
        this.email = email;
        this.number = number;
        this.status = status;
        this.isActive = isActive;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDiff() {
        return diff;
    }

    public void setDiff(String diff) {
        this.diff = diff;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", diff='" + diff + '\'' +
                ", email='" + email + '\'' +
                ", number='" + number + '\'' +
                ", status=" + status +
                ", isActive=" + isActive +
                '}'+" \n";
    }
}
