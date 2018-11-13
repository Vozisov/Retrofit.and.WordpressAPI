package com.vozisov.wordpress.model.posts;

public class Excerpt {
    private String rendered;
    private boolean jsonMemberProtected;

    public void setRendered(String rendered) {
        this.rendered = rendered;
    }

    public String getRendered() {
        return rendered;
    }

    public void setJsonMemberProtected(boolean jsonMemberProtected) {
        this.jsonMemberProtected = jsonMemberProtected;
    }

    public boolean isJsonMemberProtected() {
        return jsonMemberProtected;
    }

    @Override
    public String toString() {
        return
                "Excerpt{" +
                        "rendered = '" + rendered + '\'' +
                        ",protected = '" + jsonMemberProtected + '\'' +
                        "}";
    }
}
