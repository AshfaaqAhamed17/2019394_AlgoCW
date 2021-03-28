import java.io.*;
import java.util.*;

public class ReaderClass {
    static String reader;
    static String[] stringArr;
    static List<String> tempArr = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        File fileText = new File("bridge_3.txt");
        Scanner fileScanner = new Scanner(fileText);

        String node = fileScanner.nextLine();
        System.out.println("Number of nodes : " + node);
        System.out.println("");
        while (fileScanner.hasNextLine()) {
            if ((reader = fileScanner.nextLine()) == null)
                break;
            tempArr.add(reader);
        }

        AdjacencyMatrix g = new AdjacencyMatrix(Integer.parseInt(node));
        AdjacencyList g1 = new AdjacencyList(Integer.parseInt(node));


        for (int i = 0; i<tempArr.size(); i++){
            stringArr = tempArr.get(i).split(" ");
            g.addEdge(Integer.parseInt(stringArr[0]),Integer.parseInt(stringArr[1]),Integer.parseInt(stringArr[2]));
            g1.addEdge(Integer.parseInt(stringArr[0]),Integer.parseInt(stringArr[1]),Integer.parseInt(stringArr[2]));

        }

        System.out.println("Adjacency Matrix\n");
        g.printMatrix();
        System.out.println("");
        System.out.println("Adjacency List\n");
        System.out.println(g1);

    }
}
