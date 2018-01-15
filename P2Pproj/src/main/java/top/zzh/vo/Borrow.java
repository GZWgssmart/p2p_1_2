package top.zzh.vo;

import java.math.BigDecimal;
import java.util.Date;

public class Borrow {
    private Long bdid;
    private String bzname;//标种id
    private BigDecimal money;//申请金额
    private String cpname;//产品名称
    private Long sid;//收益方式
    private Byte state;//审核状态（0表示为审核，1表示已审核）

    public Borrow() {
    }

    public Borrow(Long bdid, String bzname, BigDecimal money, String cpname, Long sid, Byte state) {
        this.bdid = bdid;
        this.bzname = bzname;
        this.money = money;
        this.cpname = cpname;
        this.sid = sid;
        this.state = state;
    }

    public Long getBdid() {
        return bdid;
    }

    public void setBdid(Long bdid) {
        this.bdid = bdid;
    }

    public String getBzname() {
        return bzname;
    }

    public void setBzname(String bzname) {
        this.bzname = bzname;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getCpname() {
        return cpname;
    }

    public void setCpname(String cpname) {
        this.cpname = cpname;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}
