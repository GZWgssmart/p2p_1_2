package top.zzh.vo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by 曾志湖 on 2018/1/3.
 * 收款表vo
 */
public class SkbVO {

    private Long skid;
    private Long uid;//用户id
    private Long juid;//借款人id
    private BigDecimal ybx;//应收本息
    private BigDecimal rbx;//已收本息
    private BigDecimal ylx;//应收利息
    private BigDecimal rlx;//已收利息
    private BigDecimal ybj;//应收本金
    private BigDecimal rbj;//已收本金
    private Integer rnum;//已还期数
    private Integer tnum;//总期数
    private Timestamp date;//日期
    private Long baid;//借款人id
    private BigDecimal fmoney;//好友奖励
    private String uname;//前台用户名称
    private String rname;//借款人姓名

    public SkbVO(){

    }
    public SkbVO(Long skid, Long uid, Long juid, BigDecimal ybx, BigDecimal rbx, BigDecimal ylx, BigDecimal rlx, BigDecimal ybj, BigDecimal rbj, Integer rnum, Integer tnum, Timestamp date, Long baid, BigDecimal fmoney, String uname, String rname) {
        this.skid = skid;
        this.uid = uid;
        this.juid = juid;
        this.ybx = ybx;
        this.rbx = rbx;
        this.ylx = ylx;
        this.rlx = rlx;
        this.ybj = ybj;
        this.rbj = rbj;
        this.rnum = rnum;
        this.tnum = tnum;
        this.date = date;
        this.baid = baid;
        this.fmoney = fmoney;
        this.uname = uname;
        this.rname = rname;
    }

    public Long getSkid() {
        return skid;
    }

    public void setSkid(Long skid) {
        this.skid = skid;
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

    public BigDecimal getYbx() {
        return ybx;
    }

    public void setYbx(BigDecimal ybx) {
        this.ybx = ybx;
    }

    public BigDecimal getRbx() {
        return rbx;
    }

    public void setRbx(BigDecimal rbx) {
        this.rbx = rbx;
    }

    public BigDecimal getYlx() {
        return ylx;
    }

    public void setYlx(BigDecimal ylx) {
        this.ylx = ylx;
    }

    public BigDecimal getRlx() {
        return rlx;
    }

    public void setRlx(BigDecimal rlx) {
        this.rlx = rlx;
    }

    public BigDecimal getYbj() {
        return ybj;
    }

    public void setYbj(BigDecimal ybj) {
        this.ybj = ybj;
    }

    public BigDecimal getRbj() {
        return rbj;
    }

    public void setRbj(BigDecimal rbj) {
        this.rbj = rbj;
    }

    public Integer getRnum() {
        return rnum;
    }

    public void setRnum(Integer rnum) {
        this.rnum = rnum;
    }

    public Integer getTnum() {
        return tnum;
    }

    public void setTnum(Integer tnum) {
        this.tnum = tnum;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Long getBaid() {
        return baid;
    }

    public void setBaid(Long baid) {
        this.baid = baid;
    }

    public BigDecimal getFmoney() {
        return fmoney;
    }

    public void setFmoney(BigDecimal fmoney) {
        this.fmoney = fmoney;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }
}
