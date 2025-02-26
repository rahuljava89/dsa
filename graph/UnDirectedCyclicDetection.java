package graph;

import java.util.ArrayList;

public class UnDirectedCyclicDetection {

    public static void main(String[] args) {
        System.out.println("Detect Cycle-----------------");

        ArrayList<Edge>[] graph = initialiseGraph(5);

        boolean[] visitedNodes = new boolean[graph.length];

        for (int itr = 0; itr < graph.length; itr++) {
            if (!visitedNodes[itr]) {
                if (detectCycle(graph, itr, visitedNodes, itr)) {
                    System.out.println(true);
                    break;
                }
            }
        }

        
    }

    private static boolean detectCycle(ArrayList<Edge>[] graph, int currentNode, boolean[] visitedNodes, int parentNode) {
       
        visitedNodes[currentNode] = true;

        for (int itr = 0; itr < graph[currentNode].size(); itr++) {
            int destination = graph[currentNode].get(itr).destination;

            if (visitedNodes[destination] && destination != parentNode) {

                return true;
            } else if(! visitedNodes[destination]){
                if(detectCycle(graph, destination, visitedNodes, currentNode)){
                    return true;
                }
            }
            
        }
        return false;
    }

    private static ArrayList<Edge>[] initialiseGraph(int size) {
        ArrayList<Edge>[] graph = new ArrayList[size];

        for (int itr = 0; itr < size; itr++) {
            graph[itr] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));

        return graph;

    }

}
