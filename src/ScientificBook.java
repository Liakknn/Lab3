public class ScientificBook extends Book implements IBook{
    private double index;

    public void setIndex(double index) throws InvalidBookPriceException {
        if(index <= 0) {
            throw new InvalidBookPriceException();
        }
        this.index = index;
    }

    public double getIndex() {
        return index;
    }

    public ScientificBook() {
        super();
        index = 0.0;
    }

    public ScientificBook(String author, String name, double rub, int year, double index) {
        super(author, name, rub, year);
        this.index = index;
    }

    public ScientificBook(String author, int year, double index) {
        super(author, year);
        this.index = index;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Автор: " + getAuthor() + ", " + "Название книги: " + getName() + ", " + "Год издания: " + getYear() + ", " + "Индекс цитируемости: " + index);
        return out.toString();
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
}