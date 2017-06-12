package com.thoughtworks.conference.track.management;

import com.thoughtworks.conference.track.management.domain.Session;
import com.thoughtworks.conference.track.management.domain.Track;
import com.thoughtworks.conference.track.management.utils.FileUtils;
import com.thoughtworks.conference.track.management.utils.TalkUtils;

import java.util.*;

/**
 * @author xq
 * @since 17/6/11
 */
public class TalkManage {

	private String resourcePath;

	private Converter converter;

	private Distributor distributor;

	private Printer printer;

	private List<Track> tracks;

	public TalkManage(String resourcePath, Converter converter, Distributor distributor, Printer printer) {
		this.resourcePath = resourcePath;
		this.converter = converter;
		this.distributor = distributor;
		this.printer = printer;
	}

	public void arrange(){
		List<String> talkList = FileUtils.loadResourceFile(resourcePath);
		Map<String, Integer> talkMap = converter.formatTalkList(talkList);

		initTrack(talkMap);

		for (Track track : tracks){
			for (Session session : track.getSessions()){
				distributor.arrangeTalk(session, talkMap);
			}
		}

		//todo:need balance,may has gap in sessions
	}


	public void print(){
		printer.printTalkCalendar(tracks);
	}

	private void initTrack( Map<String, Integer> talkMap){
		Collection<Integer> times = talkMap.values();
		Integer minSum = 0;
		for (Integer time : times){
			minSum += time;
		}
		tracks = TalkUtils.generateTrack(minSum);
	}
}
