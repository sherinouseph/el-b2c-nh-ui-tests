package com.englishtown.helpers.utils.filedownloader;

/**
 * Created by nikol.marku on 28/04/2016.
 * Taking an unsalted MD5/SHA1 hash of a file will always produce the same hash for the same file.
 * So all you need to do is take a hash of the file you have downloaded and compare it to a known
 * good hash of the file. If the hash doesn’t match you can fail the test and then examine the
 * file manually later to find out what went wrong.
 *
 *
 * ref:   http://ardesco.lazerycode.com/index.php/2012/07/how-to-download-files-with-selenium-and-why-you-shouldnt/
 */

import org.apache.commons.codec.digest.DigestUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CheckFileHash {

    private static final Logger LOG = LoggerFactory.getLogger(CheckFileHash.class);
    private HashType typeOfHash = null;
    private String expectedFileHash = null;
    private File fileToCheck = null;

    /**
     * The File to perform a Hash check upon
     *
     * @param fileToCheck
     * @throws FileNotFoundException
     */
    public void fileToCheck(File fileToCheck) throws FileNotFoundException {
        if (!fileToCheck.exists()) throw new FileNotFoundException(fileToCheck + " does not exist!");

        this.fileToCheck = fileToCheck;
    }

    /**
     * Hash details used to perform the Hash check
     *
     * @param hash
     * @param hashType
     */
    public void hashDetails(String hash, HashType hashType) {
        this.expectedFileHash = hash;
        this.typeOfHash = hashType;
    }

    /**
     * Performs a expectedFileHash check on a File.
     *
     * @return
     * @throws IOException
     */
    public boolean hasAValidHash() throws IOException {
        if (this.fileToCheck == null) throw new FileNotFoundException("File to check has not been set!");
        if (this.expectedFileHash == null || this.typeOfHash == null) throw new NullPointerException("Hash details have not been set!");

        String actualFileHash = "";
        boolean isHashValid = false;

        switch (this.typeOfHash) {
            case MD5:
                actualFileHash = DigestUtils.md5Hex(new FileInputStream(this.fileToCheck));
                if (this.expectedFileHash.equals(actualFileHash)) isHashValid = true;
                break;
            case SHA1:
                actualFileHash = DigestUtils.shaHex(new FileInputStream(this.fileToCheck));
                if (this.expectedFileHash.equals(actualFileHash)) isHashValid = true;
                break;
        }

        LOG.info("Filename = '" + this.fileToCheck.getName() + "'");
        LOG.info("Expected Hash = '" + this.expectedFileHash + "'");
        LOG.info("Actual Hash = '" + actualFileHash + "'");

        return isHashValid;
    }



//    private final URL testFile = this.getClass().getResource("/download.zip");
//
//    @Test
//    public void checkValidMD5Hash() throws Exception {
//        CheckFileHash fileToCheck = new CheckFileHash();
//        fileToCheck.fileToCheck(new File(testFile.toURI()));
//        fileToCheck.hashDetails("def3a66650822363f9e0ae6b9fbdbd6f", MD5);
//        assertThat(fileToCheck.hasAValidHash(), is(equalTo(true)));
//    }

}