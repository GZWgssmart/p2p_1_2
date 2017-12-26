package top.zzh.bean;

/**
 * Created by Administrator on 2017/12/21 0021.
 */
public class Permission {
    private Integer id;
    private String permission;
    private String desZh;
    private Integer moduleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
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
}
