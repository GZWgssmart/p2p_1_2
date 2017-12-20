package top.zzh.bean;

import java.math.BigDecimal;
import java.util.Date;

//申请借款表
public class BorrowApply {

    private Long baid;

    private String rname;//真实姓名

    private BigDecimal money;//申请金额

    private Long uid;//借款人id

    private Long bzid;//标种id

    private Date time;//审核时间

    private Byte state;//审核状态（0表示为审核，1表示已审核）

    private Byte type;//借款类型为标种的主键字段

    private String term;//借款期限

    private Date deadline;//截止时间

    private Long int1;

    private String str1;

    public BorrowApply(Long baid, String rname, BigDecimal money, Long uid, Long bzid, Date time, Byte state, Byte type, String term, Date deadline, Long int1, String str1) {
        this.baid = baid;
        this.rname = rname;
        this.money = money;
        this.uid = uid;
        this.bzid = bzid;
        this.time = time;
        this.state = state;
        this.type = type;
        this.term = term;
        this.deadline = deadline;
        this.int1 = int1;
        this.str1 = str1;
    }

    public BorrowApply() {
        super();
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
        this.rname = rname == null ? null : rname.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getBzid() {
        return bzid;
    }

    public void setBzid(Long bzid) {
        this.bzid = bzid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term == null ? null : term.trim();
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Long getInt1() {
        return int1;
    }

    public void setInt1(Long int1) {
        this.int1 = int1;
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1 == null ? null : str1.trim();
    }
}