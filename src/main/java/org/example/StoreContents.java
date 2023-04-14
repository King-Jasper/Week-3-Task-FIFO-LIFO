package org.example;

import org.example.entities.CustomerInterface;
import org.example.entities.Order;
import org.example.product.Product;
import org.example.services.CashierServices;
import org.example.services.ManagerServices;
import org.example.staffs.Cashier;
import org.example.staffs.Manager;
import org.example.utilities.CustomerIdComparator;

import java.io.IOException;

public class StoreContents {

    public static void main (String[] args) throws IOException {

//        File file = new File("Product Doc- Sheet1.csv");
//        CsvFiles readThis = new CsvFiles();
//        ArrayList<Product> productArrayList = readThis.csvReader(file);
//
////       org.Conveniencestore.fileReader.CsvFiles readMe = new org.Conveniencestore.fileReader.CsvFiles();
////       productArrayList = readMe.csvReader(file);
//       System.out.println("The total number of product added to the store is: " + productArrayList.size());
//

        Manager manager = new Manager("Mr Frank", "AD12");
        ManagerServices man = new ManagerServices(manager);
        Product Apple = new Product("Green Apple", 2000, 100);
        Product Wine = new Product("Red Wine", 4500, 70);
        Product Perfume = new Product("Oil Perfume", 3500, 500);
        Product Cake = new Product("Chocolate Cake", 5000, 5000);
        Product BeerDrinks = new Product("All kinds", 400, 100);

        man.addProductToStore(Apple);
        man.addProductToStore(Wine);
        man.addProductToStore(Perfume);
        man.addProductToStore(Cake);
        man.addProductToStore(BeerDrinks);

//        Cashier cashier1 = new Cashier("Prisca", "SAM111", store1, new CustomerIdComparator());
//        manager.hireCashier(cashier1);
        Cashier cashier2 = new Cashier("Edward Smith", "SAM112", new CustomerIdComparator());
        CashierServices cash = new CashierServices(cashier2);
        man.hireCashier(cashier2);

        CustomerInterface customer = new CustomerInterface("Joseph", 50000.0, 1);

        customer.addToCart(Apple, 5);
        customer.addToCart(Perfume, 7);
        customer.addToCart(Perfume, 7);
        customer.addToCart(Perfume, 7);
        customer.addToCart(Perfume, 7);

        Order order1 = customer.checkout();

        CustomerInterface customer2 = new CustomerInterface("John Michael", 10000.0, 2);
        customer2.addToCart(Apple, 1);
        customer2.addToCart(Apple, 1);
        customer2.addToCart(Apple, 1);
        customer2.addToCart(Apple, 1);
        customer2.addToCart(Apple, 1);
        customer2.addToCart(Perfume, 4);
        customer2.addToCart(BeerDrinks, 4);

        Order order2 = customer2.checkout();

        CustomerInterface customer3 = new CustomerInterface("Felix", 12000.0, 3);
        customer3.addToCart(Perfume, 4);
        customer3.addToCart(Cake, 2);

        Order order3 = customer3.checkout();

        CustomerInterface customer4 = new CustomerInterface("Musa", 1200000.0, 4);
        customer4.addToCart(Perfume, 4);
        customer4.addToCart(Cake, 2);
        customer4.addToCart(Cake, 2);
        customer4.addToCart(Cake, 2);

        Order order4 = customer4.checkout();


//        System.out.println("HIGHEST NUMBER OF ITEMS");
        // Confirming customer service based on Number of items in customer cart.
        cash.addCustomerToTheQueue(customer);
        cash.addCustomerToTheQueue(customer2);
        cash.addCustomerToTheQueue(customer3);
        cash.addCustomerToTheQueue(customer4);

        System.out.println("Cashier 2: " + Store.getVipQueue());
//
//        System.out.println("Cashier 2: " + cashier2.getCustomersQueue());

        cash.attendToHighestCartSize();
        cash.attendToHighestCartSize();
        cash.attendToHighestCartSize();
        cash.attendToHighestCartSize();

        System.out.println("\n**************************FIFO**************");
       cash.attendFirstComeFirstServe();
        cash.attendFirstComeFirstServe();
        cash.attendFirstComeFirstServe();
        cash.attendFirstComeFirstServe();


    }
}
