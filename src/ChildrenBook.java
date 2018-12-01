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

    public boolean equals(Object object) {
        if(super.equals(object)){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return getName().hashCode()^getAuthor().hashCode();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Автор: " + getAuthor() + " , " + "Название книги: " + getName() + " , " + "Год издания: " + getYear() + " , " + "Минимальный возраст: " + min);
        return out.toString();
    }
}