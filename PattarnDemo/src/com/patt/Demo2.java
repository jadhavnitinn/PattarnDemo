package com.patt;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 9; i >= 1; i--) {

			for (int j = i; j >= 1; j--) {

				if (j == 6) {
					System.out.print("  " + 9);
				}
				else if (j == 9) {
					System.out.print("  " + 6);
				} else {
					System.out.print("  " + j);

				}
			}
			System.out.println();
		}
	}

}
