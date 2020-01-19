package Iceland.Tech.Test.iceland;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
class IcelandApplicationTests {

	@Test
	void contextLoads() {
	}


	// Joda stuff works
	@Test
	public void givenTwoDatesInJodaTime_whenDifferentiating_thenWeGetSix() {
		LocalDate now = LocalDate.now();
		LocalDate sixDaysBehind = now.minusDays(6);
		System.out.println("Now: "+now.toString()+" \nSixDaysBehind: "+sixDaysBehind.toString());
	
		Period period = new Period(now, sixDaysBehind);
		long diff = Math.abs(period.getDays());
		System.out.println("difference: "+period.getDays()+" \nperiod object: "+period.toString());

	
		assertEquals(diff, 6);
	}

	// @Test
	// void CheeseRate(int sellBy, int quality){

	// }
	
	// @Test
	// void FrozenFoodRate(int sellBy, int quality){

	// }

	// @Test
	// void BasicRate(int sellBy, int quality){
		
	// }

}
