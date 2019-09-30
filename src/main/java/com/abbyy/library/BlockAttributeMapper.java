package com.abbyy.library;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.abbyy.model.BlockInfo;

public class BlockAttributeMapper {

	public static Map<String, Map<String, String>> getProfileBlockAttributeMapper(List<BlockInfo> blockAttributeList, String blockName) {

		Map<String, Map<String, String>> blockAttribute = new HashMap<String, Map<String, String>>();

		for (BlockInfo blockAtt : blockAttributeList) {

			// System.out.println("BlockFound " + blockAtt.getText());

			if (blockAtt.getText().contains("Alarm")) {

				Map<String, String> attributeMap = getAttributeMap(BlockConstants.profiles_block_alarm_severity,
						blockAttributeList, blockAtt.getTop(), blockAtt.getLeft());
				blockAttribute.put(BlockConstants.profiles_block, attributeMap);

			}

			if (blockAtt.getText().contains("xDSL")) {

				Map<String, String> attributeMap = getAttributeMap(BlockConstants.profiles_block_xDsl_line,
						blockAttributeList, blockAtt.getTop(), blockAtt.getLeft());
				blockAttribute.put(BlockConstants.profiles_block, attributeMap);
			}

			if (blockAtt.getText().contains("Custom Notch:")) {

				Map<String, String> attributeMap = getAttributeMap(BlockConstants.profiles_block_custom_notch,
						blockAttributeList, blockAtt.getTop(), blockAtt.getLeft());
				blockAttribute.put(BlockConstants.profiles_block, attributeMap);
			}
			if (blockAtt.getText().contains("Upstream PSD mask:")) {

			}
			if (blockAtt.getText().contains("Downstream PSD mask:")) {

			}
			if (blockAtt.getText().contains("Event:")) {
				;
			}
			if (blockAtt.getText().contains("Channel")) {

			}
		}
		return blockAttribute;

	}

	private static Map<String, String> getAttributeMap(String nodeName, List<BlockInfo> bList, int top, int left) {

		for (BlockInfo b : bList) {
			Map<String, String> map = new HashMap<String, String>();

			if (b.getTop() != top && (b.getTop() < (top + 8) && b.getTop() > (top - 8))) {

				//System.out.println("Value Found Node  " + nodeName + " : " + b.getText());
				map.put(nodeName, b.getText());
				return map;
			} else {

				map.put(nodeName, BlockConstants.ORC_NOT_ABLE_RECORGINE);
				return map;
			}

		}

		return null;
	}

}
