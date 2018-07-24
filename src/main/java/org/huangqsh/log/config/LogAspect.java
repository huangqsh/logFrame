package org.huangqsh.log.config;

import java.io.IOException;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	
	@Before("execution(* org.huangqsh.log.service..*.add*(..))&&@annotation(mylog)")
	public void MethedBefore(JoinPoint joinpoint , MyLog mylog) {
		String className = joinpoint.getSignature().getDeclaringTypeName();
		Logger aoplog = Logger.getLogger(className);
        aoplog.setLevel(Level.DEBUG);
		if(LogType.CONSOLE.equals(mylog.type())) {
			//日志输出到控制台
	        aoplog.addAppender(new ConsoleAppender(new PatternLayout("AOP-%d{yyyy-MM-dd HH\\:mm\\:ss} %p [%c]\\:%L Line - %m%n")));
			PrintLog(aoplog,mylog);
		}else if(LogType.FILE.equals(mylog.type())){
			String filename = "log/log.txt";
			//文件日志
			try {
				aoplog.addAppender(new FileAppender(new PatternLayout("%d{yyyy-MM-dd HH\\:mm\\:ss} %p [%c]\\:%L Line - %m%n"), filename));
			} catch (IOException e) {
				e.printStackTrace();
			}
			PrintLog(aoplog,mylog);
		}else {
			//TODO 其他日志
		}
	}

	
	/**
	 * 判断日志输出级别
	 * @param log
	 * @param mylog
	 */
	private void PrintLog(Logger log, MyLog mylog) {
		switch (mylog.level()) {
		case DEBUG:
			log.debug(mylog.message());
			break;
		case INFO:
			log.info(mylog.message());
			break;
		case WARN:
			log.warn(mylog.message());
			break;
		case ERROR:
			log.error(mylog.message());
			break;
			
		default:
			break;
		}
	}
}
