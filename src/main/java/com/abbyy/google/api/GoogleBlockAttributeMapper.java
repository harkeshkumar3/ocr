package com.abbyy.google.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.abbyy.formatter.AdslPortFormat11;
import com.abbyy.formatter.InformationFormat;
import com.abbyy.formatter.LineActionFormat;
import com.abbyy.formatter.NliFormat;
import com.abbyy.formatter.ProfileFormat;
import com.abbyy.formatter.XdslTabFormat;
import com.abbyy.library.BlockConstants;

public class GoogleBlockAttributeMapper {

	private static final Logger logger = LoggerFactory.getLogger(GoogleBlockAttributeMapper.class);

	public static NliFormat getGoogleJsonAttributeMapper(List<GooglefilterSet> sList) {

		NliFormat nli = new NliFormat();

		AdslPortFormat11 adslPort11 = new AdslPortFormat11();
		nli.setAdslPort11(adslPort11);

	//	adslPort11.setAdslPortNo("11");

		XdslTabFormat xdslTab = new XdslTabFormat();

		sList.forEach(s -> {
			System.out.println(s);
			
			System.out.println(s.getText().equals("Line action"));
			if (s.getText().startsWith("NE - 10.206.72.5")) {

				String header = s.getText();
				adslPort11.setAdslPortNo(header);
			}

			if (s.getText().contains(BlockConstants.profiles_block)) {

				// logger.info("Profile Match" + s.getText());
				profileAttributeFinder(sList);
				xdslTab.setProfile(profileAttributeFinder(sList));
			}

			if (s.getText().contains(BlockConstants.INFORMATION_BLOCK)) {
				// logger.info("information Block Found" + s.getText());
				informationAttributeFinder(sList);
				xdslTab.setInformation(informationAttributeFinder(sList));
			}

			if (s.getText().equals("Line action")) {
				 logger.info("Line Action Block Found" + s.getText());
				lineActionAttributeFinder(sList);
				xdslTab.setLineAction(lineActionAttributeFinder(sList));
			}
		});
		adslPort11.setXdsl(xdslTab);

		return nli;

	}

	private static LineActionFormat lineActionAttributeFinder(List<GooglefilterSet> sList) {
		// TODO Auto-generated method stuburn

		LineActionFormat line = new LineActionFormat();

		sList.forEach(s -> {

			logger.info("Status Match" + s.getText());
			line.setStartUp(true);
			line.setDelt(false);
			
			if (s.getText().equals("Unlock") || s.getText().equals("Lock")) {

System.out.println("______________________________"+s.getText());
				if (s.getText().equals("Unlock")) {
					line.setStatus(false);
				}
				if (s.getText().equals("Lock")) {
					line.setStatus(true);
				}

			}

		});

		return line;

	}

	private static InformationFormat informationAttributeFinder(List<GooglefilterSet> sList) {
		InformationFormat info = new InformationFormat();
		sList.forEach(s -> {

			if (s.getText().equals("ID:")) {

				String infoId = informationKeyValueFinder(sList, s.getTop(), s.getBottom(), s.getText());
				logger.info("Id Match" + s.getText() + "Value is " + infoId);
				info.setId(infoId);

			}
			if (s.getText().equals("Name:")) {

				String infoName = informationKeyValueFinder(sList, s.getTop(), s.getBottom(), s.getText());
				logger.info("Name Id" + s.getText() + "Value is " + infoName);
				info.setName(infoName);

			}
		});
		return info;
	}

	private static ProfileFormat profileAttributeFinder(List<GooglefilterSet> sList) {

		ProfileFormat profile = new ProfileFormat();
		sList.forEach(s -> {

			if (s.getText().equals("Alarm severity:")) {

				String googleBlockKeyValueFinder = googleBlockKeyValueFinder(sList, s.getTop(), s.getBottom(),
						s.getText());
				logger.info("Profile Match" + s.getText() + "Value is " + googleBlockKeyValueFinder);
				profile.setAlarmSeverity(googleBlockKeyValueFinder);

			}

			if (s.getText().equals("XDSL Line:")) {
				String googleBlockKeyValueFinder = googleBlockKeyValueFinder(sList, s.getTop(), s.getBottom(),
						s.getText());
				logger.info("information Block Found" + s.getText() + "Value is " + googleBlockKeyValueFinder);
				profile.setxDslLine(googleBlockKeyValueFinder);

			}

			if (s.getText().contains(BlockConstants.profiles_block_custom_notch)) {
				String googleBlockKeyValueFinder = googleBlockKeyValueFinder(sList, s.getTop(), s.getBottom(),
						s.getText());
				logger.info("Line Action Block Found" + s.getText() + "Value is " + googleBlockKeyValueFinder);
				profile.setCustomNotch(googleBlockKeyValueFinder);
			}
			if (s.getText().contains(BlockConstants.PROFILES_BLOCK_UPSTREAM_PSD_MARK)) {
				String googleBlockKeyValueFinder = googleBlockKeyValueFinder(sList, s.getTop(), s.getBottom(),
						s.getText());
				logger.info("Line Action Block Found" + s.getText() + "Value is " + googleBlockKeyValueFinder);
				profile.setUpstreamPsdMark(googleBlockKeyValueFinder);
			}
			if (s.getText().contains(BlockConstants.PROFILES_BLOCK_DOWNSTREAM_PSD_MARK)) {
				String googleBlockKeyValueFinder = googleBlockKeyValueFinder(sList, s.getTop(), s.getBottom(),
						s.getText());
				logger.info("Line Action Block Found" + s.getText() + "Value is " + googleBlockKeyValueFinder);
				profile.setDownstreamPsdMark(googleBlockKeyValueFinder);
			}
			if (s.getText().contains(BlockConstants.PROFILES_BLOCK_EVENT)) {
				String googleBlockKeyValueFinder = googleBlockKeyValueFinder(sList, s.getTop(), s.getBottom(),
						s.getText());
				logger.info("Line Action Block Found" + s.getText() + "Value is " + googleBlockKeyValueFinder);
				profile.setEvent(googleBlockKeyValueFinder);
			}
			if (s.getText().contains(BlockConstants.PROFILES_BLOCK_CHANNEL1)) {
				String googleBlockKeyValueFinder = googleBlockKeyValueFinder(sList, s.getTop(), s.getBottom(),
						s.getText());
				logger.info("Line Action Block Found" + s.getText() + "Value is " + googleBlockKeyValueFinder);
				profile.setChannel1(googleBlockKeyValueFinder);
			}
		});
		return profile;
	}

	private static String googleBlockKeyValueFinder(List<GooglefilterSet> list, int top, int bottom, String text) {

		String ValueFound = null;

		for (GooglefilterSet b : list) {

			// System.out.println("block Name"+ b.getText() +" top "+ b.getTop()+"/"+top);

			if (!b.getText().equals(text) && (b.getTop() < (top + 2) && b.getTop() > (top - 2))) {
				ValueFound = b.getText();
				break;
			} else {
				ValueFound = BlockConstants.ORC_NOT_ABLE_RECORGINE;
			}
		}

		// System.out.println("Value Found " + ValueFound);

		return ValueFound;

	}

	private static String informationKeyValueFinder(List<GooglefilterSet> list, int top, int bottom, String text) {

		String ValueFound = null;

		for (GooglefilterSet b : list) {

			// System.out.println("block Name"+ b.getText() +" top "+ b.getTop()+"/"+top);

			if (!b.getText().equals(text) && (b.getTop() <= (top + 2) && b.getTop() >= (top - 2))) {
				ValueFound = b.getText();
				break;
			} else {
				ValueFound = BlockConstants.ORC_NOT_ABLE_RECORGINE;
			}
		}

		// System.out.println("Value Found " + ValueFound);

		return ValueFound;

	}

}
