package com.vozisov.wordpress.model.comments;

import java.util.List;

public class Links {
    private List<ChildrenItem> children;
    private List<SelfItem> self;
    private List<CollectionItem> collection;
    private List<UpItem> up;

    public void setChildren(List<ChildrenItem> children) {
        this.children = children;
    }

    public List<ChildrenItem> getChildren() {
        return children;
    }

    public void setSelf(List<SelfItem> self) {
        this.self = self;
    }

    public List<SelfItem> getSelf() {
        return self;
    }

    public void setCollection(List<CollectionItem> collection) {
        this.collection = collection;
    }

    public List<CollectionItem> getCollection() {
        return collection;
    }

    public void setUp(List<UpItem> up) {
        this.up = up;
    }

    public List<UpItem> getUp() {
        return up;
    }

    @Override
    public String toString() {
        return
                "Links{" +
                        "children = '" + children + '\'' +
                        ",self = '" + self + '\'' +
                        ",collection = '" + collection + '\'' +
                        ",up = '" + up + '\'' +
                        "}";
    }
}