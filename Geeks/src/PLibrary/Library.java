package PLibrary;

import java.util.ArrayList;

class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book b){
        books.add(b);
    }

    public Book getBook(int index){
        return books.get(index);
    }

    private class Log{
        public void log(String message){
            System.out.println(message);
        }
    }
}
