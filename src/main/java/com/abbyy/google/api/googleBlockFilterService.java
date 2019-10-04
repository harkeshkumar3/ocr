package com.abbyy.google.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.abbyy.formatter.NliFormat;

public class googleBlockFilterService {

	public static NliFormat getTextLineBlock(List<GoogleBlock> gBlock) {

		String totalDescription = gBlock.get(0).getText();

		String[] desList = totalDescription.split("\\n");
		for(String s : desList) {
			
			//System.out.println("Split Text " + s);
		}

		List<GoogleBlock> googleList = new ArrayList<GoogleBlock>();
		Set<GooglefilterSet> filterSet = new HashSet<GooglefilterSet>();
		gBlock.forEach(gb -> {

			StringBuilder stringBuilder = new StringBuilder();
			GoogleBlock googleBlock = new GoogleBlock();

			gBlock.forEach(ib -> {
				if (gb.getTopLeft().getY() == ib.getTopLeft().getY()
						&& gb.getBottomLeft().getY() == ib.getBottomLeft().getY()) {

					stringBuilder.append(ib.getText());
				}

			});

			googleBlock.setText(stringBuilder.toString());
			googleBlock.setTopLeft(gb.getTopLeft());
			googleBlock.setBottomLeft(gb.getBottomLeft());
			GooglefilterSet gSet = new GooglefilterSet(stringBuilder.toString(), gb.getTopLeft().getY(),
					gb.getBottomLeft().getY());
			//System.out.println("Filter set Text " + stringBuilder.toString());

			filterSet.add(gSet);
			googleList.add(googleBlock);

		});
		//System.out.println(googleList.size() + "Filter set " + filterSet);
		return compareText(desList, filterSet);

	}

	public static NliFormat compareText(String[] list, Set<GooglefilterSet> filterSet) {

		List<GooglefilterSet> fixList = new ArrayList<GooglefilterSet>();

		for (String x : list) {

			for (GooglefilterSet filter : filterSet) {
				if (x.replaceAll("\\s+", "").equalsIgnoreCase(filter.getText().replaceAll("\\s+", ""))
						&& !x.equals("+")) {
				//	System.out.println("Found " + x);
					GooglefilterSet gList = new GooglefilterSet(x, filter.getTop(), filter.getBottom());
					fixList.add(gList);
				}
			}

		}
		return GoogleBlockAttributeMapper.getGoogleJsonAttributeMapper(fixList);

	}

}
