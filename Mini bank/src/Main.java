import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Main{
    static ArrayList<Client> clients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void menu(){
        System.out.println("1. Добавить клиента");
        System.out.println("2. Показать клиентов");
        System.out.println("3. Пополнить счет");
        System.out.println("4. Снять со счета");
        System.out.println("5. Перевод между клиентами");
        System.out.println("6. Выход");
    }

    static boolean overenieAmount(double amount){
        if (amount <= 0){
            System.out.println("Неплатная сумма(");
            return true;
        }
        return false;
    }

    static void addClient(){
        //Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя клиента: ");
        String name = sc.nextLine();
        Client c = new Client(name);
        clients.add(c);
    }

    static void showClient(){
        int idx = 1;
        for(Client c : clients){
            System.out.println(idx + ". " + c.getName() + " - " + c.getBalance());
            ++idx;
        }
    }

    static void depositClient(){
        System.out.println("Введите имя клиента: ");
        String name = sc.nextLine();

        for(Client c : clients){
            if(c.getName().equals(name)){
                System.out.println("Введите cумму: ");
                double amount = sc.nextDouble();
                sc.nextLine();
                if (overenieAmount(amount)) return;
                c.deposit(amount);
                return;
            }
        }
        System.out.println("Kлиент не найдет:(");
    }

    static void withdrawClient(){
        System.out.println("Введите имя клиента: ");
        String name = sc.nextLine();

        for(Client c : clients){
            if(c.getName().equals(name)){
                System.out.println("Введите cумму: ");
                double amount = sc.nextDouble();
                sc.nextLine();
                if (overenieAmount(amount)) return;
                c.withdraw(amount);
                return;
            }
        }
        System.out.println("Kлиент не найдет:(");

    }

    static void transferClient(){
        System.out.println("От кого: ");
        String sender = sc.nextLine();

        System.out.println("Кому: ");
        String recipient = sc.nextLine();

        for(Client c : clients){
            if(c.getName().equals(sender)){
                for(Client r : clients){
                    if(r.getName().equals(recipient)){
                        System.out.println("Введите cумму: ");
                        double amount = sc.nextDouble();
                        sc.nextLine();
                        if (overenieAmount(amount)) return;
                        c.transfer(r, amount);
                        System.out.println("Перевод успешный!");
                        return;
                    }
                }
            }
        }
        System.out.println("Ошибка! Перевод невыполнен:(");

    }

    static void saveClients() {
        try {
            FileWriter writer = new FileWriter("clients.txt");

            for(Client c : clients){
                writer.write(c.getName() + "|" + c.getBalance()+ "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка работы с файлом");
        }
    }

    static void loadingClients() {

        try {
            File file = new File("clients.txt");
            Scanner scf = new Scanner(file);

            while(scf.hasNextLine()){

                String line = scf.nextLine();
                String[] parts = line.split("\\|");

                String name = parts[0];
                double balance = Double.parseDouble(parts[1]);

                clients.add(new Client(name, balance));
            }
            scf.close();

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

    }

    public static void main(String[] args){

        loadingClients();
        while (true){

            menu();

            System.out.println("Выберите опцию: ");
            int option = sc.nextInt();
            sc.nextLine(); // очистка буфера

            switch (option) {
                case 1 :
                    addClient();
                    break;
                case 2 :
                    showClient();
                    break;
                case 3 :
                    depositClient();
                    break;
                case 4 :
                    withdrawClient();
                    break;
                case 5 :
                    transferClient();
                    break;
                case 6 :
                    saveClients();
                    return;
            }
        }
    }
}
