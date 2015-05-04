package ua.org.oa.kostitcina;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// –еализовать программу котора€ будет копировать 
//  все файлы из одной папки в другую использу€ потоки

public class CopyFiles {

	private static void copyFile(String source, String destination)
			throws IOException {

		FileReader reader = new FileReader(source);
		FileWriter writer = new FileWriter(destination);

		while (reader.ready()) {
			writer.write(reader.read());
		}

		reader.close();
		writer.close();

	}

	public static void copy(String source, String destination)
			throws IOException {
		File f = new File(source);
		if (f.isDirectory()) {
			File d = new File(destination);
			d.mkdir();
			String[] list = f.list();
			for (int i = 0; i < list.length; i++) {
				copy(source + "\\\\" + list[i], destination + "\\\\" + list[i]);
			}
		} else {
			copyFile(source, destination);
		}

	}

	public static void main(String[] args) throws IOException {

		copy("C:\\\\Temp\\\\java\\\\from", "C:\\\\Temp\\\\java\\\\to");

	}
}
