package com.example.supermarket.lh.domain;

import lombok.Data;

@Data
public class Provider {
    String pnum;
    String pname;
    String padd;
    String ptel;
    String pmail;
    String trust;
    String cnum;
    String cname;

    public String getPnum() {
        return pnum;
    }

    public String getPname() {
        return pname;
    }

    public String getPadd() {
        return padd;
    }

    public String getPtel() {
        return ptel;
    }

    public String getPmail() {
        return pmail;
    }

    public String getTrust() {
        return trust;
    }

    public String getCnum() {
        return cnum;
    }

    public String getCname() {
        return cname;
    }
}
