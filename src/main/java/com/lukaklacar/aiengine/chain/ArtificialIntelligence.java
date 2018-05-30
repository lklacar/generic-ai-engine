package com.lukaklacar.aiengine.chain;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.toIntExact;

public class ArtificialIntelligence {

    private Graph graph;

    public ArtificialIntelligence(Graph graph) {
        this.graph = graph;
    }

    private Node next(Node prev) {
        Node nextNode = RandomUtil.choose(prev.getChildren());

        if (nextNode == null) {
            return RandomUtil.choose(new ArrayList<>(graph.getRootNodes()));
        }

        return nextNode;
    }

    public List<Object> generate(int size) {
        List<Node> result = new ArrayList<>();
        Node selectedNode = RandomUtil.choose(new ArrayList<>(graph.getRootNodes()));
        result.add(selectedNode);

        for (int i = 0; i < size; i++) {
            Node nextNode = next(selectedNode);
            result.add(nextNode);
            selectedNode = nextNode;
        }


        return result.stream().map(Node::getItem).collect(Collectors.toList());
    }

}
