public class Book implements IBook{
    private String author;
    private String name;
    private Double rub;
    private int year;

    public Book() {
        author = "не определено";
        name = "не определено";
        rub = 0.0;
        year = 0;
    }

    public Book(String author, String name, double rub, int year) {
        this.author = author;
        this.name = name;
        this.rub = rub;
        this.year = year;
    }

    public Book(String author, int year) {
        this();
        this.author = author;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRub() {
        return rub;
    }

    public void setRub(double rub) throws InvalidBookPriceException{
        if(rub <= 0) {
            throw new InvalidBookPriceException();
        }
        this.rub = rub;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return "Автор: " + getAuthor() + " , " + "Название книги: " + getName() + " , " + "Стоимость: " + getRub() + " , " + "Год издания: " + getYear();
    }
}
