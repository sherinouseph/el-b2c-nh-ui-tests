package com.englishtown.tests.core.responsivecore;
/**
 * Configuration for responsive design
 *
 * Created by nikol.marku on 01/06/2015.
 *
 * REF: chrome://web-developer/content/generated/view-responsive-layouts.html
 */
import org.openqa.selenium.Dimension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class ResponsiveDesignConfig {
    private static final Logger logger = LoggerFactory.getLogger(ResponsiveDesignConfig.class);
    // Screen sizes to test
    // Mobile portrait (320x480)
    public static Dimension DIMENSION_320X480 = new Dimension(320, 480);
    // Mobile landscape (480x320)
    public static Dimension DIMENSION_480x320 = new Dimension(480, 320);
    // Small tablet portrait (600x800)
    public static Dimension DIMENSION_600x800 = new Dimension(600, 800);
    // Small tablet landscape (800x600)
    public static Dimension DIMENSION_800x600 = new Dimension(800, 600);
    //Tablet portrait (768x1024)
    public static Dimension DIMENSION_768x1024= new Dimension(768, 1024);
    // Tablet landscape (1024x768)
    public static Dimension DIMENSION_1024x768 = new Dimension(1024, 768);
    //1,920 × 1,080 full HD
    public static Dimension DIMENSION_1920x1080 = new Dimension(1920, 1080);


    public static List<Dimension> getAllDimensions(){
        List <Dimension> allDimension = new ArrayList();
        allDimension.add(DIMENSION_320X480);
        allDimension.add(DIMENSION_480x320);
        allDimension.add(DIMENSION_600x800);
        allDimension.add(DIMENSION_800x600);
        allDimension.add(DIMENSION_768x1024);
        allDimension.add(DIMENSION_1024x768);
        allDimension.add(DIMENSION_1920x1080);

        return allDimension;
    }



}
