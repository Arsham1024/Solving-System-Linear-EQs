# Solving-System-Linear-EQs
##### I developed these algorithms to solve linear equations using two methods: 1. gauss-seidel 2. Jacobi
This was done for CS 3010 Numerical Methods
---
### Description:
###### 1. Gauss-Seidel method: This is an itterative method used to solve a system of linear equations
###### 2. Jacobi method: This is also an itterative method used to solve a system of linear equations. 
###### These methods are very similar to each other with minor difference.
---
### Backstory:
###### This is the second try of the team to rebuild this algorithm after the first version proved to be unsuccessful.This time we implimented the code in Google collab which allowed for better debugging experience. Though we had to import the data set everytime into the data base. Version 1 is also included as a reference.
---
### Data Set:
###### The data used is a list of fruits (Orange, Apple, Mandarin, Lemon). This data set has many features such as weight, height, width, etc. but for our purposes we used only the width, height, fruit-name attributes. We split the data set 30-70 with 30% of data for testing and 70% for training.
---
### How:
#### Gauss-Seidel
...
#### Jacobi : 
###### 
---
### What did we learn?
###### a clean data set is crucial for this algorithm to be successful. Preprocessing of the data took by far the longest amount of time and it was by far the most useful thing we did. A distinct data set that is also absoluteley necessary.
###### Choosing a reasonable k number of neighbors to consider is very important. if k is too large or too small the data could be dramatically influenced. This happens usually when a dataset has very similar items and can be visually seen when plotting the data set. we can easily undermine the distance function if the K number is too large since we will be considering the objects that are too far away and are considered of a different kind, but we are considering them anyway because that particular object is still closer than others.
---
### Using: 
* Python
* Numpy
* Pandas
* Matplotlib
* Google colab

