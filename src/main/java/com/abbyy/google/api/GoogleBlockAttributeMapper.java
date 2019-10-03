package com.abbyy.google.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.abbyy.library.BlockConstants;

public class GoogleBlockAttributeMapper {

	private static final Logger logger = LoggerFactory.getLogger(GoogleBlockAttributeMapper.class);

	public static List<GooglefilterSet> getGoogleJsonAttributeMapper(List<GooglefilterSet> sList) {

		sList.forEach(s -> {

			if (s.getText().contains(BlockConstants.profiles_block)) {

				logger.info("Profile Match" + s.getText());
				profileAttributeFinder(sList);
			}

			if (s.getText().contains(BlockConstants.INFORMATION_BLOCK)) {
				logger.info("information Block Found" + s.getText());
				// googleBlockKeyValueFinder(sList, s.getTop(), s.getBottom(), s.getText());

			}

			if (s.getText().contains(BlockConstants.LINE_ACTION_BLOCK)) {
				logger.info("Line Action Block Found" + s.getText());
				// googleBlockKeyValueFinder(sList, s.getTop(), s.getBottom(), s.getText());
			}
		});

		return sList;

	}

	private static void profileAttributeFinder(List<GooglefilterSet> sList) {

		sList.forEach(s -> {

			if (s.getText().equals("Alarm severity:")) {

				logger.info("Profile Match" + s.getText());
				googleBlockKeyValueFinder(sList, s.getTop(), s.getBottom(), s.getText());
			}

			if (s.getText().equals("XDSL Line:")) {
				logger.info("information Block Found" + s.getText());
				googleBlockKeyValueFinder(sList, s.getTop(), s.getBottom(), s.getText());

			}

			if (s.getText().contains(BlockConstants.profiles_block_custom_notch)) {
				logger.info("Line Action Block Found" + s.getText());
				googleBlockKeyValueFinder(sList, s.getTop(), s.getBottom(), s.getText());
			}
			if (s.getText().contains(BlockConstants.PROFILES_BLOCK_UPSTREAM_PSD_MARK)) {
				logger.info("Line Action Block Found" + s.getText());
				googleBlockKeyValueFinder(sList, s.getTop(), s.getBottom(), s.getText());
			}
			if (s.getText().contains(BlockConstants.PROFILES_BLOCK_DOWNSTREAM_PSD_MARK)) {
				logger.info("Line Action Block Found" + s.getText());
				googleBlockKeyValueFinder(sList, s.getTop(), s.getBottom(), s.getText());
			}
			if (s.getText().contains(BlockConstants.PROFILES_BLOCK_EVENT)) {
				logger.info("Line Action Block Found" + s.getText());
				googleBlockKeyValueFinder(sList, s.getTop(), s.getBottom(), s.getText());
			}
			if (s.getText().contains(BlockConstants.PROFILES_BLOCK_CHANNEL1)) {
				logger.info("Line Action Block Found" + s.getText());
				googleBlockKeyValueFinder(sList, s.getTop(), s.getBottom(), s.getText());
			}
		});
	}

	private static void googleBlockKeyValueFinder(List<GooglefilterSet> list, int top, int bottom, String text) {

		list.forEach(s -> {
			if ((top - 2) >= s.getTop() && (top + 2) <= s.getTop()) {

				System.out.println("Match Found " + s.getTop() + "/" + top + " [ " + text + " : " + s.getText());

			}
		});

	}

}
