package com.thoughtworks.conference.track.management;

import com.thoughtworks.conference.track.management.domain.Track;

import java.util.List;

/**
 * print talk schedule
 *
 * @author xq
 * @since 17/6/11
 */
public interface Printer {

	void printTalkCalendar(List<Track> tracks);
}
