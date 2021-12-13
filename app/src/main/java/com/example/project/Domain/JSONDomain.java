package com.example.project.Domain;

public class JSONDomain {
    private String title;
    private String details;
    private String coverImage;
    private String URL;
    public JSONDomain(){}
    public JSONDomain(String title,String details,String coverImage, String URL){
        this.title=title;
        this.details=details;
        this.coverImage=coverImage;
        this.URL=URL;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
