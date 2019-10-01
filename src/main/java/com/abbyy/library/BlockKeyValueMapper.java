package com.abbyy.library;

import java.util.List;

import org.slf4j.Logger;

import com.abbyy.model.BlockInfo;

public class BlockKeyValueMapper {

	public static String getAttributeMap(String nodeName, List<BlockInfo> bList, int top, int left) {

		String ValueFound = null;

		int count = 0;
		for (BlockInfo b : bList) {

			if (b.getTop() != top && (b.getTop() < (top + 8) && b.getTop() > (top - 8))) {
				ValueFound = b.getText();
				break;
			} else {
				ValueFound = BlockConstants.ORC_NOT_ABLE_RECORGINE;
			}
			count++;
		}

		return ValueFound;
	}

	public static Boolean getLineActionAttributeMap(String nodeName, List<BlockInfo> bList, int top, int left,
			int bottom) {

		Boolean ValueFound = false;

		for (BlockInfo b : bList) {
			System.out.println(b.getText());

			if (b.getTop() < 1000) {

				if (b.getText().contains("\\.")) {
					ValueFound = true;
					break;
				}
				if (b.getText().contains("Lock")) {
					ValueFound = true;
					break;
				}
			}
		}

		return ValueFound;
	}

}
