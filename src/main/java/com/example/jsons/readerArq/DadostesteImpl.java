package com.example.jsons.readerArq;

import com.google.gson.annotations.SerializedName;

public class DadostesteImpl {

    @SerializedName("updated_at")
    private String updated_at;

    @SerializedName("fetched_at")
    private String fetched_at;

    @SerializedName("description")
    private String description;

    @SerializedName("language")
    private String language;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String url;

    @SerializedName("icon_url")
    private String icon_url;

    @SerializedName("logo_url")
    private String logo_url;

    @SerializedName("id")
    private String id;

    @SerializedName("modified")
    private String modified;

    public final String get_Updated_at() {
        return this.updated_at;
    }

    public final String get_Fetched_at() {
        return this.fetched_at;
    }

    public final String get_Description() {
        return this.description;
    }

    public final String get_Language() {
        return this.language;
    }

    public final String get_Title() {
        return this.title;
    }

    public final String get_Url() {
        return this.url;
    }

    public final String get_Icon_url() {
        return this.icon_url;
    }

    public final String get_Logo_url() {
        return this.logo_url;
    }

    public final String get_Id() {
        return this.id;
    }

    public final String get_Modified() {
        return this.modified;
    }

    
}
