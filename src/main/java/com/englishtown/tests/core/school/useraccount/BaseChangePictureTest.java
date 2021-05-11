//package com.englishtown.tests.core.school.useraccount;
///**
// *
// * User: nikol.marku
// * Date: 06/02/18
// *
// * 1. go to my account and change picture
// * 2. change pic source changed
// *
// *
// *
// */
//
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.newhouse.school.pages.home.SchoolHeaderPage;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//
//import static org.hamcrest.Matchers.*;
//
//public abstract class BaseChangePictureTest extends BaseAccountSettingsTest {
//    private static final Logger logger = LoggerFactory.getLogger(BaseChangePictureTest.class);
//
//    protected static String currentImageFileSource = "notInit";
//    protected static String currentAvatarImageFileSource = "notInit";
//    protected static String newImageFileSource = "notInit";
//
//    @Test (dependsOnMethods = "goToMyAccountPage")
//    public void getCurrentImageSourceAccountPage() {
//        schoolHeaderPage = new SchoolHeaderPage(getWebDriver());
//        currentImageFileSource = TestUtil.getAttributeValue(getWebDriver(), myAccountPage.profileImageWe, "src");
//        currentAvatarImageFileSource = TestUtil.getAttributeValue(getWebDriver(), schoolHeaderPage.userAvatarImgWe, "src");
//        logger.info("currentAvatarImageFileSource [{}]", currentAvatarImageFileSource);
//        logger.info("currentImageFileSource...... [{}]", currentImageFileSource);
//
//    }
//
//    @Test (dependsOnMethods = "getCurrentImageSourceAccountPage")
//    public void changePic(){
//        /*TODO*/
//        myAccountPage.changePicWe.get(0).sendKeys(myAccountPage.IMAGE_NAME);
//        sleep(1000);
//        refresh(getWebDriver());
//        sleep(3000);
//        initMyAccountPage();
//    }
//
//    @Test (dependsOnMethods = "changePic")
//    public void checkImageSourceChangedAccountPage(){
//        newImageFileSource = TestUtil.getAttributeValue(getWebDriver(), myAccountPage.profileImageWe, "src");
//        logger.info("newImageFileSource [{}]", newImageFileSource);
//        AssertHelper.assertThat("Image source is not changed ....!", currentImageFileSource, is(not(equalTo(newImageFileSource))) );
//    }
//
//    @Test (dependsOnMethods = "changePic")
//    public void checkAvatarImageSourceChangedHeader(){
//        schoolHeaderPage = new SchoolHeaderPage(getWebDriver());
//        newImageFileSource = TestUtil.getAttributeValue(getWebDriver(), schoolHeaderPage.userAvatarImgWe, "src");
//        logger.info("newImageFileSource [{}]", newImageFileSource);
//        AssertHelper.assertThat("Image source is not changed ....!", currentAvatarImageFileSource, is(not(equalTo(newImageFileSource))) );
//    }
//
//}
//
//
///**
// e.g
//       currentImageFileSource [ https://qa-englishlive.ef.com/1/shared/api/media-persistor/v2/3d20f9cd-5262-4f4a-85d7-49b66db65b15]
//       newImageFileSource     [ https://qa-englishlive.ef.com/1/shared/api/media-persistor/v2/0c8ab476-6773-4e1d-9535-860876c81bcc]
//       newImageFileSource     [https://qa-englishlive.ef.com/1/shared/api/media-persistor/v2/26addc86-ac64-4070-b73d-e682bd892666]    - head
// */