package com.thoughtworks.conference.track.management;

import com.thoughtworks.conference.track.management.domain.Session;

import java.util.Map;

/**
 * arrange talks to each session, can choose diff Distributor,
 * now only have RandomDistributor(random a talk to session,may has gap)
 *
 * @author xq
 * @since 17/6/11
 */

public interface Distributor {

	void arrangeTalk(Session session, Map<String, Integer> talkMap);
}
