package com.englishlive.tests;



import com.englishtown.helpers.bean.handler.CreateMemberBean;
import com.englishtown.helpers.bean.handler.EfFullDataBean;
import com.englishtown.helpers.reader.MyJsonReader;
import com.englishtown.helpers.utils.TestUtil;
import net.sf.cglib.core.Local;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Created by nikol.marku on 09/06/2015.
 */
public class TestNM {
    private static final Logger logger = LoggerFactory.getLogger(TestNM.class);


   // @Test
    void readURLsFromUrl(){
        String jsonUrl = "http://10.162.82.101:4503/content/englishtown/monitored-pages/jcr:content/main-parsys/page-list.infinity.json";
        MyJsonReader myJsonReader = new MyJsonReader();
        try{
            JSONObject jsonObject = MyJsonReader.readJsonFromUrl(jsonUrl);
            //logger.info("jsonObject ["+jsonObject.toString()+"]");
            // get values ...
            String valueData = jsonObject.getString("value");
            if(!StringUtils.isBlank(valueData)){
                String [] urls = valueData.split("\n");
                logger.info("urls ["+ Arrays.toString(urls)+"]");
            }
            //logger.info("valueData  [\n"+valueData.toString()+"]");
        }catch (IOException e){
            e.printStackTrace();
        }
    }



/*
    static AtomicInteger id = new AtomicInteger(0);
    String file = "C:\\work\\project\\nikol\\qa\\testdata\\json\\EfFullDataBeanJson.json";
    //{"Result":{"Address
    String jsonFile = "{{\"Address\":\"\",\"Address1\":\"\",\"Address2\":\"\",\"CityCode\":\"\",\"CountryCode\":\"de\",\"DataStore\":\"US1\",\"Email\":\"auto_1487344483974_xdelx@qp1.org\",\"EmailLanguageCode\":\"ge\",\"ETag\":\"\",\"FirstName\":\"testing\",\"GenderCode\":\"\",\"HomePhone\":\"0755654565       \",\"LanguageCode\":\"ge\",\"LastName\":\"AutoLastName\",\"LocalName\":\"testing AutoLastName\",\"Member_id\":35356878,\"MemberType\":\"M\",\"MobilePhone\":\"0755654565\",\"Occupation\":\"\",\"OmnitureFriendlyName\":\"Checkout:default:member\",\"PartnerCode\":\"None\",\"Password\":\"pass\",\"PostalCode\":\"\",\"StateCode\":\"\",\"UserName\":\"tAutoLastName76557\",\"AutoLogin\":false,\"SubscribeToEmailEnglish\":false,\"SubscribeToSMS\":false,\"SubscribeToPartnerPromo\":false,\"SubscribeToDailyLesson\":false,\"SubscribeToETPromo\":false,\"SubscribedToEmailEnglish\":false,\"StudentType\":\"NeverStudent\",\"HasSuspendedSubscription\":false,\"HasRenewableActiveSubscription\":false},\"Success\":true}\n";

    String url = "http://englishlive.ef.com/services/commerce-v4/membermanager/GetMember?CMus=ADMANQAzADUANwAwADAAMgB8ADEANAA4ADcAMwA0ADYANgA5ADIANwA2ADgAfAB0AEEAdQB0AG8ATABhAHMAdABOAGEAbQBlADcANgA1ADcAOAB8AE0AfABOA";


    EfFullDataBean expectedPostData;
    String s = "{\"Result\":14522603,\"Success\":true,\"Results\":14522603,\"Successs\":true,\"dResult\":14522603,\"Succesds\":true}";
*/

    //@Test
    void test(){
        //logger.info("--> "+getJasonKeyValue( s, "Result") );
        //try {
             //expectedPostData = MyJsonReader.getCreateMemberBean(url);
        //}catch (IOException | JSONException e){
            //e.printStackTrace();
        //}

        //logger.info(expectedPostData.toString());

    }


    private static String generateRandom(String startString) {
        Random rand=new Random();
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder res=new StringBuilder(startString);
        for (int i = 0; i < 4; i++) {
            int randIndex=rand.nextInt(candidateChars.length());
            res.append(candidateChars.charAt(randIndex));
        }
        return res.toString();
    }

    public static String getRunningMethodName(){
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String getCountryFromUrl(String url) throws NullPointerException {
        try{
            return url.split("ef.com")[1].split("/")[1].split("-")[1];
        }catch (Exception e){//e.printStackTrace();
            //BaseTest.failTest("Can not get Language ...! "+e.getMessage());
        }
        return null;
    }

    /**
     * {"Result":14522603,"Success":true}
     * 1. clean up/remove { and "  -> Result:14522603,Success:true
     * 2. split on "," and check to mach key  --> Result:14522603
     * 3. if match found get content value --> 14522603
     * @param content
     * @return
     * @throws NullPointerException
     */
    public static String getJasonKeyValue(String content, String key ) throws NullPointerException{
        String value = null;
        try {
            content = content.replace("{", "").replace("}", "").replace("[", "").replace("]","").replace("\"", "");
            String[] parts = content.split(",");
            String[] temp = null;

            for(int i=0; i < parts.length; i++) {
                temp = parts[i].split(":");
                if(StringUtils.equals(temp[0].trim(), key) ){
                    value = temp[1].trim();
                    logger.info("Found match key ["+key+"  value is ["+value+"]");
                    return value;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.info(key+" value : "+value);
        return value;
    }


}


/**
 *
 *
 String []  manyStr = {"https://englishlive.ef.com/en-wws/",
 "http://englishlive.ef.com/community/Channels/article.aspx?articleName=117-5mis",
 "http://qa-englishlive.ef.com/it-it/article.aspx?articleName=117-5mis?ctr=en",
 "https://englishlive.ef.com/ar-wws/",
 "http://qa-englishlive.ef.com/de-de/buy/default/member/",
 "http://qa.englishtown.it/",
 ""
 };
 */


    // AssertHelper.assertThat("Not matched ...!", manyStr, hasItemInArray(matchOne));
    //AssertHelper.assertThat("Match Not Found ...!",manyStr , arrayContaining(matchOne));
 //   List<String> expected  =  Arrays.asList(  "nik", "MemberRegistration", "bre", "EmailEnglish");     //  assertThat(list, containsInAnyOrder(2, 4, 5));
  //  List<String> actual    = Arrays.asList("EmailEnglish", "MemberRegistration", "nik", "per");        //assertTrue(first.containsAll(second)) ; // && second.containsAll(first));
  //  assertThat("Not matched ...!", expected , hasItems(match));

//assertThat(fruit, hasItems("apple", "pear"));

//    public static String getCountryFromUrl(String url) {
//        String country = null;
//        String[] regExp = {"ctr=", "-"};
//        //'http://englishlive.ef.com/ko-kr/'    http://www.englishtown.com/online/home.aspx?ctr=kr
//        for (String reg : regExp) {
//           // country = safeSplit(url, reg, 1, 0, 2);
//            if (null != country) {
//                break;
//            }
//        }
//        return country;
//    }
//    public void statusCode404FromString() throws Exception {
//        //WebDriver driver = new FirefoxDriver();
//        String webServerURL = "http://englishlive.ef.com/de-de/";
//        URLStatusChecker urlChecker = new URLStatusChecker();
//        // urlChecker.setURIToCheck(webServerURL + ":" + webServerPort + "/doesNotExist.html");
//        urlChecker.setURIToCheck(webServerURL);
//        urlChecker.setHTTPRequestMethod(RequestMethod.GET);
//        Assert.assertEquals(urlChecker.getHTTPStatusCode(), 200, " Not 200 response ...!");
//    }

    /**
     * get LandingHandler response data
     * @param content
     * @param startStringContent
     * @param endStringContent
     * @return   e.g for landing handler
    Success:true
    RedirectUrl:http://www.englishtown.com/online/pt-thankyou.aspx
    LeadId:38514697
     */
//    String getStringPart(String content, String startStringContent, String endStringContent,  String replaceContent, String replaceContentWith){
//        String subContent = null;
//        try {
//            int redirectIndex = content.indexOf(startStringContent);
//            int endRedirectIndex = content.indexOf(endStringContent);
//            subContent = content.substring(redirectIndex, endRedirectIndex);
//            subContent = subContent.replace(replaceContent, replaceContentWith);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        logger.info("subContent : "+subContent);
//        return subContent;
//    }

//    @Test
//    public void main() {
//       /* int successIndex = str.indexOf("Success");
//        int endSuccessIdex =  successIndex+13;
//        logger.info("SuccessStatus : "+str.substring(successIndex, endSuccessIdex).replace("\"", ""));
//        int redirectIndex = str.indexOf("RedirectUrl");
//        int endRedirectIndex = str.indexOf("?omnievents=");
//        logger.info("RedirectUrl : "+str.substring(redirectIndex, endRedirectIndex).replace("\"", ""));
//        int leadIdIndex = str.indexOf("LeadId");
//        int endLeadIdIndex =  str.indexOf("}");
//        logger.info("LeadId : "+str.substring(leadIdIndex, endLeadIdIndex).replace("\"", ""));
//        */logger.info("************************************************************************");
//        getStringPart(str, "Success", ",\"RedirectUrl", "\"", "");
//        getStringPart(str, "RedirectUrl", "?omnievents=", "\"", "");
//        getStringPart(str, "LeadId", "}", "\"", "");
//
//    }

 /*       JSONParser parser = new JSONParser();
        int count=0;
        BasicStats basicStats;

        try {
           // Object obj =  parser.parse(new FileReader(file));
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(file)); //(JSONArray) obj;
            logger.info(jsonArray.toString());

            for(Object testRunStat : jsonArray){
                JSONObject testStat = (JSONObject) testRunStat;
                basicStats = JsonUtils.getObject(testStat.toJSONString(), BasicStats.class);
                basicStats.print();
            }

            ReadWriteToFile.deleteFileLastLine();

            Iterator<JSONObject> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObject = (JSONObject) iterator.next();
                basicStats = JsonUtils.getObject(jsonObject.toJSONString(), BasicStats.class);
                basicStats.print();
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }



class TestRunStats {
    public Collection<BasicStats> testRunStats;
}

class BasicStats {
    private static final Logger log = LoggerFactory.getLogger(BasicStats.class);
    Long runId;
    String testName;
    String url;
    float loadTime;

    BasicStats(Long runId, String testName, String url, float loadTime){
        this.runId    = runId;
        this.testName = testName;
        this.url      = url;
        this.loadTime =loadTime;
    }

    public void print(){
        log.info("\nrunId :" +runId+"\ntestName :"+testName+"\nurl :"+url+"\nloadTime :"+loadTime);
    }
}


// loop array
//            JSONArray msg = (JSONArray) jsonObject.get("messages");
//            Iterator<String> iterator = msg.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next());
//            }
//JSONObject jsonObject = (JSONObject) obj;

//            BasicStats basicStats = new BasicStats(
//                    (long)  jsonObject.get("runId"),
//                    (String)jsonObject.get("testName"),
//                    (String)jsonObject.get("url"),
//                    (float) ((double)jsonObject.get("loadTime"))
//            );

/**
 * JsonObject jsonObject = JsonObject.readFrom( reader );
 * JsonArray jsonArray = JsonArray.readFrom( string );
 *
 // (Serialization)
 BagOfPrimitives obj = new BagOfPrimitives();
 Gson gson = new Gson();
 String json = JsonUtils.getString(obj); //gson.toJson(obj);
 logger.info("json [{}] ",json); //==>  json is {"value1":1,"value2":"abc"}

 // (Deserialization)
 BagOfPrimitives obj2 = JsonUtils.getObject(json, BagOfPrimitives.class);
 //gson.fromJson(json, BagOfPrimitives.class);
 //==> obj2 is just like obj
 logger.info("obj2  1 :"+obj2.value1+" 2 :"+obj.value2+" 3 :"+obj.value3);
*/

//        getWebDriver().get("http://www.tutorialspoint.com/java/lang/string_contains.htm");//I want to validate str1 value with current url value i.e. " http://www.tutorialspoint.com/java/lang/string_contains.htm "
//        String str1="java/lang/string_contains.htm";
//        String str2=getWebDriver().getCurrentUrl();        // getWebDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//        System.out.println("str1 ...!"+str1);
//        System.out.println("str2 ...!"+str2);
//        if(str2.toLowerCase().trim().contains(str1.toLowerCase().trim())){
//            System.out.println("Pass ...!");           //return true;
//        }
//        else{
//            System.out.println("Fail ...!");            //return false;
//        }
//    public boolean testme(){
//        getWebDriver().get("http://www.tutorialspoint.com/java/lang/string_contains.htm");
////I want to validate str1 value with current url value i.e. " http://www.tutorialspoint.com/java/lang/string_contains.htm "
//        String str1="java/lang/string_contains.htm";
//        String str2=getWebDriver().getCurrentUrl();
//        // getWebDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//        System.out.println("str2 ...!"+str2);
//        if(str1.toLowerCase().trim().contains(str2.toLowerCase().trim())){
//            System.out.println("Pass ...!");
//            return true;
//        }
//        else{
//            System.out.println("Fail ...!");
//            return false;
//
//        }
//    }


//    static String s  = ("Popular Artist - 2015");
//    static String s1 = ("changed Popular Artist - 2015");
//
//    @Test
//    public void stringEqualTestWithSpaces(){
//        if(s.equals(s1)){
//            System.out.println("Is Equal ...! TRUE");
//        }else {
//            System.out.println("Is Not Equal ...! FALSE");
//        }
//        assertTrue(s.equals(s1));
//    }
//    @Test
//    public void stringDoubleEqualSignTest(){
//        if(s==s1){
//            System.out.println("USE == Is Equal ...! TRUE");
//        }else {
//            System.out.println("USE == Is Not Equal ...! FALSE");
//        }
//    }

//        for(int i=0;i<3;++i){
//            System.out.println("i is "+i);
//            for(int j=0;j<3;++j) {
//                System.out.println("j is"+j);
//                for(int k=0;k<3;++k) {
//                    System.out.println("k is"+k);
//                }
//            }
//        }
//class BagOfPrimitives {
//    int value1 = 1;
//    String value2 = "abc";
//    transient int value3 = 3;
//    BagOfPrimitives() {
//        // no-args constructor
//    }
//}

//    static String s = "Popular Artist - 2015";
//    static String s1 = "Popular Artist - 2015";
//
//    @Test
//    public void stringEqualTestWithSpaces(){
//        if(s.equals(s1)){
//            System.out.println("Is Equal ...!");
//        }else {
//            System.out.println("Is Not Equal ...!");
//        }
//    }
//    @Test
//    public void stringEqualTestWithSpacesAndTrim(){
//        if(s.trim().equals(s1.trim())){
//            System.out.println("Trim Is Equal ...!");
//        }else {
//            System.out.println("Trim Is Not Equal ...!");
//        }
//    }
//    @Test
//    public void stringEqualTestWithSpacesAndTrimLowerCase(){
//        if(s.trim().toLowerCase().equals(s1.trim().toLowerCase())){
//            System.out.println("Trim toLowerCase Is Equal ...!");
//        }else {
//            System.out.println("Trim toLowerCase Is Not Equal ...!");
//        }
//    }
//    @Test
//    public void stringEqualTestWithSpacesAndToLowerCaseAndTrim(){
//        if(s.toLowerCase().trim().equals(s1.toLowerCase().trim())){
//            System.out.println("toLowerCase Trim  Is Equal ...!");
//        }else {
//            System.out.println("toLowerCase Trim  Is Not Equal ...!");
//        }
//    }

//    private String str = "{\"Success\":true,\"RedirectUrl\":\"http://www.englishtown.com/online/pt-thankyou.aspx?omnievents=event5,event34,event4,event33&omniproducts=;EmailEnglish_LeadOE;1;0;event34=0|event33=0&csf=eyJmaXJzdF9uYW1lIjoidGVzdERCc3RvcmUiLCJlbWFpbCI6ImRiMV8xNDYwMTA5NzMyNTAzQHFwMS5vcmciLCJsZWFkX2lkIjozODUxNDY5N30%3d\",\"LeadId\":38514697}";
//    String patternLangCtr    = ".*/[a-z]{2}-[a-z]{2}/.*";   // */en-it/*
//    String patternCtrEqual   = ".*ctr=[a-z]{2}.*";       // *?ctr=it/
//    String patterDotCtr      = ".*englishtown\\.[a-z]{2}/.*";      // *?englishtown.it/
//    String patterDotCOdotCtr = ".*englishtown\\.[a-z]{2}\\.[a-z]{2}/.*";  //englishtown.co.jp