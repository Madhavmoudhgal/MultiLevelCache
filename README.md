# Dynamic Multilevel Caching System

## Overview

This project implements a **Dynamic Multilevel Caching System** in Java, allowing efficient management of data across multiple cache levels with support for different eviction policies such as **Least Recently Used (LRU)** and **Least Frequently Used (LFU)**. The system allows for dynamic addition and removal of cache levels at runtime.

## Features

- **Multiple Cache Levels**: L1, L2, ..., Ln with configurable sizes.
- **Eviction Policies**:
  - **LRU (Least Recently Used)**: Evicts the least recently accessed data.
  - **LFU (Least Frequently Used)**: Evicts the least frequently accessed data.
- **Dynamic Cache Level Management**: Add or remove cache levels at runtime.
- **Efficient Data Management**: Data is retrieved from the highest-priority cache first (L1), and promoted to higher levels if retrieved from lower levels.
- **In-Memory Storage**: All operations and data storage are performed in memory without external services.

## How to Run

### Prerequisites

- **Java Development Kit (JDK)** installed on your machine.
- **IntelliJ IDEA** (or any other Java IDE) for compiling and running the project.

### Steps to Run:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Madhavmoudhgal/MultiLevelCache.git
2. Open the Project in IntelliJ IDEA:

   Navigate to the folder where you cloned the repository.
   Open the project in any IDE.
3. Compile and Run:

   In the src/ folder, open the Main.java file.
   Run the file (Main.java) using IntelliJ's run button or right-click and select Run 'Main'.

# Example Test Case

## Cache Levels

### Level 1 (L1)
- **Size**: 3
- **Eviction Policy**: LRU (Least Recently Used)

### Level 2 (L2)
- **Size**: 2
- **Eviction Policy**: LFU (Least Frequently Used)

## Test Operations

1. **Insert Data into L1**:
   - Insert ("A", "1")
   - Insert ("B", "2")
   - Insert ("C", "3")

2. **Retrieve Data**:
   - Retrieve key **A** from the cache.
     - **Expected Output**: `1`
     - **Level 1 Cache**: `{A=1, D=4, C=3}`
     - **Level 2 Cache**: `{}`
   
3. **Insert More Data to Trigger Eviction**:
   - Insert ("D", "4") into L1, which will trigger an eviction of the least recently used key (**B**).

4. **Promote Key B**:
   - Retrieve key **B** from the cache.
     - **Expected Output**: `2`
     - **Level 1 Cache**: `{B=2, D=4, C=3}`
     - **Level 2 Cache**: `{}`

## Key Assumptions

- All data is stored in memory.
- No external services or databases are required.
- Evictions are handled based on the specified eviction policy (LRU or LFU).

## Project Structure
``` src/
  ├── CacheLevel.java      # Manages individual cache levels
  ├── CacheManager.java    # Manages all cache levels and operations
  └── Main.java            # Main class to run test cases
.gitignore                 # Ignores unnecessary files (e.g., .idea/, compiled files)
README.md                  # Project documentation (this file)
```


