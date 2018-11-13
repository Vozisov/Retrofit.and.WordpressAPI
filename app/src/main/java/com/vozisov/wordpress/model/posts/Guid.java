package com.vozisov.wordpress.model.posts;

public class Guid {
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
                "Guid{" +
                        "rendered = '" + rendered + '\'' +
                        "}";
    }
}
