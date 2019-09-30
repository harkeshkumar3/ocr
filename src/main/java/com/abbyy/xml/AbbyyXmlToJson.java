package com.abbyy.xml;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class AbbyyXmlToJson {

	private static String xml_String = "﻿<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
			+ "<document xmlns=\"http://www.abbyy.com/FineReader_xml/FineReader10-schema-v1.xml\" version=\"1.0\" producer=\"ABBYY FineReader Engine 12\" languages=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.abbyy.com/FineReader_xml/FineReader10-schema-v1.xml http://www.abbyy.com/FineReader_xml/FineReader10-schema-v1.xml\">\n"
			+ "<page width=\"430\" height=\"228\" resolution=\"96\" originalCoords=\"1\">\n"
			+ "<block blockType=\"Text\" blockName=\"\" l=\"16\" t=\"16\" r=\"420\" b=\"32\"><region><rect l=\"16\" t=\"16\" r=\"374\" b=\"17\"/><rect l=\"16\" t=\"17\" r=\"420\" b=\"31\"/><rect l=\"342\" t=\"31\" r=\"420\" b=\"32\"/></region>\n"
			+ "<text>\n" + "<par align=\"Justified\" startIndent=\"1100\" lineSpacing=\"1150\">\n"
			+ "<line baseline=\"29\" l=\"17\" t=\"17\" r=\"418\" b=\"32\"><formatting lang=\"EnglishUnitedStates\">\n"
			+ "<charParams l=\"17\" t=\"18\" r=\"24\" b=\"27\">N</charParams>\n"
			+ "<charParams l=\"25\" t=\"18\" r=\"30\" b=\"27\">E</charParams>\n"
			+ "<charParams l=\"31\" t=\"18\" r=\"35\" b=\"27\"> </charParams>\n"
			+ "<charParams l=\"36\" t=\"22\" r=\"40\" b=\"24\">-</charParams>\n"
			+ "<charParams l=\"41\" t=\"19\" r=\"46\" b=\"28\"> </charParams>\n"
			+ "<charParams l=\"47\" t=\"19\" r=\"52\" b=\"28\">1</charParams>\n"
			+ "<charParams l=\"54\" t=\"19\" r=\"61\" b=\"28\">0</charParams>\n"
			+ "<charParams l=\"62\" t=\"26\" r=\"64\" b=\"28\">.</charParams>\n"
			+ "<charParams l=\"66\" t=\"19\" r=\"72\" b=\"28\">2</charParams>\n"
			+ "<charParams l=\"74\" t=\"19\" r=\"81\" b=\"28\">0</charParams>\n"
			+ "<charParams l=\"82\" t=\"19\" r=\"89\" b=\"28\">6</charParams>\n"
			+ "<charParams l=\"90\" t=\"26\" r=\"92\" b=\"28\">.</charParams>\n"
			+ "<charParams l=\"95\" t=\"19\" r=\"101\" b=\"28\">7</charParams>\n"
			+ "<charParams l=\"102\" t=\"19\" r=\"109\" b=\"28\">2</charParams>\n"
			+ "<charParams l=\"110\" t=\"26\" r=\"112\" b=\"28\">.</charParams>\n"
			+ "<charParams l=\"114\" t=\"19\" r=\"121\" b=\"28\">5</charParams>\n"
			+ "<charParams l=\"122\" t=\"19\" r=\"126\" b=\"28\"> </charParams>\n"
			+ "<charParams l=\"127\" t=\"21\" r=\"129\" b=\"28\">:</charParams>\n"
			+ "<charParams l=\"130\" t=\"19\" r=\"134\" b=\"28\"> </charParams>\n"
			+ "<charParams l=\"135\" t=\"19\" r=\"144\" b=\"28\">M</charParams>\n"
			+ "<charParams l=\"146\" t=\"18\" r=\"153\" b=\"28\">3</charParams>\n"
			+ "<charParams l=\"154\" t=\"18\" r=\"161\" b=\"27\">0</charParams>\n"
			+ "<charParams l=\"163\" t=\"18\" r=\"168\" b=\"27\">1</charParams>\n"
			+ "<charParams l=\"170\" t=\"22\" r=\"174\" b=\"23\">-</charParams>\n"
			+ "<charParams l=\"177\" t=\"18\" r=\"182\" b=\"27\">1</charParams>\n"
			+ "<charParams l=\"185\" t=\"18\" r=\"190\" b=\"27\">1</charParams>\n"
			+ "<charParams l=\"191\" t=\"18\" r=\"197\" b=\"27\"> </charParams>\n"
			+ "<charParams l=\"198\" t=\"18\" r=\"205\" b=\"27\">4</charParams>\n"
			+ "<charParams l=\"206\" t=\"18\" r=\"213\" b=\"27\">0</charParams>\n"
			+ "<charParams l=\"214\" t=\"18\" r=\"221\" b=\"27\">5</charParams>\n"
			+ "<charParams l=\"221\" t=\"28\" r=\"229\" b=\"30\">_</charParams>\n"
			+ "<charParams l=\"229\" t=\"18\" r=\"237\" b=\"27\">G</charParams>\n"
			+ "<charParams l=\"238\" t=\"18\" r=\"245\" b=\"27\">H</charParams>\n"
			+ "<charParams l=\"247\" t=\"18\" r=\"254\" b=\"27\">S</charParams>\n"
			+ "<charParams l=\"255\" t=\"18\" r=\"262\" b=\"27\">H</charParams>\n"
			+ "<charParams l=\"264\" t=\"18\" r=\"271\" b=\"27\">7</charParams>\n"
			+ "<charParams l=\"278\" t=\"18\" r=\"287\" b=\"27\">A</charParams>\n"
			+ "<charParams l=\"288\" t=\"18\" r=\"292\" b=\"27\"> </charParams>\n"
			+ "<charParams l=\"293\" t=\"20\" r=\"295\" b=\"27\">:</charParams>\n"
			+ "<charParams l=\"296\" t=\"17\" r=\"300\" b=\"27\"> </charParams>\n"
			+ "<charParams l=\"301\" t=\"17\" r=\"308\" b=\"28\">h</charParams>\n"
			+ "<charParams l=\"309\" t=\"17\" r=\"312\" b=\"28\">i</charParams>\n"
			+ "<charParams l=\"312\" t=\"18\" r=\"320\" b=\"28\">X</charParams>\n"
			+ "<charParams l=\"321\" t=\"17\" r=\"324\" b=\"28\"> </charParams>\n"
			+ "<charParams l=\"325\" t=\"18\" r=\"332\" b=\"28\">5</charParams>\n"
			+ "<charParams l=\"333\" t=\"18\" r=\"340\" b=\"27\">6</charParams>\n"
			+ "<charParams l=\"341\" t=\"18\" r=\"348\" b=\"27\">3</charParams>\n"
			+ "<charParams l=\"349\" t=\"18\" r=\"356\" b=\"27\">5</charParams>\n"
			+ "<charParams l=\"357\" t=\"18\" r=\"360\" b=\"27\"> </charParams>\n"
			+ "<charParams l=\"361\" t=\"18\" r=\"369\" b=\"27\">R</charParams>\n"
			+ "<charParams l=\"370\" t=\"18\" r=\"377\" b=\"27\">3</charParams>\n"
			+ "<charParams l=\"378\" t=\"25\" r=\"380\" b=\"28\">.</charParams>\n"
			+ "<charParams l=\"382\" t=\"18\" r=\"389\" b=\"28\">8</charParams>\n"
			+ "<charParams l=\"390\" t=\"18\" r=\"399\" b=\"27\">M</charParams>\n"
			+ "<charParams l=\"401\" t=\"18\" r=\"409\" b=\"27\">H</charParams>\n"
			+ "<charParams l=\"410\" t=\"19\" r=\"413\" b=\"27\"> </charParams>\n"
			+ "<charParams l=\"414\" t=\"22\" r=\"418\" b=\"24\">-</charParams></formatting></line></par>\n"
			+ "</text>\n" + "</block>\n"
			+ "<block blockType=\"Text\" blockName=\"\" l=\"2\" t=\"47\" r=\"413\" b=\"227\"><region><rect l=\"2\" t=\"47\" r=\"322\" b=\"48\"/><rect l=\"2\" t=\"48\" r=\"363\" b=\"49\"/><rect l=\"2\" t=\"49\" r=\"400\" b=\"50\"/><rect l=\"2\" t=\"50\" r=\"413\" b=\"211\"/><rect l=\"35\" t=\"211\" r=\"413\" b=\"212\"/><rect l=\"276\" t=\"212\" r=\"413\" b=\"213\"/><rect l=\"297\" t=\"213\" r=\"413\" b=\"214\"/><rect l=\"310\" t=\"214\" r=\"413\" b=\"215\"/><rect l=\"321\" t=\"215\" r=\"413\" b=\"216\"/><rect l=\"329\" t=\"216\" r=\"413\" b=\"217\"/><rect l=\"338\" t=\"217\" r=\"413\" b=\"218\"/><rect l=\"346\" t=\"218\" r=\"413\" b=\"219\"/><rect l=\"354\" t=\"219\" r=\"413\" b=\"220\"/><rect l=\"362\" t=\"220\" r=\"413\" b=\"221\"/><rect l=\"370\" t=\"221\" r=\"413\" b=\"222\"/><rect l=\"377\" t=\"222\" r=\"413\" b=\"223\"/><rect l=\"385\" t=\"223\" r=\"413\" b=\"224\"/><rect l=\"392\" t=\"224\" r=\"413\" b=\"225\"/><rect l=\"400\" t=\"225\" r=\"412\" b=\"226\"/><rect l=\"408\" t=\"226\" r=\"412\" b=\"227\"/></region>\n"
			+ "<text>\n" + "<par lineSpacing=\"980\">\n"
			+ "<line baseline=\"64\" l=\"3\" t=\"47\" r=\"404\" b=\"72\"><formatting lang=\"EnglishUnitedStates\">\n"
			+ "<charParams l=\"3\" t=\"55\" r=\"8\" b=\"61\">x</charParams>\n"
			+ "<charParams l=\"9\" t=\"53\" r=\"15\" b=\"61\">D</charParams>\n"
			+ "<charParams l=\"16\" t=\"53\" r=\"21\" b=\"61\">S</charParams>\n"
			+ "<charParams l=\"22\" t=\"54\" r=\"26\" b=\"61\">L</charParams>\n"
			+ "<charParams l=\"27\" t=\"54\" r=\"29\" b=\"61\"> </charParams>\n"
			+ "<charParams l=\"30\" t=\"54\" r=\"34\" b=\"62\">L</charParams>\n"
			+ "<charParams l=\"35\" t=\"56\" r=\"36\" b=\"62\">i</charParams>\n"
			+ "<charParams l=\"37\" t=\"55\" r=\"42\" b=\"62\">n</charParams>\n"
			+ "<charParams l=\"43\" t=\"55\" r=\"48\" b=\"62\">e</charParams>\n"
			+ "<charParams l=\"49\" t=\"55\" r=\"60\" b=\"64\"> </charParams>\n"
			+ "<charParams l=\"61\" t=\"57\" r=\"66\" b=\"64\" suspicious=\"1\">X</charParams>\n"
			+ "<charParams l=\"67\" t=\"55\" r=\"72\" b=\"64\" suspicious=\"1\">T</charParams>\n"
			+ "<charParams l=\"72\" t=\"56\" r=\"79\" b=\"64\" suspicious=\"1\">U</charParams>\n"
			+ "<charParams l=\"80\" t=\"55\" r=\"82\" b=\"64\"> </charParams>\n"
			+ "<charParams l=\"83\" t=\"55\" r=\"88\" b=\"64\">P</charParams>\n"
			+ "<charParams l=\"89\" t=\"55\" r=\"94\" b=\"64\">h</charParams>\n"
			+ "<charParams l=\"96\" t=\"58\" r=\"100\" b=\"66\">y</charParams>\n"
			+ "<charParams l=\"101\" t=\"57\" r=\"106\" b=\"64\">s</charParams>\n"
			+ "<charParams l=\"106\" t=\"56\" r=\"107\" b=\"64\">i</charParams>\n"
			+ "<charParams l=\"108\" t=\"57\" r=\"112\" b=\"64\">c</charParams>\n"
			+ "<charParams l=\"113\" t=\"57\" r=\"118\" b=\"64\">a</charParams>\n"
			+ "<charParams l=\"119\" t=\"55\" r=\"120\" b=\"64\">l</charParams>\n"
			+ "<charParams l=\"121\" t=\"51\" r=\"125\" b=\"68\"> </charParams>\n"
			+ "<charParams l=\"126\" t=\"51\" r=\"127\" b=\"68\" suspicious=\"1\">|</charParams>\n"
			+ "<charParams l=\"128\" t=\"51\" r=\"131\" b=\"68\"> </charParams>\n"
			+ "<charParams l=\"132\" t=\"58\" r=\"137\" b=\"64\">x</charParams>\n"
			+ "<charParams l=\"138\" t=\"55\" r=\"143\" b=\"64\">T</charParams>\n"
			+ "<charParams l=\"143\" t=\"56\" r=\"150\" b=\"64\" suspicious=\"1\">U</charParams>\n"
			+ "<charParams l=\"151\" t=\"54\" r=\"153\" b=\"63\"> </charParams>\n"
			+ "<charParams l=\"154\" t=\"54\" r=\"160\" b=\"63\">C</charParams>\n"
			+ "<charParams l=\"161\" t=\"54\" r=\"166\" b=\"63\">h</charParams>\n"
			+ "<charParams l=\"167\" t=\"56\" r=\"172\" b=\"63\">a</charParams>\n"
			+ "<charParams l=\"173\" t=\"56\" r=\"178\" b=\"63\">n</charParams>\n"
			+ "<charParams l=\"179\" t=\"56\" r=\"184\" b=\"63\">n</charParams>\n"
			+ "<charParams l=\"185\" t=\"56\" r=\"190\" b=\"63\">e</charParams>\n"
			+ "<charParams l=\"191\" t=\"54\" r=\"192\" b=\"63\">l</charParams>\n"
			+ "<charParams l=\"193\" t=\"50\" r=\"197\" b=\"67\"> </charParams>\n"
			+ "<charParams l=\"198\" t=\"50\" r=\"199\" b=\"67\" suspicious=\"1\">|</charParams>\n"
			+ "<charParams l=\"200\" t=\"50\" r=\"203\" b=\"67\"> </charParams>\n"
			+ "<charParams l=\"204\" t=\"54\" r=\"209\" b=\"63\">S</charParams>\n"
			+ "<charParams l=\"210\" t=\"54\" r=\"215\" b=\"63\">h</charParams>\n"
			+ "<charParams l=\"216\" t=\"56\" r=\"221\" b=\"63\">o</charParams>\n"
			+ "<charParams l=\"222\" t=\"57\" r=\"229\" b=\"63\">w</charParams>\n"
			+ "<charParams l=\"231\" t=\"55\" r=\"234\" b=\"63\">t</charParams>\n"
			+ "<charParams l=\"234\" t=\"57\" r=\"235\" b=\"63\">i</charParams>\n"
			+ "<charParams l=\"236\" t=\"57\" r=\"243\" b=\"63\">m</charParams>\n"
			+ "<charParams l=\"244\" t=\"57\" r=\"249\" b=\"63\">e</charParams>\n"
			+ "<charParams l=\"250\" t=\"54\" r=\"252\" b=\"63\"> </charParams>\n"
			+ "<charParams l=\"253\" t=\"54\" r=\"258\" b=\"63\">S</charParams>\n"
			+ "<charParams l=\"260\" t=\"55\" r=\"263\" b=\"63\">t</charParams>\n"
			+ "<charParams l=\"263\" t=\"56\" r=\"268\" b=\"63\">a</charParams>\n"
			+ "<charParams l=\"270\" t=\"55\" r=\"273\" b=\"64\">t</charParams>\n"
			+ "<charParams l=\"273\" t=\"57\" r=\"278\" b=\"64\">u</charParams>\n"
			+ "<charParams l=\"279\" t=\"57\" r=\"283\" b=\"64\">s</charParams>\n"
			+ "<charParams l=\"284\" t=\"51\" r=\"288\" b=\"68\"> </charParams>\n"
			+ "<charParams l=\"289\" t=\"51\" r=\"290\" b=\"68\" suspicious=\"1\">|</charParams>\n"
			+ "<charParams l=\"291\" t=\"51\" r=\"294\" b=\"68\"> </charParams>\n"
			+ "<charParams l=\"295\" t=\"55\" r=\"301\" b=\"64\" suspicious=\"1\">D</charParams>\n"
			+ "<charParams l=\"302\" t=\"55\" r=\"307\" b=\"63\" suspicious=\"1\">E</charParams>\n"
			+ "<charParams l=\"308\" t=\"55\" r=\"312\" b=\"63\" suspicious=\"1\">L</charParams>\n"
			+ "<charParams l=\"312\" t=\"55\" r=\"319\" b=\"63\" suspicious=\"1\">t</charParams>\n"
			+ "<charParams l=\"322\" t=\"50\" r=\"326\" b=\"68\" suspicious=\"1\">]</charParams>\n"
			+ "<charParams l=\"327\" t=\"50\" r=\"329\" b=\"68\"> </charParams>\n"
			+ "<charParams l=\"330\" t=\"54\" r=\"336\" b=\"64\">C</charParams>\n"
			+ "<charParams l=\"337\" t=\"57\" r=\"342\" b=\"63\">o</charParams>\n"
			+ "<charParams l=\"343\" t=\"57\" r=\"348\" b=\"63\">u</charParams>\n"
			+ "<charParams l=\"349\" t=\"57\" r=\"354\" b=\"63\">n</charParams>\n"
			+ "<charParams l=\"355\" t=\"55\" r=\"359\" b=\"64\">t</charParams>\n"
			+ "<charParams l=\"359\" t=\"57\" r=\"364\" b=\"64\">e</charParams>\n"
			+ "<charParams l=\"365\" t=\"56\" r=\"368\" b=\"63\">r</charParams>\n"
			+ "<charParams l=\"369\" t=\"57\" r=\"374\" b=\"64\">s</charParams>\n"
			+ "<charParams l=\"375\" t=\"49\" r=\"378\" b=\"67\"> </charParams>\n"
			+ "<charParams l=\"379\" t=\"49\" r=\"380\" b=\"67\" suspicious=\"1\">|</charParams>\n"
			+ "<charParams l=\"381\" t=\"50\" r=\"384\" b=\"68\"> </charParams>\n"
			+ "<charParams l=\"385\" t=\"55\" r=\"392\" b=\"66\">Q</charParams>\n"
			+ "<charParams l=\"393\" t=\"57\" r=\"398\" b=\"63\">o</charParams>\n"
			+ "<charParams l=\"399\" t=\"55\" r=\"404\" b=\"63\">S</charParams></formatting></line></par>\n"
			+ "<par align=\"Justified\" startIndent=\"1100\" lineSpacing=\"860\">\n"
			+ "<line baseline=\"78\" l=\"18\" t=\"70\" r=\"246\" b=\"77\"><formatting lang=\"EnglishUnitedStates\">\n"
			+ "<charParams l=\"18\" t=\"71\" r=\"22\" b=\"76\" suspicious=\"1\">L</charParams>\n"
			+ "<charParams l=\"23\" t=\"71\" r=\"28\" b=\"76\" suspicious=\"1\">a</charParams>\n"
			+ "<charParams l=\"29\" t=\"71\" r=\"34\" b=\"76\" suspicious=\"1\">b</charParams>\n"
			+ "<charParams l=\"35\" t=\"71\" r=\"38\" b=\"76\" suspicious=\"1\">t</charParams>\n"
			+ "<charParams l=\"41\" t=\"71\" r=\"43\" b=\"76\" suspicious=\"1\">i</charParams>\n"
			+ "<charParams l=\"43\" t=\"71\" r=\"45\" b=\"76\" suspicious=\"1\">i</charParams>\n"
			+ "<charParams l=\"47\" t=\"71\" r=\"49\" b=\"76\" suspicious=\"1\">i</charParams>\n"
			+ "<charParams l=\"49\" t=\"72\" r=\"50\" b=\"76\" suspicious=\"1\">i</charParams>\n"
			+ "<charParams l=\"52\" t=\"72\" r=\"56\" b=\"77\" suspicious=\"1\">u</charParams>\n"
			+ "<charParams l=\"57\" t=\"72\" r=\"62\" b=\"77\" suspicious=\"1\">a</charParams>\n"
			+ "<charParams l=\"63\" t=\"72\" r=\"64\" b=\"77\" suspicious=\"1\">i</charParams>\n"
			+ "<charParams l=\"65\" t=\"72\" r=\"71\" b=\"77\" suspicious=\"1\">u</charParams>\n"
			+ "<charParams l=\"72\" t=\"72\" r=\"77\" b=\"77\" suspicious=\"1\">a</charParams>\n"
			+ "<charParams l=\"79\" t=\"72\" r=\"83\" b=\"77\">u</charParams>\n"
			+ "<charParams l=\"84\" t=\"72\" r=\"90\" b=\"77\">u</charParams>\n"
			+ "<charParams l=\"90\" t=\"72\" r=\"92\" b=\"77\" suspicious=\"1\">i</charParams>\n"
			+ "<charParams l=\"94\" t=\"72\" r=\"95\" b=\"77\" suspicious=\"1\">i</charParams>\n"
			+ "<charParams l=\"96\" t=\"71\" r=\"98\" b=\"77\"> </charParams>\n"
			+ "<charParams l=\"99\" t=\"71\" r=\"101\" b=\"77\" suspicious=\"1\">i</charParams>\n"
			+ "<charParams l=\"103\" t=\"71\" r=\"109\" b=\"77\" suspicious=\"1\">c</charParams>\n"
			+ "<charParams l=\"109\" t=\"71\" r=\"117\" b=\"77\" suspicious=\"1\">m</charParams>\n"
			+ "<charParams l=\"117\" t=\"71\" r=\"126\" b=\"77\" suspicious=\"1\">m</charParams>\n"
			+ "<charParams l=\"127\" t=\"71\" r=\"129\" b=\"77\" suspicious=\"1\">;</charParams>\n"
			+ "<charParams l=\"130\" t=\"70\" r=\"196\" b=\"77\" isTab=\"1\" tabLeaderCount=\"13\"> </charParams>\n"
			+ "<charParams l=\"197\" t=\"70\" r=\"205\" b=\"76\" suspicious=\"1\">m</charParams>\n"
			+ "<charParams l=\"205\" t=\"70\" r=\"210\" b=\"76\" suspicious=\"1\">m</charParams>\n"
			+ "<charParams l=\"210\" t=\"70\" r=\"218\" b=\"76\" suspicious=\"1\">x</charParams>\n"
			+ "<charParams l=\"218\" t=\"70\" r=\"224\" b=\"76\" suspicious=\"1\">c</charParams>\n"
			+ "<charParams l=\"224\" t=\"70\" r=\"234\" b=\"76\" suspicious=\"1\">m</charParams>\n"
			+ "<charParams l=\"235\" t=\"71\" r=\"237\" b=\"76\" suspicious=\"1\">i</charParams>\n"
			+ "<charParams l=\"238\" t=\"71\" r=\"244\" b=\"76\" suspicious=\"1\">u</charParams>\n"
			+ "<charParams l=\"244\" t=\"71\" r=\"246\" b=\"76\" suspicious=\"1\">i</charParams></formatting></line></par>\n"
			+ "<par align=\"Justified\" startIndent=\"1100\" lineSpacing=\"860\">\n"
			+ "<line baseline=\"104\" l=\"18\" t=\"92\" r=\"303\" b=\"104\"><formatting lang=\"EnglishUnitedStates\">\n"
			+ "<charParams l=\"18\" t=\"94\" r=\"23\" b=\"102\">V</charParams>\n"
			+ "<charParams l=\"24\" t=\"94\" r=\"25\" b=\"102\">i</charParams>\n"
			+ "<charParams l=\"26\" t=\"96\" r=\"32\" b=\"102\">o</charParams>\n"
			+ "<charParams l=\"32\" t=\"93\" r=\"33\" b=\"102\">l</charParams>\n"
			+ "<charParams l=\"34\" t=\"96\" r=\"39\" b=\"102\">a</charParams>\n"
			+ "<charParams l=\"41\" t=\"94\" r=\"44\" b=\"102\">t</charParams>\n"
			+ "<charParams l=\"44\" t=\"94\" r=\"45\" b=\"102\">i</charParams>\n"
			+ "<charParams l=\"46\" t=\"95\" r=\"52\" b=\"102\">o</charParams>\n"
			+ "<charParams l=\"52\" t=\"95\" r=\"57\" b=\"102\">n</charParams>\n"
			+ "<charParams l=\"58\" t=\"95\" r=\"60\" b=\"102\"> </charParams>\n"
			+ "<charParams l=\"61\" t=\"95\" r=\"65\" b=\"102\">s</charParams>\n"
			+ "<charParams l=\"67\" t=\"94\" r=\"70\" b=\"102\">t</charParams>\n"
			+ "<charParams l=\"70\" t=\"96\" r=\"75\" b=\"103\">a</charParams>\n"
			+ "<charParams l=\"77\" t=\"95\" r=\"80\" b=\"103\">t</charParams>\n"
			+ "<charParams l=\"80\" t=\"96\" r=\"85\" b=\"103\">e</charParams>\n"
			+ "<charParams l=\"87\" t=\"97\" r=\"89\" b=\"103\">:</charParams>\n"
			+ "<charParams l=\"90\" t=\"93\" r=\"197\" b=\"103\" isTab=\"1\" tabLeaderCount=\"21\"> </charParams>\n"
			+ "<charParams l=\"198\" t=\"92\" r=\"201\" b=\"103\">f</charParams>\n"
			+ "<charParams l=\"201\" t=\"95\" r=\"206\" b=\"103\">e</charParams>\n"
			+ "<charParams l=\"207\" t=\"95\" r=\"212\" b=\"103\">a</charParams>\n"
			+ "<charParams l=\"214\" t=\"94\" r=\"217\" b=\"103\">t</charParams>\n"
			+ "<charParams l=\"217\" t=\"96\" r=\"222\" b=\"102\">u</charParams>\n"
			+ "<charParams l=\"223\" t=\"95\" r=\"226\" b=\"102\">r</charParams>\n"
			+ "<charParams l=\"227\" t=\"95\" r=\"232\" b=\"102\">e</charParams>\n"
			+ "<charParams l=\"233\" t=\"95\" r=\"235\" b=\"102\"> </charParams>\n"
			+ "<charParams l=\"236\" t=\"95\" r=\"241\" b=\"102\">n</charParams>\n"
			+ "<charParams l=\"242\" t=\"95\" r=\"247\" b=\"102\">o</charParams>\n"
			+ "<charParams l=\"249\" t=\"94\" r=\"251\" b=\"103\">t</charParams>\n"
			+ "<charParams l=\"252\" t=\"95\" r=\"254\" b=\"103\"> </charParams>\n"
			+ "<charParams l=\"255\" t=\"96\" r=\"259\" b=\"103\">s</charParams>\n"
			+ "<charParams l=\"260\" t=\"97\" r=\"265\" b=\"103\">u</charParams>\n"
			+ "<charParams l=\"266\" t=\"96\" r=\"272\" b=\"104\">p</charParams>\n"
			+ "<charParams l=\"272\" t=\"96\" r=\"278\" b=\"104\">p</charParams>\n"
			+ "<charParams l=\"278\" t=\"96\" r=\"283\" b=\"103\">o</charParams>\n"
			+ "<charParams l=\"284\" t=\"96\" r=\"287\" b=\"102\">r</charParams>\n"
			+ "<charParams l=\"288\" t=\"94\" r=\"292\" b=\"102\">t</charParams>\n"
			+ "<charParams l=\"292\" t=\"96\" r=\"297\" b=\"102\">e</charParams>\n"
			+ "<charParams l=\"298\" t=\"93\" r=\"303\" b=\"102\">d</charParams></formatting></line></par>\n"
			+ "<par lineSpacing=\"860\">\n"
			+ "<line baseline=\"133\" l=\"10\" t=\"122\" r=\"121\" b=\"134\"><formatting lang=\"EnglishUnitedStates\">\n"
			+ "<charParams l=\"10\" t=\"123\" r=\"15\" b=\"131\">S</charParams>\n"
			+ "<charParams l=\"16\" t=\"123\" r=\"19\" b=\"131\">t</charParams>\n"
			+ "<charParams l=\"20\" t=\"125\" r=\"25\" b=\"131\">a</charParams>\n"
			+ "<charParams l=\"26\" t=\"123\" r=\"29\" b=\"131\">t</charParams>\n"
			+ "<charParams l=\"30\" t=\"125\" r=\"35\" b=\"131\">e</charParams>\n"
			+ "<charParams l=\"36\" t=\"125\" r=\"40\" b=\"131\">s</charParams>\n"
			+ "<charParams l=\"41\" t=\"122\" r=\"43\" b=\"131\"> </charParams>\n"
			+ "<charParams l=\"44\" t=\"122\" r=\"45\" b=\"131\">l</charParams>\n"
			+ "<charParams l=\"46\" t=\"125\" r=\"51\" b=\"131\">a</charParams>\n"
			+ "<charParams l=\"52\" t=\"125\" r=\"56\" b=\"131\">s</charParams>\n"
			+ "<charParams l=\"57\" t=\"123\" r=\"60\" b=\"131\">t</charParams>\n"
			+ "<charParams l=\"61\" t=\"123\" r=\"63\" b=\"131\"> </charParams>\n"
			+ "<charParams l=\"64\" t=\"124\" r=\"68\" b=\"131\">c</charParams>\n"
			+ "<charParams l=\"69\" t=\"122\" r=\"74\" b=\"131\">h</charParams>\n"
			+ "<charParams l=\"75\" t=\"124\" r=\"80\" b=\"131\">a</charParams>\n"
			+ "<charParams l=\"81\" t=\"124\" r=\"86\" b=\"132\">n</charParams>\n"
			+ "<charParams l=\"87\" t=\"125\" r=\"92\" b=\"134\">g</charParams>\n"
			+ "<charParams l=\"93\" t=\"125\" r=\"98\" b=\"132\">e</charParams>\n"
			+ "<charParams l=\"99\" t=\"124\" r=\"101\" b=\"132\"> </charParams>\n"
			+ "<charParams l=\"102\" t=\"124\" r=\"105\" b=\"132\">t</charParams>\n"
			+ "<charParams l=\"106\" t=\"124\" r=\"107\" b=\"132\">i</charParams>\n"
			+ "<charParams l=\"108\" t=\"125\" r=\"115\" b=\"132\">m</charParams>\n"
			+ "<charParams l=\"116\" t=\"125\" r=\"121\" b=\"132\">e</charParams></formatting></line></par>\n"
			+ "<par align=\"Justified\" startIndent=\"1100\" lineSpacing=\"860\">\n"
			+ "<line baseline=\"157\" l=\"18\" t=\"141\" r=\"299\" b=\"162\"><formatting lang=\"EnglishUnitedStates\">\n"
			+ "<charParams l=\"18\" t=\"147\" r=\"24\" b=\"155\">U</charParams>\n"
			+ "<charParams l=\"25\" t=\"149\" r=\"31\" b=\"157\">p</charParams>\n"
			+ "<charParams l=\"32\" t=\"149\" r=\"33\" b=\"157\"> </charParams>\n"
			+ "<charParams l=\"34\" t=\"149\" r=\"39\" b=\"155\">o</charParams>\n"
			+ "<charParams l=\"40\" t=\"149\" r=\"46\" b=\"157\">p</charParams>\n"
			+ "<charParams l=\"46\" t=\"149\" r=\"51\" b=\"155\">e</charParams>\n"
			+ "<charParams l=\"52\" t=\"149\" r=\"55\" b=\"155\">r</charParams>\n"
			+ "<charParams l=\"56\" t=\"149\" r=\"61\" b=\"155\">a</charParams>\n"
			+ "<charParams l=\"63\" t=\"147\" r=\"66\" b=\"155\">t</charParams>\n"
			+ "<charParams l=\"66\" t=\"147\" r=\"67\" b=\"155\">i</charParams>\n"
			+ "<charParams l=\"68\" t=\"148\" r=\"74\" b=\"155\">o</charParams>\n"
			+ "<charParams l=\"74\" t=\"148\" r=\"79\" b=\"155\">n</charParams>\n"
			+ "<charParams l=\"80\" t=\"148\" r=\"85\" b=\"155\">a</charParams>\n"
			+ "<charParams l=\"86\" t=\"146\" r=\"87\" b=\"155\">l</charParams>\n"
			+ "<charParams l=\"88\" t=\"146\" r=\"90\" b=\"155\"> </charParams>\n"
			+ "<charParams l=\"91\" t=\"148\" r=\"96\" b=\"155\">s</charParams>\n"
			+ "<charParams l=\"97\" t=\"147\" r=\"100\" b=\"155\">t</charParams>\n"
			+ "<charParams l=\"100\" t=\"148\" r=\"105\" b=\"156\">a</charParams>\n"
			+ "<charParams l=\"107\" t=\"148\" r=\"110\" b=\"156\">t</charParams>\n"
			+ "<charParams l=\"110\" t=\"149\" r=\"115\" b=\"156\">e</charParams>\n"
			+ "<charParams l=\"117\" t=\"150\" r=\"119\" b=\"156\">:</charParams>\n"
			+ "<charParams l=\"120\" t=\"142\" r=\"193\" b=\"161\" isTab=\"1\" tabLeaderCount=\"14\"> </charParams>\n"
			+ "<charParams l=\"194\" t=\"142\" r=\"195\" b=\"161\" suspicious=\"1\">1</charParams>\n"
			+ "<charParams l=\"198\" t=\"147\" r=\"203\" b=\"156\" suspicious=\"1\">2</charParams>\n"
			+ "<charParams l=\"203\" t=\"147\" r=\"209\" b=\"156\" suspicious=\"1\">0</charParams>\n"
			+ "<charParams l=\"211\" t=\"148\" r=\"214\" b=\"156\" suspicious=\"1\">1</charParams>\n"
			+ "<charParams l=\"215\" t=\"147\" r=\"221\" b=\"156\">9</charParams>\n"
			+ "<charParams l=\"222\" t=\"151\" r=\"224\" b=\"153\">-</charParams>\n"
			+ "<charParams l=\"224\" t=\"147\" r=\"230\" b=\"156\" suspicious=\"1\">0</charParams>\n"
			+ "<charParams l=\"233\" t=\"148\" r=\"236\" b=\"156\" suspicious=\"1\">1</charParams>\n"
			+ "<charParams l=\"238\" t=\"151\" r=\"241\" b=\"153\">-</charParams>\n"
			+ "<charParams l=\"242\" t=\"147\" r=\"247\" b=\"156\">2</charParams>\n"
			+ "<charParams l=\"247\" t=\"147\" r=\"252\" b=\"156\">9</charParams>\n"
			+ "<charParams l=\"253\" t=\"147\" r=\"255\" b=\"156\"> </charParams>\n"
			+ "<charParams l=\"256\" t=\"147\" r=\"261\" b=\"156\">0</charParams>\n"
			+ "<charParams l=\"262\" t=\"147\" r=\"268\" b=\"155\">4</charParams>\n"
			+ "<charParams l=\"269\" t=\"149\" r=\"271\" b=\"156\">:</charParams>\n"
			+ "<charParams l=\"272\" t=\"147\" r=\"277\" b=\"156\">0</charParams>\n"
			+ "<charParams l=\"278\" t=\"147\" r=\"283\" b=\"155\">9</charParams>\n"
			+ "<charParams l=\"285\" t=\"149\" r=\"287\" b=\"155\">:</charParams>\n"
			+ "<charParams l=\"288\" t=\"147\" r=\"294\" b=\"155\">4</charParams>\n"
			+ "<charParams l=\"296\" t=\"147\" r=\"299\" b=\"156\">1</charParams></formatting></line></par>\n"
			+ "<par startIndent=\"1100\" lineSpacing=\"860\">\n"
			+ "<line baseline=\"183\" l=\"18\" t=\"172\" r=\"212\" b=\"184\"><formatting lang=\"EnglishUnitedStates\">\n"
			+ "<charParams l=\"18\" t=\"173\" r=\"24\" b=\"182\">D</charParams>\n"
			+ "<charParams l=\"25\" t=\"175\" r=\"30\" b=\"181\">o</charParams>\n"
			+ "<charParams l=\"31\" t=\"175\" r=\"38\" b=\"181\">w</charParams>\n"
			+ "<charParams l=\"39\" t=\"175\" r=\"44\" b=\"181\">n</charParams>\n"
			+ "<charParams l=\"45\" t=\"175\" r=\"47\" b=\"181\"> </charParams>\n"
			+ "<charParams l=\"48\" t=\"175\" r=\"53\" b=\"181\">o</charParams>\n"
			+ "<charParams l=\"54\" t=\"175\" r=\"60\" b=\"183\">p</charParams>\n"
			+ "<charParams l=\"60\" t=\"175\" r=\"65\" b=\"181\">e</charParams>\n"
			+ "<charParams l=\"66\" t=\"175\" r=\"69\" b=\"181\">r</charParams>\n"
			+ "<charParams l=\"70\" t=\"175\" r=\"75\" b=\"181\">a</charParams>\n"
			+ "<charParams l=\"77\" t=\"173\" r=\"80\" b=\"181\">t</charParams>\n"
			+ "<charParams l=\"80\" t=\"173\" r=\"81\" b=\"181\">i</charParams>\n"
			+ "<charParams l=\"82\" t=\"174\" r=\"88\" b=\"181\">o</charParams>\n"
			+ "<charParams l=\"88\" t=\"174\" r=\"93\" b=\"181\">n</charParams>\n"
			+ "<charParams l=\"94\" t=\"174\" r=\"99\" b=\"181\">a</charParams>\n"
			+ "<charParams l=\"100\" t=\"172\" r=\"101\" b=\"181\">l</charParams>\n"
			+ "<charParams l=\"102\" t=\"173\" r=\"104\" b=\"182\"> </charParams>\n"
			+ "<charParams l=\"105\" t=\"175\" r=\"109\" b=\"182\">s</charParams>\n"
			+ "<charParams l=\"111\" t=\"174\" r=\"114\" b=\"182\">t</charParams>\n"
			+ "<charParams l=\"114\" t=\"175\" r=\"119\" b=\"182\">a</charParams>\n"
			+ "<charParams l=\"121\" t=\"174\" r=\"124\" b=\"182\">t</charParams>\n"
			+ "<charParams l=\"124\" t=\"175\" r=\"129\" b=\"182\">e</charParams>\n"
			+ "<charParams l=\"131\" t=\"176\" r=\"133\" b=\"182\">:</charParams>\n"
			+ "<charParams l=\"134\" t=\"175\" r=\"196\" b=\"182\" isTab=\"1\" tabLeaderCount=\"12\"> </charParams>\n"
			+ "<charParams l=\"197\" t=\"175\" r=\"202\" b=\"182\">n</charParams>\n"
			+ "<charParams l=\"203\" t=\"173\" r=\"207\" b=\"184\">/</charParams>\n"
			+ "<charParams l=\"207\" t=\"175\" r=\"212\" b=\"182\">a</charParams></formatting></line></par>\n"
			+ "<par startIndent=\"1100\" lineSpacing=\"860\">\n"
			+ "<line baseline=\"208\" l=\"18\" t=\"197\" r=\"300\" b=\"210\"><formatting lang=\"EnglishUnitedStates\">\n"
			+ "<charParams l=\"18\" t=\"199\" r=\"24\" b=\"208\">A</charParams>\n"
			+ "<charParams l=\"25\" t=\"198\" r=\"30\" b=\"207\">d</charParams>\n"
			+ "<charParams l=\"31\" t=\"201\" r=\"38\" b=\"207\">m</charParams>\n"
			+ "<charParams l=\"39\" t=\"199\" r=\"40\" b=\"207\">i</charParams>\n"
			+ "<charParams l=\"41\" t=\"201\" r=\"46\" b=\"207\">n</charParams>\n"
			+ "<charParams l=\"47\" t=\"201\" r=\"49\" b=\"207\"> </charParams>\n"
			+ "<charParams l=\"50\" t=\"201\" r=\"54\" b=\"207\">s</charParams>\n"
			+ "<charParams l=\"56\" t=\"199\" r=\"59\" b=\"207\">t</charParams>\n"
			+ "<charParams l=\"59\" t=\"201\" r=\"64\" b=\"207\">a</charParams>\n"
			+ "<charParams l=\"66\" t=\"199\" r=\"69\" b=\"207\">t</charParams>\n"
			+ "<charParams l=\"69\" t=\"200\" r=\"74\" b=\"207\">e</charParams>\n"
			+ "<charParams l=\"76\" t=\"201\" r=\"78\" b=\"207\">:</charParams>\n"
			+ "<charParams l=\"79\" t=\"198\" r=\"197\" b=\"208\" isTab=\"1\" tabLeaderCount=\"23\"> </charParams>\n"
			+ "<charParams l=\"198\" t=\"199\" r=\"203\" b=\"208\">2</charParams>\n"
			+ "<charParams l=\"203\" t=\"199\" r=\"208\" b=\"208\" suspicious=\"1\">0</charParams>\n"
			+ "<charParams l=\"211\" t=\"200\" r=\"214\" b=\"208\" suspicious=\"1\">1</charParams>\n"
			+ "<charParams l=\"216\" t=\"199\" r=\"221\" b=\"208\">3</charParams>\n"
			+ "<charParams l=\"222\" t=\"203\" r=\"225\" b=\"205\">-</charParams>\n"
			+ "<charParams l=\"225\" t=\"199\" r=\"231\" b=\"208\" suspicious=\"1\">0</charParams>\n"
			+ "<charParams l=\"233\" t=\"200\" r=\"236\" b=\"208\" suspicious=\"1\">1</charParams>\n"
			+ "<charParams l=\"238\" t=\"203\" r=\"241\" b=\"205\">-</charParams>\n"
			+ "<charParams l=\"242\" t=\"199\" r=\"247\" b=\"208\">2</charParams>\n"
			+ "<charParams l=\"247\" t=\"199\" r=\"253\" b=\"208\">9</charParams>\n"
			+ "<charParams l=\"254\" t=\"199\" r=\"255\" b=\"208\" isTab=\"1\" tabLeaderCount=\"1\"> </charParams>\n"
			+ "<charParams l=\"256\" t=\"199\" r=\"262\" b=\"208\">0</charParams>\n"
			+ "<charParams l=\"263\" t=\"199\" r=\"268\" b=\"208\">3</charParams>\n"
			+ "<charParams l=\"269\" t=\"201\" r=\"271\" b=\"207\">:</charParams>\n"
			+ "<charParams l=\"273\" t=\"199\" r=\"278\" b=\"207\">5</charParams>\n"
			+ "<charParams l=\"278\" t=\"199\" r=\"284\" b=\"207\">8</charParams>\n"
			+ "<charParams l=\"285\" t=\"201\" r=\"287\" b=\"207\">:</charParams>\n"
			+ "<charParams l=\"289\" t=\"198\" r=\"294\" b=\"208\">3</charParams>\n"
			+ "<charParams l=\"294\" t=\"199\" r=\"300\" b=\"207\">6</charParams></formatting></line></par>\n"
			+ "</text>\n" + "</block>\n"
			+ "<block blockType=\"Separator\" blockName=\"\" l=\"126\" t=\"127\" r=\"331\" b=\"132\"><region><rect l=\"126\" t=\"127\" r=\"286\" b=\"128\"/><rect l=\"126\" t=\"128\" r=\"328\" b=\"129\"/><rect l=\"126\" t=\"129\" r=\"331\" b=\"130\"/><rect l=\"286\" t=\"130\" r=\"331\" b=\"131\"/><rect l=\"311\" t=\"131\" r=\"315\" b=\"132\"/></region>\n"
			+ "<separator type=\"Black\" thickness=\"2\"><start x=\"126\" y=\"128\"/><end x=\"331\" y=\"130\"/>\n"
			+ "</separator>\n" + "</block>\n" + "</page>\n" + "</document>﻿";

	public static void main(String[] args) {

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
						if (text.has("par")) {

							Object parObject = text.get("par");
							if (parObject instanceof JSONArray) {
								JSONArray parArray = (JSONArray) parObject;
								parArray.forEach(parObj -> {
									JSONObject par = (JSONObject) parObj;

									if (par.has("line")) {
										JSONObject line = (JSONObject) par.get("line");
										int top = line.getInt("t");
										int bottom = line.getInt("b");
										int left = line.getInt("l");
										int right = line.getInt("r");

										System.out.println("TOP :- [" + top + " ]");
										System.out.println("Bottom :-[ " + bottom + " ]");
										System.out.println("left:- [" + left + " ]");
										System.out.println("Right :[" + right + " ]");

										if (line.has("formatting")) {
											JSONObject formatting = (JSONObject) line.get("formatting");
											Object charParamsArrayObj = formatting.get("charParams");
											if (charParamsArrayObj instanceof JSONArray) {

												JSONArray charParamsArray = (JSONArray) charParamsArrayObj;

												charParamsArray.forEach(charParamObj -> {

													JSONObject charParam = (JSONObject) charParamObj;

													if (charParam.has("content")) {
														System.out.print(charParam.get("content"));
													} else {
														System.out.print(" ");
													}

												});
											}
										}
									}

									System.out.println();
									System.out.println("______________________________________________________-");

								});

							} else {
								JSONObject par = (JSONObject) parObject;

								if (par.has("line")) {
									JSONObject line = (JSONObject) par.get("line");

									int top = line.getInt("t");
									int bottom = line.getInt("b");
									int left = line.getInt("l");
									int right = line.getInt("r");

									System.out.println("TOP :- [" + top + " ]");
									System.out.println("Bottom :-[ " + bottom + " ]");
									System.out.println("left:- [" + left + " ]");
									System.out.println("Right :[" + right + " ]");
									if (line.has("formatting")) {
										JSONObject formatting = (JSONObject) line.get("formatting");
										Object charParamsArrayObj = formatting.get("charParams");
										if (charParamsArrayObj instanceof JSONArray) {

											JSONArray charParamsArray = (JSONArray) charParamsArrayObj;

											charParamsArray.forEach(charParamObj -> {

												JSONObject charParam = (JSONObject) charParamObj;

												if (charParam.has("content")) {
													System.out.print(charParam.get("content"));
												} else {
													System.out.print(" ");
												}

											});
										}
									}
								}
							}
							System.out.println();
							System.out.println("______________________________________________________-");
						}
					}

				});
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
