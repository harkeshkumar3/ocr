package com.abbyy.library;

import java.util.List;

import com.abbyy.model.BlockInfo;

public class PageTrackingLibrary {

	public void pageUniqueConstantFinder() {

	}

	public static BlockInfo screenFinder(List<BlockInfo> blockList) {

		for (BlockInfo block : blockList) {

			BlockFinder.blockNameFinder(block);
		}

		return null;
	}

}
