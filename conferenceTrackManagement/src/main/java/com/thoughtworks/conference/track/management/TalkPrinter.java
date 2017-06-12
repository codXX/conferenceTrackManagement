package com.thoughtworks.conference.track.management;

import com.thoughtworks.conference.track.management.constant.SessionType;
import com.thoughtworks.conference.track.management.domain.Session;
import com.thoughtworks.conference.track.management.domain.Talk;
import com.thoughtworks.conference.track.management.domain.Track;

import java.util.List;

/**
 * @author xiaoqing
 * @since 17/6/11
 */
public class TalkPrinter implements Printer {

	public void printTalkCalendar(List<Track> tracks) {

		for (Track track : tracks){
			System.out.print("Track " + track.getTrackId() + ":\n");
			for (Session session : track.getSessions()){
				for (Talk talk : session.getTalkList()){

					StringBuilder talkPrint = new StringBuilder();
					talkPrint.append(talk.getBeginTime())
							.append(session.getType().getFormat())
							.append(" ")
							.append(talk.getTheme())
							.append(" ")
							.append(talk.getInterval() + "min")
							.append("\n");
					System.out.print(talkPrint.toString());
				}

				if (session.getType().equals(SessionType.MORNING_SESSION)){
					System.out.print("12:00PM Lunch\n");
				}

				if (session.getType().equals(SessionType.AFTERNOON_SESSION)){
					if (session.getEndTime().startsWith("04") || session.getEndTime().startsWith("05")){
						System.out.print("05:00PM Networking Event\n");
					} else {
						System.out.print("04:00PM Networking Event\n");
					}
				}
			}
		}
	}
}
