package com.pgworks.analytics;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class QuartileApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(QuartileApplication.class, args);
		try (
				Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/hello.csv"));
				CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
						.withHeader("Name", "Email", "Phone", "Country")
						.withIgnoreHeaderCase()
						.withTrim());
		) {
			for (CSVRecord csvRecord : csvParser) {
				// Accessing values by the names assigned to each column
				String name = csvRecord.get("Name");
				String email = csvRecord.get("Email");
				String phone = csvRecord.get("Phone");
				String country = csvRecord.get("Country");

				System.out.println("Record No - " + csvRecord.getRecordNumber());
				System.out.println("---------------");
				System.out.println("Name : " + name);
				System.out.println("Email : " + email);
				System.out.println("Phone : " + phone);
				System.out.println("Country : " + country);
				System.out.println("---------------\n\n");
			}
	}

}
}
