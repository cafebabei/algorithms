package com.test.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Sign {

    public static void main(String[] args) {
        DirectedWeightedEdgeDigraph weightedEdgeDigraph = new DirectedWeightedEdgeDigraph(10);
        weightedEdgeDigraph.addEdge(new DirectedWeightedEdge("桌面开料", 0, 1, 0.5d));
        weightedEdgeDigraph.addEdge(new DirectedWeightedEdge("抽屉板开料", 0, 2, 1d));
        weightedEdgeDigraph.addEdge(new DirectedWeightedEdge("抛光", 1, 3, 0.5d));
        weightedEdgeDigraph.addEdge(new DirectedWeightedEdge("打磨", 1, 4, 1d));
        weightedEdgeDigraph.addEdge(new DirectedWeightedEdge("抽屉组装", 2, 5, 1d));
        weightedEdgeDigraph.addEdge(new DirectedWeightedEdge("组装", 3, 6, 0.5d));
        weightedEdgeDigraph.addEdge(new DirectedWeightedEdge("组装", 4, 6, 0.5d));
        weightedEdgeDigraph.addEdge(new DirectedWeightedEdge("抽屉油漆", 5, 7, 2d));
        weightedEdgeDigraph.addEdge(new DirectedWeightedEdge("油漆", 6, 8, 0.5d));
        weightedEdgeDigraph.addEdge(new DirectedWeightedEdge("全桌组装", 8, 9, 0.5d));
        weightedEdgeDigraph.addEdge(new DirectedWeightedEdge("全桌组装", 7, 9, 0.5d));
        DirectedWeightedEdge[] edges = new AcyclicSP(weightedEdgeDigraph, 9).edgeTo;
        for (int i = 0; i < edges.length; i++) {
            System.out.println(edges[i].name);
        }
    }

    public static class AcyclicSP {
        public double[] distTo;
        public DirectedWeightedEdge[] edgeTo;

        public AcyclicSP(DirectedWeightedEdgeDigraph graph, int s) {
            distTo = new double[graph.vertexNum];
            edgeTo = new DirectedWeightedEdge[graph.vertexNum];
            // 全部初始化为负无穷
            for (int v = 0; v < graph.vertexNum; v++)
                distTo[v] = 0.0;
            distTo[s] = 0.0;
            for (int v = 0; v < graph.vertexNum; v++) {
                for (DirectedWeightedEdge e : graph.adj(v))
                    relax(e);
            }
        }

        private void relax(DirectedWeightedEdge e) {
            int v = e.start, w = e.end;
            // 改变不等式的方向
            if (distTo[w] < distTo[v] + e.weight) {
                distTo[w] = distTo[v] + e.weight;
                edgeTo[w] = e;
            }
        }

    }


    public static class DirectedWeightedEdge {
        public String name;
        public int start;
        public int end;
        public double weight;

        public DirectedWeightedEdge(String name, int start, int end, double weight) {
            this.name = name;
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static class DirectedWeightedEdgeDigraph {
        public final int vertexNum;
        public int edgeNum;
        public List<DirectedWeightedEdge>[] adj;
        public int[] indegree;

        public DirectedWeightedEdgeDigraph(int vertexNum) {
            this.vertexNum = vertexNum;
            this.edgeNum = 0;
            this.indegree = new int[vertexNum];
            this.adj = (List<DirectedWeightedEdge>[]) new List[vertexNum];
            for (int v = 0; v < vertexNum; v++)
                adj[v] = new ArrayList<>();
        }

        public void addEdge(DirectedWeightedEdge e) {
            int v = e.start;
            int w = e.end;
            adj[v].add(e);
            indegree[w]++;
            edgeNum++;
        }

        public Iterable<DirectedWeightedEdge> adj(int v) {
            return adj[v];
        }

        public int outdegree(int v) {
            return adj[v].size();
        }

        public int indegree(int v) {
            return indegree[v];
        }

        // 在有向图中每条边只会出现一次
        // 遍历边集不需要在无向图里那样为了消除重复边而进行复杂的判断
        public Iterable<DirectedWeightedEdge> edges() {
            List<DirectedWeightedEdge> list = new ArrayList<>();
            for (int v = 0; v < vertexNum; v++) {
                for (DirectedWeightedEdge e : adj(v)) {
                    list.add(e);
                }
            }
            return list;
        }
    }


}
