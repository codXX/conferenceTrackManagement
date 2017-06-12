package com.thoughtworks.conference.track.management.utils;

import java.util.UUID;

/**
 * @author xq
 * @since 17/6/11
 */
public class IdUtils {

	public static final String TRACK_ID_PREFIX = "track_";
	public static final String SESSION_ID_PREFIX = "session_";
	public static final String TALK_ID_PREFIX = "talk_";

	public static final String generateTrackId(){
		return TRACK_ID_PREFIX + UUID.randomUUID().toString();
	}
	public static final String generateSessionId(){
		return SESSION_ID_PREFIX + UUID.randomUUID().toString();
	}
	public static final String generateTalkId(){
		return TALK_ID_PREFIX + UUID.randomUUID().toString();
	}
}
