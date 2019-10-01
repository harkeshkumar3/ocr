package com.abbyy.library;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.abbyy.formatter.AdslPortFormat11;
import com.abbyy.formatter.InformationFormat;
import com.abbyy.formatter.LineActionFormat;
import com.abbyy.formatter.NliFormat;
import com.abbyy.formatter.ProfileFormat;
import com.abbyy.formatter.XdslTabFormat;
import com.abbyy.model.BlockFinderParam;
import com.abbyy.model.BlockInfo;

public class PageTrackingLibrary {

	private static final Logger logger = LoggerFactory.getLogger(PageTrackingLibrary.class);

	public NliFormat screenFinder(List<BlockInfo> blockList) {
		
		NliFormat nli = new NliFormat();
		
		AdslPortFormat11 adslPort11 = new AdslPortFormat11();
		nli.setAdslPort11(adslPort11);
		
		adslPort11.setAdslPortNo("11");
		

		XdslTabFormat xdslTab = new XdslTabFormat();

		for (BlockInfo block : blockList) {
			BlockFinderParam blockNameFinder = BlockFinder.blockNameFinder(block);
			if (blockNameFinder != null) {

				if (blockNameFinder.getBlockName().equals("Line action")) {

					BlockFinderParam blockfind = BlockFinder.blockNameFinder(block);
					int LineActionBottomLine = 0;
					if (blockfind.getBlockName().equals("Power managment")) {
						LineActionBottomLine = blockfind.getTop();
						System.out.println("PM ==== top" + LineActionBottomLine);
					}
					List<BlockInfo> blockAttributeFinder = BlockAttributeFinder.getBlockAttributeFinder(
							blockNameFinder.getTop(), blockNameFinder.getMinleft(), blockNameFinder.getMaxleft(),
							blockList);
					LineActionFormat lineActionBlockAttributeMapper = BlockAttributeMapper
							.getLineActionBlockAttributeMapper(blockAttributeFinder, BlockConstants.LINE_ACTION_BLOCK,
									LineActionBottomLine);
					xdslTab.setLineAction(lineActionBlockAttributeMapper);
					System.out.println(lineActionBlockAttributeMapper);
				}

				if (blockNameFinder.getBlockName().equals("Profiles")) {
					List<BlockInfo> blockAttributeFinder = BlockAttributeFinder.getBlockAttributeFinder(
							blockNameFinder.getTop(), blockNameFinder.getMinleft(), blockNameFinder.getMaxleft(),
							blockList);
					ProfileFormat profileBlockAttributeMapper = BlockAttributeMapper
							.getProfileBlockAttributeMapper(blockAttributeFinder, BlockConstants.profiles_block);

					xdslTab.setProfile(profileBlockAttributeMapper);
					System.out.println(profileBlockAttributeMapper);
				}
				if (blockNameFinder.getBlockName().equals("Information")) {
					List<BlockInfo> blockAttributeFinder = BlockAttributeFinder.getBlockAttributeFinder(
							blockNameFinder.getTop(), blockNameFinder.getMinleft(), blockNameFinder.getMaxleft(),
							blockList);

					InformationFormat informationBlockAttributeMapper = BlockAttributeMapper
							.getInformationBlockAttributeMapper(blockAttributeFinder, BlockConstants.INFORMATION_BLOCK);
					xdslTab.setInformation(informationBlockAttributeMapper);
					System.out.println(informationBlockAttributeMapper);

				}
			}
		}
		
		adslPort11.setXdsl(xdslTab);
		
		return nli;
	}

}
