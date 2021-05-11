package com.englishtown.newhouse.school.beanandenum.bean.surveybean;

public class Settings {
    private Value value;

    private String key;

    public Value getValue ()
    {
        return value;
    }

    public void setValue (Value value)
    {
        this.value = value;
    }

    public String getKey ()
    {
        return key;
    }

    public void setKey (String key)
    {
        this.key = key;
    }

    @Override
    public String toString()
    {
        //return "{\n Settings : ["+value.toString()+", key = "+key+"\n}";
        return "{\nkey = "+key+",\n value : {\n"+value.toString()+" \n } \n },\n" ;
    }
}
