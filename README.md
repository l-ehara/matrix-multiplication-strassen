# Matrix Multiplication with Strassen Algorithm

## Introduction

This repository contains an implementation of the Strassen algorithm for matrix multiplication in Java. The Strassen algorithm is an efficient algorithm for multiplying matrices, based on the concept of recursive divide-and-conquer.

## Features

- Implements the Strassen algorithm for matrix multiplication.
- Divides matrices into submatrices and performs calculations recursively.
- Merges submatrices to obtain the final result.
- Provides methods for matrix addition and subtraction.
- Includes a demonstration in the `Main` class to showcase the usage and performance.

## Usage

To use the Strassen algorithm for matrix multiplication, follow these steps:

1. Clone the repository: `git clone https://github.com/your-username/matrix-multiplication-strassen.git`
2. Open the project in your preferred Java development environment.
3. Create or import your matrices for multiplication.
4. Instantiate the `AlgoritmoStrassen` class.
5. Call the `multiplicar` method, passing the matrices as arguments.
6. Retrieve the resulting matrix.
7. Perform any additional operations or analysis as needed.

## Runtime analisys

- For this multiplication:

```JAVA
Matrix A:
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16

WITH

Matrix B:
17 18 19 20
21 22 23 24
25 26 27 28
29 30 31 32
```

The result was given in **0,0000579s.**

