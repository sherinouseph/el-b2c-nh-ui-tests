package com.englishtown.enumpack;
/**
 * TEst need to setup what grid it is using so the test could be executed
 *
 * Created by nikol.marku on 10-Nov-17.
 * Niko
 *
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public enum GridEnvironment {
    LOCAL("local"),    // LOCAL MACHINE
    TC_GRID("tcgrid"),
    BROWSERSTACK("browserstack"),
    OTHER("other");

    private final String gridEnv;

    private GridEnvironment(String gridEnv) {
        this.gridEnv = gridEnv;
    }

    public String getGridEnv(){
        return this.gridEnv;
    }

    private static final Logger logger = LoggerFactory.getLogger(GridEnvironment.class);

    /**
     * Get gridEnvironment from str
     * @param gridEnv
     * @return GridEnvironment
     */
    public static GridEnvironment getGridEnvFromString(String gridEnv) {
        GridEnvironment gridEnvironment = GridEnvironment.LOCAL;
        logger.info("Get Test type for [{}]", gridEnv);

        if(null != gridEnv) {

            switch (gridEnv) {
                case "local":
                    gridEnvironment = GridEnvironment.LOCAL;
                    break;
                case "tcgrid":
                    gridEnvironment = GridEnvironment.TC_GRID;
                    break;
                case "browserstack":
                    gridEnvironment = GridEnvironment.BROWSERSTACK;
                    break;

                default:
                    logger.warn(gridEnv + " Is not on the test type list ...!");
            }
        } else {
            logger.error("Test gridEnv set to local BY DEFAULT ...!");
        }
        return gridEnvironment;
    }

}