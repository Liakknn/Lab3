public class ChildrenLibraryHall implements IHall{
    private String forename;
    private IBook[] mas;

    public ChildrenLibraryHall(String forename, int number) {
        this.forename = forename;
        mas = new IBook[number];
        for (int i = 0; i < number; i++) {
            mas[i] = new ChildrenBook(null, i, i);
        }
    }

    public ChildrenLibraryHall(String forename, IBook[] mas) {
        this.forename = forename;
        this.mas = mas;
    }

    public String getForename() {
        return forename;
    }

    public int getNumber() {
        return mas.length;
    }

    public void setSize(int size) {
        for (int i = 0; i < size; i++) {
            mas[i] = new ChildrenBook();
        }
    }

    public IBook[] getMas() {
        return mas;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public IBook[] getBooks() {
        return mas;
    }

    public void setMas(IBook[] mas) throws InvalidBookCountException {
        if(mas.length < 0) {
            throw new InvalidBookCountException();
        }
        this.mas = mas;
    }

    public String printBook() {
        String out = "";
        for (int i = 0; i < mas.length; i++) {
            out += mas[i].toString() + "\n";
        }
        return out;
    }

    public void printName() {
        for (int i = 0; i < mas.length; i++)
            System.out.println("Название книги: " + mas[i].getName());
    }

    public double price() {
        double sum = 0;
        for (int i = 0; i < mas.length; i++) {
            sum += mas[i].getRub();
        }
        return sum;
    }

    public IBook getBook(int index) throws  BookIndexOutOfBoundsException {
        if(index < 0 || index > mas.length) {
            throw new BookIndexOutOfBoundsException();
        }
        return mas[index];
    }

    public int getBookCount() {
        return mas.length;
    }

    public void setBook(int index, IBook book) throws BookIndexOutOfBoundsException {
        if(index < 0 || index > mas.length) {
            throw new BookIndexOutOfBoundsException();
        }
        mas[index] = book;
    }

    public void addBook(int index, IBook book) throws BookIndexOutOfBoundsException{
        if(index < 0 || index > mas.length) {
            throw new BookIndexOutOfBoundsException();
        }
        IBook arr[] = new IBook[mas.length + 1];
        for (int i = 0; i < index; i++) {
            arr[i] = mas[i];
        }
        arr[index] = book;
        for (int i = index + 1; i < arr.length; i++) {
            arr[i] = mas[i - 1];
        }
        mas = arr;
    }

    public void deleteBook(int index) throws BookIndexOutOfBoundsException {
        if(index < 0 || index > mas.length) {
            throw new BookIndexOutOfBoundsException();
        }
        IBook arr[] = new IBook[mas.length - 1];
        for (int i = 0; i < index; i++) {
            arr[i] = mas[i];
        }
        for (int i = index + 1; i <= arr.length; i++) {
            arr[i - 1] = mas[i];
        }
        mas = arr;
    }

    public IBook getBestBook() {
        double count = 0;
        int index = 0;
        for (int i = 0; i < mas.length; i++) {
            if (count < mas[i].getRub()) {
                count = mas[i].getRub();
                index = i;
            }
        }
        return mas[index];

    }

        @Override
    public String toString() {
        StringBuilder out = new StringBuilder(getClass() + " Количество книг: " + mas.length + "\n" + "Книги: "+ "\n" + printBook() );
        return out.toString();
    }

    public boolean equals(Object object){
        boolean t=false;
        for (int i = 0; i <((IHall)object).getBookCount(); i++) {
            if(mas[i].equals(((IHall)object).getBook(i))){
                t=true;
            }else{
                t=false;
                break;
            }
        }
        if (object.getClass() == this.getClass() &&((IHall)object).getBookCount()==mas.length&&t){
            return true;
        }
        return false;
    }
}