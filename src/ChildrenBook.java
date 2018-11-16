public class ChildrenBook extends Book implements IBook{
    private int min;

    public void setMin(int m) {
        min = m;
    }

    public int getMin() {
        return min;
    }

    public ChildrenBook() {
        super();
        min = 0;
    }

    public ChildrenBook(String author, String name, double rub, int year, int min) {
        super(author, name, rub, year);
        this.min = min;
    }

    public ChildrenBook(String author, int year, int min) {
        super(author, year);
        this.min = min;
    }

    public String toString() {
        String out = "";
        return out = "Автор: " + getAuthor() + " , " + "Название книги: " + getName() + " , " + "Стоимость: " + getRub() + " , " + "Год издания: " + getYear() + " , " + "Минимальный возраст: " + getMin();
    }
}