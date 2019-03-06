package com.example.myapplication.models;

public class SocialItem {
    String name ;
    String type ;
    String description ;
    int image_resource_id ;

    public SocialItem(String name, String type, String description, int image_resource_id) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.image_resource_id = image_resource_id;
    }
    public SocialItem(){

    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public int getImage_resource_id() {
        return image_resource_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage_resource_id(int image_resource_id) {
        this.image_resource_id = image_resource_id;
    }
}
