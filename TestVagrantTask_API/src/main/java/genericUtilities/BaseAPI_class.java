package genericUtilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.constant.Constable;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
/**
 * this class contains method and variable which we'll use in every test
 * @author Yajnesh M
 *
 */
public class BaseAPI_class {
	public JSONParser jsonparser;
	public JSONObject jsonobj;
	public JSONArray jsonArr;
	/**
	 * this method will load the file
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	@BeforeClass
	public void loadFile() throws FileNotFoundException, IOException, ParseException {
		jsonparser = new JSONParser();
		jsonobj = (JSONObject) jsonparser.parse(new FileReader(Const.jsonFilePath));
	}
}
