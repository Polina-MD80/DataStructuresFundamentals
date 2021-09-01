package implementations;

import interfaces.AbstractTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
//https://pastebin.com/SGHWMxDx

public class Tree<E> implements AbstractTree<E> {
    private E value;
    private Tree<E> parent;
    private List<Tree<E>> children;

    public Tree(E value,Tree<E>... children ) {
        this.value = value;
        this.initChildren(children);

    }

    private void initChildren(Tree<E>[] children) {
        this.children = new ArrayList<>();
        for (Tree<E> child : children) {
            child.setParent(this);
            this.children.add(child);
        }
    }
    private String getAsStringDFS(Tree<E> node, int indent){
     StringBuilder result = new StringBuilder(getIndent(indent) + node.getKey());
        for (Tree<E> child : node.children) {
            result.append(System.lineSeparator()).append(getAsStringDFS(child, indent + 2));
        }
     return result.toString();
    }

    private String getIndent(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    @Override
    public void setParent(Tree<E> parent) {
        this.parent = parent;
    }

    @Override
    public void addChild(Tree<E> child) {
         this.children.add(child);
    }

    @Override
    public Tree<E> getParent() {
        return this.parent;
    }

    @Override
    public E getKey() {
        return this.value;
    }

    @Override
    public String getAsString() {
        return this.getAsStringDFS(this, 0);
    }

    @Override
    public List<E> getLeafKeys() {
        List<E> leaves = new ArrayList<>();
        Queue<Tree<E>> treeQueue = new ArrayDeque<>();
        treeQueue.offer(this);
        while (!treeQueue.isEmpty()){
            Tree<E> currentElem = treeQueue.poll();
                if (currentElem.children.isEmpty()){
                    leaves.add(currentElem.value);
                }
            for (Tree<E> child : currentElem.children) {
                treeQueue.offer(child);
            }
        }
        return leaves;
    }

    @Override
    public List<E> getMiddleKeys() {
        List<E> leaves = new ArrayList<>();
        Queue<Tree<E>> treeQueue = new ArrayDeque<>();
        treeQueue.offer(this);
        while (!treeQueue.isEmpty()){
            Tree<E> currentElem = treeQueue.poll();
            if (!currentElem.children.isEmpty() && currentElem.parent != null){
                leaves.add(currentElem.value);
            }
            for (Tree<E> child : currentElem.children) {
                treeQueue.offer(child);
            }
        }
        return leaves;

    }

    @Override
    public Tree<E> getDeepestLeftmostNode() {
        return null;
    }

    @Override
    public List<E> getLongestPath() {
        return null;
    }

    @Override
    public List<List<E>> pathsWithGivenSum(int sum) {
        return null;
    }

    @Override
    public List<Tree<E>> subTreesWithGivenSum(int sum) {
        return null;
    }
}



