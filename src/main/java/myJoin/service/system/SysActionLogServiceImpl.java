package myJoin.service.system;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myJoin.dao.system.SysActionDao;
import myJoin.domain.system.SysActionLog;
import myJoin.service.system.pub.ISysActionLogService;

@Service
public class SysActionLogServiceImpl implements ISysActionLogService {

	@Autowired
	SysActionDao sysActionDao;
	public void createLog(String userName, String name, String type,
			String logName, String content, String url, String ip) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		SysActionLog sysActionLog = new SysActionLog();
		sysActionLog.setId(sdf.format(new Date()));
		sysActionLog.setActionUrl(url);
		sysActionLog.setContent(content);
		sysActionLog.setCreateTime(new Date());
		sysActionLog.setCreator(userName);
		sysActionLog.setIp(ip);
		sysActionLog.setLogName(logName);
		sysActionLog.setLogType(type);
		sysActionLog.setName(name);
		sysActionLog.setUserName(userName);
		sysActionDao.insert(sysActionLog);
	}

}
