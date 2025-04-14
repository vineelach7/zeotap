from flask import Flask, request, jsonify
from clickhouse_driver import Client
import pandas as pd

app = Flask(__name__)

@app.route('/connect', methods=['POST'])
def connect_clickhouse():
    data = request.json
    try:
        client = Client(
            host=data['host'],
            port=int(data['port']),
            user=data['user'],
            password=data['jwt'],
            database=data['database'],
            secure=True
        )
        tables = client.execute("SHOW TABLES")
        return jsonify({'tables': [t[0] for t in tables]})
    except Exception as e:
        return jsonify({'error': str(e)})

@app.route('/ingest', methods=['POST'])
def ingest():
    data = request.json
    client = Client(
        host=data['host'],
        port=int(data['port']),
        user=data['user'],
        password=data['jwt'],
        database=data['database'],
        secure=True
    )
    cols = ','.join(data['columns'])
    query = f"SELECT {cols} FROM {data['table']}"
    result = client.execute(query)
    df = pd.DataFrame(result, columns=data['columns'])
    df.to_csv(f"datasets/{data['filename']}", index=False)
    return jsonify({'records': len(df)})

if __name__ == '__main__':
    app.run(debug=True)
