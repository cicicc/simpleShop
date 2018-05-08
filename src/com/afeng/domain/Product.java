package com.afeng.domain;

import javax.xml.crypto.Data;
import java.io.Serializable;

public class Product implements Serializable {
    /**
     *CREATE TABLE `product` (
     *   `pid` varchar(32) NOT NULL,
     *   `pname` varchar(50) DEFAULT NULL,
     *   `market_price` double DEFAULT NULL,
     *   `shop_price` double DEFAULT NULL,
     *   `pimage` varchar(200) DEFAULT NULL,
     *   `pdate` date DEFAULT NULL,
     *   `is_hot` int(11) DEFAULT NULL,
     *   `pdesc` varchar(255) DEFAULT NULL,
     *   `pflag` int(11) DEFAULT NULL,
     *   `cid` varchar(32) DEFAULT NULL,
     *   PRIMARY KEY (`pid`),
     *   KEY `sfk_0001` (`cid`),
     *   CONSTRAINT `sfk_0001` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8
     */
    private String pid;
    private String pname;
    private Integer market_price;
    private Integer shop_price;
    private String pdate;
    private Integer is_hot;
    private String pimage;
    private String pdesc;
    private Integer pflag;
    private String cid;

    public Product() {
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getMarket_price() {
        return market_price;
    }

    public void setMarket_price(Integer market_price) {
        this.market_price = market_price;
    }

    public Integer getShop_price() {
        return shop_price;
    }

    public void setShop_price(Integer shop_price) {
        this.shop_price = shop_price;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public Integer getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(Integer is_hot) {
        this.is_hot = is_hot;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public Integer getPflag() {
        return pflag;
    }

    public void setPflag(Integer pflag) {
        this.pflag = pflag;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", market_price=" + market_price +
                ", shop_price=" + shop_price +
                ", pdate=" + pdate +
                ", is_hot=" + is_hot +
                ", pimage='" + pimage + '\'' +
                ", pdesc='" + pdesc + '\'' +
                ", pflag=" + pflag +
                ", cid='" + cid + '\'' +
                '}';
    }
}
