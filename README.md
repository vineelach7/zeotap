

# **CDAP Wrangler Enhancement & Bidirectional ClickHouse Flat File Data Ingestion Tool**

This repository contains two assignments:

- **Assignment 1:** Enhance CDAP Wrangler with Byte Size and Time Duration Units Parsers  
- **Assignment 2:** Build a Bidirectional ClickHouse & Flat File Data Ingestion Tool with UI

---

## **Assignment 1: Enhance Wrangler with Byte Size and Time Duration Units Parsers**

### 📌 Project Overview
This project improves the CDAP Wrangler data preparation tool by adding support for parsing:
- Byte size units (e.g., KB, MB, GB)
- Time duration units (e.g., ms, s, m, h)

It also introduces a new directive to compute aggregated statistics from these parsed values.

### ✅ Features
- **Byte Size Parsing**: Converts `10KB`, `1MB` into bytes (`10240`, `1048576`)
- **Time Duration Parsing**: Converts `200ms`, `2h` into milliseconds (`200`, `7200000`)
- **New Directive**: `aggregate-stats` for computing summaries (min, max, mean, sum)

### 🛠️ Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/vineelach7/zeotap.git
   cd zeotap/wrangler-enhancement-parser assignment 1
   ```

2. **Build the Project**
   ```bash
   mvn clean install
   ```

3. **Requirements**
   - Java 8+
   - Apache Maven
   - CDAP environment

### 🚀 Usage

Use the `aggregate-stats` directive in your Wrangler recipe:

```bash
aggregate-stats :data_transfer_size :response_time total_size_mb total_time_sec
```

You can apply it to columns that contain strings like `5MB`, `200ms`, etc.

### 🧪 Testing

Run the test suite using:
```bash
mvn test
```

---

## **Assignment 2: Bidirectional ClickHouse & Flat File Data Ingestion Tool**

### 📌 Project Overview
A web application that allows users to ingest data **to and from ClickHouse and Flat Files**. The tool features a secure authentication mechanism, user-friendly UI, and support for multi-table joins.

### ✅ Features
- 🔁 **Bidirectional Ingestion**: ClickHouse ↔ Flat File (CSV/JSON)
- 🔐 **JWT Token Authentication** for ClickHouse
- 🧭 **UI to Select Tables & Columns**
- 👁️ **Data Preview**
- 📊 **Progress Bar**
- 🔗 **Multi-Table Joins** *(Bonus Feature)*

### 🛠️ Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/vineelach7/zeotap.git
   cd zeotap/clickhouse-flatfile-ingestion-tool assignment 2
   ```

2. **Install Dependencies**

   - **Backend (Go or Java)**:
     - Go:
       ```bash
       go mod tidy
       go run main.go
       ```
     - Java:
       ```bash
       mvn clean install
       mvn spring-boot:run
       ```

   - **Frontend (React)**:
     ```bash
     npm install
     npm start
     ```

3. **Environment Variables**

Create a `.env` file in the root with the following content:

```env
CLICKHOUSE_HOST=clickhouse.zeotap.internal
CLICKHOUSE_PORT=9440
CLICKHOUSE_DB=zeotap_analytics
CLICKHOUSE_USER=zeo_admin
CLICKHOUSE_PASSWORD=zeo_secure_pass
CLICKHOUSE_JWT_TOKEN=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.zeotap-custom-token


```

### 🖥️ Usage

1. Start both the backend and frontend servers.
2. In the UI:
   - Choose the source (ClickHouse or Flat File)
   - Enter credentials (for ClickHouse)
   - Choose destination
   - Preview data
   - Ingest with progress bar tracking

### 🧪 Testing

- **Backend**:
  ```bash
  go test ./...
  # or
  mvn test
  ```

- **Frontend**:
  ```bash
  npm test
  ```

### 🎁 Bonus

- Users can select multiple ClickHouse tables and define join conditions visually before ingestion.

---

## 📂 Project Structure

```bash
zeotap/
│
├── wrangler-enhancement-parser assignment 1/
│   ├── src/
│   ├── pom.xml
│   └── README.md
│
└── clickhouse-flatfile-ingestion-tool assignment 2/
    ├── backend/
    ├── frontend/
    ├── .env.example
    └── README.md
```

---

## 🧾 License

This project is licensed under the **MIT License**. See the `LICENSE` file for details.

---

