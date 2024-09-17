# FlightPlan
Implementation of Dijkstra's Algorithm to calculate the shortest and most cost-effective flight paths to a given destination using a list of direct flights

## About the Project

This project utilizes Dijkstra's Algorithm, creating a nested Linked List of Liked Lists, one for every distinct city given in the input file. Each list contains the cities and other information that can be reached from this city. It uses a stack and an iterative backtracking algorithm to "remember" where we currently are in the search. 

## How to build and run:
Runs best using the Google Colab Link at the top of the python file, but by installing the necessary packages and libraries mentioned above before compiling and running.
<br /> The final version runs from the command line with the following:
<br /> ./FlightPlan <FlightDataFile> <PathsToCalculateFile> <OutputFile>
