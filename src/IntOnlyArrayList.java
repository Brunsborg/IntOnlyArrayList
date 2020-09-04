public class IntOnlyArrayList {
    private int[] array;
    private int size;

    //Constructor
    public IntOnlyArrayList() {
        array = new int[2];
        size = 0;
    }

    //Tilføjer bagerst i arrayet
    public void add(int value) {
        checkArrayIncrease();
        array[size()] = value;
        size++;
    }

    public void add(int index, int value) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            //Check for arrayets længde
            checkArrayIncrease();
            for (int i = size; i > index; i--) {
                //Vi shuffler elementerne i slutningen og bagud
                array[i] = array[i - 1];
                if (i - 1 == index) {
                    array[i - 1] = value;
                }
            }
        }
        size++;
    }

    //Returnere Index value
    public int get(int index) {
        //checker for IndexOutOfBounds
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            return array[index];
        }
    }

    //Fjerner index og sætter objekter i korrekt plads
    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            for (int i = index; i < size ; i++) {
                array[i] = array[i+1];
            }
        }
        size--;
        checkArrayDecrease();
    }

    //Returns antallet af elementer
    public int size() {
        return size;
    }


    //Tømmer arrayet ved at lave et nyt
    public void clear() {
        array = new int[2];
        size = 0;
    }

    //Printer objekter i vores arraylist
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + array[0];

            for (int i = 1; i < size; i++) {
                result += ", " + array[i];
            }
            result += "]";
            return result;
        }
    }

    //Checker om der er brug for et større array
    private void checkArrayIncrease() {
        if (array.length < 1){
            array = new int[2];
        }
        //Hvis length og size er ens, så er arrayet fyldt og skal udviddes
        else if (array.length == size) {
            int[] newArray = new int[array.length + 5];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    //checks if we can decrease our array size
    private void checkArrayDecrease() {
        if (array.length/2 > size) {
            int[] newArray = new int[array.length / 2 ];

            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }
}