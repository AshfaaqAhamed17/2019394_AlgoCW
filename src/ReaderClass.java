/* *****************************************************************************
 *  Name:    Ashfaaq Ahamed
 *  Student ID: 2019394
 *  UOW ID: W1761334
 *
 *  Description:    * Level-5, Algorithm CW
 *                  * Aim - Algorithmic analysis of network flow
 *                  * In order to find the maximum flow through a network,
 *                   Matrix data structure is used.
 *                   Ford-Fulkerson Algorithm including breath first search is used.
 *
 ***************************************************************************** */

import java.io.*;
import java.util.*;

public class ReaderClass {
    static String reader;       //To read and the matrix values
    static String[] stringArr;  //Stores the matrix value which is split. Stores each row by row
    static List<String> tempArr = new ArrayList<>();    //ArrayList which stores all the rows together by splitting separately

    public static void main(String[] args) throws FileNotFoundException {
        Stopwatch stopwatch = new Stopwatch();              //Stop watch class to see the time elapsed
        File fileText = new File("bridge_1.txt");
        Scanner fileScanner = new Scanner(fileText);


        String node = fileScanner.nextLine().trim();
        System.out.println("Number of nodes : " + node);
        System.out.println("");
        while (fileScanner.hasNextLine()) {
            if ((reader = fileScanner.nextLine()) == null)
                break;
            tempArr.add(reader);
        }

        AdjacencyMatrix myMatrix = new AdjacencyMatrix(Integer.parseInt(node));

        FordFulkersonMaxFlow maxFlowObj = new FordFulkersonMaxFlow();
        FordFulkersonMaxFlow.numOfVertices = Integer.parseInt(node);    //Extracting number of nodes from the data set and storing it

        for (int i = 0; i<tempArr.size(); i++){
            stringArr = tempArr.get(i).split(" ");
            myMatrix.addEdge(Integer.parseInt(stringArr[0]),Integer.parseInt(stringArr[1]),Integer.parseInt(stringArr[2]));
        }

        System.out.println("Adjacency Matrix\n");
        myMatrix.printMatrix();
        System.out.println("\n\n");

        System.out.println("The maximum possible flow is " + maxFlowObj.fordFulkerson(myMatrix.matrix, 0, Integer.parseInt(node)-1));

        System.out.println("\nTime taken to complete the task => " + stopwatch.elapsedTime() + " seconds");
    }
}
