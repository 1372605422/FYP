import sqlite3
import yfinance as yf
import json

with open('config/config.json') as f:
    config = json.load(f)

table_name = config['Ticker']

# 创建 SQLite 连接和游标
conn = sqlite3.connect('../FinanceData.db')
cursor = conn.cursor()
# table_name = 'BA'

# 获取 TSLA 的财务数据
tsla = yf.Ticker(table_name)
headers = tsla.financials

# 获取对应列的索引
column_name = headers.columns[0]
column_index = headers.columns.get_loc(column_name)

header_row = tsla.financials.index

# 获取对应列的数据
column_data = headers.iloc[:, column_index].tolist()

# 创建 Data 表（如果不存在）
cursor.execute(f'''
    CREATE TABLE IF NOT EXISTS {table_name} (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        column_name TEXT,
        value REAL
    )
''')

# 插入数据到 Data 表
for i, value in enumerate(column_data):
    column_name = header_row[i] # 使用 header_row 中的列名
    cursor.execute(f'''
        INSERT INTO {table_name} (column_name, value) VALUES (?, ?)
    ''', (column_name, value))


# 提交事务并关闭连接
conn.commit()
conn.close()