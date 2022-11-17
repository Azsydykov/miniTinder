package kg.megacom.sts.models;

import kg.megacom.sts.models.enums.Status;

public class User {
    private long id;
    private String name;
    private int age;
    private String definition;
    private String email;

    private Status status;

    public User(String name, int age, String definition, String email, Status status) {
        this.name = name;
        this.age = age;
        this.definition = definition;
        this.email = email;
        this.status = status;
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

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", diff='" + definition + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}'+" \n";
    }
}
