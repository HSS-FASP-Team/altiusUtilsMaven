/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.altius.utils.TreeUtils;

import cc.altius.utils.StringUtils;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author akil
 */
public class Tree<T> implements Serializable {

    public Tree(Node<T> root) {
        this.root = root;
        this.root.setLevel(0);
        this.root.setSortOrder("00");
        flatList = new LinkedList<>();
        flatList.add(root);
    }

    private final Node<T> root;
    private List<Node<T>> flatList = new LinkedList<>();

    public void addNode(Node<T> n) throws Exception {
        if (n.getParentId() == null) {
            throw new Exception("Must have a valid Parent Id");
        }
        Node<T> checkNode = new Node<>(n.getParentId(), 0);
        int idx = this.flatList.indexOf(checkNode);
        if (idx == -1) {
            throw new Exception("Must have a valid Parent Id");
        }
        Node<T> foundNode = findNode(this.root, n.getParentId());
        if (foundNode != null) {
            n.setLevel(foundNode.getLevel() + 1);
            String newSortOrder = foundNode.getSortOrder() + ".";
            newSortOrder += StringUtils.pad(Integer.toString(foundNode.getNoOfChild() + 1), '0', 2, StringUtils.LEFT);
            n.setSortOrder(newSortOrder);
            foundNode.getTree().add(n);
        } else {
            n.setLevel(this.root.getLevel() + 1);
            String newSortOrder = this.root.getSortOrder() + ".";
            newSortOrder += StringUtils.pad(Integer.toString(this.root.getNoOfChild() + 1), '0', 2, StringUtils.LEFT);
            n.setSortOrder(newSortOrder);
            this.root.getTree().add(n);
        }
        this.flatList.add(n);
    }

    public Node<T> findNode(int id) {
        Node<T> n = this.root;
        return findNode(n, id);
    }

    private Node<T> findNode(Node<T> node, int id) {
        if (node.getId() == id) {
            return node;
        }
        for (Node<T> n : node.getTree()) {
            if (n.getId() == id) {
                return n;
            } else if (!n.getTree().isEmpty()) {
                Node foundNode = findNode(n, id);
                if (foundNode != null) {
                    return foundNode;
                }
            }
        }
        return null;
    }

    public Node<T> findNodeByPayloadId(int payloadId) {
        Node<T> n = this.root;
        return findNodeByPayloadId(n, payloadId);
    }

    private Node<T> findNodeByPayloadId(Node<T> node, int payloadId) {
        if (node.getPayloadId() == payloadId) {
            return node;
        }
        for (Node<T> n : node.getTree()) {
            if (n.getPayloadId() == payloadId) {
                return n;
            } else if (!n.getTree().isEmpty()) {
                Node foundNode = findNodeByPayloadId(n, payloadId);
                if (foundNode != null) {
                    return foundNode;
                }
            }
        }
        return null;
    }

    public Node<T> getTreeRoot() {
        return this.root;
    }

    public List<Node<T>> getFlatList() {
        return this.flatList;
    }

    public List<T> getPayloadSubList(int id, boolean includeSelf, int level) {
        List<T> subList = new LinkedList<>();
        Node<T> n = findNode(id);
        if (includeSelf) {
            subList.add(n.getPayload());
        }
        if (level == -1 || level > 0) {
            n.getTree().forEach((child) -> {
                getPayloadSubList(child, subList, (level > 0 ? level - 1 : level));
            });
        }
        return subList;
    }

    public List<Node<T>> getTreeFullList() {
        return getTreeSubList(1, true, -1);
    }

    public List<Node<T>> getTreeSubList(int id, boolean includeSelf, int level) {
        List<Node<T>> subList = new LinkedList<>();
        Node<T> n = findNode(id);
        if (includeSelf) {
            subList.add(n);
        }
        if (level == -1 || level > 0) {
            n.getTree().forEach((child) -> {
                getTreeSubList(child, subList, (level > 0 ? level - 1 : level));
            });
        }
        return subList;
    }

    private void getPayloadSubList(Node<T> n, List<T> subList, int level) {
        subList.add(n.getPayload());
        if (level == -1 || level > 0) {
            n.getTree().forEach((child) -> {
                getPayloadSubList(child, subList, (level > 0 ? level - 1 : level));
            });
        }
    }

    private void getTreeSubList(Node<T> n, List<Node<T>> subList, int level) {
        subList.add(n);
        if (level == -1 || level > 0) {
            n.getTree().forEach((child) -> {
                getTreeSubList(child, subList, (level > 0 ? level - 1 : level));
            });
        }
    }
}
