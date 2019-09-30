package com.abbyy.library;

import com.abbyy.model.BlockInfo;

public class BlockAttributeFinder {

	public  static BlockInfo getBlockAttributeFinder(int top, int left, BlockInfo block) {

		if (block.getTop() < (top + 3) || block.getTop() > (top - 3) && block.getLeft() < (left + 3)
				|| block.getLeft() > (left - 3)) {

			return block;

		}

		return null;
	}

}
