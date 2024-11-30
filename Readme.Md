# Tambola Game

A basic implementation of the Tambola (Housie) game logic, including ticket creation, 
game pattern validation, and winner determination.

## Features
- **Exception Handling**:
    - Custom exceptions for handling invalid inputs.
- **Game Patterns**:
    - Supports various winning patterns such as:
        - Top Row
        - Middle Row
        - Bottom Row
        - Full House
        - Early Five
- **Validation Helpers**:
    - Validates winning claims based on announced numbers and ticket structure.

## How It Works

1. **Game Pattern Factory**:
    - Dynamically generates the strategy for the requested game pattern.
2. **Ticket Validation**:
    - Ensures tickets meet the required structure and announced numbers match the winning criteria.
3. **Winner Determination**:
    - Implements pattern-specific logic to check if the claim is valid.

## Example Usage

- **Create a Ticket**:
    - Define a ticket with predefined numbers.
- **Announce Numbers**:
    - List the numbers announced during the game.
- **Validate Claim**:
    - Use `isGameWinner` to verify claims for different game patterns (e.g., `Top Row`, `Middle Row`, etc.).

## How to Run

1. Initialize the `Round` and `Game` objects.
2. Create a `Ticket` with the required numbers.
3. Validate the winning claims using pattern logic.

## Setup and Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/GuganVishagan/Tambola.git
