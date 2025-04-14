# Wrangler Enhancement: Byte Size & Time Duration Parsers

## Overview
This enhancement adds support for parsing byte size units (e.g., `KB`, `MB`, `GB`) and time duration units (e.g., `ms`, `s`) directly in Wrangler recipes. A new directive `aggregate-stats` is introduced to demonstrate usage.

## Usage Example
```wrangler
aggregate-stats :data_transfer_size :response_time total_size_mb total_time_sec
```

## Build and Test
```bash
mvn clean install
mvn test
```
