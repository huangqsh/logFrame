package org.huangqsh.log.config;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyLog {

	/**
	 * 日志输出类型
	 * @return
	 */
	LogType type();
	
	/**
	 * 日志级别
	 * @return
	 */
	LogLevel level();
	
	/**
	 * 日志消息
	 * @return
	 */
	String message() default " ";
	
	/**
	 * 备注
	 * @return
	 */
	String remark() default " ";
}
