//package com.englishlive.tests.galen.core;
//
///**
// * Created by nikol.marku on 11/2/2016.
// *  Used to get Test ENVs from spring ..... maven ...
// *
// *
// */
//import org.openqa.selenium.WebDriver;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestExecutionListeners;
//import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//
//
//@ContextConfiguration(locations = {"/applicationContext-test.xml"})
//@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
//@Configuration
//public class MyGalenUtils extends AbstractTestNGSpringContextTests{
//
//    //@Resource(name="driver")    protected transient WebDriver webDriver;
//    @Value("#{applicationPropertiesList['env.id']}")
//    public String ENVIRONMENT;
//    @Value("#{applicationPropertiesList['base.url']}")
//    public String BASE_URL;
//
//
//    public String getENVIRONMENT() {
//        return ENVIRONMENT;
//    }
//
//    public void setENVIRONMENT(String ENVIRONMENT) {
//        this.ENVIRONMENT = ENVIRONMENT;
//    }
//
//    public String getBASE_URL() {
//        return BASE_URL;
//    }
//
//    public void setBASE_URL(String BASE_URL) {
//        this.BASE_URL = BASE_URL;
//    }
//
//
//}
