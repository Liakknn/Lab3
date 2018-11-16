public class ScientificLibrary implements ILibrary {
    private DoublyLinkedList<IHall> halls = new DoublyLinkedList<>();

    public ScientificLibrary(int numHall, int[] arrayBook) throws InvalidBookCountException {
        if(arrayBook.length < 0) {
            throw new InvalidBookCountException();
        }
        halls = new DoublyLinkedList<>();
        halls.setSize(numHall);
        for (int i = 0; i < numHall; i++) {
            halls.get(i).setSize(arrayBook[i]);
        }
    }

    public ScientificLibrary(ScientificLibraryHall[] mas) {
        for (int i = 0; i < mas.length ; i++) {
            halls.addNode(i, mas[i]);
        }
    }

    public int getCountHalls() {
        return halls.getSize();
    }

    public int getCountBooks() {
        int kolvoBook = 0;
        for (int i = 0; i < halls.getSize(); i++) {
            kolvoBook += halls.get(i).getBookCount();
        }
        return kolvoBook;
    }

    public IHall[] getHalls() {
        IHall[] arr=new IHall[halls.getSize()];
        for (int i = 0; i <halls.getSize() ; i++) {
            arr[i]=halls.get(i);
        }
        return arr;
    }

    public int getBooks() {
        int kolvoBook = 0;
        for (int i = 0; i < halls.getSize(); i++) {
            kolvoBook += halls.get(i).getBookCount();
        }
        return kolvoBook;
    }

    public double sumPrice() {
        double sum = 0;
        for (int i = 0; i <= halls.getSize() - 1; i++) {
            sum += halls.get(i).price();
        }
        return sum;
    }

    public IHall getHall(int index) throws HallIndexOutOfBoundsException {
        if(index < 0 || index > halls.getSize()) {
            throw new HallIndexOutOfBoundsException();
        }
        return halls.get(index);
    }

    public IBook getBook(int index) throws BookIndexOutOfBoundsException {
        int countBook = 0;
        for(int i = 0; i < halls.getSize(); i++) {
            countBook += halls.get(i).getBookCount();
        }
        if(index < 0 || index > countBook) {
            throw new BookIndexOutOfBoundsException();
        }
        int count = 0;
        for (int i = 0; i < halls.getSize(); i++) {
            count += halls.get(i).getBookCount();
            if (count > index) {
                return halls.get(i).getBook(index + halls.get(i).getBookCount() - count);
            }
        }
        return null;
    }

    public IBook[] sort() {
        int indexOfMax = 0;
        int indexOfMin = 0;
        int kol = 0;
        for (int i = 0; i < halls.getSize(); i++) {
            kol += halls.get(i).getBookCount();
        }
        IBook[] arr = new IBook[kol];
        int count = 0;
        for (int i = 0; i < halls.getSize(); i++) {
            for (int j = 0; j < halls.get(i).getBookCount(); j++) {
                arr[count] = halls.get(i).getBook(j);
                count++;
            }
        }
        IBook temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].getRub() < arr[j].getRub()) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public void printNameHollandNumbBook() {
        for (int i = 0; i < halls.getSize(); i++) {
            System.out.println("Имя зала: " + halls.get(i).getForename() + " Кол-во книг: " + halls.get(i).getBookCount());
        }
    }

    public void changeHall(int index, IHall newHall) throws HallIndexOutOfBoundsException {
        if(index < 0 || index > halls.getSize()) {
            throw new HallIndexOutOfBoundsException();
        }
            halls.setNode(index, newHall);
    }

    public void changeBook(int index, IBook ScBook) throws BookIndexOutOfBoundsException {
        int countBook = 0;
        for(int i = 0; i < halls.getSize(); i++) {
            countBook += halls.get(i).getBookCount();
        }
        if(index < 0 || index > countBook) {
            throw new BookIndexOutOfBoundsException();
        }
        int count = 0;
        for (int i = 0; i < halls.getSize(); i++) {
            count += halls.get(i).getBookCount();
            if (count > index) {
                halls.get(i).setBook(index + halls.get(i).getBookCount() - count, ScBook);
                break;
            }
        }
    }

    public void addBook(int index, IBook ShBook) throws BookIndexOutOfBoundsException {
        int countBook = 0;
        for(int i = 0; i < halls.getSize(); i++) {
            countBook += halls.get(i).getBookCount();
        }
        if(index < 0 || index > countBook) {
            throw new BookIndexOutOfBoundsException();
        }
        int count = 0;
        for (int i = 0; i < halls.getSize(); i++) {
            count += halls.get(i).getBookCount();
            if (count > index) {
                halls.get(i).addBook(index + halls.get(i).getBookCount() - count, ShBook);
            }
        }
    }

    public void deleteBook(int index) throws BookIndexOutOfBoundsException {
        int countBook = 0;
        for(int i = 0; i < halls.getSize(); i++) {
            countBook += halls.get(i).getBookCount();
        }
        if(index < 0 || index > countBook) {
            throw new BookIndexOutOfBoundsException();
        }
        int count = 0;
        for (int i = 0; i < halls.getSize(); i++) {
            count += halls.get(i).getBookCount();
            if (count > index) {
                halls.get(i).deleteBook(index + halls.get(i).getBookCount() - count);
            }
        }
    }

    public IBook getBestBook() {
        IBook[] arr = new IBook[halls.getSize()];
        for (int i = 0; i < halls.getSize(); i++) {
            arr[i] = halls.get(i).getBestBook();
        }
        double count = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (count < arr[i].getRub()) {
                count = arr[i].getRub();
                index = i;
            }
        }
        return arr[index];
    }

    public void printArr(IBook[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}