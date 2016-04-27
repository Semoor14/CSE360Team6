package dice.game.myCode;

import java.io.*;  
public class ReadRules 
{   
	public ReadRules() 
	{
		
	}   
	public static String read() 
	{ 
		String rules = ""; 
		try 
		{ 
			FileReader ruleHandler = new FileReader("./rules.txt"); 
			for(int inputC = ruleHandler.read(); inputC != -1; inputC = ruleHandler.read()) 
				rules = (new StringBuilder(String.valueOf(rules))).append((char)inputC).toString();
			ruleHandler.close();
		} 
		catch(FileNotFoundException e) 
		{ 
			rules = "Rule file Not found"; 
		} 
		catch(IOException e) 
		{ 
			e.printStackTrace(); rules = "I/O exception"; 
		} 
		
		return rules; 
	} 
}