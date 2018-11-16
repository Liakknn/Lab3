public interface IHall {
    public int getBookCount();
    public void printName();
    public double price();
    public IBook getBook(int n);
    public void setBook(int index, IBook book);
    public void addBook(int index, IBook book);
    public void deleteBook(int index);
    public IBook[] getBooks();
    public String getForename();
    public void setSize(int size);
    public IBook getBestBook();
}