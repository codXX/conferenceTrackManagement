package com.thoughtworks.conference.track.management;

import com.thoughtworks.conference.track.management.domain.Session;
import com.thoughtworks.conference.track.management.domain.Talk;
import com.thoughtworks.conference.track.management.utils.TalkUtils;
import com.thoughtworks.conference.track.management.utils.IdUtils;

import java.util.*;

/**
 * @author xq
 * @since 17/6/11
 */
public class RandomDistributor implements Distributor {

	public void arrangeTalk(Session session, Map<String, Integer> talkMap) {

		List<String> talkList = new ArrayList<String>(talkMap.keySet());

		Integer minSum = session.getType().getMinSum();
		List<Talk> talks = new LinkedList<Talk>();

		String sessionBeginTime = session.getType().getBeginTime();

		while (minSum > 0 && talkList.size() > 0){

			Random random = new Random();
			Integer randomIndex = random.nextInt(talkList.size());
			String talkTheme = talkList.get(randomIndex);

			Integer min = talkMap.get(talkTheme);

			talkList.remove(talkTheme);
			if (min <= minSum){
				Talk talk = new Talk();
				talk.setTalkId(IdUtils.generateTalkId());
				talk.setInterval(min);
				talk.setBeginTime(sessionBeginTime);

				String nextBeginTime = TalkUtils.getNextBeginTime(session, sessionBeginTime, min);
				talk.setEndTime(nextBeginTime);
				talk.setTheme(talkTheme);
				talks.add(talk);

				sessionBeginTime = nextBeginTime;
				minSum = minSum - min;
			}
		}


		for (Talk talk : talks){
			talkMap.remove(talk.getTheme());
		}

		session.setTalkList(talks);
		session.setEndTime(session.getTalkList().get(session.getTalkList().size() - 1).getEndTime());

	}
}
