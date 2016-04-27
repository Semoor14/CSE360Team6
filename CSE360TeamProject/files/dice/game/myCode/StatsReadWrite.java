package dice.game.myCode;

import java.io.*; 
import java.util.Iterator; 

import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.JSONParser; 
import org.json.simple.parser.ParseException;   
public class StatsReadWrite 
{
	private int gamesPlayed; 
	private int diceRolled; 
	private int playerRecords[];
	
	public StatsReadWrite() 
	{ 
		gamesPlayed = 0; 
		diceRolled = 0; 
		playerRecords = new int[4]; 
		for(int index = 0; index < 4; index++) 
		{
			playerRecords[index] = 0;
		}
	}   
	
	public void write(int dice, int winner) 
	{ 
		boolean fileExists = true; 
		JSONObject previousStats = null; 
		try 
		{ 
			previousStats = read(); 
		} 
		catch(FileNotFoundException e) 
		{ 
			fileExists = false; 
		} 
		if(fileExists) 
		{ 
			gamesPlayed = ((Integer) previousStats.get("Games Played")).intValue(); 
			diceRolled = ((Integer)previousStats.get("Dice Rolled")).intValue(); 
			JSONArray playerResults = (JSONArray)previousStats.get("Players"); 
			Iterator iterator = playerResults.iterator(); 
			for(int count = 0; iterator.hasNext(); count++) 
			{ 
				JSONObject currentPlayer = (JSONObject)iterator.next(); 
				playerRecords[count] = ((Integer)currentPlayer.get("Rounds Won")).intValue(); 
			}   
		} 
		
		gamesPlayed++; 
		diceRolled += dice; 
		playerRecords[winner - 1]++; 
		JSONObject data = new JSONObject(); 
		data.put("Games Played", Integer.valueOf(gamesPlayed)); 
		data.put("Dice Rolled", Integer.valueOf(diceRolled)); 
		JSONArray players = new JSONArray(); 
		JSONObject play1 = new JSONObject(); 
		
		for(int i = 0; i < 4; i++) 
		{ 
			play1 = new JSONObject(); 
			play1.put("name", (new StringBuilder("Player ")).append(i + 1).toString()); 
			play1.put("Rounds Won", Integer.valueOf(playerRecords[i])); 
			players.add(play1); 
		}   
		
		data.put("Players", players); 
		
		try 
		{ 
			FileWriter file = new FileWriter("./stats.txt"); 
			file.write(data.toJSONString()); 
			file.flush(); 
			file.close(); 
		} 
		catch(IOException e) 
		{ 
			e.printStackTrace(); 
		} 	
	}  
	
	public String getStats() 
	{ 
		String result = ""; 
		try 
		{ 
			update(); 
		} 
		catch(FileNotFoundException e) 
		{ 
			return "No Game Statistics Stored yet"; 
		} 
		result = (new StringBuilder(String.valueOf(result))).append("Games Played: ").append(gamesPlayed).append("\n").toString(); 
		result = (new StringBuilder(String.valueOf(result))).append("Dice Rolled: ").append(diceRolled).append("\n").toString(); 
		for(int index = 0; index < playerRecords.length; index++)
		{
			result = (new StringBuilder(String.valueOf(result))).append("Player ").append(index + 1).append(" wins: ").append(playerRecords[index]).append("\n").toString();   
		}
		return result;
	}
	
	private void update() throws FileNotFoundException 
	{ 
		JSONObject previousStats = null; 
		try 
		{ 
			previousStats = read(); 
		} 
		catch(FileNotFoundException e) 
		{ 
			throw e; 
		} 
		gamesPlayed = ((Integer)previousStats.get("Games Played")).intValue(); 
		diceRolled = ((Integer)previousStats.get("Dice Rolled")).intValue(); 
		JSONArray playerResults = (JSONArray)previousStats.get("Players"); 
		Iterator iterator = playerResults.iterator(); 
		for(int count = 0; iterator.hasNext(); count++) 
		{ 
			JSONObject currentPlayer = (JSONObject)iterator.next(); 
			playerRecords[count] = ((Integer)currentPlayer.get("Rounds Won")).intValue();
		}
	}
		
	private JSONObject read() throws FileNotFoundException 
	{ 
		JSONParser parser = new JSONParser(); 
		Object ob = null; 
		try 
		{ 
			ob = parser.parse(new FileReader("./stats.txt")); 
		} 
		catch(FileNotFoundException e) 
		{ 
			throw e; 
		} 
		catch(IOException e) 
		{ 
			e.printStackTrace(); 
		} 
		catch(ParseException e) 
		{ 
			e.printStackTrace(); 
		} 
		JSONObject result = (JSONObject)ob; 
		return result; 
	}   			
}

