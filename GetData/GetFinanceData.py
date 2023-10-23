import sqlite3
import yfinance as yf
import pandas as pd

# 创建 SQLite 连接和游标
conn = sqlite3.connect('../FinanceData.db')
cursor = conn.cursor()

# 获取 TSLA 的财务数据
tsla = yf.Ticker('TSLA')
headers = tsla.financials

# 获取对应列的索引
column_name = '2022-12-31'
column_index = headers.columns.get_loc(column_name)
header_row = ['Tax Effect Of Unusual Items', 'Tax Rate For Calcs', 'Normalized EBITDA', 'Total Unusual Items',
              'Total Unusual Items Excluding Goodwill', 'Net Income From Continuing Operation Net Minority Interests',
              'Reconciled Depreciation', 'Reconciled Cost Of Revenue', 'EBITDA', 'EBIT', 'Net Interest Income',
              'Interest Expense', 'Interest Income', 'Normalized Income', 'Net Income From Continuing And Discontinued Operations',
              'Total Expenses', 'Total Operating Income As Reported', 'Diluted Average Shares', 'Basic Average Shares',
              'Diluted EPS', 'Basic EPS', 'Diluted NI Avail to Com Stockholders', 'Average Dilution Earnings',
              'Net Income Common Stockholders', 'Net Income', 'Minority Interests', 'Net Income Including Noncontrolling Interests',
              'Net Income Continuous Operations', 'Tax Provision', 'Pretax Income', 'Other Income Expense',
              'Other Non Operating Income Expenses', 'Special Income Charges', 'Restructuring And Mergern Acquisition',
              'Net Non Operating Interest Income Expense', 'Interest Expense Non Operating', 'Interest Income Non Operating',
              'Operating Income', 'Operating Expense', 'Research And Development', 'Selling General And Administration',
              'Gross Profit', 'Cost Of Revenue', 'Total Revenue', 'Operating Revenue']

# 获取对应列的数据
column_data = headers.iloc[:, column_index].tolist()

# 创建 Data 表（如果不存在）
cursor.execute('''
    CREATE TABLE IF NOT EXISTS FiData (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        column_name TEXT,
        value REAL
    )
''')

# 插入数据到 Data 表
for i, value in enumerate(column_data):
    column_name = header_row[i] # 使用 header_row 中的列名
    cursor.execute('''
        INSERT INTO FiData (column_name, value) VALUES (?, ?)
    ''', (column_name, value))




# 提交事务并关闭连接
conn.commit()
conn.close()