package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PropertyHelper {

	private static final String JSON_FILE_PATH = System.getProperty("user.dir")
			+ "//src//main//resources//data//labels.json";
	private static final String TEST_DATA_FILE_PATH = System.getProperty("user.dir")
			+ "//src//main//resources//data//testData.json";

	public static Map<String, String> loadResourcefile(String url, String pageName) {
		Map<String, String> resourceMap = new HashMap<>();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode rootNode = objectMapper.readTree(new File(JSON_FILE_PATH));

			// Get only the relevant section (e.g., "TablesPage" or "AnalyzePage")
			JsonNode pageNode = rootNode.path(pageName);

			// Convert JSON Node to Map<String, String>
			Iterator<Map.Entry<String, JsonNode>> fields = pageNode.fields();
			while (fields.hasNext()) {
				Map.Entry<String, JsonNode> field = fields.next();
				resourceMap.put(field.getKey(), field.getValue().asText());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resourceMap;
	}

	// Read test data from JSON based on the key (e.g., "UXP-1121") and return as
	// Map
	public static Map<String, String> readTestDataJson(String testCaseId) {
		Map<String, String> dataMap = new HashMap<String, String>();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode rootNode = objectMapper.readTree(new File(TEST_DATA_FILE_PATH));

			// Get the data for the specific test case ID
			JsonNode testDataNode = rootNode.path(testCaseId);

			// Convert JSON Node to Map<String, String>
			Iterator<Map.Entry<String, JsonNode>> fields = testDataNode.fields();
			while (fields.hasNext()) {
				Map.Entry<String, JsonNode> field = fields.next();
				dataMap.put(field.getKey(), field.getValue().asText());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataMap;
	}
	
	public static String getGlobalPropertyValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//global.properties");
		prop.load(fis);
		String value = prop.getProperty(key);	
		return value;
	}
}