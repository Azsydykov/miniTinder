package kg.megacom.sts.models.enums;

public enum Status {

    ВЗАИМНО(1),
    В_ОЖИДАНИИ(2),
    НЕ_ВЗАИМНО(3),
    BLOCKED(4),
    INPROGRESS(5),
    NEW(6);

    private int value;

    Status(int value) {
        this.value = value;
    }
}
