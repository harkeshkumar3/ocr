package com.abbyy.library;

import java.util.List;

import com.abbyy.formatter.InformationFormat;
import com.abbyy.formatter.LineActionFormat;
import com.abbyy.formatter.ProfileFormat;
import com.abbyy.model.BlockInfo;

public class BlockAttributeMapper {

	public static ProfileFormat getProfileBlockAttributeMapper(List<BlockInfo> blockAttributeList, String blockName) {

		ProfileFormat profile = new ProfileFormat();

		for (BlockInfo blockAtt : blockAttributeList) {

			if (blockAtt.getText().contains("Alarm")) {

				String attributeMapAlarm = BlockKeyValueMapper.getAttributeMap(
						BlockConstants.profiles_block_alarm_severity, blockAttributeList, blockAtt.getTop(),
						blockAtt.getLeft());
				profile.setAlarmSeverity(attributeMapAlarm);
			}

			if (blockAtt.getText().contains("xDSL")) {

				String attributeMapXdsl = BlockKeyValueMapper.getAttributeMap(BlockConstants.profiles_block_xDsl_line,
						blockAttributeList, blockAtt.getTop(), blockAtt.getLeft());
				profile.setxDslLine(attributeMapXdsl);
			}

			if (blockAtt.getText().contains("Notch")) {

				String attributeMapCustom = BlockKeyValueMapper.getAttributeMap(
						BlockConstants.profiles_block_custom_notch, blockAttributeList, blockAtt.getTop(),
						blockAtt.getLeft());
				profile.setCustomNotch(attributeMapCustom);
			}
			if (blockAtt.getText().contains("Upstream PSD mask")) {
				
				String attributeMapCustom = BlockKeyValueMapper.getAttributeMap(
						BlockConstants.PROFILES_BLOCK_UPSTREAM_PSD_MARK, blockAttributeList, blockAtt.getTop(),
						blockAtt.getLeft());
				profile.setUpstreamPsdMark(attributeMapCustom);

			}
			if (blockAtt.getText().contains("Downstream PSD mask")) {
				
				String attributeMapCustom = BlockKeyValueMapper.getAttributeMap(
						BlockConstants.PROFILES_BLOCK_DOWNSTREAM_PSD_MARK, blockAttributeList, blockAtt.getTop(),
						blockAtt.getLeft());
				profile.setDownstreamPsdMark(attributeMapCustom);

			}
			if (blockAtt.getText().contains("Event")) {
				String attributeMapCustom = BlockKeyValueMapper.getAttributeMap(
						BlockConstants.PROFILES_BLOCK_EVENT, blockAttributeList, blockAtt.getTop(),
						blockAtt.getLeft());
				profile.setEvent(attributeMapCustom);
			}
			if (blockAtt.getText().contains("Channel")) {
				String attributeMapCustom = BlockKeyValueMapper.getAttributeMap(
						BlockConstants.PROFILES_BLOCK_CHANNEL1, blockAttributeList, blockAtt.getTop(),
						blockAtt.getLeft());
				profile.setChannel1(attributeMapCustom);
			}
		}
		return profile;

	}

	public static LineActionFormat getLineActionBlockAttributeMapper(List<BlockInfo> blockAttributeList,
			String blockName, int bottom) {

		LineActionFormat lineAction = new LineActionFormat();

		for (BlockInfo blockAtt : blockAttributeList) {

			if (blockAtt.getText().contains("Startup")) {
				if (blockAtt.getText().contains("• Startup")) {
					lineAction.setStartUp(true);
				}
			}

			if (blockAtt.getText().contains("Test mode")) {
				if (blockAtt.getText().contains("• Test mode")) {
					lineAction.setTestMode(true);
				}
			}

			if (blockAtt.getText().contains("CELT")) {
				if (blockAtt.getText().contains("• CELT")) {
					lineAction.setDelt(true);
				}
			}
			if (blockAtt.getText().contains("LOCK") || blockAtt.getText().contains("Unlock")) {

				System.out.println("Line action Status: " + blockAtt.getText());
				if (blockAtt.getText().contains("LOCK")) {
					lineAction.setStatus(true);
				}
				if (blockAtt.getText().contains("Unlock")) {
					lineAction.setStatus(false);
				}

			}

		}
		return lineAction;

	}

	public static InformationFormat getInformationBlockAttributeMapper(List<BlockInfo> blockAttributeList,
			String blockName) {

		InformationFormat info = new InformationFormat();

		for (BlockInfo blockAtt : blockAttributeList) {

			if (blockAtt.getText().contains("ID")) {

				String attributeMapAlarm = BlockKeyValueMapper.getAttributeMap(BlockConstants.INFORMATION_BLOCK_ID,
						blockAttributeList, blockAtt.getTop(), blockAtt.getLeft());
				info.setId(attributeMapAlarm);
			}

			if (blockAtt.getText().contains("Name")) {
				String attributeMapXdsl = BlockKeyValueMapper.getAttributeMap(BlockConstants.INFORMATION_BLOCK_NAME,
						blockAttributeList, blockAtt.getTop(), blockAtt.getLeft());
				info.setName(attributeMapXdsl);
			}

		}
		return info;

	}

}
