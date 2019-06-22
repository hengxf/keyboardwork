package com.gh.keyboardwork;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.gh.keyboardwork.exception.InvalidateInputException;

public class AppTest {

	@Test
	public void testGetRandomCombine() {
		App app = new App();
		String result = app.getRandomCombine(new int[] { 2, 3 });
		System.out.println("result=" + result);
		boolean fit = result.equals("ad ae af bd be bf cd ce cf");
		assertFalse(fit);
		System.out.println("app.getRandomCombine(new int[]{9})=" + app.getRandomCombine(new int[] { 9 }));
		System.out.println("app.getRandomCombine(new int[]{1})=" + app.getRandomCombine(new int[] { 1 }));
		System.out.println("app.getRandomCombine(new int[]{2,3,4})=" + app.getRandomCombine(new int[] { 2, 3, 4 }));
		System.out.println("app.getRandomCombine(new int[]{22})=" + app.getRandomCombine(new int[] { 22 }));
		System.out.println("app.getRandomCombine(new int[]{27})=" + app.getRandomCombine(new int[] { 27 }));
		System.out.println("app.getRandomCombine(new int[]{27,3})=" + app.getRandomCombine(new int[] { 27, 3 }));
		System.out.println("app.getRandomCombine(new int[]{07,3})=" + app.getRandomCombine(new int[] { 07, 3 }));
		System.out.println("app.getRandomCombine(new int[]{124,3})=" + app.getRandomCombine(new int[] { 124, 3 }));
	}

	@Test
	public void testGetArr() {
		String[] result;
		try {
			result = new App().getArr(15);
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}

		} catch (InvalidateInputException e) {
			e.printStackTrace();
		}

	}

}
