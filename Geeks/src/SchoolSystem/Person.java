package SchoolSystem;

public class Person {
    protected String name;
    private int age;

    public Person(){
        name = "No name";
        age = 0;
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private class Address{
        private String city;
        private String street;

        public Address(){
            city = "No city";
            street = "No street";
        }

        public Address(String city, String street){
            this.city = city;
            this.street = street;
        }

        public String getCity() {
            return city;
        }

        public String getStreet() {
            return street;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setStreet(String street) {
            this.street = street;
        }
    }
}
