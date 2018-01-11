package top.zzh.enums;


public enum ControllerStatusEnum {
    HUSER_ROLE_MODIFY_SUCCESS(81,"ok","修改成功！"),
    HUSER_ROLE_SAVE_SUCCESS(82,"ok","保存成功！"),
    ROLE_UPDATE_STATUS_FAIL(83,"error","修改角色状态失败"),
    ROLE_UPDATE_STATUS_SUCCESS(84,"ok","修改角色状态成功"),
    PERMISSION_UPDATE_STATUS_SUCCESS(85,"ok","修改权限状态成功"),
    PERMISSION_UPDATE_STATUS_FAIL(86,"error","修改权限状态失败"),
    ROLE_PERMISSION_SAVE_PERMISSION_NULL(82,"permissionNull","该角色已无任何权限！"),
    ROLE_PERMISSION_SAVE_FAIL(87,"error","保存失败"),
    ROLE_PERMISSION_SAVE_SUCCESS(88,"ok","保存成功！"),
    ROLE_ADD_SUCCESS(89,"ok","角色新增成功！"),
    ROLE_ADD_FAIL(90,"error","角色新增失败"),
    ROLE_UPDATE_SUCCESS(91,"ok","修改角色成功！"),
    ROLE_UPDATE_FAIL(92,"error","修改角色失败"),
    PERMISSION_UPDATE_FAIL(93,"error","修改权限失败"),
    PERMISSION_UPDATE_SUCCESS(94,"ok","修改权限成功！"),
    PERMISSION_ADD_FAIL(95,"error","权限新增失败"),
    PERMISSION_ADD_SUCCESS(96,"ok","权限新增成功！"),
    UPLOAD_EXCEL_BUSY(97,"error","服务器繁忙，请稍后再试哦！"),
    UPLOAD_EXCEL_ERROR(98,"error","文件上传错误，请上传excel文件！"),
    UPLOAD_EXCEL_SUCCESS(99,"ok","文件上传成功,已成功导入数据库！"),

    USER_LOGIN_SUCCESS(100, "ok", "登录成功"),
    USER_LOGIN_ERROR_CODE(101, "error", "验证码错误"),
    USER_LOGIN_FAIL(102, "error", "用户名或密码错误"),
    USER_LOGIN_PHONEFAIL(006, "error", "手机号或密码错误"),
    USER_ALREADY_LOGIN(001, "logined", "已登录"),
    USER_LOGIN_ERROR_EXIST_POWER(002, "error", "账户不存在或者权限不足！"),
    USER_LOGIN_ERROR_EXIST(003, "error", "账户不存在！"),
    USER_LOGIN_ERROR_ALREADYEXIST(004, "error", "账户已存在！"),
    USER_REGISTER_FAIL(901,"error","手机号已存在！"),
    USER_LOGIN_ERROR_ALREADY_EXIST(005, "error", "用户名已存在！"),
    CASH_SAVE_SUCCESS(103, "ok", "添加成功"),
    CASH_SAVE_FAIL(104, "error", "添加失败，稍候再试"),
    CASH_UPDATE_SUCCESS(105, "ok", "修改成功"),
    CASH_UPDATE_FAIL(106, "error", "修改失败，稍候再试"),
    CASH_DELETE_SUCCESS(107, "ok", "删除成功"),
    CASH_DELETE_FAIL(108, "error", "删除失败，稍候再试"),
    CASH_PASSWORD_SUCCESS(109, "ok", "更新用户密码成功"),
    CASH_PASSWORD_FAIL(110, "error", "更新用户密码失败"),
    CHECK_PASSWORD_SUCCESS(112,"ok","检查原密码成功"),
    CHECK_PASSWORD_FAIL(113,"error","检查原密码失败"),
    CASH_ACTIVE_SUCCESS(112,"ok","激活成功"),
    CASH_ACTIVE_FAIL(113,"error","激活失败，请稍候再试"),
    CHECK_USER_SUCCESS(114,"ok","审核用户成功"),
    CHECK_USER_FAIL(115,"error","审核用户失败，请稍候再试"),
    BORROW_SAVE_WAIT(116,"ok","我们将在1个工作日之内完成审核"),
    TZM_FIND_FAIL(117,"error","该推荐码不存在"),
    CHECK_ERR_FAIL(118,"error","提现失败，请稍候再试"),
    USER_TZ_SUCCESS(119,"ok","恭喜你，投资成功！"),
    CHECK_TZ_FAIL(120,"error","投资失败，不能给自己投资"),
    USER_TZ_FAIL(121,"error","投资失败，请稍候再试"),
    CHECK_TZ_FAILED(123,"error","未投满"),
    USER_MONEY_ENOUGH(122,"error","用户余额不足，请立即充值"),
    SWAY_SAVE_SUCCESS(500,"ok","添加成功"),
    SWAY_SAVE_FAIL(501,"error","添加失败"),
    SWAY_UPDATE_SUCCESS(503,"ok","修改成功"),
    SWAY_UPDATE_FAIL(504,"error","修改失败"),
    SWAY_DELETE_SUCCESS(505,"ok","删除成功"),
    SWAY_DELETE_FAIL(506,"error","删除失败"),
    SWAY_UPDATE_STATE_SUCCESS(507,"ok","修改状态成功"),
    SWAY_UPDATE_STATE_FAIL(508,"error","修改状态失败"),
    BZ_SAVE_SUCCESS(509,"ok","添加成功"),
    BZ_SAVE_FAIL(510,"error","添加失败"),
    BZ_UPDATE_SUCCESS(511,"ok","修改成功"),
    BZ_UPDATE_FAIL(512,"error","修改失败"),
    BZ_DELETE_SUCCESS(513,"ok","删除成功"),
    BZ_DELETE_FAIL(514,"error","删除失败"),
    BZ_UPDATE_STATE_SUCCESS(515,"ok","修改状态成功"),
    BZ_UPDATE_STATE_FAIL(516,"error","修改状态失败"),
    JKLX_SAVE_SUCCESS(517,"ok","添加成功"),
    JKLX_SAVE_FAIL(518,"error","添加失败"),
    JKLX_UPDATE_SUCCESS(519,"ok","修改成功"),
    JKLX_UPDATE_FAIL(520,"error","修改失败"),
    JKLX_DELETE_SUCCESS(521,"ok","删除成功"),
    JKLX_DELETE_FAIL(522,"error","删除失败"),
    JKLX_UPDATE_STATE_SUCCESS(523,"ok","修改状态成功"),
    JKLX_UPDATE_STATE_FAIL(524,"error","修改状态失败"),
    FRIEND_SAVE_SUCCESS(525,"ok","添加成功"),
    FRIEND_SAVE_FAIL(526,"error","添加失败"),
    FRIEND_UPDATE_SUCCESS(527,"ok","修改成功"),
    FRIEND_UPDATE_FAIL(528,"error","修改失败"),
    FRIEND_DELETE_SUCCESS(529,"ok","删除成功"),
    FRIEND_DELETE_FAIL(530,"error","删除失败"),
    FRIEND_UPDATE_STATE_SUCCESS(531,"ok","修改状态成功"),
    FRIEND_UPDATE_STATE_FAIL(532,"error","修改状态失败"),
    NOTICE_SAVE_SUCCESS(525,"ok","添加成功"),
    NOTICE_SAVE_FAIL(526,"error","添加失败"),
    NOTICE_UPDATE_SUCCESS(527,"ok","修改成功"),
    NOTICE_UPDATE_FAIL(528,"error","修改失败"),
    NOTICE_DELETE_SUCCESS(529,"ok","删除成功"),
    NOTICE_DELETE_FAIL(530,"error","删除失败"),
    MEDIA_SAVE_SUCCESS(525,"ok","添加成功"),
    MEDIA_SAVE_FAIL(526,"error","添加失败"),
    MEDIA_UPDATE_SUCCESS(527,"ok","修改成功"),
    MEDIA_UPDATE_FAIL(528,"error","修改失败"),
    MEDIA_DELETE_SUCCESS(529,"ok","删除成功"),
    MEDIA_DELETE_FAIL(530,"error","删除失败"),
    MEDIA_UPDATE_STATE_SUCCESS(531,"ok","修改状态成功"),
    MEDIA_UPDATE_STATE_FAIL(532,"error","修改状态失败"),
    DYNAMIC_SAVE_SUCCESS(533,"ok","添加成功"),
    DYNAMIC_SAVE_FAIL(534,"error","添加失败"),
    DYNAMIC_UPDATE_SUCCESS(535,"ok","修改成功"),
    DYNAMIC_UPDATE_FAIL(536,"error","修改失败"),
    DYNAMIC_DELETE_SUCCESS(537,"ok","删除成功"),
    DYNAMIC_DELETE_FAIL(538,"error","删除失败"),
    DYNAMIC_UPDATE_STATE_SUCCESS(539,"ok","修改状态成功"),
    DYNAMIC_UPDATE_STATE_FAIL(540,"error","修改状态失败"),
    HOME_SAVE_SUCCESS(541,"ok","添加成功"),
    HOME_SAVE_FAIL(542,"error","添加失败"),
    HOME_UPDATE_SUCCESS(543,"ok","修改成功"),
    HOME_UPDATE_FAIL(544,"error","修改失败"),
    HOME_DELETE_SUCCESS(545,"ok","删除成功"),
    HOME_DELETE_FAIL(546,"error","删除失败"),
    HOME_UPDATE_STATE_SUCCESS(547,"ok","修改状态成功"),
    HOME_UPDATE_STATE_FAIL(548,"error","修改状态失败"),
    UESR_CHONG_SUCCESS(225,"ok","充值成功"),
    UESR_CHONG_FAIL(226,"error","充值失败"),
    TICKET_SAVE_SUCCESS(1125,"ok","保存成功"),
    TICKET_SAVE_FAIL(1126,"error","保存失败"),
    TICKET_UPDATE_SUCCESS(1128,"ok","修改成功"),
    TICKET_UPDATE_FAIL(1129,"error","修改失败"),
    TICKET_GETBYID_SUCCESS(1130,"ok","获取信息成功"),
    TICKET_GETBYID_FAIL(1131,"error","获取信息失败"),
    UERS_MONEY_FAIL(1132,"error","余额不足！审核失败"),
    UERS_BANK_FAIL(1142,"fail","银行卡已经绑定,不允许绑定多张银行卡！"),
    UERS_BANK_SUCCESS(1143,"ok","银行卡绑定成功!"),
    UERS_ERROR_FAIL(1142,"error","银行卡绑定失败！"),
    UERS_BANK_ERROR(1144,"error","银行卡号错误，请重新输入!"),
    UERS_ERROR_ERROR(1145,"error","支付密码错误，请重新输入！"),
    UERS_KEREN_ERROR(1146,"error","资料不足无法绑定银行卡，请完善个人资料！"),
    UERS_JCDIN_SUCCESS(1200,"ok","银行卡解绑成功！"),
    UERS_JCDIN_ERROR(1201,"error","银行卡解绑失败！")
    ;

    private Integer code;
    private String result;
    private String message;

    ControllerStatusEnum(Integer code, String result, String message) {
        this.code = code;
        this.result = result;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
