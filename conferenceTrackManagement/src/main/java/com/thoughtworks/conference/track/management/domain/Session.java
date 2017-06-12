package com.thoughtworks.conference.track.management.domain;

import com.thoughtworks.conference.track.management.constant.SessionType;

import java.util.List;

/**
 * @author xq
 * @since 17/6/11
 */
public class Session {

	private String sessionId;
	private SessionType type;
	private String endTime;
	private List<Talk> talkList;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public SessionType getType() {
		return type;
	}

	public void setType(SessionType type) {
		this.type = type;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public List<Talk> getTalkList() {
		return talkList;
	}

	public void setTalkList(List<Talk> talkList) {
		this.talkList = talkList;
	}
}
