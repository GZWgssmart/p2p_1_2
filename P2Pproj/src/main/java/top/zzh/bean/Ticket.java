package top.zzh.bean;

import java.math.BigDecimal;
import java.util.Date;

//优惠券表
public class Ticket {
    private Integer kid;

    private Byte type;//优惠券类型，如现金劵，代金券，体验金,加息券

    private BigDecimal tkmoney;//优惠券金额

    private Date tktime;//有效时间

    private String tname;//优惠卷名称

    private String tintro;//优惠卷简介
    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTintro() {
        return tintro;
    }

    public void setTintro(String tintro) {
        this.tintro = tintro;
    }


    public Ticket(Integer kid, Byte type, BigDecimal tkmoney, Date tktime, String tname, String tintro) {
        this.kid = kid;
        this.type = type;
        this.tkmoney = tkmoney;
        this.tktime = tktime;
        this.tname = tname;
        this.tintro = tintro;
    }

    public Ticket() {
        super();
    }

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public BigDecimal getTkmoney() {
        return tkmoney;
    }

    public void setTkmoney(BigDecimal tkmoney) {
        this.tkmoney = tkmoney;
    }

    public Date getTktime() {
        return tktime;
    }

    public void setTktime(Date tktime) {
        this.tktime = tktime;
    }
}