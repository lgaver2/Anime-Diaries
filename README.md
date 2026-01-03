# Anime diary app
A simple program to keep a log of anime episodes you watched.

## Core Functionality:
- **Menu Screen:** The dashboard allows the user to add a new anime or a new review to an existing series. The main list displays the title, the average episode score, the date of the last entry, and the user’s progression (percentage of watched episodes relative to the total).
- **Log Mode:** When selecting an existing anime, the user can log a review. This includes a score (out of 10) and a written note (the program may suggest themes to assist with writing). The submission.
date is automatically recorded by the system.
- **View Mode:** to see former comment and scores with date.
- **Add Mode:** Used to register a new anime series to the database. The user inputs the title and the total number of episodes.


## Technical Specifications
### Requirements
- Java (tested with javac 21.0.9)
- Maven (tested with maven 21.0.9)
- Makefile
### Other specifications
- Architecture: The application follows the MVC pattern. This ensures the display interface is decoupled from the logic, allowing for easier UI updates.
- GUI: Options include a Console/Terminal interface, HTML, or Java Swing.
- Data Persistence: User reviews and logs will be stored using the JSON format. There will be one file per anime (within the JSON file, each review and score will be tagged with the entry date).

## How to use
### Launch
Go to the root directory and just type *make* and the app will launch.
### Application guide
- **Add an anime**: Go to *File->Add anime* then type the anime title and the total nuber of episodes then push ADD button.
- **Review an episode**: From the main menu, push Add button of the anime you want to review, then type your score (out of 10) and a comment for the episode then push Commit button to save your comment.
- **View your comments**: From the main menu, choose one anime then push View button to view your former score and comments.
- **Cancelation**: If you want to cancel a writing (for new anime or a comment), go to *File->Cancel*, and you will back to main menu without saving your records.
