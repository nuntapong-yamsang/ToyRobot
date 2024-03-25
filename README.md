# ToyRobot
This project is for SS&amp;C recruiting process

## 0. Prerequisite
1. JDK

2. Git Bash

## 1. Setup
1. Open Git Bash

2. Create a folder for containing the project and go to the folder.

3. Download source code using this command.
```bash
git clone https://github.com/nuntapong-yamsang/ToyRobot.git
```

4. Go to folder "ToyRobot"

5. Compile the source code using this command.
```bash
javac -d bin/ -cp src src/ssc/robot/main/ToyRobot.java
```

6. Run the application using this command.
```bash
java -cp bin ssc.robot.main.ToyRobot
```

## 2. Robot command
1. PLACE
```bash
PLACE X,Y,F
```
PLACE will put the robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST. The origin (0,0) can be considered to be the SOUTH WEST most corner. It is required that the first command to the robot is a PLACE command, after that, any sequence of commands may be issued, in any order, including another PLACE command. The application should discard all commands in the sequence until a valid PLACE command has been executed.
The table dimensions are 5 units x 5 units. 

2. MOVE
```bash
MOVE
```
MOVE will move the toy robot one unit forward in the direction it is currently facing.

3. LEFT
```bash
LEFT
```
LEFT will rotate the robot 90 degrees in the left direction without changing the position of the robot.

4. RIGHT
```bash
RIGHT
```
RIGHT will rotate the robot 90 degrees in the right direction without changing the position of the robot.

5. REPORT
```bash
REPORT
```
REPORT will announce the X,Y and F of the robot. This can be in any form, but standard output is
sufficient.

## 3. Example Input and Output:
Example 1:
PLACE 0,0,NORTH
MOVE
REPORT
Output: 0,1,NORTH

Example 2:
PLACE 0,0,NORTH
LEFT
REPORT
Output: 0,0,WEST

Example 3:
PLACE 1,2,EAST
MOVE
MOVE
LEFT
MOVE
REPORT
Output: 3,3,NORTH
