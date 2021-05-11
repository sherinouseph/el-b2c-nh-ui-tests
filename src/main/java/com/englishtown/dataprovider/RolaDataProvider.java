package com.englishtown.dataprovider;

import com.englishtown.dataprovider.bin.CountryBean;
import org.testng.annotations.DataProvider;

/**
 * Created by nikol.marku on 12/11/2015.
 */
public class RolaDataProvider {


    @DataProvider(name = "rolaTopCountries")
    public static Object[][] rolaTopCountries() {
        return new Object[][] {
                { "Argentina",  "ar" },
                { "Bolivia",    "bo" },
                { "Chile",      "cl" },
                { "Colombia",   "co" },
                { "Ecuador",    "ec" },
                { "Peru",       "pe" },
                { "Costa Rica", "cr" },
                { "Select Counry", "xx" },        // if no ctr found show select country
                { "Select Counry", "anything" }  //
        };
    }

    @DataProvider(name = "rolaTopCountrieBean")
    public static Object[][] rolaTopCountrieBean() {
        return new Object[][] {
                { new CountryBean("Argentina",      "ar", "es", "Capital Federal",       "/es-mx/", true , "(54)-911",  "(54)-11-" ,  "0800-44-41719")  },
                { new CountryBean("Bolivia",        "bo", "es", "Santa Cruz",            "/es-mx/", true , "(591)-7",   "(591)-3-" ,  "800101925")  },
                { new CountryBean("Chile",          "cl", "es", "Santiago Metropolitan", "/es-mx/", true , "(56)-9",    "(56)-2-2" ,  "123-0-020-1720")  },
                { new CountryBean("Colombia",       "co", "es", "Bogotá",                "/es-mx/", true , "(57)-3",    "(57)-1-" ,   "01-800-518-3897")  },
                { new CountryBean("Ecuador",        "ec", "es", "Guayas",                "/es-mx/", true , "(593)-9",   "(593)-4-" ,  "180-0000-729")  },
                { new CountryBean("Perú",           "pe", "es", "Departamento",   "/es-mx/", true , "na", "na" , "0800-77-636")  },
                { new CountryBean("Costa Rica",     "cr", "es", "San José",              "/es-mx/", false, "+506-", "+506-" , "800-223-3445")  }
               // { new CountryBean("País", "xx", "es", "País",                "/es-mx/", false, "na", "na" , "+1 (617) 603-9880")  },   // if no ctr found show select country
                //{ new CountryBean("Mexico", "anything", "es", "Mexico",          "/es-mx/", false, "na", "na")  }
        };
    }
}


/**

 <option value="ar">Argentina</option>
 <option value="bo">Bolivia</option>
 <option value="cl">Chile</option>
 <option value="co">Colombia</option>
 <option value="cr">Costa Rica</option>
 <option value="do">Dominican Republic</option>
 <option value="ec">Ecuador</option>
 <option value="gt">Guatemala</option>
 <option value="hn">Honduras</option>
 <option value="mx">Mexico</option>
 <option value="ni">Nicaragua</option>
 <option value="pa">Panama</option>
 <option value="pe">Peru</option>
 <option value="pr">Puerto Rico</option>
 <option value="py">Paraguay</option>
 <option value="sv">El Salvador</option>
 <option value="uy">Uruguay</option>

 */