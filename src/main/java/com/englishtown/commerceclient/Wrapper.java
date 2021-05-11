package com.englishtown.commerceclient;

import com.englishtown.commerceclient.generated.AccountService;
import com.englishtown.commerceclient.generated.ArrayOfSubscriptionInfo;
import com.englishtown.commerceclient.generated.IAccountService;
import com.englishtown.commerceclient.generated.ISubscriptionService;
import com.englishtown.commerceclient.generated.MemberInfo;
import com.englishtown.commerceclient.generated.SubscriptionInfo;
import com.englishtown.commerceclient.generated.SubscriptionService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class Wrapper {
    private static final HashMap<Environment, String> s_environmentAndUrlMap = new HashMap<Environment, String>();

    private static final Logger logger = LoggerFactory.getLogger(Wrapper.class);

    static {
        s_environmentAndUrlMap.put(Environment.Local, Constant.LocalUrl);
        s_environmentAndUrlMap.put(Environment.QA, Constant.QAUrl);
        s_environmentAndUrlMap.put(Environment.Staging, Constant.StagingUrl);
        s_environmentAndUrlMap.put(Environment.Live, Constant.LiveUrl);
    }

    private Environment environment;
    private ISubscriptionService subscriptionService;
    private IAccountService accountService;

    public Wrapper(Environment env) {
        this.environment = env;

        URL wsdlLocation = SubscriptionService.class.getResource("/SubscriptionService.wsdl");
        SubscriptionService ss = new SubscriptionService(wsdlLocation, new QName("http://tempuri.org/", "SubscriptionService"));
        this.subscriptionService = ss.getBasicHttpBindingISubscriptionService();
        setServiceEndpointAddress((BindingProvider) this.subscriptionService, env, "/services/commerce/1.0/SubscriptionService.svc");

        wsdlLocation = AccountService.class.getResource("/AccountService.wsdl");
        AccountService as = new AccountService(wsdlLocation, new QName("http://tempuri.org/", "AccountService"));
        this.accountService = as.getBasicHttpBindingIAccountService();
        setServiceEndpointAddress((BindingProvider) this.accountService, env, "/services/commerce/1.0/AccountService.svc");
    }

    private static void setServiceEndpointAddress(BindingProvider bindingProvider, Environment environment, String relativeUrl) {
        bindingProvider
                .getRequestContext()
                .put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, s_environmentAndUrlMap.get(environment) + relativeUrl);
    }

    public ActionResult cancelSubscriptionForMember(int memberId) {
        try {
            ActionResult<MemberInfo> miResult = getMemberInfo(memberId);
            if (!miResult.getSucceed()) {
                logger.info(" -------------- 1 ------------------"+miResult.getErrorMessage());
                return new ActionResult(/*succeed*/ false, /*result*/ null, miResult.getErrorMessage());
            }

            if (miResult.getResult() == null) {
                logger.info(" -------------- 2 ------------------");
                return new ActionResult(/*succeed*/ false, /*result*/ null, "member not found with id: " + memberId+" error ... "+miResult.getErrorMessage());
            } else if (!isTestEmail(miResult.getResult().getEmail().getValue())) {
                logger.info(" -------------- 3 ------------------");
                return new ActionResult(/*succeed*/ false, /*result*/ null, "only @qp1.org emails are supported.");
            } else {
                logger.info(" -------------- 4 ------------------");
                this.subscriptionService.cancelSubscription(memberId, "Testing", "comments-b2c-london-test", "systemNotes-b2c-london-automation-test");
                logger.info(" -------------- 5 ------------------");
                return new ActionResult(/*succeed*/ true);
            }
        } catch (Exception e) {
            logger.info(" -------------- 1000000000 errrr ------------------");
            e.printStackTrace();
            return new ActionResult(/*succeed*/ false, /*result*/ null, e.getMessage());
        }
    }

    public ActionResult cancelSubscriptionByEmail(String email) {
        if (!isTestEmail(email)) {
            return new ActionResult(/*succeed*/ false, /*result*/ null, "only @qp1.org emails are supported.");
        }

        try {
            ActionResult<MemberInfo> miResult = getMemberByEmail(email);
            if (!miResult.getSucceed()) {
                return new ActionResult(/*succeed*/ false, /*result*/ null, miResult.getErrorMessage());
            }

            if (miResult.getResult() == null) {
                return new ActionResult(/*succeed*/ false, /*result*/ null, "member not found with email: " + email);
            } else {
                this.subscriptionService.cancelSubscription(miResult.getResult().getMemberId().getValue(), "Testing", "comments-b2c-london-test", "systemNotes-b2c-london-automation-test");
                return new ActionResult(/*succeed*/ true);
            }
        } catch (Exception e) {
            return new ActionResult(/*succeed*/ false, /*result*/ null, e.getMessage());
        }
    }

    public boolean isTestEmail(String email) {
        return (!StringUtils.isEmpty(email) && email.endsWith("@qp1.org"));
    }

    public ActionResult<List<SubscriptionInfo>> getAllSubscriptions(int memberId) {
        try {
            ArrayOfSubscriptionInfo subscriptionInfos = this.subscriptionService.getAllSubscriptions(memberId);
            List<SubscriptionInfo> subscriptionInfoList = subscriptionInfos.getSubscriptionInfo();
            return new ActionResult<List<SubscriptionInfo>>(/*succeed*/ true, subscriptionInfoList, /*errorMessage*/ null);
        } catch (Exception e) {
            return new ActionResult<List<SubscriptionInfo>>(/*succeed*/ false, /*result*/ null, e.getMessage());
        }
    }

    public ActionResult<MemberInfo> getMemberInfo(int memberId) {
        try {
            return new ActionResult<MemberInfo>(/*succeed*/ true, this.accountService.getMemberInfo(memberId), /*errorMessage*/ null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ActionResult<MemberInfo>(/*succeed*/ false, /*result*/ null, e.getMessage());
        }
    }

    public ActionResult<MemberInfo> getMemberByEmail(String email) {
        try {
            return new ActionResult<MemberInfo>(/*succeed*/ true, this.accountService.getMemberByEmail(email), /*errorMessage*/ null);
        } catch (Exception e) {
            return new ActionResult<MemberInfo>(/*succeed*/ false, /*result*/ null, e.getMessage());
        }
    }
}
