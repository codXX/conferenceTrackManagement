package com.thoughtworks.conference.track.management.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xq
 * @since 17/6/11
 */
public class FileUtils {

	public static List<String> loadResourceFile(String resourcePath){

		File file = new File(resourcePath);
		BufferedReader reader = null;
		List<String> resourceList = new ArrayList<String>();
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = null;

			while ((line = reader.readLine()) != null) {
				resourceList.add(line);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return resourceList;
	}
}
