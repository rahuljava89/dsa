package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * maintain a list of visited nodes
 * Iterate over current node
 *  if ( visitedNodes == false){
 *          syso(curr);
 *          visitedNodes[curr] = true;
 *          for(on all edges)
 *              dfs()
 *      }
 */

public class DFS {
    public static void main(String[] args) {
        System.out.println("DFS");

        ArrayList<Edge>[] graph = initialiseGraph(7);

        boolean[] visitedNodes = new boolean[graph.length];

        for (int itr = 0; itr < graph.length; itr++) {
            if (!visitedNodes[itr]) {
                dfs(graph, itr, visitedNodes);
            }

        }

    }


    private static void dfs(ArrayList<Edge>[] graph, int currentNode, boolean[] visitedNodes) {

        if (!visitedNodes[currentNode]) {
            System.out.println(currentNode);
            visitedNodes[currentNode] = true;
            for (int itr = 0; itr < graph[currentNode].size(); itr++) {
                dfs(graph, graph[currentNode].get(itr).getDestination(), visitedNodes);
            }
        }
    }

    private static ArrayList<Edge>[] initialiseGraph(int size) {
        ArrayList<Edge>[] graph = new ArrayList[size];

        for (int itr = 0; itr < size; itr++) {
            graph[itr] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(5, 6));

        return graph;

    }
}