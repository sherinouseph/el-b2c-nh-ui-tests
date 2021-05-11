//package com.englishlive.tests.newhouse.salesforce.flows;
//
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.pages.core.BasePage;
//import com.englishtown.tests.core.BaseTest;
//import org.openqa.selenium.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//
//public  class PCITest extends BaseTest {
//    public static final Logger logger = LoggerFactory.getLogger(PCITest.class);
//
//    //setup environment
//    String DEV_URL="https://ef--dev2.cs5.my.salesforce.com/?ec=302&startURL=%2Fhome%2Fhome.jsp";
//    String QA_URL="https://test.salesforce.com/";
//    String USER_DEV="evan.sun@ef.com.dev";
//    String USER_QA="evan.sun@ef.com.qa";
//    String rolaProduct="ROLA Private 48PL.12 Month - loyalty";
//    String MXProduct="TEST New Payment";//"MX Private 100PL.12 Month";
//    String USProduct="US Private 12PL 12 Month";
//
//    //change this when running the unit test
//    public String url = QA_URL;
//    String userName = USER_QA;
//    public static final String LeadRecordType = "MEXICO";
//    String product=MXProduct;
//
//
//     //variables
//    String convertButton="convert_new";
//    String addProduct="add_product";
//    String rolaCountry="Argentina";
//    String addProductUrl="addproduct";
//    String takePayment="take_payment_selectable";
//    String submitforApproval="submit";
//    String paymentSuccess="CONGRATULATIONS";
//    String paybtn="commit";
//    String aptdateWe="00N40000001QNVc";
//    String cardTypeValue="card_type_001";
//    public static Long currTime;
//    public static final String TEST_MAIL_START_TOKEN = "auto_";
//    public static final String TEST_MAIL_END_TOKEN = "_xdelx";
//    String name;
//    String Firstname="name_salutationlea2";
//
//    @BeforeClass
//    protected void setup() {
//        setThreadSafeDriver();
//        openUrl(getWebDriver(), url);
//
//    }
//
//    @Override
//
//    public void openUrl(WebDriver driver, String url) {
//        driver.get(url);
//    }
//
//
//    @Test()
//    public void login() {
//        getWebDriver().findElement(By.name("username")).sendKeys("evan.sun@ef.com.qa");
//        getWebDriver().findElement(By.name("pw")).sendKeys("efef@123");
//        getWebDriver().findElement(By.name("Login")).click();
//        sleep(1000);
//        WebElement home = getWebDriver().findElement(By.cssSelector(".brandPrimaryFgr"));
//        AssertHelper.assertWebElementDisplayed(home);
//    }
//
//    @Test(dependsOnMethods = "login")
//    public void goToLeadForm() {
//        WebElement lead = getWebDriver().findElement(By.id("Lead_Tab"));
//        lead.click();
//        getWebDriver().findElement(By.name("new")).click();
//        sleep(1000);
//        country(LeadRecordType);
//        WebElement Continue = getWebDriver().findElement(By.cssSelector("Input[value*='Continue']"));
//        Continue.click();
//        assertIsUrlContaining("lead");
//    }
//    @Test(dependsOnMethods = "goToLeadForm")
//    public void createLead(){
//        enterFormData(LEAD_MAP);
//        Dropdown(Firstname,"Mr");
//        Dropdown("lea13","Set Appt");
//        WebElement date = findElement(By.id(aptdateWe));
//        date.click();
//        date.sendKeys("01/11/2017 14:58");
//        //selectDate();
//        logger.info("date selected");
//        Dropdown("00N30000000k5UY","EFST");
//        if(LeadRecordType=="ROLA"){
//            Dropdown("00N9000000DHYiV",rolaCountry);
//        }
//        List<WebElement> save = getWebDriver().findElements(By.name("save"));
//        save.get(0).click();
//        logger.info("Lead Created");
//
//    }
//    @Test(dependsOnMethods = "createLead")
//    public void convertToOppo() {
//        WebElement convert= findElement(By.name(convertButton));
//        click(convertButton);
//        sleep(3000);
//        alertAccept();
//       logger.info("Lead successfully converted to oppo");
//    }
//
//
//    @Test(dependsOnMethods = "convertToOppo")
//    public void addProduct()
//    {
//        List <WebElement> addproducts=getWebDriver().findElements(By.name(addProduct));
//        addproducts.get(0).click();
//        addProducts_PCI();
//        sleep(1000);
//        logger.info("product added");
//
//    }
//
//    @Test(dependsOnMethods = "addProduct")
//    public void sendforApproval()
//    {
//        WebElement submitApproveBtn=findElement(By.name(submitforApproval),20);
//        click(submitApproveBtn);
//        alertAccept();
//        assertIsUrlContaining("006O0000009");
//        approveProduct();
//    }
//    @Test(dependsOnMethods = "addProduct")
//    public void takePayment() {
//        List<WebElement> payment = getWebDriver().findElements(By.name(takePayment));
//        payment.get(0).click();
//        logger.info("Payment Page");
//        if(LeadRecordType!="US"){
//            cyberSource();
//            sleep(3000);
//            AssertHelper.assertStringContains(findElement(By.cssSelector(".pay-main-box label"),90).getText(),paymentSuccess,"Payment FAILED");
//        }else {
//            worldPay();
//        }
//        getWebDriver().switchTo().defaultContent();
//        findElement(By.name("page:form:block:j_id27:j_id28"));
//        click(getWebDriver().findElement(By.name("page:form:block:j_id27:j_id28")));
//
//
//    }
//
//
//    @Test(dependsOnMethods ="takePayment" )
//    public void checkOppoStageValue()
//    {   sleep(3000);
//        getWebDriver().navigate().refresh();
//        oppoStatusCheck();
//    }
//    @Test(dependsOnMethods = "checkOppoStageValue")
//    public  void checkActualsCreated(){
//        WebElement actuallink = findElement(By.partialLinkText("FIN"));
//        scrollToWeAndClick(getWebDriver(),actuallink,0,100);
//        AssertHelper.assertUrlContains(getWebDriver().getCurrentUrl(),"OverrideActual","Actual page not loaded");
//
//    }
//
//
//    @AfterClass
//    protected void teardownAfterClass() {
//        //destroyDriver();
//    }
//
//
//    //functions
//    public void country(String Country) {
//        if (Country !=null) {
//            WebElement recordTypWe =getWebDriver().findElement(By.name("p3"));
//            //recordTypWe.click();
//            recordTypWe.sendKeys(LeadRecordType);
//        } else
//            System.out.println("Country not init");
//
//    }
//
//    public void addProducts_VTF()
//    {
//        Dropdown("page:form:block:section:item:product","TestVirtualTerminalPay");
//        Dropdown("page:form:block:section:j_id33","Credit Card");
//        click("page:form:block:j_id46:j_id47");
//        click("page:form:j_id48:j_id73:j_id74");
//        sleep(1000);
//        logger.info("product added");
//    }
//
//    public void addProducts_PCI()
//    {
//
//        Dropdown("page:form:block:section:item:product",product);
//        Dropdown("page:form:block:section:j_id33","Credit Card");
//        Dropdown("page:form:block:section:j_id34","Installments-Manual-No Deposit");
//        Dropdown("page:form:block:section:j_id35","4");
//        Dropdown("page:form:block:section:j_id36","10%");
//
//        click("page:form:block:j_id41:j_id42");
//        click("page:form:j_id43:j_id58:j_id59");
//        sleep(1000);
//        logger.info("product added");
//    }
//    public static final Map<String, String> CREDITCARD_MAP = new LinkedHashMap<>();
//    static {
//        CREDITCARD_MAP.put("card_number", "4111111111111111");
//        CREDITCARD_MAP.put("card_cvn", "123");
//        CREDITCARD_MAP.put("card_expiry_month", "selectMeSelectOpt&true&05");
//        CREDITCARD_MAP.put("card_expiry_year", "selectMeSelectOpt&true&2018");
//
//
//
//    }
//    public static final Map<String, String> WORLDPAYCREDIT_MAP = new LinkedHashMap<>();
//    static {
//        WORLDPAYCREDIT_MAP.put("cardNoInput","4111111111111111");
//        WORLDPAYCREDIT_MAP.put("cardCVV", "123");
//        WORLDPAYCREDIT_MAP.put("name", "Testworldpayuser");
//        WORLDPAYCREDIT_MAP.put("cardExp.month", "selectMeSelectOpt&true&5");
//        WORLDPAYCREDIT_MAP.put("cardExp.year", "selectMeSelectOpt&true&2018");
//
//
//
//    }
//    public static final Map<String, String> LEAD_MAP = new LinkedHashMap<>();
//
//    static {
//            Long currNanoTime = System.nanoTime();
//            String randomStrInt = TestUtil.generateRandomStringNumber();
//            LEAD_MAP.put("lea3", LeadRecordType+"CompanyTest" + TestUtil.generateRandomString("R", 3));
//            LEAD_MAP.put("name_firstlea2", "firstname" + TestUtil.generateRandomString("R", 3));
//            LEAD_MAP.put("name_lastlea2", "Lastname" + TestUtil.generateRandomString("R", 3));
//            LEAD_MAP.put("lea11", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
//            //LEAD_MAP.put("lea11", "subrata.acharyya@ef.com");
//            LEAD_MAP.put("lea8", "123456689");
//            LEAD_MAP.put("name_salutationlea2", "selectMeSelectOpt&true&Mr.");
//            LEAD_MAP.put("lea13", "selectMeSelectOpt&true&Set Appt");
//  }
//    public void oppoStatusCheck() {
//        WebElement body = getWebDriver().findElement(By.tagName("body"));
//        String bodyText = body.getText();
//        AssertHelper.assertStringContains(bodyText,"Closed Won","Oppo status is wrong");
//
//    }
//
//    public void selectDate()
//    {
//      DateFormat dateFormat2 = new SimpleDateFormat("dd");
//      Date date2 = new Date();
//      String today = dateFormat2.format(date2);
//      logger.info(today);
//      click(findElement(By.id(aptdateWe)));
//      //find the calendar
//      WebElement dateWidget = getWebDriver().findElement(By.id("datePicker"));
//      List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
//      //comparing the text of cell with today's date and clicking it.
//      for (WebElement cell : columns)
//      {  if (cell.getText().equals(today))
//          {
//              cell.click();
//              break;
//          }
//      }
//  }
//   public void alertAccept()
//   {
//      Alert alert=getWebDriver().switchTo().alert();
//      System.out.println(alert.getText());
//      alert.accept();
//      logger.info("Alert Accepted");
//  }
//   public void Dropdown(String name,String Value)
//   {
//      WebElement we = getWebDriver().findElement(By.name(name));
//      we.sendKeys(Value);
//
//  }
//  public void selectCardType(String cardType)
//    {  WebElement cardtypeRdBtn = findElement(By.id(cardType));
//           click(cardtypeRdBtn);
//    }
//        public  void click(String nameselector){
//        //log.info(" Click on WebElement [{}] ", webElement);
//        WebElement webElement = getWebDriver().findElement(By.name(nameselector));
//        try {
//            if(webElement != null) {
//                webElement.click();
//            } else {
//                BasePage.failTest("Can't click on NULL WebElement ...!", true);
//            }
//        }catch (WebDriverException wde){
//            BasePage.failTest("Failed to click on WebElement ...!\n"+wde.getMessage(),webElement, true);
//        }
//    }
//
//    public void approveProduct(){
//       List <WebElement> approveWe=findElements(By.partialLinkText("Approve"));
//      scrollToWeAndClick(getWebDriver(),approveWe.get(0),0,100);
//      findElement(By.id("Comments")).sendKeys("Approved");
//      click(findElement(By.name("goNext")));
//
//    }
//
//    public void cyberSource()
//    {
//        click(findElement(By.id("imgCybersource"),30));
//        click(findElement(By.name("j_id0:form:pb:j_id31")));
//        int size = getWebDriver().findElements(By.tagName("iframe")).size();
//        logger.info("number of frames+" + size);
//        getWebDriver().switchTo().frame(2);
//        WebElement oCheckBox = getWebDriver().findElement(By.id("card_type_001"));
//        AssertHelper.assertWebElementDisplayed(oCheckBox);
//        oCheckBox.click();
//        selectCardType(cardTypeValue);
//        enterFormData(CREDITCARD_MAP);
//        click(By.name(paybtn));
//    }
//    public void worldPay()
//    {
//
//        int size = getWebDriver().findElements(By.tagName("iframe")).size();
//        logger.info("number of frames+" + size);
//        getWebDriver().switchTo().frame(2);
//        click(findElement(By.name("op-DPChoose-VISA^SSL"),30));
//        enterFormData(WORLDPAYCREDIT_MAP);
//        paybtn="op-PMMakePayment";
//        click(By.name(paybtn));
//        click(By.name("continue"));
//    }
//
//}