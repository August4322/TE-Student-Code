package com.techelevator.farm;

import java.math.BigDecimal;

public class Cow extends FarmAnimal implements Sellable {
	private BigDecimal price;

	public Cow() {
		super("Cow", "moo!");
		price = new BigDecimal("1500.00");
	}

	public BigDecimal getPrice() {
		return price;
	}

	public final void moo() {
		System.out.println("Moo");
	}

	@Override
	public void eat() {
		System.out.println("I eat grass");
	}
}
