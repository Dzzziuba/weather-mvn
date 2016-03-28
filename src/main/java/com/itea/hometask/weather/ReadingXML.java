package com.itea.hometask.weather;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

//import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.io.SAXReader;

public class ReadingXML {

	public Weather parse(InputStream inputStream) throws Exception {
		Weather weather = new Weather();

		SAXReader xmlReader = createXmlReader();
		Document doc = xmlReader.read(inputStream);

		/*
		 * org.dom4j.XPath xpath1 =
		 * doc.createXPath("/query/results/channel/yweather:location/@city");
		 * org.dom4j.XPath xpath2 =
		 * doc.createXPath("/query/results/channel/yweather:location/@region");
		 * org.dom4j.XPath xpath3 = doc.createXPath(
		 * "/query/results/channel/item/yweather:condition/@temp");
		 * org.dom4j.XPath xpath4 = doc.createXPath(
		 * "/query/results/channel/item/yweather:condition/@text");
		 * org.dom4j.XPath xpath5 =
		 * doc.createXPath("/query/results/channel/yweather:wind/@chill");
		 * org.dom4j.XPath xpath6 = doc.createXPath(
		 * "/query/results/channel/yweather:atmosphere/@humidity");
		 * org.dom4j.XPath xpath7 =
		 * doc.createXPath("/query/results/channel/yweather:location/@country");
		 * 
		 * xpath1.setNamespaceURIs(new HashMap<String, String>() {
		 * 
		 * { put("yweather", "http://xml.weather.yahoo.com/ns/rss/1.0"); } });
		 * xpath2.setNamespaceURIs(new HashMap<String, String>() {
		 * 
		 * { put("yweather", "http://xml.weather.yahoo.com/ns/rss/1.0"); } });
		 * xpath3.setNamespaceURIs(new HashMap<String, String>() {
		 * 
		 * { put("yweather", "http://xml.weather.yahoo.com/ns/rss/1.0"); } });
		 * xpath4.setNamespaceURIs(new HashMap<String, String>() {
		 * 
		 * { put("yweather", "http://xml.weather.yahoo.com/ns/rss/1.0"); } });
		 * xpath5.setNamespaceURIs(new HashMap<String, String>() {
		 * 
		 * { put("yweather", "http://xml.weather.yahoo.com/ns/rss/1.0"); } });
		 * xpath6.setNamespaceURIs(new HashMap<String, String>() {
		 * 
		 * { put("yweather", "http://xml.weather.yahoo.com/ns/rss/1.0"); } });
		 * xpath7.setNamespaceURIs(new HashMap<String, String>() {
		 * 
		 * { put("yweather", "http://xml.weather.yahoo.com/ns/rss/1.0"); } });
		 * 
		 * weather.setCity(xpath1.valueOf(doc));
		 * weather.setRegion(xpath2.valueOf(doc));
		 * weather.setTemp(xpath3.valueOf(doc));
		 * weather.setCondition(xpath4.valueOf(doc));
		 * weather.setChill(xpath5.valueOf(doc));
		 * weather.setHumidity(xpath6.valueOf(doc));
		 * weather.setCountry(xpath7.valueOf(doc));
		 */

		weather.setCity(doc.valueOf("/query/results/channel/yweather:location/@city"));
		weather.setRegion(doc.valueOf("/query/results/channel/yweather:location/@region"));
		weather.setCountry(doc.valueOf("/query/results/channel/yweather:location/@country"));
		weather.setCondition(doc.valueOf("/query/results/channel/item/yweather:condition/@text"));
		weather.setTemp(doc.valueOf("/query/results/channel/item/yweather:condition/@temp"));
		weather.setChill(doc.valueOf("/query/results/channel/yweather:wind/@chill"));
		weather.setHumidity(doc.valueOf("/query/results/channel/yweather:atmosphere/@humidity"));

		return weather;
	}

	private SAXReader createXmlReader() {
		Map<String, String> uris = new HashMap<String, String>();
		uris.put("yweather", "http://xml.weather.yahoo.com/ns/rss/1.0");

		DocumentFactory factory = new DocumentFactory();
		factory.setXPathNamespaceURIs(uris);

		SAXReader xmlReader = new SAXReader();
		xmlReader.setDocumentFactory(factory);
		return xmlReader;
	}
}