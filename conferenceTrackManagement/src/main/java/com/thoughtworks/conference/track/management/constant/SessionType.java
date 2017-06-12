package com.thoughtworks.conference.track.management.constant;

/**
 * @author xiaoqing
 * @since 17/6/11
 */
public enum SessionType {

	MORNING_SESSION("AM", "09:00","12:00", 180),
	AFTERNOON_SESSION("PM", "01:00","05:00", 240);

	private String format;
	private String beginTime;
	private String endTime;
	private Integer minSum;

	SessionType(String format, String beginTime, String endTime, Integer minSum) {
		this.format = format;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.minSum = minSum;
	}


	public String getFormat() {
		return format;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public Integer getMinSum() {
		return minSum;
	}
}
