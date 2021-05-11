package com.englishtown.dataprovider;

import org.testng.annotations.DataProvider;

/**
 * Created by nikol.marku on 9/2/2016.
 * https://jira-bos.englishtown.com/browse/SAND-3711
 */
public class ExperienceTestDataProvider {

    @DataProvider(name = "experienceTest")//, parallel = true)
    public static Object[][] getExperienceTest() {
        return new Object[][]{
                {"default only / DefaultExperience / ptn=none / OneParamExperience / MixAndMatchManyDefault", "englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/"},
                {"default only / ctr=ar / ptn=none / OneParamExperience / ctr=ar|pe|cl / MixAndMatch / MixAndMatchManyDefault", "englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/?ctr=ar"},
                {"default only / DefaultExperience / ptn=mkge / OneParamExperience / MixAndMatchManyDefault", "englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/?ptn=mkge"},
                /*{"default only / DefaultExperience / ptn=none / OneParamExperience / MixAndMatchManyDefault", "englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/?ptn="},
                {"default only / DefaultExperience / ptn=none / etag=etag2 / OneParamExperience / MixAndMatchManyDefault", "englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/?etag=etag2"},
                {"default only / DefaultExperience / ptn=none / exp=v035 / exp=v001|v035|v887 / OneParamExperience / MixAndMatch / " +
                        "MixAndMatchManyDefault", "englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/?exp=v035"},
                {"default only / DefaultExperience / ptn=none / OneParamExperience / offerid=365745 / MixAndMatchManyDefault", "englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/?offerid=365745"},
                {"default only / DefaultExperience / ptn=none / OneParamExperience / ctr=ar|pe|cl / MixAndMatch / MixAndMatchManyDefault", "englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/?ctr=pe"},
                {"default only / DefaultExperience / ptn=none / exp=v035 / OneParamExperience / exp=v001|v035|v887 / MixAndMatch / "+
                        "ptn=mkge|nonev / exp=001|v035|v887 / MixAndMatchManyDefault", "englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/?exp=v035"},
                {"default only / DefaultExperience / ptn=mkge / exp=v035 / OneParamExperience / exp=v035 / ctr=ar|pe|cl / "+
                 "ptn=mkge|nonev/ exp=001|v035|v887 / ptn=mkge|gogg/ "+
                 "ctr=pe|de / MixAndMatch / MixAndMatchManyDefault", "englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/?exp=v035&ptn=mkge&ctr=pe"},*/
                // todo
               /* {"", "englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/?exp=v035"},
                {"", "englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/  "},

                *///{"", "englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/?ipctr=mx"}
        };
    }

}

/*
"default only / DefaultExperience / ptn=mkge / exp=v035 / OneParamExperience / exp=v035 / ctr=ar|pe|cl / "+
ptn=mkge|nonev/ exp=001|v035|v887 / MixAndMatch / exp=v001|v035|v887 / ptn=mkge|gogg/ "+
"ctr=pe|de / MixAndMatch / MixAndMatchManyDefault",

ptn=mkge only experience : groupe = OneParamExperience
exp=v035 only experience : groupe = OneParamExperience
ctr=ar|pe|cl experience : groupe = MixAndMatch
ptn=mkge|nonev  exp=001|v035|v887   group = MixAndMatchManyDefault
exp=v001|v035|v887 ptn=mkge|gogg ctr=pe|de    group = MixAndMatchManyDefault
*/
