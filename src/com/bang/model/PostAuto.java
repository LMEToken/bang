package com.bang.model;

/**
 * Created by tom on 2017/3/31.
 */
public class PostAuto {

    //访问状态
    public boolean postStatus;
    //失败的错误
    public String errormsg;

    public String successmsg;

    public int code;

    public String apiUrl;

    public String session;

    public boolean isPostStatus() {
        return postStatus;
    }

    public String getSuccessmsg() {
        return successmsg;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public int getCode() {
        return code;
    }

    public String getSession() {
        return session;
    }

    public String getApiUrl() {
        return apiUrl;
    }
}
