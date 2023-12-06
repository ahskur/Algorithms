public class Clock {
    private int h;
    private int min;

    public Clock() {
        this(0, 0);
    }

    public Clock(int h, int min) {
        this.h = h;
        this.min = min;
    }

    public Clock(String time) {
        String[] parts = time.split(":");
        this.h = Integer.parseInt(parts[0]);
        this.min = Integer.parseInt(parts[1]);
    }

    public int getMin() {
        return min;
    }

    public int getH() {
        return h;
    }
    public Clock add(int minutes) {
        int newMin = (this.min + minutes) % 60;
        int additionalHours = (this.min + minutes) / 60;
        int newHour = (this.h + additionalHours) % 24;

        return new Clock(newHour, newMin);
    }

    public Clock add(Clock other) {
        return add(other.getH() * 60 + other.getMin());
    }

    public String toString() {
        return String.format("%02d:%02d", h, min);
    }

    public static void main(String[] args) {
        int h = 8;
        int m = 30;

        Clock clock = new Clock(h + ":" + m);
        System.out.println("Clock: " + clock);
    }
}
