package com.patt;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 5; i++) {

			for (int j = i; j <= 5; j++) {

				System.out.print("  " + j);
			}
			System.out.println();
		}

		// OutPut
		// 1 2 3 4 5
		// 2 3 4 5
		// 3 4 5
		// 4 5
		// 5

		System.out.println("\n\n\n\n*********************************   1  ******************************************");

		for (int i = 1; i <= 5; i++) {

			for (int j = 5; j >= i; j--) {

				System.out.print("  " + j);
			}
			System.out.println();
		}

		// OutPut
		// 5 4 3 2 1
		// 5 4 3 2
		// 5 4 3
		// 5 4
		// 5

		System.out.println("\n\n\n\n************************************  2   ***************************************");

		for (int i = 5; i >= 1; i--) {

			for (int j = i; j <= 5; j++) {

				System.out.print("  " + i);
			}
			System.out.println();
		}

		// OutPut
		// 5
		// 4 4
		// 3 3 3
		// 2 2 2 2
		// 1 1 1 1 1

		System.out.println("\n\n\n\n**********************************   3   *************************************");

		for (int i = 1; i <= 5; i++) {

			for (int j = 1; j <= i; j++) {

				System.out.print(j + "  ");
			}

			System.out.println();
		}

		// OutPut
		// 1
		// 1 2
		// 1 2 3
		// 1 2 3 4
		// 1 2 3 4 5

		System.out.println("\n\n\n**********************************  4   *************************************");

		for (int i = 9; i >= 1; i--) {

			for (int j = i; j >= 1; j--) {

				if (j == 6) {
					System.out.print("  " + 9);
				} else if (j == 9) {
					System.out.print("  " + 6);
				} else {
					System.out.print("  " + j);

				}
			}
			System.out.println();
		}

		// OutPut
		// 6 8 7 9 5 4 3 2 1
		// 8 7 9 5 4 3 2 1
		// 7 9 5 4 3 2 1
		// 9 5 4 3 2 1
		// 5 4 3 2 1
		// 4 3 2 1
		// 3 2 1
		// 2 1
		// 1
		
		System.out.println("\n\n\n***************************  5   ***********************");

		
		for (int i = 1; i <= 5; i++) {
			int num = i;

			for (int j = 1; j <= i; j++) {
				System.out.print(num + " ");

				num = num + 1;
			}

			System.out.println();
		}

		// Output
		// 1
		// 2 3
		// 3 4 5
		// 4 5 6 7
		// 5 6 7 8 9

		
		
		FileInputStream reader = new FileInputStream("D://f.txt");
		FileOutputStream writer = new FileOutputStream("D://ff.txt");
		boolean inBlockComment = false;
		boolean inSlashSlashComment = false;
		int char1 = reader.read();
		if (char1 != -1) {
			int char2;
			while (char1 != -1) {
				if ((char2 = reader.read()) == -1) {
					writer.write(char1);
					break;
				}
				if (char1 == '/' && char2 == '*') {
					inBlockComment = true;
					char1 = reader.read();
					continue;
				} else if (char1 == '*' && char2 == '/') {
					inBlockComment = false;
					char1 = reader.read();
					continue;
				} else if (char1 == '/' && char2 == '/' && !inBlockComment) {
					inSlashSlashComment = true;
					char1 = reader.read();
					continue;
				}
				if (inBlockComment) {
					char1 = char2;
					continue;
				}
				if (inSlashSlashComment) {
					if (char2 == '\n') {
						inSlashSlashComment = false;
						writer.write(char2);
						char1 = reader.read();
						continue;
					} else if (char1 == '\n') {
						inSlashSlashComment = false;
						writer.write(char1);
						char1 = char2;
						continue;
					} else {
						char1 = reader.read();
						continue;
					}
				}
				writer.write(char1);
				char1 = char2;
			}
			writer.flush();
			writer.close();
			reader.close();
		}
		System.out.println("success....");
		
		
		

	}

}
