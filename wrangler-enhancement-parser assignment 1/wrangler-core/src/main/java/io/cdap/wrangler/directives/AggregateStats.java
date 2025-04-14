public class AggregateStats implements Directive {
    private String sizeCol, timeCol, outputSizeCol, outputTimeCol;
    private long totalBytes = 0;
    private long totalMillis = 0;

    @Override
    public void initialize(Arguments args) {
        sizeCol = args.value("sizeCol");
        timeCol = args.value("timeCol");
        outputSizeCol = args.value("outputSizeCol");
        outputTimeCol = args.value("outputTimeCol");
    }

    @Override
    public List<Row> execute(List<Row> rows) {
        for (Row row : rows) {
            ByteSize bs = new ByteSize(row.getValue(sizeCol).toString());
            TimeDuration td = new TimeDuration(row.getValue(timeCol).toString());
            totalBytes += bs.getBytes();
            totalMillis += td.getMilliseconds();
        }
        Row result = new Row();
        result.add(outputSizeCol, totalBytes / (1024.0 * 1024));
        result.add(outputTimeCol, totalMillis / 1000.0);
        return Collections.singletonList(result);
    }

    @Override
    public UsageDefinition define() {
        return UsageDefinition.builder("aggregate-stats")
                .define("sizeCol", UsageDefinition.Type.STRING, "Column with byte size")
                .define("timeCol", UsageDefinition.Type.STRING, "Column with time duration")
                .define("outputSizeCol", UsageDefinition.Type.STRING, "Total size output column")
                .define("outputTimeCol", UsageDefinition.Type.STRING, "Total time output column")
                .build();
    }
}
