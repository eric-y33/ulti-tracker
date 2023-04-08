# Team Stat Tracker for Ultimate Frisbee
### A CPSC 210 Project by Eric Yee

## About Ultimate

[Ultimate frisbee](https://en.wikipedia.org/wiki/Ultimate_(sport)) 
is a 7-on-7 non-contact team sport where two teams try to catch the disc
(or frisbee) in the other team's endzone. Each catch in the endzone
is worth one point, and games end once one team scores 15 points or
the time limit is reached. 
Players move the disc up the field by passing it to one another
with the caveat of *not being able to walk or run while holding
the disc*. On-field players usually
rotate with off-field players after each point.

I discovered this game around the age of ten, and it has 
remained my favourite sport ever since. I hope to coach a high school team
soon, and that's where I got the inspiration for this project.

## What is this Project?

As the name suggests, this project aims to be a stat-tracking
application for those who manage ultimate frisbee teams. Players usually have
jersey numbers and designated positions as either cutters or handlers 
(although sometimes both). During games, team managers or coaches 
often keep track of who plays, assists, and scores on each point.

This application will allow users to add multiple player profiles to a team and record their
information. Users will then be able to see the names of all players on the team,
update any player's profile or game statistics, and remove existing players from the team if needed.

## User Stories
- As a user, I want to see the names of all the players on a team.
- As a user, I want to be able to see any individual player's name, jersey number,
  position, points played, assists, and goals.
- As a user, I want to be able to edit any individual player's name, jersey number,
  position, points played, assists, and goals.
- As a user, I want to be able to add new players to a team along with 
  their jersey number and position.
- As a user, I want to be able to delete players from a team along with
  their jersey number and position.
- As a user, when I select quit from the main menu, I want to be
  reminded to save my team's information and have the option to do so or not.
- As a user, when I start the application, I want to be given the option to
  load my team's information from file.

## Instructions for Grader
- Start the GUI by running `GUI.java`.
- You can add players to a team by clicking "add a new player" and putting in a new player's details 
(ex. "Eric", "33", and "Handler" for each prompt).
- You can generate the first required action related to adding players to a team by clicking on the newly created player
and seeing their information on the right hand side of the application.
- You can generate the second required action related to adding players to a team by clicking "remove selected player"
to remove the previously selected player form the team.
- You can locate my visual component when clicking "remove selected player", where a checkmark will appear in the popup 
telling you that the selected player has been successfully removed.
- You can save the state of my application by clicking "Save" **(do not click on this with an empty team, 
or else the empty team will be saved)**.
- You can reload the state of my application by clicking "Load".

## Phase 4: Task 2
Sun Apr 02 11:29:53 PDT 2023
Added Eric to the team.

Sun Apr 02 11:30:09 PDT 2023
Added Will to the team.

Sun Apr 02 11:30:12 PDT 2023
Removed Will from the team.

## Phase 4: Task 3
If I were to refactor my program, I would mainly focus on splitting the GUI
class into multiple classes. 
Separating it into classes that handle the panels and components for
saving, player information viewing, and team editing would increase
the project's overall cohesion. 
The main GUI class would then use these classes to help "glue together"
all the pieces rather than provide functionality, and 
making the GUI application run from a "Main" class would also be an appropriate
change.

---
## Sources

- https://github.students.cs.ubc.ca/CPSC210/TellerApp
- https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
- https://github.students.cs.ubc.ca/CPSC210/AlarmSystem
- https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html
- https://clipartix.com/check-mark-clip-art-image-14891/