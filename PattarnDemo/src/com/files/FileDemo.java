package com.files;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class FileDemo {
	public static void main(String[] args) throws Exception {
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
