package com.englishtown.helpers;

/**
 * Created by nikol.marku on 4/7/2017.
 *
 * All JS script should be moved/defined here
 * //getElementsByTagName querySelectorAll
 */
public interface IJavaScriptHelper {

    String JS_GET_VIDEO_SCRIPT         = "document.getElementsByTagName('video')[0]";
    String JS_PLAY_YOUTUBE_VIDEO       = JS_GET_VIDEO_SCRIPT +".play()";
    String JS_PAUSE_YOUTUBE_VIDEO      = JS_GET_VIDEO_SCRIPT +".pause()";
    String JS_YOUTUBE_VIDEO_CURRENTIME = JS_GET_VIDEO_SCRIPT +".currentTime";
    String JS_YOUTUBE_VIDEO_DURATION   = JS_GET_VIDEO_SCRIPT +".duration";
    String JS_YOUTUBE_VIDEO_ERROR      = JS_GET_VIDEO_SCRIPT +".error";


    /**
     * JS
     * Async script
     */
    String ALL_STATE_OBJECT = "var callback = arguments[arguments.length - 1];" +
            "window.et = window.et || {}; window.et.state = window.et.state || [];" +
            "et.state.push(null, function(){" +
            "et.state.get('',function( v ){if (v) { callback(JSON.stringify(v)) } else { callback('error'); } })" +
            "});";

    String STATE_OBJECT_PAGE_NAME = "var callback = arguments[arguments.length - 1];" +
            "window.et = window.et || {}; window.et.state = window.et.state || [];" +
            "et.state.push(null, function(){" +
            "et.state.get('page.name',function( v ){if (v) { callback(JSON.stringify(v)) } else { callback('error'); } })" +
            "});";
    /*******************************************************************************************************************
     * experimental
     */
    String addPlayingEventListenerScript = "var callback = arguments[arguments.length - 1];" +
            "document.querySelectorAll('video')[0].addEventListener('playing',"+
            "function( v ){ if(v){ callback('ok'); } else { callback('error'); } } );";
    String script1 = "var callback = arguments[arguments.length - 1]; document.querySelectorAll('video')[0].addEventListener('playing', callback);";

    // get uuid
    //String UUID_JSSCRIPT = "var callback = require('shared/my/accessToken').get().then(function(v){{if (v) { callback(JSON.stringify(v)) } else { callback('error: CANT GET UUID'); }}";//console.log(v)})";
    /**
     *
     "var callback = arguments[arguments.length - 1];" +
     "et.state.get('',function( v ){if (v) { callback(JSON.stringify(v)) } else { callback('error'); } })" +
     "});"
     */

}
