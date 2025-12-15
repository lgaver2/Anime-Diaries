# Anime diary app
A simple program to keep a log of anime episodes you watched.

## Core Functionality:
- **Menu Screen:** The dashboard allows the user to add a new anime or a new review to an existing series. The main list displays the title, the average episode score, the date of the last entry, and the user’s progression (percentage of watched episodes relative to the total).
- **Review Mode:** When selecting an existing anime, the user can log a review. This includes a score (out of 10) and a written note (the program may suggest themes to assist with writing). The submission
date is automatically recorded by the system.
- **Add Mode:** Used to register a new anime series to the database. The user inputs the title and the total number of episodes.


## Technical Specifications
- Architecture: The application follows the MVC pattern. This ensures the display interface is decoupled from the logic, allowing for easier UI updates.
- GUI: Options include a Console/Terminal interface, HTML, or Java Swing.
- Data Persistence: User reviews and logs will be stored using the JSON format. There will be one file per anime (within the JSON file, each review and score will be tagged with the entry date).
