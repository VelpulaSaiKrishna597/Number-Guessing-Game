# Number Guessing Game

A fun and interactive Java console application where you try to guess a randomly generated number. The game features multiple rounds, limited attempts, and a scoring system based on how quickly you guess the number.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Requirements](#requirements)
- [How to Compile and Run](#how-to-compile-and-run)
- [How the Game Works](#how-the-game-works)
- [Game Flow](#game-flow)
- [Scoring System](#scoring-system)
- [Code Structure](#code-structure)
- [Customization](#customization)
- [Example Gameplay](#example-gameplay)

## 🎮 Overview

The Number Guessing Game is a classic guessing game where:
- The computer generates a random number between **1 and 100**
- You have **7 attempts** to guess the number in each round
- The game consists of **3 rounds**
- You earn points based on how quickly you guess correctly
- After all rounds, you can choose to play again

## ✨ Features

✅ **Random Number Generation**: Computer picks a random number from 1-100 each round  
✅ **User Input Validation**: Ensures you enter valid numbers within the range  
✅ **Feedback System**: Tells you if your guess is "Too high", "Too low", or "Correct"  
✅ **Limited Attempts**: 7 attempts per round to keep the game challenging  
✅ **Multiple Rounds**: 3 rounds per game session  
✅ **Scoring System**: Points awarded based on number of attempts used  
✅ **Score Tracking**: Shows your score after each round and final score at the end  
✅ **Play Again Option**: Choose to play another full game after completion  
✅ **Error Handling**: Handles invalid input gracefully  

## 📦 Requirements

- **Java Development Kit (JDK)**: Version 8 or higher
- **Command Line/Terminal**: To compile and run the program
- **Text Editor or IDE**: To view/edit the code (optional)

## 🚀 How to Compile and Run

### Step 1: Open Terminal/Command Prompt

Navigate to the project directory:
```bash
cd "C:\Cursor\Number Guessing Game"
```

### Step 2: Compile the Java File

```bash
javac NumberGuessingGame.java
```

This creates a `NumberGuessingGame.class` file (the compiled bytecode).

### Step 3: Run the Game

```bash
java NumberGuessingGame
```

The game will start and display the welcome message!

## 🎯 How the Game Works

### Game Flow

1. **Welcome Screen**: The game displays rules and instructions
2. **Game Loop**: The outer loop allows playing multiple full games
3. **Round Loop**: Each game consists of 3 rounds
4. **Guessing Loop**: Each round allows up to 7 attempts
5. **Scoring**: Points are calculated and added after each successful round
6. **Game Over**: Final score is displayed
7. **Play Again**: Option to start a new game

### Detailed Step-by-Step Process

#### 1. **Initialization**
```
- Scanner object is created to read user input
- Random object is created to generate random numbers
- Welcome message and rules are displayed
```

#### 2. **Game Session Loop** (Outer Loop)
```
- Total score is reset to 0 for each new game
- Loops through 3 rounds
```

#### 3. **Round Loop** (Middle Loop)
```
For each round:
  - A new random number is generated (1-100)
  - Attempt counter is reset to 0
  - Guessed correctly flag is set to false
```

#### 4. **Guessing Loop** (Inner Loop)
```
For each attempt:
  - Prompts user to enter a guess
  - Validates the input (must be a number between 1-100)
  - Increments attempt counter
  - Compares guess with secret number:
      * If equal → Correct! Calculate points, add to score
      * If lower → "Too low! Try a higher number."
      * If higher → "Too high! Try a lower number."
  - Continues until correct guess OR max attempts reached
```

#### 5. **Round Completion**
```
- If guessed correctly: Shows points earned
- If out of attempts: Reveals the secret number
- Displays current total score
```

#### 6. **Game Completion**
```
- After 3 rounds: Shows final score
- Asks if player wants to play again (Y/N)
- If Yes: Starts new game session
- If No: Thanks player and exits
```

## 🏆 Scoring System

Points are awarded based on how quickly you guess the number:

| Attempts Used | Points Earned |
|---------------|---------------|
| 1st attempt   | 100 points    |
| 2nd attempt   | 80 points     |
| 3rd attempt   | 60 points     |
| 4th attempt   | 40 points     |
| 5th attempt   | 30 points     |
| 6th attempt   | 20 points     |
| 7th attempt   | 10 points     |

**Note**: If you don't guess correctly within 7 attempts, you earn **0 points** for that round.

## 💻 Code Structure

### Main Components

#### 1. **Constants** (Lines 17-20)
```java
MIN_NUMBER = 1              // Minimum number in range
MAX_NUMBER = 100            // Maximum number in range
MAX_ATTEMPTS_PER_ROUND = 7  // Maximum guesses per round
TOTAL_ROUNDS = 3            // Number of rounds per game
```

#### 2. **Main Method** (Lines 22-97)
- **Initialization**: Creates Scanner and Random objects
- **Outer Loop**: Handles multiple game sessions
- **Round Loop**: Manages 3 rounds per game
- **Guessing Loop**: Handles individual guesses and feedback
- **Input Validation**: Ensures valid number input
- **Score Calculation**: Calls `calculatePoints()` method
- **Play Again**: Prompts for another game

#### 3. **calculatePoints() Method** (Lines 112-129)
- Takes the number of attempts as input
- Returns points based on a switch statement
- Rewards fewer attempts with more points

#### 4. **readInt() Method** (Lines 134-140)
- Safely reads integer input from Scanner
- Handles invalid input (non-numeric) gracefully
- Re-prompts until valid integer is entered

### Key Algorithms

#### Random Number Generation
```java
random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER
```
- `nextInt(100)` generates 0-99
- Adding 1 makes it 0-100
- Adding MIN_NUMBER shifts it to 1-100

#### Input Validation
```java
if (guess < MIN_NUMBER || guess > MAX_NUMBER) {
    // Re-prompt without counting as an attempt
}
```

#### Game State Management
- Uses boolean flags (`guessedCorrectly`) to control loop flow
- Tracks attempts with counter
- Accumulates score across rounds

## 🛠️ Customization

You can easily modify the game by changing the constants at the top of the file:

### Change the Number Range
```java
private static final int MIN_NUMBER = 1;   // Change to any minimum
private static final int MAX_NUMBER = 100; // Change to any maximum (e.g., 500)
```

### Change Attempts per Round
```java
private static final int MAX_ATTEMPTS_PER_ROUND = 7; // Change to 5, 10, etc.
```

### Change Number of Rounds
```java
private static final int TOTAL_ROUNDS = 3; // Change to 5, 10, etc.
```

### Modify Scoring System
Edit the `calculatePoints()` method to change point values:
```java
case 1: return 100;  // Change these values
case 2: return 80;   // to customize scoring
// ... etc
```

## 📝 Example Gameplay

```
=======================================
        WELCOME TO GUESS THE NUMBER    
=======================================
Rules:
- I will think of a number between 1 and 100.
- You have 7 attempts each round to guess it.
- There are 3 rounds in total.
- The fewer attempts you use, the more points you earn.

---------------------------------------
Round 1 of 3
---------------------------------------
Enter your guess (1 - 100): 50
Too high! Try a lower number.
Enter your guess (1 - 100): 25
Too low! Try a higher number.
Enter your guess (1 - 100): 37
Correct! You guessed the number in 3 attempt(s).
You earned 60 point(s) this round.
Your current total score: 60

---------------------------------------
Round 2 of 3
---------------------------------------
Enter your guess (1 - 100): 75
Too low! Try a higher number.
Enter your guess (1 - 100): 90
Too high! Try a lower number.
Enter your guess (1 - 100): 82
Correct! You guessed the number in 3 attempt(s).
You earned 60 point(s) this round.
Your current total score: 120

---------------------------------------
Round 3 of 3
---------------------------------------
Enter your guess (1 - 100): 50
Too high! Try a lower number.
Enter your guess (1 - 100): 25
Too low! Try a higher number.
Enter your guess (1 - 100): 37
Too low! Try a higher number.
Enter your guess (1 - 100): 44
Correct! You guessed the number in 4 attempt(s).
You earned 40 point(s) this round.
Your current total score: 160

=======================================
              GAME OVER                
=======================================
Your final score after 3 round(s): 160

Do you want to play again? (Y/N): N

Thank you for playing the Number Guessing Game!
```

## 🎓 Learning Points

This project demonstrates:
- **Object-Oriented Programming**: Using classes and methods
- **Control Flow**: Loops (while, for) and conditionals (if-else)
- **Input/Output**: Using Scanner for user input
- **Random Number Generation**: Using Random class
- **Error Handling**: Input validation
- **State Management**: Tracking game state with variables
- **Modular Design**: Separating logic into methods

## 📄 License

This is a simple educational project. Feel free to use, modify, and learn from it!

## 🤝 Contributing

Feel free to enhance this game with additional features like:
- Difficulty levels (Easy, Medium, Hard)
- High score tracking
- Statistics (average attempts, win rate)
- GUI version using Java Swing
- Sound effects
- Color-coded feedback

---

**Enjoy playing the Number Guessing Game!** 🎉

