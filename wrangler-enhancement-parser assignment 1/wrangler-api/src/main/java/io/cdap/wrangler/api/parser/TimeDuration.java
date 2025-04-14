public class TimeDuration extends Token {
    private final long millis;

    public TimeDuration(String value) {
        super(value);
        value = value.toLowerCase();
        double number = Double.parseDouble(value.replaceAll("[^\d.]", ""));
        if (value.endsWith("ms")) millis = (long)number;
        else if (value.endsWith("s")) millis = (long)(number * 1000);
        else millis = (long)number;
    }

    public long getMilliseconds() {
        return millis;
    }
}
