Here is a README file content for your assignments:

---

# **CDAP Wrangler Enhancement & Bidirectional ClickHouse Flat File Data Ingestion Tool**

## **Assignment 1: Enhance Wrangler with Byte Size and Time Duration Units Parsers**

### **Project Overview**
This project enhances the CDAP Wrangler library by integrating native support for parsing byte sizes (e.g., KB, MB) and time durations (e.g., ms, s) into data processing pipelines. It includes modifications to the grammar, API, core parser, and the creation of a new directive for aggregating byte size and time duration statistics.

### **Features**
- **Byte Size Parsing**: Automatically convert data values with byte size units (e.g., `10KB`, `1MB`) into a consistent internal format (bytes).
- **Time Duration Parsing**: Convert time-related values (e.g., `150ms`, `5s`) into a consistent internal format (milliseconds).
- **Aggregation**: A new aggregate directive (`aggregate-stats`) that processes byte size and time duration columns and computes statistics.

### **Installation & Setup**
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/cdap-wrangler-enhancement.git
   ```
2. Navigate to the project directory:
   ```bash
   cd cdap-wrangler-enhancement
   ```
3. Compile the project:
   ```bash
   mvn clean install
   ```
4. Ensure that your environment is set up with the necessary dependencies for CDAP (refer to CDAP's official documentation for more details).

### **Usage**
1. **Add the Directives in Recipes**:
   - Use the new `aggregate-stats` directive in your CDAP recipes:
     ```java
     aggregate-stats :data_transfer_size :response_time total_size_mb total_time_sec
     ```
   - Replace `data_transfer_size` and `response_time` with the actual column names from your dataset.
   
2. **Example Input**:
   - Use CSV files or other data sources with byte size and time duration columns.
   
3. **Run**:
   - Execute the CDAP pipeline with the enhanced Wrangler library and validate the output.

### **Testing**
- The module includes unit tests for both byte size and time duration parsing as well as the new aggregation logic.
- Run tests using:
   ```bash
   mvn test
   ```

---

## **Assignment 2: Bidirectional ClickHouse & Flat File Data Ingestion Tool**

### **Project Overview**
This project implements a web-based tool to facilitate bidirectional data ingestion between ClickHouse and Flat Files. The tool supports ClickHouse as the source (via JWT token authentication) and allows data ingestion to both ClickHouse and Flat Files. Users can configure connection details, choose tables and columns, and visualize the data flow.

### **Features**
- **Bidirectional Ingestion**: Supports ClickHouse to Flat File and Flat File to ClickHouse data transfer.
- **ClickHouse Authentication**: Uses JWT token-based authentication for secure ClickHouse connections.
- **Data Preview**: Users can preview data before ingestion.
- **Progress Bar**: Visual progress indicator during data transfer.
- **Multi-Table Joins** (Bonus): Supports joining multiple ClickHouse tables before ingesting into Flat Files.

### **Installation & Setup**
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/clickhouse-flatfile-ingestion.git
   ```
2. Navigate to the project directory:
   ```bash
   cd clickhouse-flatfile-ingestion
   ```
3. Install dependencies:
   - For backend (Go/Java):
     ```bash
     # Go (if using Go)
     go mod tidy
     # Java (if using Java)
     mvn clean install
     ```
   - For frontend (React/Vue):
     ```bash
     npm install
     ```

4. Configure environment variables for ClickHouse connection and JWT token authentication in `.env`:
   ```bash
   CLICKHOUSE_HOST=your_clickhouse_host
   CLICKHOUSE_PORT=your_clickhouse_port
   CLICKHOUSE_DB=your_database_name
   CLICKHOUSE_USER=your_username
   CLICKHOUSE_JWT_TOKEN=your_jwt_token
   ```

### **Usage**
1. **Launch Backend Server**:
   ```bash
   # For Go backend:
   go run main.go
   # For Java backend:
   mvn spring-boot:run
   ```
   
2. **Launch Frontend**:
   ```bash
   npm run start
   ```

3. **UI Features**:
   - Select the source (ClickHouse or Flat File).
   - Provide necessary credentials for ClickHouse.
   - Select the target (ClickHouse or Flat File).
   - Preview the data before ingestion.
   - Start the ingestion process.

### **Testing**
- The application includes tests for both the frontend and backend components.
- Run tests using:
   ```bash
   # For Go:
   go test ./...
   # For Java:
   mvn test
   ```

### **Bonus Features**
- Multi-table ClickHouse join support for data ingestion to Flat Files.

### **Acknowledgments**
- This project uses ClickHouse as the database source, with JWT token-based authentication for secure access.
- Frontend developed using React (or Vue, depending on your choice).

---

### **License**
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Let me know if you need any changes to the README!
