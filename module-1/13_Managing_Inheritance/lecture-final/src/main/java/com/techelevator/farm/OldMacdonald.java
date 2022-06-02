package com.techelevator.farm;

import com.techelevator.nintendo.Mario;
import com.techelevator.nintendo.VideoGameCharacter;

public class OldMacdonald {
	public static void main(String[] args) {

		// 1. Force FarmAnimal to be inherited. Do not allow it to be instantiated on its own
		// 2. Change the eat() method in FarmAnimal to force any inheriting class to provide a custom implementation
		// 3. Create a cat class. Cats are unique. Don't let anyone else be allowed to extend the cat class
		// 4. Don't let any child classes of cow be able to override moo()





		//You cannot call protected methods or properties from other packages unless you are a descendant of the class in question
		//mario.doSecretMove();

		Singable[] singables =
				new Singable[] {new Cow(), new Chicken(), new Pig(), new Tractor(), new Cat()};

		for (Singable singable : singables) {
			String name = singable.getName();
			String sound = singable.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name
					+ ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound
					+ " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		Sellable[] sellables = new Sellable[] {new Cow(), new Pig(), new Egg()};

		for (Sellable sellable : sellables) {
			System.out.println("Step right up and get your " + sellable.getName());
			System.out.println("Only $" + sellable.getPrice());
		}
	}
}