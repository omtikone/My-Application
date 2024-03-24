package com.example.myapplication;

public class SchemeDetails {
    private int sid;
    private String schemename,schemenidhi,duration;

    public SchemeDetails(int sid, String schemename, String schemenidhi, String duration) {
        this.sid = sid;
        this.schemename = schemename;
        this.schemenidhi = schemenidhi;
        this.duration = duration;
    }

    public SchemeDetails(String schemename, String schemenidhi, String duration) {
        this.schemename = schemename;
        this.schemenidhi = schemenidhi;
        this.duration = duration;
    }

    public SchemeDetails(CreateSchemeAct createSchemeAct) {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSchemename() {
        return schemename;
    }

    public void setSchemename(String schemename) {
        this.schemename = schemename;
    }

    public String getSchemenidhi() {
        return schemenidhi;
    }

    public void setSchemenidhi(String schemenidhi) {
        this.schemenidhi = schemenidhi;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
