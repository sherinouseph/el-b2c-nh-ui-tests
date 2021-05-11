package com.englishtown.util.db.testdbbean;

//import com.steadystate.css.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 24/02/2016.
 *
 * Page load stats
 * calculating values for analyses of page load stats
 *
 */
public class PerformanceTimingBean {
    private static final Logger log = LoggerFactory.getLogger(PerformanceTimingBean.class);
    // Start ....
    protected long navigationStart ;
    protected long unloadEventStart ;
    protected long unloadEventEnd ;
    protected long redirectStart ;
    protected long redirectEnd ;
    protected long fetchStart ;
    protected long domainLookupStart ;
    protected long domainLookupEnd ;
    protected long connectStart ;
    protected long secureConnectionStart ;
    protected long connectEnd ;
    protected long requestStart ;
    protected long responseStart ;
    protected long responseEnd ;
    //dom processing
    protected long domLoading ;
    protected long domInteractive ;
    protected long domContentLoadedEventStart ;
    protected long domContentLoadedEventEnd ;
    protected long domComplete ;
    // onload .. selenium use this before you can interact with it
    protected long loadEventStart ;
    protected long loadEventEnd ;
    // my extras
    // if spinner not visible then this is equal to domComplete time
    // if spinner is visible then wait for it to disappear ; getTime() - navigationStart;
    protected long spinnerGoesWayTime;
    protected boolean foundSpinner ;

    // calculated values
    protected long networkLatency ;                 // responseEnd - fetchStart //http://www.html5rocks.com/en/tutorials/webperformance/basics/
    protected long pageLoadOnceReceivedFromServer ; // loadEventEnd - responseEnd
    protected long domCompleteProcessingTime ;      // domComplete - responseEnd
    protected long timeToDomComplete ;              // domComplete - navigationStart;
    protected long timeToSpinnerWay ;               // spinnerGoesWayTime - navigationStart
    protected long timeToDomInteractive;           // domInteractive - navigationStart


    /**
     * All field
     */
    public PerformanceTimingBean(long navigationStart, long unloadEventStart, long unloadEventEnd, long redirectStart,
                                 long redirectEnd, long fetchStart, long domainLookupStart, long domainLookupEnd,
                                 long connectStart, long secureConnectionStart, long connectEnd, long requestStart,
                                 long responseStart, long responseEnd, long domLoading, long domInteractive,
                                 long domContentLoadedEventStart, long domContentLoadedEventEnd, long domComplete,
                                 long loadEventStart, long loadEventEnd, long spinnerGoesWayTime, boolean foundSpinner,
                                 long networkLatency, long pageLoadOnceReceivedFromServer, long domCompleteProcessingTime,
                                 long timeToDomComplete,long timeToDomInteractive, long timeToSpinnerWay) {
        this.navigationStart = navigationStart;
        this.unloadEventStart = unloadEventStart;
        this.unloadEventEnd = unloadEventEnd;
        this.redirectStart = redirectStart;
        this.redirectEnd = redirectEnd;
        this.fetchStart = fetchStart;
        this.domainLookupStart = domainLookupStart;
        this.domainLookupEnd = domainLookupEnd;
        this.connectStart = connectStart;
        this.secureConnectionStart = secureConnectionStart;
        this.connectEnd = connectEnd;
        this.requestStart = requestStart;
        this.responseStart = responseStart;
        this.responseEnd = responseEnd;
        this.domLoading = domLoading;
        this.domInteractive = domInteractive;
        this.domContentLoadedEventStart = domContentLoadedEventStart;
        this.domContentLoadedEventEnd = domContentLoadedEventEnd;
        this.domComplete = domComplete;
        this.loadEventStart = loadEventStart;
        this.loadEventEnd = loadEventEnd;
        this.spinnerGoesWayTime = spinnerGoesWayTime;
        this.foundSpinner = foundSpinner;
        this.networkLatency = networkLatency;
        this.pageLoadOnceReceivedFromServer = pageLoadOnceReceivedFromServer;
        this.domCompleteProcessingTime = domCompleteProcessingTime;
        this.timeToDomComplete = timeToDomComplete;
        this.timeToDomInteractive = timeToDomInteractive;
        this.timeToSpinnerWay = timeToSpinnerWay;
    }

    /**
     * No calculation fields included
     *
     */
    public PerformanceTimingBean(long navigationStart, long unloadEventStart, long unloadEventEnd, long redirectStart,
                                 long redirectEnd, long fetchStart, long domainLookupStart, long domainLookupEnd,
                                 long connectStart, long secureConnectionStart, long connectEnd, long requestStart,
                                 long responseStart, long responseEnd, long domLoading, long domInteractive,
                                 long domContentLoadedEventStart, long domContentLoadedEventEnd, long domComplete,
                                 long loadEventStart, long loadEventEnd) {
        this.navigationStart = navigationStart;
        this.unloadEventStart = unloadEventStart;
        this.unloadEventEnd = unloadEventEnd;
        this.redirectStart = redirectStart;
        this.redirectEnd = redirectEnd;
        this.fetchStart = fetchStart;
        this.domainLookupStart = domainLookupStart;
        this.domainLookupEnd = domainLookupEnd;
        this.connectStart = connectStart;
        this.secureConnectionStart = secureConnectionStart;
        this.connectEnd = connectEnd;
        this.requestStart = requestStart;
        this.responseStart = responseStart;
        this.responseEnd = responseEnd;
        this.domLoading = domLoading;
        this.domInteractive = domInteractive;
        this.domContentLoadedEventStart = domContentLoadedEventStart;
        this.domContentLoadedEventEnd = domContentLoadedEventEnd;
        this.domComplete = domComplete;
        this.loadEventStart = loadEventStart;
        this.loadEventEnd = loadEventEnd;
    }

    /**
     * Only my calculated fields
     * @return
     */
    public PerformanceTimingBean(long spinnerGoesWayTime, boolean foundSpinner,
                                 long networkLatency, long pageLoadOnceReceivedFromServer, long domCompleteProcessingTime,
                                 long timeToDomComplete, long timeToDomInteractive, long timeToSpinnerWay) {
        this.spinnerGoesWayTime = spinnerGoesWayTime;
        this.foundSpinner = foundSpinner;
        this.networkLatency = networkLatency;
        this.pageLoadOnceReceivedFromServer = pageLoadOnceReceivedFromServer;
        this.domCompleteProcessingTime = domCompleteProcessingTime;
        this.timeToDomComplete = timeToDomComplete;
        this.timeToDomInteractive = timeToDomInteractive;
        this.timeToSpinnerWay = timeToSpinnerWay;
    }

    public PerformanceTimingBean(){}

    public void setupCalculatedValues(){
        setNetworkLatency();
        setPageLoadOnceReceivedFromServer();
        setDomCompleteProcessingTime();
        setTimeToDomComplete();
        setTimeToDomInteractive();
        // spinner
    }

    @Override
    public String toString() {
        return "PerformanceTimingBean{" +
                "navigationStart=" + navigationStart +
                ", unloadEventStart=" + unloadEventStart +
                ", unloadEventEnd=" + unloadEventEnd +
                ", redirectStart=" + redirectStart +
                ", redirectEnd=" + redirectEnd +
                ", fetchStart=" + fetchStart +
                ", domainLookupStart=" + domainLookupStart +
                ", domainLookupEnd=" + domainLookupEnd +
                ", connectStart=" + connectStart +
                ", secureConnectionStart=" + secureConnectionStart +
                ", connectEnd=" + connectEnd +
                ", requestStart=" + requestStart +
                ", responseStart=" + responseStart +
                ", responseEnd=" + responseEnd +
                ", domLoading=" + domLoading +
                ", domInteractive=" + domInteractive +
                ", domContentLoadedEventStart=" + domContentLoadedEventStart +
                ", domContentLoadedEventEnd=" + domContentLoadedEventEnd +
                ", domComplete=" + domComplete +
                ", loadEventStart=" + loadEventStart +
                ", loadEventEnd=" + loadEventEnd +
                ", spinnerGoesWayTime=" + spinnerGoesWayTime +
                ", foundSpinner=" + foundSpinner +
                ", networkLatency=" + networkLatency +
                ", pageLoadOnceReceivedFromServer=" + pageLoadOnceReceivedFromServer +
                ", domCompleteProcessingTime=" + domCompleteProcessingTime +
                ", timeToDomComplete=" + timeToDomComplete +
                ", timeToDomInteractive=" + timeToDomInteractive +
                ", timeToSpinnerWay=" + timeToSpinnerWay +
                '}';
    }


    /**
     *
     * Convert the string below to an object
     * 0. ???? replace  "toJSON={}," with nothing - remove
     * 1. split on commas
     * 2. split on = and match first part;
     * 3. if true assign the value as second part
     *
     */
    public static PerformanceTimingBean getTimingBean(String performanceTiming){
        PerformanceTimingBean ptb = new PerformanceTimingBean();
        String temp = null;
        String tempKey = null;
        String tempValue = null;
        if(null!=performanceTiming && performanceTiming.contains(",") && performanceTiming.contains("=") ) {
            try {
                String tmp = performanceTiming.replaceAll("toJSON=\\{\\}\\,", "");
                tmp = tmp.replaceAll("\\{|\\}", "");
                String[] tokens1 = tmp.split(",");
                if(null != tokens1 && tokens1.length > 0){
                    for(String tokenPart : tokens1){
                        String[] keyAndValue = tokenPart.split("=");
                        if(null != keyAndValue && keyAndValue.length > 0){
                            tempKey = keyAndValue[0].trim();
                            tempValue = keyAndValue[1].trim();
                            log.info("key["+tempKey+"]; value["+tempValue+"]");
                            initPtbStatFromString(tempKey,tempValue,ptb);
                        }else {  log.warn("Token1 is null or cant split on commas .....!");  }
                    }
                } else {    log.warn("Token1 is null or cant split on commas .....!");  }
            } catch (Exception e) {
                log.warn("parsePerfomanceTimingJSresult > Cant parse this value ....! : ");
            }
        }else{
            log.warn("performanceTiming is null nor commas nor equals signs ...! : "+performanceTiming);
        }
        //log.info(ptb.toString());
        return ptb;
    }

    public static void initPtbStatFromString(String key, String value, PerformanceTimingBean ptb) {//throws ParseException {
        //log.info("initPtbStatFromString ...");
        switch(key){
            case "navigationStart":         ptb.setNavigationStart(Long.parseLong(value));
                break;
            case "unloadEventStart":        ptb.setUnloadEventStart(Long.parseLong(value));
                break;
            case "unloadEventEnd":          ptb.setUnloadEventEnd(Long.parseLong(value));
                break;
            case "redirectStart":           ptb.setRedirectStart(Long.parseLong(value));
                break;
            case "redirectEnd":             ptb.setRedirectEnd(Long.parseLong(value));
                break;
            case "fetchStart":              ptb.setFetchStart(Long.parseLong(value));
                break;
            case "domainLookupStart":       ptb.setDomainLookupStart(Long.parseLong(value));
                break;
            case "domainLookupEnd":         ptb.setDomainLookupEnd(Long.parseLong(value));
                break;
            case "connectStart":            ptb.setConnectStart(Long.parseLong(value));
                break;
            case "secureConnectionStart":   ptb.setSecureConnectionStart(Long.parseLong(value));
                break;
            case "connectEnd":              ptb.setConnectEnd(Long.parseLong(value));
                break;
            case "requestStart":            ptb.setRequestStart(Long.parseLong(value));
                break;
            case "responseStart":           ptb.setResponseStart(Long.parseLong(value));
                break;
            case "responseEnd":             ptb.setResponseEnd(Long.parseLong(value));
                break;
            case "domLoading":              ptb.setDomLoading(Long.parseLong(value));
                break;
            case "domInteractive":          ptb.setDomInteractive(Long.parseLong(value));
                break;
            case "domContentLoadedEventStart":  ptb.setDomContentLoadedEventStart(Long.parseLong(value));
                break;
            case "domContentLoadedEventEnd":    ptb.setDomContentLoadedEventEnd(Long.parseLong(value));
                break;
            case "domComplete":                 ptb.setDomComplete(Long.parseLong(value));
                break;
            case "loadEventStart":              ptb.setLoadEventStart(Long.parseLong(value));
                break;
            case "loadEventEnd":                ptb.setLoadEventEnd(Long.parseLong(value));
                break;
            default: log.warn("Invalid Key ...! >"+key);
                break;
        }
    }


    //*************************************************************************************************

    public long getTimeToDomInteractive() {
        return timeToDomInteractive;
    }
    public void setTimeToDomInteractive(long timeToDomeInteractive) {
        this.timeToDomInteractive = timeToDomeInteractive;
    }
    public void setTimeToDomInteractive() {
        timeToDomInteractive = domInteractive - navigationStart;
    }

    public boolean isFoundSpinner() {
        return foundSpinner;
    }
    public void setFoundSpinner(boolean foundSpinner) {
        this.foundSpinner = foundSpinner;
    }

    public long getTimeToSpinnerWay() {
        return timeToSpinnerWay;
    }
    public void setTimeToSpinnerWay(long timeToSpinnerWay) {
        this.timeToSpinnerWay = timeToSpinnerWay;
    }

    public long getTimeToDomComplete() {
        return timeToDomComplete;
    }
    public void setTimeToDomComplete(long timeToDomComplete) {
        this.timeToDomComplete = timeToDomComplete;
    }
    public void setTimeToDomComplete() {
        timeToDomComplete = domComplete - navigationStart;
    }

    public long getDomCompleteProcessingTime() {
        return domCompleteProcessingTime;
    }
    public void setDomCompleteProcessingTime(long domCompleteProcessingTime) {
        this.domCompleteProcessingTime = domCompleteProcessingTime;
    }
    public void setDomCompleteProcessingTime() {
        domCompleteProcessingTime = domComplete - responseEnd;
    }

    public long getPageLoadOnceReceivedFromServer() {
        return pageLoadOnceReceivedFromServer;
    }
    public void setPageLoadOnceReceivedFromServer(long pageLoadOnceRecivedFromServer) {
        this.pageLoadOnceReceivedFromServer = pageLoadOnceRecivedFromServer;
    }
    public void setPageLoadOnceReceivedFromServer() {
        pageLoadOnceReceivedFromServer = loadEventEnd - responseEnd;
    }

    public long getNetworkLatency() {
        return networkLatency;
    }
    public void setNetworkLatency(long networkLatency) {
        this.networkLatency = networkLatency;
    }
    public void setNetworkLatency() {
        networkLatency = responseEnd - fetchStart;
    }

    public long getSpinnerGoesWayTime() {
        return spinnerGoesWayTime;
    }

    public void setSpinnerGoesWayTime(long spinnerGoesWayTime) {
        this.spinnerGoesWayTime = spinnerGoesWayTime;
    }

    public Long getUnloadEventEnd() {
        return unloadEventEnd;
    }

    public void setUnloadEventEnd(Long unloadEventEnd) {
        this.unloadEventEnd = unloadEventEnd;
    }

    public Long getLoadEventEnd() {
        return loadEventEnd;
    }

    public void setLoadEventEnd(Long loadEventEnd) {
        this.loadEventEnd = loadEventEnd;
    }

    public Long getResponseEnd() {
        return responseEnd;
    }

    public void setResponseEnd(Long responseEnd) {
        this.responseEnd = responseEnd;
    }

    public Long getResponseStart() {
        return responseStart;
    }

    public void setResponseStart(Long responseStart) {
        this.responseStart = responseStart;
    }

    public Long getDomInteractive() {
        return domInteractive;
    }

    public void setDomInteractive(Long domInteractive) {
        this.domInteractive = domInteractive;
    }

    public Long getDomainLookupEnd() {
        return domainLookupEnd;
    }

    public void setDomainLookupEnd(Long domainLookupEnd) {
        this.domainLookupEnd = domainLookupEnd;
    }

    public Long getUnloadEventStart() {
        return unloadEventStart;
    }

    public void setUnloadEventStart(Long unloadEventStart) {
        this.unloadEventStart = unloadEventStart;
    }

    public Long getDomComplete() {
        return domComplete;
    }

    public void setDomComplete(Long domComplete) {
        this.domComplete = domComplete;
    }

    public Long getDomContentLoadedEventStart() {
        return domContentLoadedEventStart;
    }

    public void setDomContentLoadedEventStart(Long domContentLoadedEventStart) {
        this.domContentLoadedEventStart = domContentLoadedEventStart;
    }

    public Long getDomainLookupStart() {
        return domainLookupStart;
    }

    public void setDomainLookupStart(Long domainLookupStart) {
        this.domainLookupStart = domainLookupStart;
    }

    public Long getRedirectEnd() {
        return redirectEnd;
    }

    public void setRedirectEnd(Long redirectEnd) {
        this.redirectEnd = redirectEnd;
    }

    public Long getRedirectStart() {
        return redirectStart;
    }

    public void setRedirectStart(Long redirectStart) {
        this.redirectStart = redirectStart;
    }

    public Long getConnectEnd() {
        return connectEnd;
    }

    public void setConnectEnd(Long connectEnd) {
        this.connectEnd = connectEnd;
    }

    public Long getConnectStart() {
        return connectStart;
    }

    public void setConnectStart(Long connectStart) {
        this.connectStart = connectStart;
    }

    public Long getLoadEventStart() {
        return loadEventStart;
    }

    public void setLoadEventStart(Long loadEventStart) {
        this.loadEventStart = loadEventStart;
    }

    public Long getNavigationStart() {
        return navigationStart;
    }

    public void setNavigationStart(Long navigationStart) {
        this.navigationStart = navigationStart;
    }

    public Long getRequestStart() {
        return requestStart;
    }

    public void setRequestStart(Long requestStart) {
        this.requestStart = requestStart;
    }

    public Long getSecureConnectionStart() {
        return secureConnectionStart;
    }

    public void setSecureConnectionStart(Long secureConnectionStart) {
        this.secureConnectionStart = secureConnectionStart;
    }

    public Long getFetchStart() {
        return fetchStart;
    }

    public void setFetchStart(Long fetchStart) {
        this.fetchStart = fetchStart;
    }

    public Long getDomContentLoadedEventEnd() {
        return domContentLoadedEventEnd;
    }

    public void setDomContentLoadedEventEnd(Long domContentLoadedEventEnd) {
        this.domContentLoadedEventEnd = domContentLoadedEventEnd;
    }

    public Long getDomLoading() {
        return domLoading;
    }

    public void setDomLoading(Long domLoading) {
        this.domLoading = domLoading;
    }

}


/*
   *
     *   {unloadEventEnd=0, responseEnd=1456246607166, responseStart=1456246606924, domInteractive=1456246608510,
     domainLookupEnd=1456246606674, unloadEventStart=0, domComplete=1456246609929, domContentLoadedEventStart=1456246608510,
     domainLookupStart=1456246606674, redirectEnd=1456246606673, redirectStart=1456246606407, connectEnd=1456246606795,toJSON={},
     connectStart=1456246606674, loadEventStart=1456246609929, navigationStart=1456246606142,
     requestStart=1456246606795, secureConnectionStart=0, fetchStart=1456246606673, domContentLoadedEventEnd=1456246608809,
     domLoading=1456246606925, loadEventEnd=1456246609935}
     *
     *("JS performance timing " +BaseTest.executeJSscript("var t = performance.timing; return t", driver, 3));

 */