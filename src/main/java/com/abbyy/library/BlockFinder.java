package com.abbyy.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.abbyy.model.BlockFinderParam;
import com.abbyy.model.BlockInfo;

public class BlockFinder {
	private static final Logger logger = LoggerFactory.getLogger(BlockFinder.class);

	public static BlockFinderParam blockNameFinder(BlockInfo block) {

		BlockFinderParam blockParam = null;

		if (block.getText().contains("Equipment Configuration")) {
			// return "String";
			logger.info("Equipment Configuration");
			// BlockAttributeFinder.getBlockAttributeFinder(block.getTop(), block.getLeft(),
			// block);

		}

		if (block.getText().contains("Information")) {
			// BlockAttributeFinder.getBlockAttributeFinder(block.getTop(), block.getLeft(),
			// block);
		}
		if (block.getText().contains("Line action")) {

			// BlockAttributeFinder.getBlockAttributeFinder(block.getTop(), block.getLeft(),
			// block);
		}
		if (block.getText().contains("Proxies")) {

			logger.info("Profiles");
			blockParam = new BlockFinderParam(block.getTop(), BlockConstants.profile_min_left,
					BlockConstants.profile_max_left, "Profiles");
			return blockParam;

		}

		return null;
	}

}
