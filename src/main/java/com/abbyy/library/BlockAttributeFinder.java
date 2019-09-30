package com.abbyy.library;

import java.util.ArrayList;
import java.util.List;

import com.abbyy.model.BlockInfo;

public class BlockAttributeFinder {

	public static List<BlockInfo> getBlockAttributeFinder(int top, int minleft, int maxleft,
			List<BlockInfo> blocklist) {
		List<BlockInfo> filterlist = new ArrayList<BlockInfo>();
		for (BlockInfo block : blocklist) {
			if (block.getTop() > (top) && (block.getLeft() < maxleft && block.getLeft() > minleft))
			{
				filterlist.add(block);
			}
		}
		return filterlist;
	}

}
