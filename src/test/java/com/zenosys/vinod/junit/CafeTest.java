package com.zenosys.vinod.junit;

import static com.zenosys.vinod.junit.CoffeeType.Espresso;
import static com.zenosys.vinod.junit.CoffeeType.FilterCoffee;
import static com.zenosys.vinod.junit.CoffeeType.Latte;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CafeTest {

	private static final int LESS_ZERO = -1;
	private static final int NO_MILK = 0;
	private static final int NO_BEAN = 0;
	private static final int LATTE_BEAN = Latte.getRequiredBeans();
	private static final int LATTE_MILK = Latte.getRequiredMilk();
	private static final int FILTERCOFFEE_BEAN = FilterCoffee
			.getRequiredBeans();
	private static final int FILTERCOFFEE_MILK = FilterCoffee.getRequiredMilk();
	private static final int ESPRESSO_BEAN = Espresso.getRequiredBeans();
	public static final int ESPRESSO_MILK = Espresso.getRequiredMilk();

	private Cafe cafe;

	@Test
	public void canBrewEspresso() {
		// 1. Given Clause
		cafe.restoreBeans(ESPRESSO_BEAN);

		// 2. When Clause
		Coffee coffee = cafe.brew(Espresso);

		// assertThat - Important Type
		assertThat(coffee, hasProperty("beans"));
		assertThat(coffee, hasProperty("beans",equalTo(Espresso)));
		

		// Thinks to assert: 1. Its Espresso only 2. Milk is 0 3. Coffee 7
		// 3. Then Clause
		assertEquals(Espresso, coffee.getCoffeeType());
		assertEquals(ESPRESSO_MILK, coffee.getMilk());
		assertEquals(ESPRESSO_BEAN, coffee.getBeans());
	}

	@Test
	public void brewingExpressoConsumesBeans() {
		cafe.restoreBeans(ESPRESSO_BEAN);

		cafe.brew(Espresso);

		assertEquals(NO_BEAN, cafe.getBeansInStock());
	}

	@Test
	public void canBrewLatte() {
		cafe.restoreBeans(LATTE_BEAN);
		cafe.restoreMilk(LATTE_MILK);

		Coffee coffee = cafe.brew(Latte);

		assertEquals(Latte, coffee.getCoffeeType());
		assertEquals(LATTE_BEAN, coffee.getBeans());
		assertEquals(LATTE_MILK, coffee.getMilk());
	}

	@Test
	public void canBrewFilterCoffee() {
		cafe.restoreBeans(FILTERCOFFEE_BEAN);
		cafe.restoreMilk(FILTERCOFFEE_MILK);

		Coffee coffee = cafe.brew(FilterCoffee);

		assertEquals(FilterCoffee, coffee.getCoffeeType());
		assertEquals(FILTERCOFFEE_BEAN, coffee.getBeans());
		assertEquals(FILTERCOFFEE_MILK, coffee.getMilk());
	}

	@Test(expected = IllegalArgumentException.class)
	public void mustRestockBeans() {
		cafe.restoreBeans(LESS_ZERO);
	}

	@Test(expected = IllegalArgumentException.class)
	public void mustRestockMilk() {
		cafe.restoreMilk(LESS_ZERO);
	}

	@Test(expected = IllegalStateException.class)
	public void mustRestockMilkBrewLatte() {
		cafe.restoreMilk(NO_MILK);
		cafe.brew(CoffeeType.Latte);
	}

	@Before
	public void setUp() {
		cafe = new Cafe();
	}

	/*
	 * Pending Test:
	 * 
	 * To check that map is having a key value : b
	 * assertThat(mapValue,hasKey("B"));
	 * 
	 * To check that list is having a value : 4
	 * assertThat(listValue,hasItem(5));
	 * 
	 */
}
