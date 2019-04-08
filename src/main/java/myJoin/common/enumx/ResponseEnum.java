package myJoin.common.enumx;
/**
 * 返回响应状态枚举
 * @author x
 *
 */
public enum ResponseEnum {
	/**	登录校验枚举 **/
	LOGIN_SUCC("1","登陆成功！"),
	LOGIN_FAIL("0","登陆失败！"),
	/** 格式校验枚举 **/
	VALIDATE_ISNULL("100001","{0} 数据项为空!"),
	VALIDATE_FORMAT("100002","{0} 数据项格式有误!"),
	VALIDATE_RESULT_ISNULL("100003","{0} 结果集为空!"),
	VALIDATE_ENUM_ERROR("100004","{0} 枚举项解析异常! {1}"),
	VALIDATE_BEANTOMAP_ERROR("100005","Bean转换Map异常!"),
	VALIDATE_COLLECTION_ISNULL("100006","{0} 集合数据项为空!"),
	VALIDATE_ARRAY_ISNULL("100007","{0} 数组项为空!"),
	
	/** 系统枚举 **/
	SYS_SUCCESS("000000","正常"),
	SYS_FAILD("900000","系统忙"),
	SYS_EXIST("900000","已经存在，请重新输入"),
	SYS_ErrorActionCode("900001","没有操作权限"),
	SYS_SessionOutActionCode("900002","会话超时"),
	SYS_WARN("000001","可忽略异常"),
	
	/** 文件上传枚举 **/
	FILE_EMPTY_FILE("F000001","导入的文件为空，拒绝导入！"),
	FILE_SIZE_OUT_RANGE("F000002","导入的文件过大，文件大小不能超过 {0}！"),
	FILE_ERROR_TYPE("F000003","导入的文件类型错误，拒绝导入！"),
	FILE_ERROR_PARSE("F000004","解析文件出错：{0}！"),
	FILE_ERROR_WRITE("F000005","写入文件出错：{0}！"),
	FILE_ERROR_FORMAT_CONTENT("F000006","文件内容必须从第{0}行开始！"),
	FILE_NO_FILE("F000007", "所需文件未生成或已失效！"),
	
	/** 异常信息完全自定义 **/
	FULL_MSG("800000","{0}");
	
	private final String code;
	private final String desc;

	private ResponseEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
	
}
