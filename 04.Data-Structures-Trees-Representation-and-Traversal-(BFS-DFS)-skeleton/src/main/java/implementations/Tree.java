package implementations;

import interfaces.AbstractTree;

import java.util.*;

public class Tree<E> implements AbstractTree<E> {
    private E key;
    private Tree<E> parent;
    private List<Tree<E>> children;

    public Tree(E key, Tree<E>... children) {
        this.key = key;
        this.children = new ArrayList<>();
        for (Tree<E> child : children) {
            this.children.add(child);
            child.parent = this;
        }
    }

    @Override
    public List<E> orderBfs() {
        List<E> result = new ArrayList<>();
        Deque<Tree<E>> queue = new ArrayDeque<>();
        queue.offer(this);
        while (queue.size() > 0) {
            Tree<E> current = queue.poll();
            result.add(current.key);
            for (Tree<E> child : current.children)
                queue.offer(child);
        }
        return result;

    }

    @Override
    public List<E> orderDfs() {
        List<E> order = new ArrayList<>();
        this.dfs(this, order);
        return order;
    }

    private void dfs(Tree<E> tree, List<E> order) {
        for (Tree<E> child : tree.children) {
            this.dfs(child, order);
        }
        order.add(tree.key);
    }

    @Override
    public void addChild(E parentKey, Tree<E> child) {
        Tree<E> tree = findByName(this, parentKey);

        tree.children.add(child);
    }

    private Tree<E> findByName(Tree<E> tree, E parentKey) {
        Tree<E> result = null;
        E key = tree.key;
        while (!key.equals(parentKey)) {
            if (!tree.children.isEmpty()) {
                for (Tree<E> child : tree.children) {
                    findByName(child, parentKey);
                }
            }
        }
        result = tree;

        return result;
    }

    @Override
    public void removeNode(E nodeKey) {

    }

    @Override
    public void swap(E firstKey, E secondKey) {

    }
}



