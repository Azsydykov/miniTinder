package kg.megacom.sts.models.enums;

public enum Status {

    ВЗАИМНО(1),
    В_ОЖИДАНИИ(2),
    НЕ_ВЗАИМНО(3);

    private int value;

    Status(int value) {
        this.value = value;
    }
}
