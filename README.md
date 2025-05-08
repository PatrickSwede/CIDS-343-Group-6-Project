# CIDS-343-Group-6-Project
## Overview
This project is a rogue-like game developed in CIDS 343,
during the Spring Semester of 2025. This project
uses the LIBGDX game framework. It consists of a
randomized map generator, and a prop/character class 
with many child classes which they contain as well. </p>

These components combine together to achieve the goal
of making a simple, yet fun and replayable rogue-like
game that you can enjoy for many hours. 

## Design

![entities](Documentation/CIDS_343_Group_6_Project.png)

This Uml diagram shows the layout of the entities, and our of our game
movement and controls as well.

### Control

The control class is how we move our player character in the game.
it uses many different values to check what directon the user is intending to 
move in. with direction booleans. Note that this class was copied online
from someone who made a similar game in the past, so we did not use all of the 
components that this class comes with.

*data fields*

These are the direction booleans to keep track of the directon of intended 
movement
- up 
- down
- left
- right

And then mouse booleans such as
- LMB
- RMB
- processed_click


there are also Vector2 variables. [^1]

[^1]:vector2 data types are linear 2d lines that can be 
used on a LibGDX screen for map positioning

These variables are 
- mouse_click_pos
- map_click_pos

these varables keep track of where on the screen the mouse was clicked
and where on the map that the mouse was clicked.

There is a debug boolean included for entering a debugging mode, and then
integers for keeping track of the 
- screen_width
- screen_height

*methods*

all of these varables have their own getters and setters as well

The constructor for this class takes the screen width and height
as well as instance of an orthographic camera to keep the camera
on the player.

The method setMouseClickedPos sets the mouse position on the screen and map 
when the mouse is clicked using the inputs of the x and y values on the screen

The method get_map_coords returns a vector 2 data type of the coordinates on the map
with an input of a Vector2 called the mouse_coords

Next, there is a method that returns a boolean called KeyDown which uses a switch
case based on common computer gaming controls to see if a key has been 
pressed down, if so it assigns true to a direction data field and then returns false
at the end to reset the key press condition. 

With KeyDown, there is KeyUp which changes the direction value associated with the 
key back to false based on a switch statement from before. this method also includes 
checks for the escape button to exit the game, as well as backspace to enter a debugging mode.

There is a method called KeyTyped that just currently returns false, which may be used later

The next method is called touchDown, it takes the x and y coordinates of the screen
and an integer called pointer. it checks if the left or right mouse button was pressed
and then sets LMB or RMB to true for use later.

There is also a touchUp method which resets LMB or RMB back to false.
both touchup and touchdown call setMouseClickedPos as well to set the postion 
on the map of where the mouse was clicked on the screen.

the next method called touchDragged is for the case of someone dragging a clicked mouse
across the screen, where it call setMouseClickedPos and gives it an x,y pair from the arguments
it is inputted, it then returns false at the end

the final method is called mouseMoved which currently does not do much, and just 
returns false.

### Movement

the movement class is how objects move throughout the screen.
it is dependent on the chunk class from the map through a compositon relationship

*Data Fields*

the data fields for Movement include
- an instance of Character
- an instance of Chunk
- a 2d array of tile instances

*Methods*

The constructor for this class takes a character instance and a chunk instance
and then sets the character and chunk data fields to what was put in for the arguments
the tiles array is then set up by using a method from the chunk class called 
getTiles to get each individual tile.

the isMoveValid method takes a string called direction to check and see if 
the move that a user is trying to make is valid according to the 
characters current position on the map. it then takes the direciton 
and then puts it in a switch statement in the method and checks the position
the user wants to move to based on its current position. Each tile has a integer 
assigned to them that dictates whether something can move there, if the integer
is not 1, then something cannot move to that tile and the mehtoud would return fase 
and the move would be invalid.

## Driver

The driver is like the main method of a java program, where all the objects come
together to make the whole game. Driver is part of LibGDX and is where you
create the gameplay loop based off of the objects you created. note this 
method implements applicaiton listener to help make the game run 
consistently.

*Data Fields* 

the driver contains
- a instance of SpriteBatch called spriteBatch [^2]
- a instance of Orthographic camera called camera
- a instance of FitViewport called viewport:
- a instance of Texture
- a instance of Sprite
- a Vector2 variable called touchPos
- 2 rectangle variables for 2 different sets of sprites

[^2]:a SpriteBatch is a group of Sprites in your game to give
your visible objects a visible asset, they are put all in 1 to load 
at once and make the game more efficient.

*methods*

the create method makes the map and the camera fit together at the beginning of the 
game, and loads other assets as well.

the resize method updates the viewport and changes its size 
to fit with a new screen size, as well as resetting the camera accordingly

The render method is a method that is called constantly 
while the game is running, this is where most of the game runs.
This method call the input, logic, and draw methods which will be expanded
upon later, with every time this method runs though, it makes a frame in the game.

The input method is where user input is taken, we have it empty currently 
but will add to it in the future. this is like the controller in a model view 
controller architecture (mvc).

the logic method is where the game logic goes, such as hitboxes, 
converting user input into making the player move, etc. this is like the model
in mvc.

then there is the draw method, which is where the assets are added into the 
screen of the game by adding a spritebatch, updating the camera, etc.
this is the view in mvc.

libGDX also has other method too for the game, such as pause, to pause the 
game and add a pause screen, etc, currently unused, a resume to unpause the game
currently unused, and a dispose method, which deletes spritebatches and textures
for when they are uneeded, or delete all the assets being used when the game is 
over.

## Entity

Entity is the mother of all objects that are going to be 
represented physically in our game

