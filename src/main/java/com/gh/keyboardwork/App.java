package com.gh.keyboardwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.gh.keyboardwork.exception.InvalidateInputException;


public class App {

	private static HashMap<Integer, String[]> iHashMap = new HashMap<Integer, String[]>();

	static {
		iHashMap.put(0, new String[] {});
		iHashMap.put(1, new String[] {});
		iHashMap.put(2, new String[] { "a", "b", "c" });
		iHashMap.put(3, new String[] { "d", "e", "f" });
		iHashMap.put(4, new String[] { "g", "h", "i" });
		iHashMap.put(5, new String[] { "j", "k", "l" });
		iHashMap.put(6, new String[] { "m", "n", "o" });
		iHashMap.put(7, new String[] { "p", "q", "r", "s" });
		iHashMap.put(8, new String[] { "t", "u", "v" });
		iHashMap.put(9, new String[] { "w", "x", "y", "z" });
	}

	/**
	 * get all combine
	 * 
	 * @param arr
	 * @return
	 */
	public String getRandomCombine(int[] arr) {
		if (arr == null || arr.length == 0) {
			return "";
		}
		String result = "";
		try {
			// init resultArr
			String[] letters1 = getArr(arr[0]);
			ArrayList<String> resultArr = new ArrayList<String>(Arrays.asList(letters1));
			for (int i = 1; i < arr.length; i++) {

				int initLen = resultArr.size(); // get the resultArr's size
												// before Circulation
				int currentNum = arr[i];
				String[] curletters = getArr(currentNum);

				for (int j = 0; j < curletters.length; j++) {
					String letter = curletters[j];

					for (int k = 0; k < initLen; k++) {
						String combineLetter = resultArr.get(k) + letter;
						resultArr.add(combineLetter);

					}
				}
				if (resultArr.size() > initLen) { // add new combine
					for (int t = 0; t < initLen; t++) {
						resultArr.remove(0); // delete old letter
					}
				}

			}
			// generate the result
			for (int i = 0; i < resultArr.size(); i++) {
				result += resultArr.get(i) + " ";

			}
			result = result.trim();
		} catch (InvalidateInputException e) {
			result = "Error: the input num must >0 and <99";
		}

		return result;
	}

	/**
	 * get the letters from the input num
	 * 
	 * @param num
	 * @return
	 * @throws InvalidateInputException
	 */
	public static String[] getArr(int num) throws InvalidateInputException {
		if (num < 0 || num >= 100) {
			throw new InvalidateInputException("the input num is invalid");
		}
		String[] arr = iHashMap.get(num);
		if (arr == null) {
			int hightNum = num / 10;
			int lowNum = num % 10;
			if (hightNum != lowNum) {
				String[] hightArr = iHashMap.get(hightNum);
				String[] lowArr = iHashMap.get(lowNum);
				String[] newArr = arrayCopy(hightArr, lowArr);
				iHashMap.put(num, newArr);
				arr = newArr;
			} else {
				arr = iHashMap.get(hightNum);
				iHashMap.put(num, arr);
			}

		}
		return arr;
	}

	/**
	 * combine the two array's letter
	 * 
	 * @param first
	 *            array
	 * @param secod
	 *            array
	 * @return
	 */
	public static String[] arrayCopy(String[] arr1, String[] arr2) {
		int len1 = arr1.length;
		int len2 = arr2.length;
		String[] newArr = new String[len1 + len2];
		System.arraycopy(arr1, 0, newArr, 0, len1);
		System.arraycopy(arr2, 0, newArr, len1, len2);
		return newArr;

	}

}
