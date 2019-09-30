package com.abbyy.library;

import java.util.List;

import com.abbyy.formatter.ProfileFormat;
import com.abbyy.model.BlockInfo;

public class BlockAttributeMapper {

	public static ProfileFormat getProfileBlockAttributeMapper(List<BlockInfo> blockAttributeList,
			String blockName) {


		ProfileFormat profile = new ProfileFormat();

		for (BlockInfo blockAtt : blockAttributeList) {

			if (blockAtt.getText().contains("Alarm")) {

				String attributeMap = getAttributeMap(BlockConstants.profiles_block_alarm_severity, blockAttributeList,
						blockAtt.getTop(), blockAtt.getLeft());
				profile.setAlarmSeverity(attributeMap);
			}

			if (blockAtt.getText().contains("xDSL")) {

				String attributeMap = getAttributeMap(BlockConstants.profiles_block_xDsl_line, blockAttributeList,
						blockAtt.getTop(), blockAtt.getLeft());
				profile.setxDslLine(attributeMap);
			}

			if (blockAtt.getText().contains("Custom Notch:")) {

				String attributeMap = getAttributeMap(BlockConstants.profiles_block_custom_notch, blockAttributeList,
						blockAtt.getTop(), blockAtt.getLeft());
				profile.setCustomNotch(attributeMap);
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
		return profile;

	}

	private static String getAttributeMap(String nodeName, List<BlockInfo> bList, int top, int left) {

		for (BlockInfo b : bList) {

			if (b.getTop() != top && (b.getTop() < (top + 8) && b.getTop() > (top - 8))) {

			System.out.println("Found "+nodeName+" :"+ b.getText());
				return b.getText();
			} else {

				return BlockConstants.ORC_NOT_ABLE_RECORGINE;
			}

		}

		return null;
	}

}
