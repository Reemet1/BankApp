import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

USAhousing = pd.read_csv('USA_Housing.csv')
print(USAhousing.head())
print(USAhousing.info())
print(USAhousing.describe())
print(USAhousing.columns)

sns.pairplot(USAhousing)
plt.show()

sns.distplot(USAhousing['Price'])
plt.show()

sns.heatmap(USAhousing.corr())
plt.show()

# TRAINING LINEAR REGRESSION MODEL

X = USAhousing[['Avg. Area Income', 'Avg. Area House Age', 'Avg. Area Number of Rooms',
               'Avg. Area Number of Bedrooms', 'Area Population']]
y = USAhousing['Price']

# Separate training and test data
from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.4, random_state=101)

# Creating training model
from sklearn.linear_model import LinearRegression
lm = LinearRegression()
lm.fit(X_train,y_train)

# Model evaluation
print(lm.intercept_)
coeff_df = pd.DataFrame(lm.coef_,X.columns,columns=['Coefficient'])
print(coeff_df)

# Predictions from model
predictions = lm.predict(X_test)
plt.scatter(y_test,predictions)
plt.show()

sns.distplot((y_test-predictions),bins=50)
plt.show()

# Regression metrics
# MAE - Mean Absolute Error
# MSE - Mean Squared Error
# RMSE - Root Mean Squared Error
from sklearn import metrics
print('MAE:', metrics.mean_absolute_error(y_test, predictions))
print('MSE:', metrics.mean_squared_error(y_test, predictions))
print('RMSE:', np.sqrt(metrics.mean_squared_error(y_test, predictions)))



