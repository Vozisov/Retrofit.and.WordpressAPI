package com.vozisov.wordpress.model.media;

public class Title {
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
                "Title{" +
                        "rendered = '" + rendered + '\'' +
                        "}";
    }
}
