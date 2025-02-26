package graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

    public static void main(String[] args) {
        System.out.println("Toplogical Sort-----------------");

        ArrayList<Edge>[] graph = initialiseGraph(6);

        boolean[] visitedNodes = new boolean[graph.length];

        Stack<Integer> stack = new Stack();

        for (int itr = 0; itr < graph.length; itr++) {
            if (!visitedNodes[itr]) {
                topoLogicalSort(graph, itr, visitedNodes, stack);
            }

        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }

    private static void topoLogicalSort(ArrayList<Edge>[] graph, int currentNode, boolean[] visitedNodes,
            Stack<Integer> stack) {
        visitedNodes[currentNode] = true;

        for (int itr = 0; itr < graph[currentNode].size(); itr++) {
            int destination = graph[currentNode].get(itr).destination;
            if (!visitedNodes[destination]) {
                topoLogicalSort(graph, destination, visitedNodes, stack);
            }
        }
        stack.push(currentNode);

    }

    private static ArrayList<Edge>[] initialiseGraph(int size) {
        ArrayList<Edge>[] graph = new ArrayList[size];

        for (int itr = 0; itr < size; itr++) {
            graph[itr] = new ArrayList<Edge>();
        }

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        return graph;

    }

}
