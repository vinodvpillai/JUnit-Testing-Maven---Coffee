package com.zenosys.vinod.junit;

public enum CoffeeType {
	Espresso(7,0),
	Latte(7,227),
	FilterCoffee(10,0);
	
	private final int requiredMilk;
	private final int requriedBeans;
	
	CoffeeType(int requriedBeans,int requiredMilk){
		this.requiredMilk=requiredMilk;
		this.requriedBeans=requriedBeans;
	}
	
	public int getRequiredMilk() {
		return requiredMilk;
	}

	public int getRequiredBeans() {
		return requriedBeans;
	}

}
