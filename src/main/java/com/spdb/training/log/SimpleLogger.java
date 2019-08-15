package com.spdb.training.log;

/**
 * ����־ʵ�� ֱ��ʹ��System.out���
 * 
 * @author wanglw2
 *
 */
public class SimpleLogger implements ILog {

	private static String defaultLogLevel = System.getProperty("LOG_LEVEL");

	private int currentLogLevel = defaultLogLevel == null ? 0 : formalizeLogLevel(defaultLogLevel);

	public SimpleLogger(Class<?> clazz) {
		this.clazz = clazz;
	}

	/**
	 * ʹ����־��¼��class
	 */
	private Class<?> clazz;

	/**
	 * ��־�ı�
	 * 
	 * @param logType
	 * @param msg
	 * @return
	 */
	private String getLogText(LogEnum logType, String msg) {
		StringBuffer logSB = new StringBuffer();
		logSB.append((clazz == null ? "" : clazz.getName() + ":"));
		logSB.append(logType.getPreLogText()).append("-").append(msg);
		return logSB.toString();
	}

	/**
	 * ���ݸ�ʽ��Ϣ��ȡ������Ϣ���� ���磺getMsg("֤���ţ�{} ������ ","001002") ->
	 * "֤���ţ�001002 ������"
	 * 
	 * @param msg
	 * @param args
	 * @return
	 */
	private String getMsg(String msg, Object... args) {
		for (Object object : args) {
			msg = msg.replaceFirst("\\{\\}", object == null ? "null" : object.toString());
		}
		return msg;
	}

	@Override
	public void info(String msg) {
		if(!isAboveCurrentLogLevel(LogEnum.INFO.getLogLevel())) return;
		String logT = getLogText(LogEnum.INFO, msg);
		System.out.println(logT);
	}

	@Override
	public void info(String msg, Throwable t) {
		if(!isAboveCurrentLogLevel(LogEnum.INFO.getLogLevel())) return;
		String logT = getLogText(LogEnum.INFO, msg);
		System.out.println(logT);
		t.printStackTrace(System.err);
	}

	@Override
	public void info(String msg, Object... args) {
		if(!isAboveCurrentLogLevel(LogEnum.INFO.getLogLevel())) return;
		String logT = getLogText(LogEnum.INFO, getMsg(msg, args));
		System.out.println(logT);
	}

	@Override
	public void warn(String msg) {
		if(!isAboveCurrentLogLevel(LogEnum.WARN.getLogLevel())) return;
		String logT = getLogText(LogEnum.WARN, msg);
		System.out.println(logT);
	}

	@Override
	public void warn(String msg, Throwable t) {
		if(!isAboveCurrentLogLevel(LogEnum.WARN.getLogLevel())) return;
		String logT = getLogText(LogEnum.WARN, msg);
		System.out.println(logT);
		t.printStackTrace(System.err);
	}

	@Override
	public void warn(String msg, Object... args) {
		if(!isAboveCurrentLogLevel(LogEnum.WARN.getLogLevel())) return;
		String logT = getLogText(LogEnum.WARN, getMsg(msg, args));
		System.out.println(logT);
	}

	@Override
	public void error(String msg) {
		if(!isAboveCurrentLogLevel(LogEnum.ERROR.getLogLevel())) return;
		String logT = getLogText(LogEnum.ERROR, msg);
		System.err.println(logT);
	}

	@Override
	public void error(String msg, Throwable t) {
		if(!isAboveCurrentLogLevel(LogEnum.ERROR.getLogLevel())) return;
		String logT = getLogText(LogEnum.ERROR, msg);
		System.err.println(logT);
		t.printStackTrace(System.err);
	}

	@Override
	public void error(String msg, Object... args) {
		if(!isAboveCurrentLogLevel(LogEnum.ERROR.getLogLevel())) return;
		String logT = getLogText(LogEnum.ERROR, getMsg(msg, args));
		System.err.println(logT);
	}

	@Override
	public void debug(String msg) {
		if(!isAboveCurrentLogLevel(LogEnum.DEBUG.getLogLevel())) return;
		String logT = getLogText(LogEnum.DEBUG, msg);
		System.out.println(logT);
	}

	@Override
	public void debug(String msg, Throwable t) {
		if(!isAboveCurrentLogLevel(LogEnum.DEBUG.getLogLevel())) return;
		String logT = getLogText(LogEnum.DEBUG, msg);
		System.out.println(logT);
		t.printStackTrace(System.out);
	}

	@Override
	public void debug(String msg, Object... args) {
		if(!isAboveCurrentLogLevel(LogEnum.DEBUG.getLogLevel())) return;
		String logT = getLogText(LogEnum.DEBUG, getMsg(msg, args));
		System.out.println(logT);
	}

	public int getCurrentLogLevel() {
		return currentLogLevel;
	}

	public void setCurrentLogLevel(String currentLogLevel) {
		this.currentLogLevel = formalizeLogLevel(currentLogLevel);
	}

	public static String getDefaultLogLevel() {
		return defaultLogLevel;
	}

	/**
	 * 
	 * @param levelInput
	 * @return
	 */
	private boolean isAboveCurrentLogLevel(int levelInput) {
		if (levelInput >= currentLogLevel) {
			return true;
		}

		return false;

	}

	public int formalizeLogLevel(String logLevel) {
		logLevel = logLevel != null ? logLevel.toUpperCase() : logLevel;
		int level = LogEnum.DEBUG.getLogLevel();
		switch (logLevel) {
		case ("DEBUG"):
			level = LogEnum.DEBUG.getLogLevel();
			break;
		case ("INFO"):
			level = LogEnum.INFO.getLogLevel();
			break;
		case ("WARN"):
			level = LogEnum.WARN.getLogLevel();
			break;
		case ("ERROR"):
			level = LogEnum.ERROR.getLogLevel();
			break;

		default:
			break;
		}

		return level;

	}

}
