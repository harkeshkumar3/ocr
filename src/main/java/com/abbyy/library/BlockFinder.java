package com.abbyy.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.abbyy.model.BlockInfo;

public class BlockFinder {
	private static final Logger logger = LoggerFactory.getLogger(BlockFinder.class);

	public static BlockInfo blockNameFinder(BlockInfo block) {

		if (block.getText() == "Equipment Configuration") {
			// return "String";
			logger.info("Equipment Configuration");
			BlockAttributeFinder.getBlockAttributeFinder(block.getTop(), block.getLeft(), block);

		}

		if (block.getText() == "Information") {
			BlockAttributeFinder.getBlockAttributeFinder(block.getTop(), block.getLeft(), block);
		}
		if (block.getText() == "Line action") {

			BlockAttributeFinder.getBlockAttributeFinder(block.getTop(), block.getLeft(), block);
		}
		if (block.getText() == "Profiles") {

			logger.info("Profiles");
			BlockInfo blockAttributeFinder = BlockAttributeFinder.getBlockAttributeFinder(block.getTop(),
					block.getLeft(), block);
			logger.info(blockAttributeFinder.getText());

		}

		return null;
	}

}
