package com.example.jjsampayo.livedata;

/**
 * Created by
 *      jjsampayo on 19/03/2018.
 */

public class GodModel {
    private String name;

    private String patreon;

    public GodModel() {
    }

    public GodModel(String name, String patreon) {
        this.name = name;
        this.patreon = patreon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatreon() {
        return patreon;
    }


    public void setPatreon(String patreon) {
        this.patreon = patreon;
    }
}
