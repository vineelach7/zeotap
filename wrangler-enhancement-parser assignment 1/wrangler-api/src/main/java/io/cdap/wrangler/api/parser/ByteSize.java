public class ByteSize extends Token {
    private final long bytes;

    public ByteSize(String value) {
        super(value);
        value = value.toUpperCase();
        double number = Double.parseDouble(value.replaceAll("[^\d.]", ""));
        if (value.endsWith("KB")) bytes = (long)(number * 1024);
        else if (value.endsWith("MB")) bytes = (long)(number * 1024 * 1024);
        else if (value.endsWith("GB")) bytes = (long)(number * 1024 * 1024 * 1024);
        else bytes = (long)number;
    }

    public long getBytes() {
        return bytes;
    }
}
