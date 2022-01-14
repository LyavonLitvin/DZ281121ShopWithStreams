import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Shop {
    private ArrayList<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        if (productList.stream().count() == 0) {
            productList.add(product);
            System.out.println("Успешное добавление товара");
        } else if (getIdProduct(product) == -1) {
            productList.add(product);
            System.out.println("Успешное добавление товара");
        } else {
            System.out.println("Товар с таким id уже существует");
        }
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public void deleteProduct(int id) {
        int indexProductExisting = getIndexProduct(id);
        if (productList.stream().count() == 0) {
            System.out.println("\n Удаление товара невозможно, список товаров магазина пустой");
        } else if (indexProductExisting == -1) {
            System.out.println("\n Удаление товара невозможно, так как товара с id = " + id + "в списке товаров магазина отсутствует");
        } else {
            productList.remove(indexProductExisting);
            System.out.println("\nТовар с id = " + id + " удален из списка товаров магазина");
        }
    }

    public void editProduct(Product product) {
        int idProductAdding = product.getId();
        boolean ischanging = false;
        for (Product productTmp : productList) {
            int idTmp = productTmp.getId();
            if (idTmp == idProductAdding) {
                productTmp.setName(product.getName());
                productTmp.setPrice(product.getPrice());
                productTmp.setDateOfRefreshing(LocalDateTime.now());
                System.out.println("\nДанные товара с id = " + product.getId() + " в списке товаров магазина успешно обновлены");
                ischanging = true;
            }
        }
        if (!ischanging) {
            System.out.println("\nТовара с таким id не существует");
        }
    }

    public int getIdProduct(Product product) {
//        int id = product.getId();                          Попытка с помощью Stream API искать нужный элемент
//        Optional<Integer> idTmp = productList.stream()
//                .filter(productTmp -> productTmp.getId() == id)
//                .findAny();
//        idTmp.ifPresentOrElse( id = (int) idTmp, id = -1);
//        return id;
        for (Product productTmp : productList) {
            int idTmp = productTmp.getId();
            if (idTmp == product.getId()) {
                return idTmp;
            }
        }
        return -1;
    }

    public int getIndexProduct(int id) {
        for (Product productTmp : productList) {
            int idTmp = productTmp.getId();
            if (idTmp == id) {
                return productList.indexOf(productTmp);
            }
        }
        return -1;
    }

}
