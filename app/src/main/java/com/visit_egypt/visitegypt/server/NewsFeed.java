package com.visit_egypt.visitegypt.server;

import java.util.ArrayList;

/**
 * Created by Muhammad on 3/25/2017
 */

public class NewsFeed extends BaseItem {

    private String cover;
    private String description;
    private String url;
    private ArrayList<NewsSite> sites;

    public NewsFeed() {
        super("", "");
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<NewsSite> getSites() {
        return sites;
    }

    public void setSites(ArrayList<NewsSite> sites) {
        this.sites = sites;
    }
}
