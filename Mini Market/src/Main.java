import javax.lang.model.type.NullType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Product> products = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void menu(){
        System.out.println("|------- Меню -------|");
        System.out.println("1. Добавить товар");
        System.out.println("2. Показать товар");
        System.out.println("3. Купить товар");
        System.out.println("4. Пополнить склад");
        System.out.println("5. Удалить товар");
        System.out.println("6. Выйти");
    }

    static boolean isValidPrice(double price) {
        if(price <= 0){
            System.out.println("Неплатная цена(");
            return false;
        }
        return true;
    }

    static boolean validateQuantity(int amount){
        if(amount <= 0){
            System.out.println("Неплатнае количество(");
            return false;
        }
        return true;
    }

    static boolean emptyName(String name){
        if(name.isEmpty()){
            System.out.println("Не задано название товара(");
            return false;
        }
        return true;
    }

    public static Product findProductByName(String name){
        for(Product p : products){
            if(p.getName().equals(name)) return p;
        }
        System.out.println("Товар ненайденный(");
        return null;
    }

    static boolean existsProduct(String name){
        for(Product p : products){
            if(p.getName().equals(name)){
                System.out.println("Это товар уже существует...");
                return false;
            }
        }
        return true;
    }

    static void addProduct(){

        System.out.println("Введите название: ");
        String name = sc.nextLine();
        if(!emptyName(name)) return;
        if(!existsProduct(name)) return;
        System.out.println("Введите цену: ");
        double price = Double.parseDouble(sc.nextLine());
        if(!isValidPrice(price)) return;
        Product p = new Product(name, price);
        products.add(p);
    }

    static void showProducts(){
        if(products.isEmpty()){
            System.out.println("На данный момент нет товаров...");
            return;
        }
        int idx = 1;
        System.out.println("|----------- Товары -----------|");
        for(Product p : products) {
            System.out.printf("| %-10s | %7.2f | %5d |\n",p.getName(), p.getPrice(), p.getQuantity());
            ++idx;
        }
        System.out.printf("\n");
    }

    static void buyProduct(){
        System.out.println("Выберите товар: ");
        String name = sc.nextLine();

        System.out.println("Задайте количество: ");
        int amount = Integer.parseInt(sc.nextLine());
        if(!validateQuantity(amount)) return;
        Product p = findProductByName(name);
        if (p == null) return;
        if(p.getQuantity() == 0)
            System.out.println("Нет товара в наличии(");
        else if(p.getQuantity() < amount){
            amount -= p.getQuantity();
            p.removeStock(p.getQuantity());
            System.out.println("Не хватает " + amount);
        }
        else
            p.removeStock(amount);
    }

    static void restockProduct(){
        System.out.println("Введите название: ");
        String name = sc.nextLine();
        if(!emptyName(name)) return;
        System.out.println("Введите количество: ");
        int amount = Integer.parseInt(sc.nextLine());
        if(!validateQuantity(amount)) return;
        Product p = findProductByName(name);
        if (p == null) return;
        if(p.getName().equals(name))
            p.addStock(amount);
    }

    static void deleteProduct(){
        System.out.println("Введите название: ");
        String name = sc.nextLine();
        if(!emptyName(name)) return;
        Product product = findProductByName(name);
        if(product == null) return;
        products.remove(product);
    }

    static void saveProduct() {

        try{
            FileWriter writer = new FileWriter("products.txt");
            for(Product p : products){
                writer.write(p.getName() + "|" + p.getPrice() + "|" + p.getQuantity() + "\n");
            }
            writer.close();
        } catch(IOException e){
            System.out.println("Ошибка работы с файлом");
        }

    }

    static void loadingProduct() {

        try {
            File file = new File("products.txt");
            Scanner scf = new Scanner(file);

            while (scf.hasNextLine()) {

                String line = scf.nextLine();
                String[] parts = line.split("\\|");

                String name = parts[0];
                double price = Double.parseDouble(parts[1]);
                int quantity = Integer.parseInt(parts[2]);

                products.add(new Product(name, price, quantity));
            }
            scf.close();
        } catch(FileNotFoundException e){
            System.out.println("Файл не найден");
        }
    }

    static void main() {

        loadingProduct();
        while (true){

            menu();

            System.out.println("Выберите опцию: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch(option) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    showProducts();
                    break;
                case 3:
                    buyProduct();
                    break;
                case 4:
                    restockProduct();
                    break;
                case 5:
                    deleteProduct();
                    break;
                case 6:
                    saveProduct();
                    return;
            }
        }
    }
}
