# file py này dùng để vẽ biểu đồ từ dữ liệu trong file average_execution_time.txt
# đưa ra hình ảnh trực quan cho giá trị trung bình đã tính

import pandas as pd
import matplotlib.pyplot as plt

# read data from file
with open('src\\Hw6_21000663_NguyenNgocAnh\\exercise03\\data\\average_execution_time.txt', 'r') as f:
    data = f.read().splitlines()

# split data into columns
data = [x.split('\t') for x in data]

# convert data to dataframe
df = pd.DataFrame(data[1:], columns=data[0])
# convert data from string to float 
df = df.astype(float)

# draw the chart
plt.plot(df['N'], df['Bubble'], label='Bubble Sort')
plt.plot(df['N'], df['Insertion'], label='Insertion Sort')
plt.plot(df['N'], df['Selection'], label='Selection Sort')
plt.plot(df['N'], df['Quick'], label='Quick Sort')
plt.plot(df['N'], df['Merge'], label='Merge Sort')
plt.plot(df['N'], df['Heap'], label='Heap Sort')

plt.legend()

# set the x and y axis labels
plt.xlabel('Number of array elements')
plt.ylabel('Average Execution Time (s)')
plt.title('Average Execution Time vs Number of array elements')

# save the chart to a file
plt.savefig('src\Hw6_21000663_NguyenNgocAnh\exercise03\data\chart.jpg')

