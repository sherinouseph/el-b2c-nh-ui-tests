package com.englishlive.tests.varnish.core;

/**
 * Created by nikol.marku on 16/06/2016.
 * test data values https://jira-bos.englishtown.com/browse/SAND-3018
 * e.g
  usb-etb2cv1
 Overall Health:Ok
 Active Node:Ok
 Passive Node:Ok
 Varnish Cluster Peer:Ok
 Caching:Ok
 Current Backend: cq_active_fallback
 Script: usb-etb2cv1
 Version: 1.0.33
 */
public interface IVarnishHelth {
   // String RESPONSE_CODE = "200";
    String OVERALL_HELTH   = "Overall Health:Ok";	//Exact match
    String ACTIVE_NODE     = "Active Node:Ok";
    String PASSIVE_NODE    = "Passive Node:Ok";
    String VARNISH_CLASTER = "Varnish Cluster Peer:Disabled"; // Disabled 23 Apr 2017 , was Ok";
    String CASHING         = "Caching:Ok";
    String[] SCRIPT        = {"usb-etb2cv1", "usb-etb2cv2"} ; //Script: XXXXXXXXXXXX	; //usb-etb2cv1 for usb-etb2cv1 and usb-etb2cv2 for usb-etb2cv2
   //DYNAMIC String VERSION; //Version: 1.0.XXXXX	     //it doesn't matter which value does XXXXX show, but the value shown in usb-etb2cv1 must be the same as that is shown in usb-etb2cv2

}

