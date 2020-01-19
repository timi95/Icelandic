package Iceland.Tech.Test.iceland;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Assert;

import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Iceland.Tech.Test.iceland.models.StoreItem;

import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
class IcelandApplicationTests {

	@Autowired
	StoreItem item;

	@Test
	void contextLoads() {
	}


	// Joda stuff works
	@Test
	public void givenTwoDatesInJodaTime_whenDifferentiating_thenWeGetSix() {
		LocalDate now = LocalDate.now();
		LocalDate sixDaysBehind = now.minusDays(6);
		System.out.println("\nNow: "+now.toString()+" SixDaysBehind: "+sixDaysBehind.toString());
	
		Period period = new Period(now, sixDaysBehind);
		long diff = Math.abs(period.getDays());
		System.out.println("difference: "+period.getDays()+" period object: "+period.toString());

	
		assertEquals(diff, 6);
	}

	@Test
	void CheeseRate(){
		// check brie
		String brie = "Brie";
		Assert.assertArrayEquals( new int[]{0,2}, item.updateStoreQuality(brie, 1, 1, null ) );
	
	}
	
	@Test
	void Edges(){
		// check negatives and over fifty
		Assert.assertArrayEquals( new int[]{0,0}, item.updateStoreQuality("--", 1, -1, null ) );
		Assert.assertArrayEquals( new int[]{0,50}, item.updateStoreQuality("--", 1, 52, null ) );
		Assert.assertArrayEquals( new int[]{-2,40}, item.updateStoreQuality("--", -1, 42, null ) );
	}

	@Test
	void FrozenFoodRate(){
		// check frozen
		String frozen = "Frozen fish";
		Assert.assertArrayEquals( new int[]{1,1}, item.updateStoreQuality(frozen, 2, 2, null ) );
		Assert.assertArrayEquals( new int[]{-2,50}, item.updateStoreQuality(frozen, -1, 55, null ) );
		
	}

	@Test
	void FreshRate(){
		// check fresh
		String fresh = "Fresh fish";
		Assert.assertArrayEquals( new int[]{1,0}, item.updateStoreQuality(fresh, 2, 2, null ) );
		Assert.assertArrayEquals( new int[]{-2,1}, item.updateStoreQuality(fresh, -1, 5, null ) );

	}

	@Test
	void CrackersRate(){
		// check xmas crackers
		String crackers = "Crackers";
		Assert.assertArrayEquals( new int[]{5,0}, item.updateStoreQuality(crackers, 6, 1, new LocalDate(2020,12,26) ) );
		Assert.assertArrayEquals( new int[]{-2,0}, item.updateStoreQuality(crackers, -1, 2, null ) );
		Assert.assertArrayEquals( new int[]{8,4}, item.updateStoreQuality(crackers, 9, 2, null ) );
	}

	@Test
	void SoapRate(){
		// check soap
		String soap = "Detol Anti-Sceptic Soap";
		Assert.assertArrayEquals( new int[]{2,2}, item.updateStoreQuality(soap, 2, 2, null ) );
	}

}
