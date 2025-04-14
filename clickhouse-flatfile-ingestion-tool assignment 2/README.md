# ClickHouse ↔ Flat File Ingestion Tool

## Overview
This web-based tool enables bidirectional data flow between ClickHouse and flat files using a simple frontend and Flask backend.

## Features
- Connect to ClickHouse using JWT
- Select specific columns to ingest
- Ingest ClickHouse data to flat CSV files
- Simple UI to input connection details and trigger ingestion

## Setup
### Backend
```bash
cd backend
pip install -r requirements.txt
python app.py
```

### Frontend
Open `frontend/index.html` in a browser.

## Example
- Host: `localhost`
- Port: `8443`
- User: `default`
- JWT: `<your_token>`
- Database: `default`
