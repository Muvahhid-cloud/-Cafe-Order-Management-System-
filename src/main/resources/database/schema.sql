CREATE TABLE IF NOT EXISTS orders (
                                      id INTEGER PRIMARY KEY AUTOINCREMENT,
                                      customer_name TEXT NOT NULL,
                                      total_price REAL NOT NULL,
                                      status TEXT NOT NULL,
                                      created_at TEXT DEFAULT CURRENT_TIMESTAMP
);
