package application;

import entities.ImportdeProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[]args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Product> productList = new ArrayList<>();

        System.out.print("Enter the number of products:");
        int n = sc.nextInt();

        for (int i = 0; i < n; ++i){
            System.out.println("Product #"+(i+1)+" data:");

            System.out.print("Common, used or imported (c/u/i)?");
            char ch = sc.next().charAt(0);
            System.out.print("Name:");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price:");
            Double price = sc.nextDouble();
            if (ch == 'i'){
                System.out.print("Customs fee:");
                Double customsFee = sc.nextDouble();
                ImportdeProduct importdeProduct = new ImportdeProduct(name, price, customsFee);
                productList.add(importdeProduct);
            }else if (ch == 'u'){
                  System.out.print("Manufacture date (DD/MM/YYYY):");
                  Date dateManufacture = sdf.parse(sc.next());
                  UsedProduct usedProduct = new UsedProduct(name, price, dateManufacture);
                  productList.add(usedProduct);
            }else{
                Product product = new Product(name, price);
                productList.add(product);
            }
        }
        System.out.println("PRICE TAGS");

        for (Product product: productList  ){
            System.out.println(product.priceTag());
        }
        sc.close();
    }
}
