package me.kamilkime.youtube;

import java.util.Random;

import org.apache.commons.lang.Validate;

public class Utils {

	private static final Random RAND = new Random();
	
	public static int getRandInt(int min, int max) throws IllegalArgumentException{
		Validate.isTrue(max > min, "Max can't be smaller than min!");
		return RAND.nextInt(max - min + 1) + min;
	}
	
	public static double getRandDouble(double min, double max) throws IllegalArgumentException{
		Validate.isTrue(max > min, "Max can't be smaller than min!");
		return RAND.nextDouble() * (max - min) + min;
	}
	
	public static boolean getChance(double chance){
		return (chance >= 100) || (chance >= getRandDouble(0, 100));
	}
	
	public static void ERROR(String msg){
		System.out.println("[ERROR] " + msg);
	}
}