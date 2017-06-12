package com.thoughtworks.conference.track.management.domain;

/**
 * @author xq
 * @since 17/6/11
 */
public class Talk {

	private String talkId;
	private String theme;
	private String beginTime;
	private String endTime;
	private Integer interval;


	public String getTalkId() {
		return talkId;
	}

	public void setTalkId(String talkId) {
		this.talkId = talkId;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public Integer getInterval() {
		return interval;
	}

	public void setInterval(Integer interval) {
		this.interval = interval;
	}
}
