//package com.englishtown.newhouse.school.beanandenum.bean.surveybean;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//
//public class PojoTest {
//    MySurvey survey;
//
//    @Test
//    void testme(){
//        ObjectMapper mapper = new ObjectMapper();
//        try{
//            survey = mapper.readValue(myjson, MySurvey.class);
//        }catch (IOException e){ e.printStackTrace();}
//
//        System.out.println(survey.toString());
//
//    }
//
//
//
//    public static String myjson = "{  \n" +
//            "   \"settings\":[  \n" +
//            "      {  \n" +
//            "         \"key\":\"a467b539-12e8-47ad-9bdc-9538c9e8412f\",\n" +
//            "         \"value\":{  \n" +
//            "            \"sourceItemId\":\"88\",\n" +
//            "            \"startDate\":1553350895750,\n" +
//            "            \"endDate\":1555942895750,\n" +
//            "            \"remainingViews\":3\n" +
//            "         }\n" +
//            "      },\n" +
//            "      {  \n" +
//            "         \"key\":\"b6574c58-fa17-47cb-b2b4-17a9cd3e6973\",\n" +
//            "         \"value\":{  \n" +
//            "            \"sourceItemId\":\"90\",\n" +
//            "            \"startDate\":1574086895750,\n" +
//            "            \"endDate\":1576678895750,\n" +
//            "            \"remainingViews\":3\n" +
//            "         }\n" +
//            "      }\n" +
//            "   ]\n" +
//            "}";
//}
