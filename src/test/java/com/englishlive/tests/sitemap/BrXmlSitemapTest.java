package com.englishlive.tests.sitemap;
/**
 *
 *
 */

import com.englishlive.tests.basetest.htmlunit.BaseResponseCodeTest;
import com.englishtown.helpers.UrlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.BeforeClass;

public class BrXmlSitemapTest extends BaseResponseCodeTest {
    private static final Logger logger = LoggerFactory.getLogger(BrXmlSitemapTest.class);
    @Value("#{applicationPropertiesList['sitemap.br.br.xml.url']}")
    private String testUrl;


    @BeforeClass
    private void setup() {
        htmlUnitTestUrl = testUrl;
    }

}