package com.vozisov.wordpress.model.media;

public class Caption {
    private String rendered;

    public void setRendered(String rendered) {
        this.rendered = rendered;
    }

    public String getRendered() {
        return rendered;
    }

    @Override
    public String toString() {
        return
                "Caption{" +
                        "rendered = '" + rendered + '\'' +
                        "}";
    }
}
