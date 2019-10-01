package com.abbyy.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.abbyy.model.BlockFinderParam;
import com.abbyy.model.BlockInfo;

public class BlockFinder {
	private static final Logger logger = LoggerFactory.getLogger(BlockFinder.class);

	public static BlockFinderParam blockNameFinder(BlockInfo block) {

		BlockFinderParam blockParam = null;
		logger.info("Enter Block Name" + block.getText());

		if (block.getText().contains("Equipment Configuration")) {
			// return "String";
			logger.info("Equipment Configuration");
			// BlockAttributeFinder.getBlockAttributeFinder(block.getTop(), block.getLeft(),
			// block);

		}

		if (block.getText().contains("Information")) {
			logger.info("Information");
			blockParam = new BlockFinderParam(block.getTop(), BlockConstants.RIGHT_BLOCK_MIN_LEFT,
					BlockConstants.RIGHT_BLOCK_MAX_LEFT, "Information");
			return blockParam;
		}
		if (block.getText().contains("Line action")|| block.getText().contains("Lne")) {
			logger.info("Line action");
			blockParam = new BlockFinderParam(block.getTop(), BlockConstants.MIDDLE_BLOCK_MIN_LEFT,
					BlockConstants.MIDDLE_BLOCK_MAX_LEFT, "Line action");
			return blockParam;
		}
		if (block.getText().contains("Power managment")) {
			logger.info("Power managment");
			blockParam = new BlockFinderParam(block.getTop(), BlockConstants.MIDDLE_BLOCK_MIN_LEFT,
					BlockConstants.MIDDLE_BLOCK_MAX_LEFT, "Power managment");
			return blockParam;
		}
		if (block.getText().contains("Proxies")) {

			logger.info("Profiles");
			blockParam = new BlockFinderParam(block.getTop(), BlockConstants.MIDDLE_BLOCK_MIN_LEFT,
					BlockConstants.MIDDLE_BLOCK_MAX_LEFT, "Profiles");
			return blockParam;

		}

		return null;
	}

}
