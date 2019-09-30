package com.abbyy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import javax.swing.JInternalFrame;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.abbyy.model.BlockInfo;
import com.abbyy.repo.OcrRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class XmlToJsonService {

	// private static final Logger logger =
	// LoggerFactory.getLogger(XmlToJsonService.class);
	@Autowired
	private OcrRepo ocrRepo;

	private static final String INDEX = "battery_info";
	ObjectMapper objectMapper = new ObjectMapper();

	public void xmlToJsonConverter(String xml_String) {

		// List<BlockInfo> blockTextList = new ArrayList<BlockInfo>();

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
						// logger.info("::::::: Inside text");

						if (extractParJsonObject(text) != null) {
							extractParJsonObject(text).forEach(x -> {
								JSONObject par = (JSONObject) x;
								if (extractLineJsonObject(par) != null) {
									extractLineJsonObject(par).forEach(lineobj -> {
										JSONObject line = (JSONObject) lineobj;
										// logger.info("::::::: Inside line");

										BlockInfo bl = new BlockInfo();
										/*
										 * int top = line.getInt("t"); int bottom = line.getInt("b"); int left =
										 * line.getInt("l"); int right = line.getInt("r");
										 */
										bl.setBottom(line.getInt("b"));
										bl.setTop(line.getInt("t"));
										bl.setLeft(line.getInt("l"));
										bl.setRight(line.getInt("r"));
										/*
										 * System.out.println("TOP :- [" + top + " ]"); System.out.println("Bottom :-[ "
										 * + bottom + " ]"); System.out.println("left:- [" + left + " ]");
										 * System.out.println("Right :[" + right + " ]");
										 */

										if (line.has("formatting")) {
											JSONObject formatting = (JSONObject) line.get("formatting");
											Object charParamsArrayObj = formatting.get("charParams");
											String toPrint = "";
											StringJoiner joiner = new StringJoiner("");
											StringBuilder blockTextBuilder = new StringBuilder();
											if (charParamsArrayObj instanceof JSONArray) {

												JSONArray charParamsArray = (JSONArray) charParamsArrayObj;

												StringBuilder listString = new StringBuilder();
												String outputblockText = null;
												charParamsArray.forEach(charParamObj -> {

													JSONObject charParam = (JSONObject) charParamObj;

													if (charParam.has("content")) {
														// System.out.print(charParam.get("content"));
														// listString.append(charParam.get("content")+" ");
														joiner.add(charParam.get("content").toString());
														blockTextBuilder.append(charParam.get("content"));
													} else {
														System.out.print(" ");
														bl.setText(" ");
														blockTextBuilder.append(" ");
													}

													// blockTextList.add(bl);
													// restTempateCall(bl);
												});
											}
											
											System.out.println("Final Output is: "+blockTextBuilder);

											bl.setText(blockTextBuilder.toString());
											// restTempateCall(joiner.toString());
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

		System.out.println("hello");

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
