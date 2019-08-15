package com.spdb.training.log;
/**
 * »’÷æ
 * @author wanglw2
 *
 */
public class LoggerFactory {
	public static ILog getLogger(Class<?> clazz){
		ILog log = new SimpleLogger(clazz);
		return log;
	}
	
	
	
	public static void main(String[] a){
		ILog log = LoggerFactory.getLogger(LoggerFactory.class);
		log.info("this is a test");
		log.warn("this {} is a test:{}",new Object[]{"a","b"});
		log.error("error", new RuntimeException("test error"));
	}
}
