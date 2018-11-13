package com.vozisov.wordpress.model.media;

public class Sizes {
    private Thumbnail thumbnail;
    private PostThumbnail postThumbnail;
    private Large large;
    private Medium medium;
    private RbResumeThumbnail rbResumeThumbnail;
    private MediumLarge mediumLarge;
    private Full full;

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setPostThumbnail(PostThumbnail postThumbnail) {
        this.postThumbnail = postThumbnail;
    }

    public PostThumbnail getPostThumbnail() {
        return postThumbnail;
    }

    public void setLarge(Large large) {
        this.large = large;
    }

    public Large getLarge() {
        return large;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setRbResumeThumbnail(RbResumeThumbnail rbResumeThumbnail) {
        this.rbResumeThumbnail = rbResumeThumbnail;
    }

    public RbResumeThumbnail getRbResumeThumbnail() {
        return rbResumeThumbnail;
    }

    public void setMediumLarge(MediumLarge mediumLarge) {
        this.mediumLarge = mediumLarge;
    }

    public MediumLarge getMediumLarge() {
        return mediumLarge;
    }

    public void setFull(Full full) {
        this.full = full;
    }

    public Full getFull() {
        return full;
    }

    @Override
    public String toString() {
        return
                "Sizes{" +
                        "thumbnail = '" + thumbnail + '\'' +
                        ",post-thumbnail = '" + postThumbnail + '\'' +
                        ",large = '" + large + '\'' +
                        ",medium = '" + medium + '\'' +
                        ",rb-resume-thumbnail = '" + rbResumeThumbnail + '\'' +
                        ",medium_large = '" + mediumLarge + '\'' +
                        ",full = '" + full + '\'' +
                        "}";
    }
}
