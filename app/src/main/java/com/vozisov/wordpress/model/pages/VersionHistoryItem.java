package com.vozisov.wordpress.model.pages;

public class VersionHistoryItem {
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
                "VersionHistoryItem{" +
                        "href = '" + href + '\'' +
                        "}";
    }
}
