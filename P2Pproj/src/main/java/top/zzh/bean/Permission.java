package top.zzh.bean;

/**
 * Created by Administrator on 2017/12/21 0021.
 */
public class Permission {
    private Integer id;
    private String url;
    private String desZh;
    private Integer moduleId;
    private Integer status;     // 1：激活  2：冻结
    private Integer sign;   //标记有没有该权限有没有被分配角色

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesZh() {
        return desZh;
    }

    public void setDesZh(String desZh) {
        this.desZh = desZh;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }
}
