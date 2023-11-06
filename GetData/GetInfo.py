from Info import YFinance

# 实例化一个YFinance对象，传入股票代码
stock = YFinance("AAPL")

# 获取股票的信息
stock_info = stock.info

# 打印股票的信息
for key, value in stock_info.items():
    print(f"{key}: {value}")
