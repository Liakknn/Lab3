public class ChildrenLibrary implements ILibrary{
    private IHall[] hall;

    public ChildrenLibrary(int numHall, int[] arrayBook) {
        hall = new ChildrenLibraryHall[numHall];
        for (int i = 0; i < numHall; i++) {
            hall[i] = new ChildrenLibraryHall(null, arrayBook[i]);
        }
    }

    public ChildrenLibrary(ChildrenLibraryHall[] hall) {
        this.hall = hall;
    }

    public int getCountBooks() {
        int count = 0;
        for (int i = 0; i < hall.length; i++) {
            count += hall[i].getBookCount();
        }
        return count;
    }

    public int getCountHalls() {
        return hall.length;
    }

    public double sumPrice() {
        double sum = 0;
        for (int i = 0; i <= hall.length - 1; i++) {
            sum += hall[i].price();
        }
        return sum;
    }

    public IHall[] getHalls() {
        return hall;
    }

    public IHall getHall(int index) throws HallIndexOutOfBoundsException{
        if(index < 0 || index > hall.length) {
            throw new HallIndexOutOfBoundsException();
        }
        return hall[index];
    }

    public IBook getBook(int index) throws BookIndexOutOfBoundsException {
        int countBook = 0;
        for(int i = 0; i < hall.length; i++) {
            countBook += hall[i].getBookCount();
        }
        if(index < 0 || index > countBook) {
            throw new BookIndexOutOfBoundsException();
        }
        int count = 0;
        for (int i = 0; i < hall.length; i++) {
            count += hall[i].getBookCount();
            if (count > index) {
                return hall[i].getBook(index + hall[i].getBookCount() - count);
            }
        }
        return null;
    }

    public IBook[] sort() {
        int indexOfMax = 0;
        int indexOfMin = 0;
        int kol = 0;
        for (int i = 0; i < hall.length; i++) {
            kol += hall[i].getBookCount();
        }
        IBook[] arr = new IBook[kol];
        int count = 0;
        for (int i = 0; i < hall.length; i++) {
            for (int j = 0; j < hall[i].getBookCount(); j++) {
                arr[count] = hall[i].getBook(j);
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

    public void printArr(IBook[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public void printNameHollandNumbBook() {
        for (int i = 0; i < hall.length; i++) {
            System.out.println("Имя зала: " + hall[i].getForename() + " Кол-во книг: " + hall[i].getBookCount());
        }
    }

    public String  printHalls() {
        String out = "";
        for (int i = 0; i < hall.length; i++) {
            out += hall[i].toString();
        }
        return out;
    }

    public void changeHall(int index, IHall newHall) throws HallIndexOutOfBoundsException {
        if (index < 0 || index > hall.length) {
            throw new HallIndexOutOfBoundsException();
        }
        hall[index] = newHall;
    }

    public void changeBook(int index, IBook book) throws BookIndexOutOfBoundsException {
        int countBook = 0;
        for(int i = 0; i < hall.length; i++) {
            countBook += hall[i].getBookCount();
        }
        if(index < 0 || index > countBook) {
            throw new BookIndexOutOfBoundsException();
        }
        int count = 0;
        for (int i = 0; i < hall.length; i++) {
            count += hall[i].getBookCount();
            if (count > index) {
                hall[i].setBook(index + hall[i].getBookCount() - count, book);
                break;
            }
        }
    }

    public void addBook(int index, IBook book) throws BookIndexOutOfBoundsException {
        int countBook = 0;
        for(int i = 0; i < hall.length; i++) {
            countBook += hall[i].getBookCount();
        }
        if(index < 0 || index > countBook) {
            throw new BookIndexOutOfBoundsException();
        }
        int count = 0;
        for (int i = 0; i < hall.length; i++) {
            count += hall[i].getBookCount();
            if (count > index) {
                hall[i].addBook(index + hall[i].getBookCount() - count, book);
            }
        }
    }

    public void deleteBook(int index) throws BookIndexOutOfBoundsException {
        int countBook = 0;
        for(int i = 0; i < hall.length; i++) {
            countBook += hall[i].getBookCount();
        }
        if(index < 0 || index > countBook) {
            throw new BookIndexOutOfBoundsException();
        }
        int count = 0;
        for (int i = 0; i < hall.length; i++) {
            count += hall[i].getBookCount();
            if (count > index) {
                hall[i].deleteBook(index + hall[i].getBookCount() - count);
            }
        }
    }

    public IBook getBestBook() {
        IBook[] arr = new IBook[hall.length];
        for (int i = 0; i < hall.length; i++) {
            arr[i] = hall[i].getBestBook();
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

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Количество залов: " + hall.length + "\n" + "Залы: "+ "\n" + printHalls());
        return out.toString();
    }
}