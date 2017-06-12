package com.thoughtworks.conference.track.management;

import java.util.List;
import java.util.Map;

/**
 * convert talk_list.txt, In addition to Standard format
 *
 * @author xiaoqing
 * @since 17/6/11
 */
public interface Converter {
	Map<String, Integer> formatTalkList(List<String> talkList);

}
