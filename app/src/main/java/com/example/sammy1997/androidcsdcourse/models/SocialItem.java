package com.example.sammy1997.androidcsdcourse.models;

/**
 * Created by sammy1997 on 5/3/19.
 */

public class SocialItem {
    String name;
    String type;
    String desc;
    int image_resource_id;

    public SocialItem(String name, String type, String desc, int image_resource_id) {
        this.name = name;
        this.type = type;
        this.desc = desc;
        this.image_resource_id = image_resource_id;
    }

    public SocialItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage_resource_id() {
        return image_resource_id;
    }

    public void setImage_resource_id(int image_resource_id) {
        this.image_resource_id = image_resource_id;
    }
}
