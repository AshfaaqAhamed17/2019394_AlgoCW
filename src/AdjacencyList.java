import java.util.*;

public class AdjacencyList {
    class Edge{
        //v=end vertex / w=weight
        int v,w;
        public Edge(int v,int w){
            this.v=v; this.w=w;
        }
        @Override
        public String toString(){
            return "("+v+","+w+")";
        }
    }


    //n=num of vertex
    List<Edge>[] G;
    public AdjacencyList(int n){
        G=new LinkedList[n];
        for(int i=0;i<G.length;i++)
            G[i]=new LinkedList<Edge>();
    }

    boolean isConnected(int u,int v){
        for(Edge i: G[u])
            if(i.v==v) return true;
        return false;
    }

    //u=start vertex; v=end vertex; w=weight
    void addEdge(int u,int v,int w){
        G[u].add(0,new Edge(v,w));
    }

    @Override
    public String toString(){
        String result="";
        for(int i=0;i<G.length;i++)
            result+=i+"=>"+G[i]+"\n";
        return result;
    }
}

class GraphExampleNew {
    public static void main(String[] args) {
        AdjacencyList g = new AdjacencyList(4);
        g.addEdge(0, 1, 6);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 2);
        g.addEdge(1, 3, 3);
        g.addEdge(2, 3, 5);

        System.out.println(g);
    }
}


