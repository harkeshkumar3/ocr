package com.abbyy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.abbyy.library.PageTrackingLibrary;
import com.abbyy.model.BlockInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class XmlToJsonService {



	private static final String INDEX = "battery_info";
	ObjectMapper objectMapper = new ObjectMapper();

	public void xmlToJsonConverter(String xml_String) {

		List<BlockInfo> blockTextList = new ArrayList<BlockInfo>();

		try {

			JSONObject xmlJsonObject = XML.toJSONObject(xml_String);

			JSONObject document = (JSONObject) xmlJsonObject.get("document");
			JSONObject page = (JSONObject) document.get("page");
			Object blockArrayObj = page.get("block");
			if (blockArrayObj instanceof JSONArray) {
				JSONArray blockArray = (JSONArray) blockArrayObj;

				blockArray.forEach(arr -> {

					JSONObject arrObj = (JSONObject) arr;

					if (arrObj.has("text")) {

						JSONObject text = (JSONObject) arrObj.get("text");

						if (extractParJsonObject(text) != null) {
							extractParJsonObject(text).forEach(x -> {
								JSONObject par = (JSONObject) x;
								if (extractLineJsonObject(par) != null) {
									extractLineJsonObject(par).forEach(lineobj -> {
										JSONObject line = (JSONObject) lineobj;

										BlockInfo bl = new BlockInfo();

										bl.setBottom(line.getInt("b"));
										bl.setTop(line.getInt("t"));
										bl.setLeft(line.getInt("l"));
										bl.setRight(line.getInt("r"));

										if (line.has("formatting")) {
											JSONObject formatting = (JSONObject) line.get("formatting");
											Object charParamsArrayObj = formatting.get("charParams");

											StringBuilder blockTextBuilder = new StringBuilder();
											if (charParamsArrayObj instanceof JSONArray) {

												JSONArray charParamsArray = (JSONArray) charParamsArrayObj;

												charParamsArray.forEach(charParamObj -> {

													JSONObject charParam = (JSONObject) charParamObj;

													if (charParam.has("content")) {
														blockTextBuilder.append(charParam.get("content"));
													} else {
														// bl.setText(" ");
														blockTextBuilder.append(" ");
													}
												});
											}

											bl.setText(blockTextBuilder.toString());

											blockTextList.add(bl);
										}

									});
								}

							});
						}
					}

				});
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		// System.out.println("hello");

		PageTrackingLibrary.screenFinder(blockTextList);

	}

	public JSONArray extractLineJsonObject(JSONObject lineJsonObject) {

		if (lineJsonObject.has("line")) {

			Object lineObject = lineJsonObject.get("line");

			if (lineObject instanceof JSONArray) {

				JSONArray lineArray = (JSONArray) lineObject;
				return lineArray;
			} else if (lineObject instanceof JSONObject) {
				JSONArray array = new JSONArray();
				JSONObject lineObj = (JSONObject) lineObject;
				array.put(lineObj);
				return array;
			}
		}
		return null;
	}

	public JSONArray extractParJsonObject(JSONObject parJsonObject) {

		if (parJsonObject.has("par")) {

			Object parObject = parJsonObject.get("par");

			if (parObject instanceof JSONArray) {
				JSONArray parArray = (JSONArray) parObject;
				return parArray;

			} else if (parObject instanceof JSONObject) {

				JSONArray array = new JSONArray();
				JSONObject parObj = (JSONObject) parObject;
				array.put(parObj);
				return array;
			}

		}

		return null;
	}

	public void restTempateCall(BlockInfo document) {
		RestTemplate restTempate = new RestTemplate();
		String url = "http://localhost:9200/" + INDEX + "/_doc";
		Map<String, Object> documentMapper = objectMapper.convertValue(document, Map.class);
		restTempate.postForObject(url, documentMapper, Object.class);
	}

}
