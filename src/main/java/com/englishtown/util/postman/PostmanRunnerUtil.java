package com.englishtown.util.postman;

/**
 * Niko 2019
 *
 * Execute postman collection with newman
 *
 *
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;


public class PostmanRunnerUtil {
    public static final Logger logger = LoggerFactory.getLogger(PostmanRunnerUtil.class);


    public printOutput getStreamWrapper(InputStream is, String type) {
        return new printOutput(is, type);
    }


    /**
     * Return exit value
     * 0 = success and all the other results are failures
     *
     * to run a specific forlder in the collection use --folder $folderName
     *  newman run C:\Tools\collection1.json -e C:\Tools\environment1.json --folder "Create EFID user"
     * @param cmdCommand     - any cmd command
     * @param waitTimeSec
     * @return
     *
     *
     *
     */
    public int executeCmdCommand(String cmdCommand, int waitTimeSec) {
        int exitValue = 1;  // 0 = success and all the rest is fail
        Runtime rt = Runtime.getRuntime();
        PostmanRunnerUtil rte = new PostmanRunnerUtil();
        printOutput errorReported, outputMessage;

        try {
            Process proc = rt.exec(cmdCommand);
            proc.waitFor(5, TimeUnit.SECONDS);
            logger.info("");
            errorReported = rte.getStreamWrapper(proc.getErrorStream(), "ERROR");
            outputMessage = rte.getStreamWrapper(proc.getInputStream(), "OUTPUT");

            errorReported.start();
            outputMessage.start();

            for(int i = 0; i <= waitTimeSec; i++) {
                try {
                    Thread.sleep(1000);
                    exitValue = proc.exitValue();
                } catch (Exception e) {
                    if(i < waitTimeSec)
                        logger.info("Try again try [{}]", i);
                    else
                        throw new Exception("Can't get Exit value for the process ....!  " + e.getMessage());
                }
            }
            logger.info("exit value [{}] ...!", exitValue);
            rte.destroy(proc);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(" Failed to executed command ...! "+e.getMessage());
            fail("Can't Execute cmd script ....! "+e.getMessage());
        }

        if (exitValue != 0 )      //0 = success
            fail("Can't create Student, exit code is not zero, current code ["+ exitValue +"] ....! ");

        return exitValue;
    }

    private class printOutput extends Thread {
        InputStream is = null;

        printOutput(InputStream is, String type) {
            this.is = is;
        }

        public void run() {
            String s = null;
            try {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(is));
                while ((s = br.readLine()) != null) {
                    logger.info(s);
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
                logger.error("Input stream Reader error ...! "+ioe.getMessage());
            }
        }
    }

    public void destroy(Process proc){
        if(null != proc) {
            try {
                proc.destroy();
            }catch (Exception e){
                logger.error("could not destroy Process ...! "+e.getMessage());
            }
        }
    }

}
