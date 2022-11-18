package kg.megacom.sts.models.enums;

public enum UserStatus {

    BLOCKED(1),
    INPROGRESS(2),
    NEW(3);

    private int value;

    UserStatus(int value) {
        this.value = value;
    }
}
