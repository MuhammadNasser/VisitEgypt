package com.visit_egypt.visitegypt.server;

/**
 * Created by Muhammad on 3/25/2017
 */

public class NewsSite extends BaseItem {

    private String url;
    private String logo;

    public NewsSite() {
        super("", "");
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
