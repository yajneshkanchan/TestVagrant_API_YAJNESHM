package Tasks;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericUtilities.GetJsonValue;
import genericUtilities.BaseAPI_class;

public class ValidateForeignPlayers extends BaseAPI_class {
	@Test
	public void validateForeignPlayersTest() throws FileNotFoundException, IOException, ParseException {
		int ForeignPlayersCount = 0;
		jsonArr = GetJsonValue.getJsonObjectArray(jsonobj, "player");
		for (int i = 0; i < jsonArr.size(); i++) {
			JSONObject player = (JSONObject) jsonArr.get(i);
			String country = GetJsonValue.getJsonObjectValue(player, "country");
			if (!country.equalsIgnoreCase("India"))
				ForeignPlayersCount++;
		}
		// Assert.assertEquals(ForeignPlayersCount, 4);
		if (ForeignPlayersCount >= 4) {
			Reporter.log("Team has only " + ForeignPlayersCount + " Foreign Players", true);
		} else {
			Reporter.log("Team is not having 4 Foreign Players");
			Assert.fail();
		}

	}
}
