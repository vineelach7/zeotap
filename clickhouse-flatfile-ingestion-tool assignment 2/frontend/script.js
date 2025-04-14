async function connect() {
  const payload = {
    host: document.getElementById('host').value,
    port: document.getElementById('port').value,
    user: document.getElementById('user').value,
    jwt: document.getElementById('jwt').value,
    database: document.getElementById('database').value
  };
  const res = await fetch('/connect', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(payload)
  });
  const data = await res.json();
  document.getElementById('status').innerText = JSON.stringify(data);
}
