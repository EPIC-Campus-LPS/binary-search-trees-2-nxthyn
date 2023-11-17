# Lab 9: Binary Search Trees

## Objective
In this lab, you are to implement several methods for a binary search tree. You will also implement a console program that will allow you to test your methods for your search tree efficiently. In order to implement your BST, modify the `BinarySearchTree` and the `TreeNode` classes provided.

## Creating a BST
Your final BST class should have the following methods:
- `void add(E value)`
- `boolean contains(E value)`
- `int countNodes()`  //returns the number of nodes in the tree
- `int countLeafNodes()`   //returns the number of leaf nodes in tree
- `int getHeight()`   //returns the longest path from the root to a leaf node
- `void printInorder()`
- `void printPreorder()`
- `void printPostorder()`  
- `E delete(E value)` //returns the deleted node
  
## Console Program
The console program should allow the following options:
1. Fill the tree from a file
2. Add a value to tree
3. Delete a value from the tree
4. See if tree contains a value
5. Test traversals (pre, in, post)
6. Print stats (nodes, leaf nodes, height)
7. Clear the tree
8. Exit Program

## Testing
You may assume the file to be read will contain only integers. (You may ask the user which it is before you build the tree.) The file will have all the data listed one at a time, each on a new line. If the user enters an invalid entry for the menu, the program will prompt the user for a valid menu entry.

Please create JUnit tests with 85% coverage for your program. 

## Javadoc
Add Javadoc comments and generate a Javadoc HTML reference for your program.


## Rubric
4 points – All requested items are present. Functional and efficient radix sort class as described above. Javadoc reference for the class. JUnit tests with a coverage report of at least 85%.
3 points – Some of the requested items are missing. Classes are complete but are missing Javadoc reference. Test cases are missing or incomplete.
2 points – Missing or incomplete. Student should re-attempt
