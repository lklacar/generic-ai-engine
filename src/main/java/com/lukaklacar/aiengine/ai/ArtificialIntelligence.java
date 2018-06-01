package com.lukaklacar.aiengine.ai;

import com.lukaklacar.aiengine.Element;
import com.lukaklacar.aiengine.graph.Graph;
import com.lukaklacar.aiengine.graph.Node;
import com.lukaklacar.aiengine.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArtificialIntelligence<T extends Element> {

    private Graph<T> graph;

    public ArtificialIntelligence(Graph<T> graph) {
        this.graph = graph;
    }

    private Node<T> next(Node<T> prev) {
        Node<T> nextNode = RandomUtil.choose(prev.getChildren());

        if (nextNode == null) {
            return RandomUtil.choose(new ArrayList<>(graph.getRootNodes()));
        }

        return nextNode;
    }

    public List<T> generate(int size) {
        List<Node<T>> result = new ArrayList<>();
        Node<T> selectedNode = RandomUtil.choose(new ArrayList<>(graph.getRootNodes()));
        result.add(selectedNode);

        for (int i = 0; i < size; i++) {
            if (selectedNode != null) {
                Node<T> nextNode = next(selectedNode);
                result.add(nextNode);
                selectedNode = nextNode;
            }
        }

        return result.stream().map(Node::getItem).collect(Collectors.toList());
    }

}
