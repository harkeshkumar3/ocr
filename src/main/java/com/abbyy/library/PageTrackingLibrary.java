package com.abbyy.library;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.abbyy.formatter.ProfileFormat;
import com.abbyy.model.BlockFinderParam;
import com.abbyy.model.BlockInfo;

public class PageTrackingLibrary {

	private static final Logger logger = LoggerFactory.getLogger(PageTrackingLibrary.class);

	public static BlockInfo screenFinder(List<BlockInfo> blockList) {

		for (BlockInfo block : blockList) {
			BlockFinderParam blockNameFinder = BlockFinder.blockNameFinder(block);
			if (blockNameFinder != null) {

				if (blockNameFinder.getBlockName().equals("Profiles")) {
					List<BlockInfo> blockAttributeFinder = BlockAttributeFinder.getBlockAttributeFinder(
							blockNameFinder.getTop(), blockNameFinder.getMinleft(), blockNameFinder.getMaxleft(),
							blockList);
					ProfileFormat profileBlockAttributeMapper = BlockAttributeMapper.getProfileBlockAttributeMapper(blockAttributeFinder, BlockConstants.profiles_block);
				
					System.out.println(profileBlockAttributeMapper);
				}
			}
		}
		return null;
	}

}
