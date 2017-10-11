package com.zenosys.vinod.junit;

public class Cafe {

	private int milkInStock = 0;
	private int beansInStock = 0;

	public Coffee brew(CoffeeType coffeeType) {
		return brew(coffeeType, 1);
	}

	public Coffee brew(CoffeeType coffeeType, int quantity) {
		int requiredMilk = quantity * coffeeType.getRequiredMilk();
		int requiredBeans = quantity * coffeeType.getRequiredBeans();
		if (requiredMilk > milkInStock || requiredBeans > beansInStock) {
			throw new IllegalStateException("Insufficient Milk or Coffee");
		}

		milkInStock -= requiredMilk;
		beansInStock -= requiredBeans;
		return new Coffee(coffeeType, requiredBeans, requiredMilk);
	}

	public void restoreBeans(int weightInGrams) {
		requiredPositive(weightInGrams);
		beansInStock += weightInGrams;
	}

	public void restoreMilk(int weightInGrams) {
		requiredPositive(weightInGrams);
		milkInStock += weightInGrams;
	}

	private void requiredPositive(int weightInGrams) {
		if (weightInGrams < 0) {
			throw new IllegalArgumentException();
		}
	}
	

	public int getMilkInStock() {
		return milkInStock;
	}

	public int getBeansInStock() {
		return beansInStock;
	}
}
