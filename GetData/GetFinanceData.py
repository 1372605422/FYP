import sqlite3
import yfinance as yf
import json
from Info import YFinance
import os

# 获取当前脚本的目录
script_dir = os.path.dirname(os.path.realpath(__file__))

# 获取上一级目录的路径
parent_dir = os.path.dirname(script_dir)

# 获取上两级目录的路径
grandparent_dir = os.path.dirname(parent_dir)

# 获取上两级目录的上一级目录的路径
great_grandparent_dir = os.path.dirname(grandparent_dir)

# 构建 JSON 文件的相对路径
json_file_path = os.path.join(grandparent_dir, 'config', 'config.json')

# 读取 JSON 文件
with open(json_file_path, 'r') as json_file:
    config = json.load(json_file)

table_name = config['Ticker']

# 创建 SQLite 连接和游标

# 构建数据库文件路径
database_file_name = 'FinanceData.db'
database_file_path = os.path.join(great_grandparent_dir, database_file_name)

# conn = sqlite3.connect('../FinanceData.db')
conn = sqlite3.connect(database_file_path)
cursor = conn.cursor()

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
        income_statement_index TEXT,
        income_statement_value REAL,
        balance_sheet_index TEXT,
        balance_sheet_value REAL,
        cashflow_index TEXT,
        cashflow_value REAL,
        current_price TEXT,
        current_price_value REAL,
        long_name TEXT
    )
''')

# 插入数据到 Data 表
for i, value in enumerate(column_data):
    column_name = header_row[i] # 使用 header_row 中的列名
    cursor.execute(f'''
        INSERT INTO {table_name} (income_statement_index, income_statement_value) VALUES (?, ?)
    ''', (column_name, value))

headers = tsla.balancesheet

# 获取对应列的索引
column_name = headers.columns[0]
column_index = headers.columns.get_loc(column_name)

header_row = tsla.balancesheet.index

# 获取对应列的数据
column_data = headers.iloc[:, column_index].tolist()

for i, value in enumerate(column_data):
    column_name = header_row[i] # 使用 header_row 中的列名
    cursor.execute(f'''
        INSERT INTO {table_name} (balance_sheet_index, balance_sheet_value) VALUES (?, ?)
    ''', (column_name, value))

headers = tsla.cashflow

# 获取对应列的索引
column_name = headers.columns[0]
column_index = headers.columns.get_loc(column_name)

header_row = tsla.cashflow.index

# 获取对应列的数据
column_data = headers.iloc[:, column_index].tolist()

for i, value in enumerate(column_data):
    column_name = header_row[i] # 使用 header_row 中的列名
    cursor.execute(f'''
        INSERT INTO {table_name} (cashflow_index, cashflow_value) VALUES (?, ?)
    ''', (column_name, value))

price = tsla.fast_info['previousClose']

column_name = "current_price"
value = price

cursor.execute(f'''
        INSERT INTO {table_name} (current_price, current_price_value) VALUES (?, ?)
    ''', (column_name, value))




# 实例化一个YFinance对象，传入股票代码
stock = YFinance(table_name)

# 获取股票的信息
stock_info = stock.info

# 打印股票的信息
stock_data = {}

for key, value in stock_info.items():
    if key == 'country':
        stock_data['country'] = value
    elif key == 'industry':
        stock_data['industry'] = value
    elif key == 'sector':
        stock_data['sector'] = value
    elif key == 'longBusinessSummary':
        stock_data['longBusinessSummary'] = value
    elif key == 'underlyingSymbol':
        stock_data['underlyingSymbol'] = value
    elif key == 'longName':
        stock_data['longName'] = value

country = stock_data['country']
industry = stock_data['industry']
sector = stock_data['sector']
longBusinessSummary = stock_data['longBusinessSummary']
underlyingSymbol = stock_data['underlyingSymbol']
longName = stock_data['longName']

# when longName meet first space, it will be split into two parts
longName1 = longName.replace(" ", "_")
# delete the dot in longName
longName1 = longName1.replace(".", "")
longName1 = longName1.replace(",", "")

print(longName1)

cursor.execute(f'''
        INSERT INTO {table_name} (long_name) VALUES (?)
    ''', (longName1,))

# 创建表格
cursor.execute(f'''
    CREATE TABLE IF NOT EXISTS {longName1} (
        country TEXT,
        industry TEXT,
        sector TEXT,
        longBusinessSummary TEXT,
        underlyingSymbol TEXT,
        longName TEXT
    )
''')


# 插入数据
insert_query = f'''
    INSERT INTO {longName1} (country, industry, sector, longBusinessSummary, underlyingSymbol, longName)
    VALUES (?, ?, ?, ?, ?, ?)
'''

cursor.execute(insert_query, (country, industry, sector, longBusinessSummary, underlyingSymbol, longName))

# 提交事务并关闭连接
conn.commit()
conn.close()