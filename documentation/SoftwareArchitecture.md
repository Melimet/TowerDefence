# Software Architecture
## Package Structure

The package structure is as shown below.

<img src="https://raw.githubusercontent.com/Melimet/TowerDefence/master/documentation/PackageStructure.png" width="200">

Package ui starts the application and contains the user interface. Package domain contains the logic for the application and dao contains code related to the database. 


## User interface(ui)

Currently there are two scenes in the application: the start/configuration menu and the game scene. The view is changed from start menu to the actual game when user presses start button. When user presses the start button, a game object is also created. 
<img src="https://raw.githubusercontent.com/Melimet/TowerDefence/master/documentation/TDSoftwareArchitecture.jpg" width="750">

## Application logic(domain)

Game class works as the middleman for pretty much everything in this application. When created, it creates a Map object and makes sure it is up to date.
# Sequence diagrams
## Generating a map for user
<img src="https://raw.githubusercontent.com/Melimet/TowerDefence/master/documentation/Generating%20game%20map.png" width="750">
