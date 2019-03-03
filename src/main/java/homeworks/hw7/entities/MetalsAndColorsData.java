package homeworks.hw7.entities;

public class MetalsAndColorsData {
    public int oddSum;
    public int evenSum;
    public String[] elements;
    public String color;
    public String metal;
    public String[] vegetables;

    public static MetalsAndColorsData DATA = new MetalsAndColorsData(3, 8,
            new String[]{"Water", "Fire"}, "Red", "Selen",
            new String[]{"Cucumber", "Tomato"});

    public MetalsAndColorsData(int oddSum, int evenSum, String[] elements, String color, String metal, String[] vegetables) {
        this.oddSum = oddSum;
        this.evenSum = evenSum;
        this.elements = elements;
        this.color = color;
        this.metal = metal;
        this.vegetables = vegetables;
    }

    public int summary() {
        return evenSum + oddSum;
    }
}
