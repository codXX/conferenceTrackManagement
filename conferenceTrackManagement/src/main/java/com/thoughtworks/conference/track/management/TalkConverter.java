package com.thoughtworks.conference.track.management;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xq
 * @since 17/6/11
 */
public class TalkConverter implements Converter {

	private static final Logger logger = LoggerFactory.getLogger(TalkConverter.class);
	private static final String LIGHTNING = "lightning";

	public Map<String, Integer> formatTalkList(List<String> talkList) {
		Map<String, Integer> talkThemeToTimeMap = new HashMap<String, Integer>();
		try {
			for (String resource : talkList){
				Integer splitPoint = resource.lastIndexOf(" ");

				String theme = resource.substring(0, splitPoint);
				String time = resource.substring(splitPoint + 1);
				Integer talkTime = 0;

				if (LIGHTNING.equals(time)){
					talkTime = 5;
				} else {
					talkTime = Integer.parseInt(time.substring(0, time.length() - 3));
				}

				if (talkThemeToTimeMap.containsKey(theme)){
					logger.info("duplicate key.key={}", theme);
				}
				talkThemeToTimeMap.put(theme, talkTime);
			}
			return talkThemeToTimeMap;
		} catch (NumberFormatException e){
			logger.error("format resource error.", e);
			return new HashMap<String, Integer>();
		}
	}
}
