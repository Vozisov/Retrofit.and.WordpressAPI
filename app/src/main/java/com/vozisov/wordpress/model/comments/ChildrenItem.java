package com.vozisov.wordpress.model.comments;

public class ChildrenItem {
    private String href;

    public void setHref(String href) {
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    @Override
    public String toString() {
        return
                "ChildrenItem{" +
                        "href = '" + href + '\'' +
                        "}";
    }
}
