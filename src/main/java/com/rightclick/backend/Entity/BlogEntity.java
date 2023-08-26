package com.rightclick.backend.Entity;

import javax.persistence.*;

@Entity
@Table(name = "blogs")

public class BlogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "short_description", nullable = false)
    private String shortDescription;

    @Column(name = "aws_blog_html_url", nullable = false)
    private String awsBlogHtmlUrl;

    @Column(name = "images", nullable = false)
    private String images;

    @Column(name = "blog_links", nullable = false)
    private String blogLinks;

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAwsBlogHtmlUrl() {
        return awsBlogHtmlUrl;
    }

    public void setAwsBlogHtmlUrl(String awsBlogHtmlUrl) {
        this.awsBlogHtmlUrl = awsBlogHtmlUrl;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getBlogLinks() {
        return blogLinks;
    }

    public void setBlogLinks(String blogLinks) {
        this.blogLinks = blogLinks;
    }
}