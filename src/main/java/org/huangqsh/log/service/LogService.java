package org.huangqsh.log.service;

import org.huangqsh.log.config.LogLevel;
import org.huangqsh.log.config.LogType;
import org.huangqsh.log.config.MyLog;
import org.springframework.stereotype.Service;

@Service
public class LogService {
	
	@MyLog( type = LogType.FILE,
			level = LogLevel.INFO,
			message = "这是一条日志",
			remark = "remark"
			)
	public void add() {
		System.out.println("LogService method ---->add()");
	}
}
