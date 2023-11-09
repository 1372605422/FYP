from Info import YFinance
import sqlite3
import json
# 实例化一个YFinance对象，传入股票代码
stock = YFinance("GOOG")

# 获取股票的信息
stock_info = stock.info

# 创建 SQLite 连接和游标
conn = sqlite3.connect('../FinanceData.db')
cursor = conn.cursor()

# 打印股票的信息
# for key, value in stock_info.items():
#     print(f"{key}: {value}")

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

with open('config/config.json') as f:
    config = json.load(f)

table_name = config['Ticker']
table_name_info = table_name + "info"

# 创建表格
cursor.execute(f'''
    CREATE TABLE IF NOT EXISTS {table_name_info} (
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
    INSERT INTO {table_name_info} (country, industry, sector, longBusinessSummary, underlyingSymbol, longName)
    VALUES (?, ?, ?, ?, ?, ?)
'''

cursor.execute(insert_query, (country, industry, sector, longBusinessSummary, underlyingSymbol, longName))

# 提交事务并关闭连接
conn.commit()
conn.close()