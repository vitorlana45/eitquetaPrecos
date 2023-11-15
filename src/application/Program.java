package application;

import entities.*;
import java.util.Scanner;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Product produtos = new Product();
        ImportedProduct Imported = new ImportedProduct();
        UsedProduct usedProduct = new UsedProduct();

        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<Product> List = new ArrayList<>();

        System.out.print("Entre com o numero de produtos: ");
        int n = sc.nextInt();
        char quest;

        for (int i = 1; i <= n; i++) {
            System.out.println("Dados do produto #" + i + ":");
            System.out.print("Comum, usado, importado (c/u/i)?  ");
            quest = sc.next().charAt(0);

            System.out.println("Produto #" + i + " Dados: ");
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Preço: ");
            Double price = sc.nextDouble();

            if (quest == 'c' || quest == 'C') {
                produtos = new Product(name, price);
                List.add(produtos);

            }

            else if (quest == 'u' || quest == 'U') {
                System.out.print("Data de fabricacao (DD/MM/YYYY): ");
                LocalDate date = LocalDate.parse(sc.next(), sdf);
                usedProduct = new UsedProduct(name, price, date);
                List.add(usedProduct);
            }

            if (quest == 'i' || quest == 'I') {
                System.out.print("Taxa de importacao: ");
                Double fee = sc.nextDouble();
                produtos = new ImportedProduct(name, price, fee);
                List.add(produtos);
            }
        }
        System.out.println("ETIQUETAS DE PRECO: ");

        for (Product p : List) {
            System.out.println(p.priceTag());
        }

        sc.close();
    }
}
