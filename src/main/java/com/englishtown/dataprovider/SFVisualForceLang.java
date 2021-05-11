package com.englishtown.dataprovider;

import org.testng.annotations.DataProvider;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by nikol.marku on 16/01/2018.
 */
public class SFVisualForceLang {

    static AtomicInteger id = new AtomicInteger(0);

    // AR "https://qa-ef.cs5.force.com/force/WelcomeMailPaymentDetailsSection?act=a00O000000clorTIAQ&lng=ar";
    // FR "https://qa-ef.cs5.force.com/force/WelcomeMailPaymentDetailsSection?act=a00O000000clorxIAA&lng=fr

    @DataProvider(name = "languages", parallel = true)
    public Object[][] languages(){
        return new Object[][] {
                {"مرحباً بك فى EF English Live", "ar"},
                {"Willkommen bei EF English Live", "de"},
                {"Welcome to EF English Live", "en"},
                {"Bienvenido a EF English Live", "es"},
                {"Bienvenue à EF English Live", "fr"},
                {"Benvenuto in EF English Live", "it"},
        };
    }


}
