package myJoin.common.enumx;
/**
 * 系统行为类型枚举
 * @author x
 *
 */
public enum SysActionTypeEnum {

	登录("0","登录"),
	登出("9","登出"),
	新增("1","新增"),
	删除("2","删除"),
	修改("3","修改"),
	查询("4","查询"),
	导入("5","导入"),
	导出("6","导出"),
	跳转("7","跳转"),
	其他("8","其他");
	
	private String code;

	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	SysActionTypeEnum(String code,String msg){
		this.code=code;
		this.msg=msg;
	}
	
}
