package com.thoughtworks.conference.track.management.domain;


import java.util.List;

/**
 * @author xiaoqing
 * @since 17/6/11
 */
public class Track {

	private String trackId;

	private List<Session> sessions;

	public String getTrackId() {
		return trackId;
	}

	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}
}
