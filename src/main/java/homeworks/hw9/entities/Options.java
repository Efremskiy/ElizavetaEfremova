package homeworks.hw9.entities;

public enum Options {
    IGNORE_DIGITS(2),
    IGNORE_URLS(4),
    FIND_REPEAT_WORDS(8),
    IGNORE_CAPITALIZATION(512);

    private int value;

    Options(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static int sumOptions(Options... options) {
        int res = 0;
        for(Options option : options) {
            res += option.getValue();
        }
        return res;
    }
}
