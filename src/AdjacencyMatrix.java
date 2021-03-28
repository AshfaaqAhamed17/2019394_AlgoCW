public class AdjacencyMatrix {
    int vertex;
    int matrix[][];

    public AdjacencyMatrix(int vertex) {
        this.vertex = vertex;
        matrix = new int[vertex][vertex];
    }

    public void addEdge(int source, int destination, int weight) {
        //add edge
        matrix[source][destination]=weight;

    }
    public  void printMatrix(){
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                System.out.format( "    " + String.valueOf(matrix[i][j]));

            }
            System.out.println("");

        }
    }
    public void printGraph() {
        System.out.println("Graph: (Adjacency Matrix)");
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j <vertex ; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
        for (int i = 0; i < vertex; i++) {
            System.out.print("Vertex " + i + " is connected to:");
            for (int j = 0; j <vertex ; j++) {
                if(matrix[i][j]==1){
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrix g = new AdjacencyMatrix(4);
        g.addEdge(0, 1, 6);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 2);
        g.addEdge(1, 3, 3);
        g.addEdge(2, 3, 5);
//        g.printGraph();
        g.printMatrix();
    }

}
