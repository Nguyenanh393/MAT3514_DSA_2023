import pandas as pd
import matplotlib.pyplot as plt

# read data from file
with open('hw7_21000663_NguyenNgocAnh/ex02/data/average.txt', 'r') as f:
    data = f.read().splitlines()

# split data into columns
data = [x.split('\t') for x in data]

# convert data to dataframe
df = pd.DataFrame(data[1:], columns=data[0])
# convert data from string to float
df = df.astype(float)

# draw the chart
# Sequential Search Algorithm
plt.plot(df['N'], df['Sequential Search Algorithm'], label='Sequential Search Algorithm')
# Binary Search Algorithm
plt.plot(df['N'], df['Binary Search Algorithm'], label='Binary Search Algorithm')
# Binary Search Tree Algorithm
plt.plot(df['N'], df['Binary Search Tree Algorithm'], label='Binary Search Tree Algorithm')

# set the title of the chart
plt.title('Average Time Complexity')
# set the label for x axis
plt.xlabel('n')
# set the label for y axis
plt.ylabel('Time Complexity')
# set the legend
plt.legend()

plt.savefig('hw7_21000663_NguyenNgocAnh\ex02\data\chart.jpg')

plt.show()
