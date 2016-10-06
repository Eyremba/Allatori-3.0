package com.allatori;

import java.io.FileReader;

import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class ConfigFile implements IParse {

	/* OK */

	private final String fileName;

	@Override
	public void parse() throws TemplateException {
		try {
			final FileReader fileReader = new FileReader(this.fileName);
			final XMLReader reader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
			reader.setContentHandler(new ConfigFileHandler(this, null));
			reader.parse(new InputSource(fileReader));
		} catch (final SAXException e) {
			throw new TemplateException(e.getMessage());
		} catch (final Exception e) {
			throw new TemplateException(e);
		}
	}

	public ConfigFile(String fileName) {
		this.fileName = fileName;
	}

	public static String getFileName(ConfigFile configFile) {
		return configFile.fileName;
	}
}
