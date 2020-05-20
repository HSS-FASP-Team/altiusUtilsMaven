/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.altius.utils.TreeUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author akil
 */
public class Node<T> {

    private int id;
    private Integer parentId;
    private T payload;
    @JsonIgnore
    private List<Node<T>> tree;
    private int level;
    private String sortOrder;
    private int payloadId;

    public Node(int id, Integer parentId, T payload, int payloadId) {
        this.id = id;
        this.parentId = parentId;
        this.payload = payload;
        this.tree = new LinkedList<>();
        this.payloadId = payloadId;
    }

    public Node(int id, int payloadId) {
        this.id = id;
        this.payloadId = payloadId;
        this.tree = new LinkedList<>();
        this.level = 0;
        this.sortOrder = "00";
    }

    public Node() {
        this.tree = new LinkedList<>();
    }

    public int getPayloadId() {
        return payloadId;
    }

    public void setPayloadId(int payloadId) {
        this.payloadId = payloadId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public List<Node<T>> getTree() {
        return tree;
    }

    public void setTree(List<Node<T>> tree) {
        this.tree = tree;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    @JsonIgnore
    public boolean hasChild() {
        return !this.tree.isEmpty();
    }

    @JsonIgnore
    public int getNoOfChild() {
        return this.getTree().size();
    }

    @Override
    public String toString() {
        return "Node{" + "sortOrder=" + sortOrder + ", level=" + level + ", id=" + id + ", parentId=" + parentId + ", payloadId=" + payloadId + ", payload=" + payload + ", tree=" + tree.size() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
