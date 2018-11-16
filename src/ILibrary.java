public interface ILibrary {
    public int getCountHalls();

    public int getCountBooks();

    public double sumPrice();

    public IHall[] getHalls();

    public IHall getHall(int index);

    public IBook getBook(int index);

    public IBook[] sort();

    public void printNameHollandNumbBook();

    public void changeHall(int index,IHall hall);

    public void changeBook(int index,IBook book);

    public void addBook(int index,IBook book);

    public void deleteBook(int index);

    public IBook getBestBook();
}
