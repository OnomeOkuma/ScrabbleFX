import static org.junit.Assert.*;

import org.junit.Test;

import com.LetsPlay.gameplay.TileBag;

public class TestTilebag {
	
	
	@Test
	public void testGetTileWeight() {
		String letter[] = {"A", "B", "C", "D", "E", "F", "G", "H"};
		
		int letterweight[] = {1, 3, 3, 2, 1, 4, 2, 4};
		TileBag tilebag = new TileBag();
		int counter = 0;
		int[] temp = new int[8];
		
		while (counter < 8){
			temp[counter] = tilebag.getTileWeight(letter[counter]);
			counter++;
		}
		
		assertArrayEquals(letterweight, temp);
		
		
	}	

	@Test
	public void testGetNumber_of_tiles() {
		
		int numberoftiles = 90;
		TileBag tilebag = new TileBag();
		for(int counter = 0; counter < 10; counter++){
			tilebag.getTile();
		}
		
		assertEquals(numberoftiles, tilebag.getNumber_of_tiles());
	}
	
	@Test
	public void testGetNumber_of_tiles2() {
		
		int numberoftiles = 60;
		TileBag tilebag = new TileBag();
		for(int counter = 0; counter < 40; counter++){
			tilebag.getTile();
		}
		
		assertEquals(numberoftiles, tilebag.getNumber_of_tiles());
	}

}
