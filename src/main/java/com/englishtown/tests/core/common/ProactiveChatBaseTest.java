package com.englishtown.tests.core.common;
/**
 As a User
 When I open URL :
 Then I see Chat button [untestable]
 but we could check the source if agent id exist
 and window.liveagent exist as well and not null
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.common.HomePage;
import com.englishtown.tests.core.BaseTest;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public abstract class ProactiveChatBaseTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(ProactiveChatBaseTest.class);
    public String chatIdBtn = "liveagent_button_online_573900000004QHz";
    private static final String chatLiveAgentScript = "return window.liveagent;";
    public WebElement chatIdWe ;
    // ru
    protected String sendChatBtnCss         = ".liveAgentSendButton" ;
    protected String liveAgentChatTextAreaId = "liveAgentChatTextArea";


    @Test
    protected void isChatButtonPresentOnSourceCode(){
        chatIdWe = WaitTool.waitForElementPresent(getWebDriver(), By.id(chatIdBtn), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        String liveagentJSresult = executeJSscript(chatLiveAgentScript, getWebDriver(), WaitTool.LONG_WAIT_4_ELEMENT);

        if(chatIdWe !=null){
            logger.info("Chat button ID is present on the source...!");
        }else {
            HomePage.failTest(chatIdBtn+" ... Chat button ID is not on source code (is null) -> not Present on source file ...!");
        }
        if(StringUtils.isNotBlank(liveagentJSresult) ){
            logger.info("window.liveagent is present on the window object ...!");
            try{ logger.info("liveagent js"+liveagentJSresult.toString());}catch (Exception e){e.printStackTrace();}
        }else {
            HomePage.failTest("return window.liveagent; is NOT present on the source......! Waited for [" + WaitTool.LONG_WAIT_4_ELEMENT + "] Seconds");
        }
    }

}
