package com.vozisov.wordpress.model.media;

public class Thumbnail {
    private String file;
    private String mimeType;
    private int width;
    private String source_url;
    private int height;

    public void setFile(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setSourceUrl(String source_url) {
        this.source_url = source_url;
    }

    public String getSourceUrl() {
        return source_url;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return
                "Thumbnail{" +
                        "file = '" + file + '\'' +
                        ",mime_type = '" + mimeType + '\'' +
                        ",width = '" + width + '\'' +
                        ",source_url = '" + source_url + '\'' +
                        ",height = '" + height + '\'' +
                        "}";
    }
}
