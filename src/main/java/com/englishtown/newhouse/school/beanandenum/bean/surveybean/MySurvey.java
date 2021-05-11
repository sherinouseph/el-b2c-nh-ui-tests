package com.englishtown.newhouse.school.beanandenum.bean.surveybean;

import java.util.List;

public class MySurvey {
    //private Settings[] settings;
    private List<Settings> settings;

    public List<Settings> getSettings ()
    {
        return settings;
    }

    public void setSettings (List<Settings> settings)
    {
        this.settings = settings;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("{\n Settings: [");
        for(Settings setting : settings){
            sb.append(setting.toString());
        }
        sb.append("] \n }");

        return sb.toString();
    }
}
