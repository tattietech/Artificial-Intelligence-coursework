# Artificial Intelligence Coursework - A* Pathfinding Algorithm

## Project Overview

This project is an academic implementation of the **A* (A-Star) pathfinding algorithm** in Java, developed as coursework for an Artificial Intelligence course. The program solves the problem of finding the shortest path through a cavern system represented as a coordinate-based map.

## Problem Statement

Given a cavern system represented by a series of coordinate points with connections between them, the task is to find the optimal (shortest) path from a start location to an end location while navigating through the cavern network. This is a classic pathfinding problem that demonstrates practical applications of AI search algorithms.

## Algorithm Implementation

### A* Algorithm

The A* algorithm is an informed search algorithm that finds the shortest path between nodes in a graph. It uses a best-first search approach and evaluates nodes by combining two values:

- **g(n)**: The actual cost from the start node to the current node
- **h(n)**: The heuristic estimated cost from the current node to the goal node (using Euclidean distance)
- **f(n) = g(n) + h(n)**: The total estimated cost of the path through node n

This implementation uses the Euclidean distance heuristic for estimating the remaining distance to the goal, making it well-suited for coordinate-based navigation problems.

## Project Structure

```
.
├── src/com/company/
│   ├── Main.java              # Entry point and file I/O handling
│   ├── AStarImproved.java     # Core A* algorithm implementation
│   ├── AStar.java             # Alternative A* implementation
│   ├── Node.java              # Node representation with coordinates
│   ├── Map.java               # Map structure for cavern system
│   ├── CavernFile.java        # Cavern file parser
│   └── FileFilter.java        # File filtering utility
├── cavernexplorer.jar         # Compiled JAR executable
└── README.md                  # This file
```

## Technical Details

- **Language**: Java
- **Algorithm**: A* (A-Star) pathfinding
- **Heuristic**: Euclidean distance
- **Data Structure**: Node-based graph representation
- **Input Format**: `.cav` files containing cavern coordinate data
- **Output Format**: `.csn` files containing the solution path

## How to Run

### Using the Compiled JAR

```bash
java -jar cavernexplorer.jar <input_file.cav>
```

### Using the Batch File (Windows)

```bash
caveroute.bat <input_file>
```

The program accepts a cavern file (`.cav` extension) as input and generates a solution file (`.csn` extension) containing the sequence of nodes representing the shortest path.

## Input Format

The program expects `.cav` files containing cavern data with coordinate information. The first node in the file is treated as the start point, and the last node as the goal.

## Output Format

The solution is written to a `.csn` file containing:
- Space-separated node indices representing the path from start to goal
- Node indices are 1-based (starting from 1, not 0)
- Returns `0` if no path is found

## Algorithm Features

- **Open List**: Maintains nodes to be evaluated
- **Closed List**: Tracks already evaluated nodes
- **Parent Tracking**: Enables path reconstruction from goal to start
- **Distance Calculation**: Uses Euclidean distance for both g(n) and h(n) values
- **Path Reversal**: Final path is reversed to show start-to-goal order

## Academic Context

This project demonstrates:
- Understanding of informed search algorithms
- Implementation of heuristic-based pathfinding
- Graph traversal and pathfinding techniques
- Practical application of AI algorithms to navigation problems
- Software engineering principles in algorithm implementation

## Author

Developed as coursework for Artificial Intelligence studies.
