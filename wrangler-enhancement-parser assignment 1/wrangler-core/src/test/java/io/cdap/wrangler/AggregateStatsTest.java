@Test
public void testAggregation() {
    List<Row> rows = Arrays.asList(
        new Row("data_transfer_size", "10MB", "response_time", "500ms"),
        new Row("data_transfer_size", "5MB", "response_time", "1.5s")
    );

    AggregateStats directive = new AggregateStats();
    directive.initialize(new TestArguments("data_transfer_size", "response_time", "total_size_mb", "total_time_sec"));
    List<Row> result = directive.execute(rows);

    Assert.assertEquals(1, result.size());
    Assert.assertEquals(15.0, result.get(0).getValue("total_size_mb"), 0.001);
    Assert.assertEquals(2.0, result.get(0).getValue("total_time_sec"), 0.001);
}
