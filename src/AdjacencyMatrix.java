public class AdjacencyMatrix {
    int vertex;
    int matrix[][];

    public AdjacencyMatrix(int vertex) {
        this.vertex = vertex;
        matrix = new int[vertex][vertex];
    }

    public void addEdge(int source, int destination, int weight) {
        matrix[source][destination]=weight;
    }

    public  void printMatrix(){
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                System.out.format( "    " + (matrix[i][j]));
            }
            System.out.println("");
        }
    }
}
