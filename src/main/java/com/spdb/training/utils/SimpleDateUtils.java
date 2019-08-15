package com.spdb.training.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @ClassName: SimpleDateUtils
* @Description: TODO:获取时间简单格式
* @author Robin
* @date 2019年8月15日
*
*/

public class SimpleDateUtils {
	/**
	 * 获取YYYYMMDD
	 * @return
	 */
	public static String getYYYYMMDD() {
		SimpleDateFormat dFormat = new SimpleDateFormat("YYYYMMDD");
		return dFormat.format(new Date());
	}
	
	/**
	 * 获取HHMMSS
	 * @return
	 */
	public static String getHHMMSS() {
		SimpleDateFormat dFormat = new SimpleDateFormat("HHMMSS");
		return dFormat.format(new Date());
	}
}
