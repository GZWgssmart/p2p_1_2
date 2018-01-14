package top.zzh.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 曾志湖 on 2017/12/28.
 */
public class TzbVO {

    private Long tzid;
    private Long uid;//前台用户id
    private Long juid;//借款人id
    private BigDecimal money;//投资金额
    private Date time;//投资时间
    private Float nprofit;//利率
    private String cpname;//产品名称
    private Long baid;//借款id
    private String rname;//借款人姓名
    private String uname;//前台用户姓名
    private Integer int1;
    private Integer int2;
    private String str1;

    public Long getTzid() {
        return tzid;
    }

    public void setTzid(Long tzid) {
        this.tzid = tzid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getJuid() {
        return juid;
    }

    public void setJuid(Long juid) {
        this.juid = juid;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Float getNprofit() {
        return nprofit;
    }

    public void setNprofit(Float nprofit) {
        this.nprofit = nprofit;
    }

    public String getCpname() {
        return cpname;
    }

    public void setCpname(String cpname) {
        this.cpname = cpname;
    }

    public Long getBaid() {
        return baid;
    }

    public void setBaid(Long baid) {
        this.baid = baid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getInt1() {
        return int1;
    }

    public void setInt1(Integer int1) {
        this.int1 = int1;
    }

    public Integer getInt2() {
        return int2;
    }

    public void setInt2(Integer int2) {
        this.int2 = int2;
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }
}
