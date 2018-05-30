package com.lukaklacar.aiengine.chain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Node {

    private Object item;
    private List<Node> children;
    private Node parent;

    public Node(Object item) {
        this.item = item;
        children = new ArrayList<Node>();
    }

    public void add(Node child) {
        this.children.add(child);
    }

    public int id() {
        return item.hashCode();
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
