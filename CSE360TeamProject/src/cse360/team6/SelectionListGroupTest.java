package cse360.team6;

import static org.junit.Assert.*;
import org.junit.Test;

public class SelectionListGroupTest {

	@Test
	public void constructorTest() {
		String[][] strings = {{"Test_1","Test_2"},{"Test_3","Test_4"}};
		SelectionListGroup group = new SelectionListGroup(strings, 24, 24, 60, 24, 12);
		assertNotNull(group);
	}

}
