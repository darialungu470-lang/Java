public class Client{
    private String name;
    private double balance;

    // Конструкторы
    public Client(String name, double balance){
        this.name = name;
        this.balance = balance;
    }

    public Client(String name){
        this.name = name;
        this.balance = 0.0;
    }

    // Геттеры
    public String getName(){
        return name;
    }

    public double getBalance(){
        return balance;
    }

    // Сеттеры
    public void setName(String name){
        this.name = name;
    }

    // Методы для работы с балансом
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
        }
    }

    public boolean withdraw(double amount){
        if( amount > 0 || amount <= balance){
            balance -= amount;
            return true; // успешное снятие
        }
        return false;  // недостаточно денег
    }

    public boolean transfer(Client other, double amount){
        if(withdraw(amount)){
            other.deposit(amount);
            return true;  // успешный перевод
        }
        return false;  // недостаточно денег
    }
}
