package myJoin.service.system.pub;

/**
 * 系统日志Service接口
 * @author x
 *
 */
public interface ISysActionLogService {

	/**
	 * 生成系统日志
	 * @param userName
	 * @param name
	 * @param type
	 * @param logName
	 * @param content
	 * @param url
	 * @param ip
	 */
	public void createLog(String userName,String name,String type,String logName, String content, String url, String ip);
}
