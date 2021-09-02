# Solving-System-Linear-EQs
##### This algorithm was developed with a team of students for CS 3310: Algorithm design class
---
### Description:
###### Knn (K - nearest neighbor) is a supervised Machine Learning algorithm used for classification of a new item with respect to a data set. This algorithm is also dubed as lazy learning.
---
### Backstory:
###### This is the second try of the team to rebuild this algorithm after the first version proved to be unsuccessful.This time we implimented the code in Google collab which allowed for better debugging experience. Though we had to import the data set everytime into the data base. Version 1 is also included as a reference.
---
### Data Set:
###### The data used is a list of fruits (Orange, Apple, Mandarin, Lemon). This data set has many features such as weight, height, width, etc. but for our purposes we used only the width, height, fruit-name attributes. We split the data set 30-70 with 30% of data for testing and 70% for training.
---
### How:
###### Most of the algorithm is focused on preprocessing on the data.
1. A subsection of the data is chosen to use for attributes for Knn (width, height, fruit name)
2. setting up a data frame for pandas to visualize and plot later
3. Making the function Distance which calculates the euclidian distance between points in order to determine their relevence to each other.
4. making function get closest neighbor. This function will find the closest n number of neighbors and return them.
5. based on previous steps we make the predict method that takes in the n closest neighbors and their distances to determine the unknown object at hand.
6. At the end we use the testing data to run the algorithm and determine the accuracy.
7. based on our data we have determined a 80% accuracy and this is due to the data size being small.
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

