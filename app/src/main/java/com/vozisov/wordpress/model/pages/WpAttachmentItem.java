package com.vozisov.wordpress.model.pages;

public class WpAttachmentItem {
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
                "WpAttachmentItem{" +
                        "href = '" + href + '\'' +
                        "}";
    }
}
