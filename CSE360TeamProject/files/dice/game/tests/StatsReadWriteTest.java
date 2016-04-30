package dice.game.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dice.game.myCode.StatsReadWrite;

public class StatsReadWriteTest {
	@Test
	public void testConstructor(){
		StatsReadWrite fileHandler = new StatsReadWrite();
		assertNotNull(fileHandler);
	}
}
