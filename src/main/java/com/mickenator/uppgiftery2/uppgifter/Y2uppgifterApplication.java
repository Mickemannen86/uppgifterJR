package com.mickenator.uppgiftery2.uppgifter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mickenator.uppgiftery2.uppgifter.models.BlogPost;
import com.mickenator.uppgiftery2.uppgifter.models.Forcast;
import com.mickenator.uppgiftery2.uppgifter.models.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.UUID;

@SpringBootApplication
public class Y2uppgifterApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Y2uppgifterApplication.class, args);
	}

	@GetMapping("/helloworld")
	public String hello() {
		return "Hello World!";
	}

	@GetMapping("/")
	public String homepage() {
		return "STARTSIDAN-DEMOJRbeforeSchool";
	}


	// ******************************** Uppgift dag 2 **************************************
	public void ovning1() throws IOException {

		var objectMapper = new ObjectMapper();

		Product products = objectMapper.readValue(new URL("https://dummyjson.com/products/1"),
				Product.class);

		var p1 = products.getTitle();

		var scan = new Scanner(System.in);

		// Menyn
		while (true) {
			apiMenu1();
			System.out.println("Action:");
			int sel = scan.nextInt();


			if (sel == 1) {
				// Hämta produkt 1, hård kodat
				showProductOne(p1);
			} else if (sel == 2) {
				// Gör så man kan mata in vilken produkt man vill se (dynamiskt)
				dynamoSelect(scan);
			} else if (sel == 3) {
				// Produkt som inte finns, hämta hem product 100.vad händer?
				System.out.println("Produkt som inte finns, hämta hem product 100.vad händer?");
			} else if (sel == 9) break;
			else System.out.println("Invalid input, 1-3 or 9 please");
		}
	}

	private void showProductOne(String p1) {
		//Hämta produkt 1
		System.out.println(p1);


	}

	private String dynamoSelect(Scanner scan) throws IOException {

		var seld = scan.next();

		var objectMapper = new ObjectMapper();
		Product typeProduct = objectMapper.readValue(new URL("https://dummyjson.com/products/" + seld),
				Product.class);

		// Hämta dynamiskt
		return seld;


	}

	private void apiMenu1() {
		System.out.println("\n***********************");
		System.out.println("1. Hämta produkt 1");
		System.out.println("2. Hämta dynamiskt produkt");
		System.out.println("3. Hämta produkt 100 som ine finns");
		System.out.println("9. Exit");
		System.out.println("***********************\n");

	}


// *******************************************************************************************


	@Override
	public void run(String... args) throws Exception {

		ovning1();

		//lektion ex 2
		var objectMapper = new ObjectMapper();

		BlogPost[] blogPosts = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/posts"),
				BlogPost[].class);

		BlogPost blogPost = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/posts/1"),
				BlogPost.class);

		System.out.println(blogPost.getId());

		// lektion ex 1
		var forcast = new Forcast();
		forcast.setId(UUID.randomUUID());
		forcast.setTemperature(12f);
		forcast.setDate(20180723);
		forcast.setHour(12);

		String json = objectMapper.writeValueAsString(forcast);
		System.out.println(json);

		Forcast forcast2 = objectMapper.readValue(json, Forcast.class);

		// lektion ex 1 slutar


		//***************************************************************************


		// U1
	}
}
