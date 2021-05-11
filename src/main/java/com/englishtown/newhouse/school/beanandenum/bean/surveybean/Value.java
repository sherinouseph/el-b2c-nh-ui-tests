package com.englishtown.newhouse.school.beanandenum.bean.surveybean;

public class Value {
    private String startDate;

    private String sourceItemId;

    private String endDate;

    private String remainingViews;

    public String getStartDate ()
    {
        return startDate;
    }

    public void setStartDate (String startDate)
    {
        this.startDate = startDate;
    }

    public String getSourceItemId ()
    {
        return sourceItemId;
    }

    public void setSourceItemId (String sourceItemId)
    {
        this.sourceItemId = sourceItemId;
    }

    public String getEndDate ()
    {
        return endDate;
    }

    public void setEndDate (String endDate)
    {
        this.endDate = endDate;
    }

    public String getRemainingViews ()
    {
        return remainingViews;
    }

    public void setRemainingViews (String remainingViews)
    {
        this.remainingViews = remainingViews;
    }

    @Override
    public String toString()
    {
        return "startDate = "+startDate+",\n sourceItemId = "+sourceItemId+",\n endDate = "+endDate+",\n remainingViews = "+remainingViews;
    }
}
