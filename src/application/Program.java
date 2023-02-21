package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();

		System.out.println("Enter the number of products: ");
		int x = sc.nextInt();

		for (int i = 0; i < x; i++) {
			System.out.println("Product #" + (i + 1) + " data:");
			System.out.println("Common, used or imported? (c/u/i)");
			char ch = sc.next().charAt(0);
			System.out.println("Name: ");
			String name = sc.next();
			System.out.println("Price: ");
			double price = sc.nextDouble();
			if (ch == 'u') {

				System.out.println("Manufacture date (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				UsedProduct product = new UsedProduct(name, price, date);
				list.add(product);

			} else if (ch == 'i') {

				System.out.println("Custom fee: ");
				double customFee = sc.nextDouble();
				ImportedProduct product = new ImportedProduct(name, price, customFee);
				list.add(product);
			}

			else {
				Product product = new Product(name, price);
				list.add(product);
			}

		}

		System.out.println("PRICE TAGS:");
		for (Product product : list) {
			System.out.println(product.priceTag());
		}

		sc.close();
	}

}
