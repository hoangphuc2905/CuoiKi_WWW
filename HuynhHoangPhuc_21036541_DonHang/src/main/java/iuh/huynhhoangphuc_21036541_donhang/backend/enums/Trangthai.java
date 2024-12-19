package iuh.huynhhoangphuc_21036541_donhang.backend.enums;

public enum Trangthai {
    CHUA_CHAP_NHAN(0),
    CHAP_NHAN(1);

    private final int value;

    Trangthai(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Trangthai fromInt(int i) {
        for (Trangthai t : values()) {
            if (t.getValue() == i) {
                return t;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + i);
    }
}
