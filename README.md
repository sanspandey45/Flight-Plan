# FlightPlan
This project implements Dijkstra's Algorithm to calculate the shortest and most cost-effective flight paths to a given destination using a list of direct flights.

## About the Project

I utilized a nested Linked List of Liked Lists, one for every distinct city given in the input file. Each list contains the cities and other information that can be reached from this city. It uses a stack and an iterative backtracking algorithm to "remember" where we currently are in the search. 
<img width="357" alt="image" src="https://github.com/user-attachments/assets/f53e74cd-633a-4e1b-a387-3a9c74778dab">

## How to build and run:
<br /> The final version can run from the command line with the following:
<br /> ./FlightPlan FlightDataFile PathsToCalculateFile OutputFile
