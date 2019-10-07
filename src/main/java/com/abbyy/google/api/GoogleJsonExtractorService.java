package com.abbyy.google.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.abbyy.formatter.NliFormat;
import com.google.cloud.vision.v1.BoundingPoly;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Vertex;

public class GoogleJsonExtractorService {

	static final Logger logger = LoggerFactory.getLogger(GoogleJsonExtractorService.class);

	public static NliFormat getGoogleJsonExtract(List<EntityAnnotation> textAnnotationsList) {

		logger.info("Inside getGoogleJsonExtract");

		List<GoogleBlock> googleBlockList = new ArrayList<GoogleBlock>();

		textAnnotationsList.forEach(

				annotation -> {

					annotation.getLocale();
					annotation.getDescription();
					BoundingPoly bPoly = annotation.getBoundingPoly();
					List<Vertex> vlist = bPoly.getVerticesList();

					GoogleBlock gBlock = new GoogleBlock();
					gBlock.setText(annotation.getDescription());
					gBlock.setTopLeft(new EdgeDetails(vlist.get(0).getX(), vlist.get(0).getY()));
					gBlock.setTopRight(new EdgeDetails(vlist.get(1).getX(), vlist.get(1).getY()));
					gBlock.setBottomRight(new EdgeDetails(vlist.get(2).getX(), vlist.get(2).getY()));
					gBlock.setBottomLeft(new EdgeDetails(vlist.get(3).getX(), vlist.get(3).getY()));

					googleBlockList.add(gBlock);
				}

		);

		return googleBlockFilterService.getTextLineBlock(googleBlockList);

	}

}
