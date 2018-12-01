public class ScientificLibraryHall implements IHall{
    private String forename;
    private LinkedList<IBook> list = new LinkedList<>();

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }


    public void setSize(int size) throws InvalidBookCountException {
        if(size < 0 || size > list.getSize()) {
            throw new InvalidBookCountException();
        }
        list.setSize(size);
    }

    public ScientificLibraryHall(String forename, int number) {
        this.forename = forename;
        list.setSize(number);
    }

    public ScientificLibraryHall(String forename, LinkedList<IBook> list) {
        this.forename = forename;
        this.list = list;
    }

    public int getBookCount() {
        return list.getSize();
    }

    public void printName() {
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println("Название книги: " + list.get(i).getData().getName());
        }
    }

    public String printBook() {
        String out = "";
        for (int i = 0; i < list.getSize(); i++) {
            out += list.get(i).getData() + "\n";
        }
        return out;
    }

    public double price() {
        double sum = 0;
        for (int i = 0; i < list.getSize(); i++) {
            sum += list.get(i).getData().getRub();
        }
        return sum;
    }

    public IBook getBook(int index) throws BookIndexOutOfBoundsException {
        if(index < 0 || index > list.getSize()) {
            throw new BookIndexOutOfBoundsException();
        }
        return list.get(index).getData();
    }

    public void setBook(int index, IBook book) throws BookIndexOutOfBoundsException{
        if(index < 0 || index > list.getSize()) {
            throw new BookIndexOutOfBoundsException();
        }
        list.setNode(index, book);

    }

    public void addBook(int index, IBook book) throws BookIndexOutOfBoundsException {
        if(index < 0 || index > list.getSize()) {
            throw new BookIndexOutOfBoundsException();
        }
        list.addNode(index, book);
    }

    public void deleteBook(int index) throws BookIndexOutOfBoundsException{
        if(index < 0 || index > list.getSize()) {
            throw new BookIndexOutOfBoundsException();
        }
            list.delNode(index);
    }

    public IBook getBestBook() {
        double count = 0;
        int index = 0;
        for (int i = 0; i < list.getSize(); i++) {
            if (count < list.get(i).getData().getRub()) {
                count = list.get(i).getData().getRub();
                index = i;
            }
        }
        return list.get(index).getData();
    }

    public IBook[] getBooks(){
        IBook[] arr=new IBook[list.getSize()];
        for (int i = 0; i <list.getSize() ; i++) {
            arr[i]=list.get(i).getData();
        }
        return arr;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder(getClass() + " Количество книг: " + list.getSize() + "\n" + "Книги: "+ "\n" + printBook() );
        return out.toString();
    }
//  не доделан
    public boolean equals(Object object){
        boolean t=false;
        for (int i = 0; i <((IHall)object).getBookCount(); i++) {
            if((list.get(i).getData()).equals(((IHall)object).getBook(i))){
                t=true;
            }else{
                t=false;
                break;
            }
        }
        if (object.getClass() == this.getClass() &&((IHall)object).getBookCount()==list.getSize()&&t){
            return true;
        }
        return false;
    }
}
