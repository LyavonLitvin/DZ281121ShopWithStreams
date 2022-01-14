import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Shop shop = new Shop();
        Product product1 = new Product(5468, "Beer", 6);
        Thread.sleep(1000); //add to get more different timeOfCreating
        Product product2 = new Product(9245, "Vodka", 11);
        Thread.sleep(1000); //add to get more different timeOfCreating
        Product product3 = new Product(7632, "Whiskey", 32);
        Thread.sleep(1000); //add to get more different timeOfCreating
        Product product4 = new Product(1268, "Brandy", 38);
        Thread.sleep(1000); //add to get more different timeOfCreating
        Product product5 = new Product(1586, "Rom", 36);
        Thread.sleep(1000); //add to get more different timeOfCreating
        Product product6 = new Product(4967, "Martini", 31);
        Thread.sleep(1000); //add to get more different timeOfCreating
        shop.addProduct(product1);
        shop.addProduct(product2);
        shop.addProduct(product3);
        shop.addProduct(product4);
        shop.addProduct(product5);
        shop.addProduct(product6);
        List<Product> productList = shop.getAllProducts().stream()
                .distinct()
                .collect(Collectors.toList());
        sortProductPriceUp(productList);
        shop.deleteProduct(7632);
        sortByAddingAtList(productList);
        shop.editProduct(new Product(1586, "Margarita", 16));
        writeInConsoleListOfGoods(productList);
        sortProductDateCreatingUp(productList);
        sortProductDateCreatingDown(productList);

    }

    private static void sortProductPriceUp(List productList) {
        List<Product> productArrayList = productList;
        if (productArrayList.stream().count() == 0) {
            System.out.println("Каталог товаров магазина пуст");
        } else {
            System.out.println("Каталог отсортирован по цене (возрастание):");
            productArrayList.stream()
                    .sorted(Comparator.comparingInt(Product::getPrice))
                    .forEach(System.out::println);
        }
    }

    private static void sortProductDateCreatingDown(List productList) {
        List<Product> productArrayList = productList;
        if (productArrayList.stream().count() == 0) {
            System.out.println("Каталог товаров магазина пуст");
        } else {
            System.out.println("Каталог отсортирован по дате создания (возрастание):");
            productArrayList.stream()
                    .sorted(((o1, o2) -> o2.getDateOfCreating().compareTo(o1.getDateOfCreating())))
                    .forEach(System.out::println);
        }
    }

    private static void sortProductDateCreatingUp(List productList) {
        List<Product> productArrayList = productList;
        if (productArrayList.stream().count() == 0) {
            System.out.println("Каталог товаров магазина пуст");
        } else {
            System.out.println("Каталог отсортирован по дате создания (убывание):");
            productArrayList.stream()
                    .sorted((Comparator.comparing(Product::getDateOfCreating)))
                    .forEach(System.out::println);
        }
    }

    public static void sortByAddingAtList(List productList) {
        List<Product> productArrayList = productList;
        if (productArrayList.stream().count() == 0) {
            System.out.println("Каталог товаров магазина пуст");
        } else {
            Collections.reverse(productArrayList);
            productArrayList.stream()
                    .forEach(System.out::println);
        }
    }

    private static void writeInConsoleListOfGoods(List productList) {
        List<Product> productArrayList = productList;
        if (productArrayList.stream().count() == 0) {
            System.out.println("Каталог товаров магазина пуст");
        } else {
            productArrayList.stream()
                    .forEach(System.out::println);
        }
    }
}
