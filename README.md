#  [DAA] Bonus Task (12016611)

This is my implementation of the bonus task for the third assignment of Design and Analysis of Algorithms.
The entire program is written in Java (tested with Java 17) and contains two testcases. Aside from those tests
it can also be run manually (with custom inputs).

## Algorithm

This is the description of the algorithm from the assignment sheet:

Initially, all nodes are uncolored. Then, in synchronous iterations, each uncolored
node selects a random candidate color from its list of available colors, that is, from
the set of colors that none of its already permanently colored neighbors have. Then,
nodes exchange their candidate colors with their neighbors. A node v that has a
candidate color c that is not selected as a candidate color by any of its neighbors
gets permanently colored with c, otherwise v discards its candidate color, remains
uncolored, and proceeds with the next iteration.

## Execution

*Tested with Java 17*

To execute the program one has just to normally run the main() method inside the Main class.
From there on there are console prompts to enter the graph details. The program asks the
following inputs:

- #### Vertices
    The first things asked are the vertices. They have to be provided as integers seperated by commas:
    
    for example: `1,3,5,2,4`, creating the nodes 1,2,3,4,5

- #### Edges
    Next, the edges have to be provided as tuples to connect the vertices.

    for example: `1,3;3,5;5,2;4,1`, creating edges between 1-3, 3-5, 5-2 and 4-1

- #### Degree
    At this step the degree has to be provided as a regular integer

- #### Colors
    Lastly the colors have to be provided, this is the entire code palette which contains all colors the
    vertices can choose from. However, the colors will be limited to the first delta+1 colors, since we
    want to have a delta+1 coloring. The colors have to be provided in the same way as the vertices:
    
    for example: `1,2,3,4,5,6,7,8,9`, adding 9 colors

The program then computes the coloring using a simulated distributed randomized algorithm (the one
described above) and outputs the coloring to the console, stating which node has which color and also
the number of iterations needed to color the graph.

## Testcases

The project contains two testcases for some test graphs, which I included in the regular assignment PDF
which I uploaded to the TeachCenter. The testcases are located in the **TestcaseOne** and **TestcaseTwo**
classes respectively. Those classes contain main() methods themselves, which enable the tests to be run.

So to execute a testcase and generate it's coloring just execute the respective main() function inside
the testcase classes.
