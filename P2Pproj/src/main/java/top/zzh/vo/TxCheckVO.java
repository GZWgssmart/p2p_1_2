package top.zzh.vo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
/**
 * @Cander 陈桢 2017/12/25
 */
public class TxCheckVO {
    private String rname;//审核姓名
    private String bankcard;//银行卡号
    private String banktype;//所属银行
    private BigDecimal money;//提现金额
    private Integer isok;//审核是否通过，0通过，1未通过
    private String excute;//审核理由
    private Timestamp dateTime;//审核时间

    public TxCheckVO(String rname, String bankcard, String banktype, BigDecimal money, Integer isok, String excute, Timestamp dateTime) {
        this.rname = rname;
        this.bankcard = bankcard;
        this.banktype = banktype;
        this.money = money;
        this.isok = isok;
        this.excute = excute;
        this.dateTime = dateTime;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    public String getBanktype() {
        return banktype;
    }

    public void setBanktype(String banktype) {
        this.banktype = banktype;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getIsok() {
        return isok;
    }

    public void setIsok(Integer isok) {
        this.isok = isok;
    }

    public String getExcute() {
        return excute;
    }

    public void setExcute(String excute) {
        this.excute = excute;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }
}
