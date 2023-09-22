package com.sortly.automation.fileutils;

import java.io.FileReader;
import java.io.Reader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;

public class JSONFileReader {

	public String getDataSetPath() {
		return "";
	}

	public <T> T getValue(final String key, final Class<T> tClass) {
		T obj = null;
		String currKey = key;
		String file = getDataSetPath();
		obj = getValue(currKey, file, tClass);
		return obj;
	}

	private <T> T getValue(String key, String file, Class<T> tClass) {
		JSONParser jsonParser = new JSONParser();
		try (FileReader reader = new FileReader(file)) {
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			T t = new Gson().fromJson(jsonObject.get(key).toString(), tClass);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public <T> T getValue(Class<T> t) {
		Gson gson = new Gson();
		try (Reader reader = new FileReader(getDataSetPath())) {
			return gson.fromJson(reader, t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
