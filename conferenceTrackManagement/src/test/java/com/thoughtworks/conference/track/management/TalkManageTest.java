package com.thoughtworks.conference.track.management;

import junit.framework.TestCase;

/**
 * Created by xiaoqing on 17/6/11.
 */
public class TalkManageTest extends TestCase {

	public void testArrangeTalk() throws Exception {

		String resourcePath = "./src/main/resources/talk_list.txt";
		Converter converter = new TalkConverter();
		Distributor distributor = new RandomDistributor();
		Printer printer = new TalkPrinter();

		TalkManage talkManage = new TalkManage(resourcePath, converter, distributor, printer);

		talkManage.arrange();
		talkManage.print();
	}

}