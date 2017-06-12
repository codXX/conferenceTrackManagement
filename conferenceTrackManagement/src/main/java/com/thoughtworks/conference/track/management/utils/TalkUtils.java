package com.thoughtworks.conference.track.management.utils;

import com.thoughtworks.conference.track.management.constant.SessionType;
import com.thoughtworks.conference.track.management.domain.Session;
import com.thoughtworks.conference.track.management.domain.Track;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoqing
 * @since 17/6/11
 */
public class TalkUtils {

	private static final Integer trackMinNum
			= SessionType.MORNING_SESSION.getMinSum() + SessionType.AFTERNOON_SESSION.getMinSum();

	public static List<Track> generateTrack(Integer minSum){

		List<Track> tracks = new ArrayList<Track>();

		Integer trackNum = minSum / trackMinNum;
		trackNum = minSum % trackMinNum == 0 ? trackNum : trackNum + 1;

		while (trackNum > 0){
			List<Session> sessions = new ArrayList<Session>();
			Track track = new Track();
			track.setTrackId(IdUtils.generateTrackId());

			Session morningSession = new Session();
			morningSession.setSessionId(IdUtils.generateSessionId());
			morningSession.setType(SessionType.MORNING_SESSION);
			sessions.add(morningSession);

			if (minSum > SessionType.MORNING_SESSION.getMinSum()){
				Session afternoonSession = new Session();
				afternoonSession.setSessionId(IdUtils.generateSessionId());
				afternoonSession.setType(SessionType.AFTERNOON_SESSION);
				sessions.add(afternoonSession);
			}

			track.setSessions(sessions);
			tracks.add(track);
			minSum = minSum - trackMinNum;
			trackNum --;
		}

		return tracks;
	}

	public static String getNextBeginTime(Session session, String beginTime, Integer min){

		String nextBeginTime = "";
		String minTime = beginTime.substring(beginTime.indexOf(":") + 1, beginTime.length());
		Integer sessionMin = minTime.equals("00") ? 0 : Integer.parseInt(minTime);

		Integer sessionHour =
				Integer.parseInt(beginTime.substring(0, beginTime.indexOf(":")));
		sessionMin = sessionMin + min;
		if (sessionMin >= 60){
			sessionHour ++;
			sessionMin = sessionMin - 60;
		}

		String sessionMinString = "";
		if (sessionMin == 0){
			sessionMinString = "00";
		} else if (sessionMin < 10){
			sessionMinString = "0" + sessionMin;
		} else {
			sessionMinString = "" + sessionMin;
		}
		if (sessionHour < 10){
			nextBeginTime = "0" + sessionHour + ":" + sessionMinString;
		} else {
			nextBeginTime = sessionHour + ":" + sessionMinString;
		}
		return nextBeginTime;
	}
}
