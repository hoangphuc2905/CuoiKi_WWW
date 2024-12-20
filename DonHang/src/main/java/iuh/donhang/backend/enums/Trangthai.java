package iuh.donhang.backend.enums;

public enum Trangthai {
    Chua_Chap_Nhan(0),
    Chap_Nhan(1);

    private final int value;

    Trangthai(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Trangthai fromValue(int value) {
        for (Trangthai trangthai : Trangthai.values()) {
            if (trangthai.getValue() == value) {
                return trangthai;
            }
        }
        return null;
    }


}
