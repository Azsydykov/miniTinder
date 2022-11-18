package kg.megacom.sts.models.enums;

import kg.megacom.sts.models.Order;

public enum OrderStatus {

    ВЗАИМНО(1),
    В_ОЖИДАНИИ(2),
    НЕ_ВЗАИМНО(3),
    ЗАПРОС_ОТПРАВЛЕН(4);
    private int value;

    OrderStatus(int value) {
        this.value = value;
    }
}
