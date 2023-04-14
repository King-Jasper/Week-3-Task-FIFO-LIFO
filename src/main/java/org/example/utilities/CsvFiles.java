package org.example.utilities;

import org.example.product.Product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvFiles {
    private ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> csvReader(File file) throws IOException {


        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] row = line.split(",");
            Product product = new Product(row[0],Double.parseDouble(row[1]),    Integer.parseInt(row[2]));
            products.add(product);

        }
        reader.close();
        return products;

    //}
   // public  Product newStock (String[] pObj){
       // String pName = pObj[0];
      // int pPrice = Integer.parseInt(pObj[1]);
        //int pQuantity = Integer.parseInt(pObj[2]);
       // String pCategory = pObj[3];
       // String pStock = pObj[4];
       // return new Product(pName, pPrice, pQuantity);
    }

    public ArrayList<Product> getProducts() {

        for (Product a : products){
            System.out.println(a.toString() + " file");
        }
        return products;
    }
}