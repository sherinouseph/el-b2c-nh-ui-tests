package com.englishlive.tests.galen.core;


/**
 * Created by nikolmarku on 10/28/2016.
 */

import org.openqa.selenium.Dimension;

import java.util.List;



public class TestDevice {
    private final String name;
    private final Dimension screenSize;
    private final List<String> tags;
    private String browserName;

    public TestDevice(String name, Dimension screenSize, List<String> tags) {
        this.name = name;
        this.screenSize = screenSize;
        this.tags = tags;
        this.browserName = browserName;
    }
    public TestDevice(String name, Dimension screenSize, List<String> tags, String browserName) {
        this.name = name;
        this.screenSize = screenSize;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public Dimension getScreenSize() {
        return screenSize;
    }

    public List<String> getTags() {
        return tags;
    }

//    public List<String> addToTags(String addToTag) {
//        int count = 0;
//        for (String tag : tags) {
//            tag = tag+" [ "+addToTag+" ]";
//            tags.set(count, tag);
//            count++;
//        }
//        return tags;
//    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }



    @Override
    public String toString() {
        return String.format("%s %dx%d", name, screenSize.width, screenSize.height);
    }
}
