package com.afeng.domain;

import java.io.Serializable;

public class Category implements Serializable {

    /**
     *     CREATE TABLE `category` (
     *   `cid` varchar(32) NOT NULL,
     *   `cname` varchar(20) DEFAULT NULL,
     *   PRIMARY KEY (`cid`)
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8
     */

    private String cid;
    private String cname;

    public Category() {
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }
}
