package myJoin.domain.system;


import myJoin.framework.domain.BaseDomain;
/**
 * 系统日志实体类
 * @author x
 *
 */
public class SysActionLog extends BaseDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3191403481292234249L;

	private String id;

    private String logType;

    private String logName;

    private String name;

    private String userName;

    private String content;

    private String memo;

    private String ip;

    private String actionUrl;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getLogName() {
		return logName;
	}

	public void setLogName(String logName) {
		this.logName = logName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getActionUrl() {
		return actionUrl;
	}

	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}
    
    
    

}
