package lvl3.lesson_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Generics {
    public static void main(String[] args) {

        Apple apple = new Apple();
        Apple freshApples = new Apple();

        Box<Apple> appleBox = new Box<>(apple, 5);
        Box<Apple> appleBox2 = new Box<>(freshApples, 3);

        freshApples.setWeight(1.3f);

        appleBox.addFruit(apple, 10);

        Orange orange = new Orange();
        Box<Orange> orangeBox = new Box<>(orange, 10);
//        appleBox2.replaceFruit(orangeBox);
        orangeBox.addFruit(orange, 5);

        appleBox2.replaceFruit(appleBox);

        String[] arrStr = {"1", "2", "3", "4", "5"};
        Integer[] arrInt = {1, 2, 3, 4, 5};

        replaceArray(arrStr, 0, 4);
        replaceArray(arrInt, 0, 2);
        System.out.println("=======================");
        System.out.println("Task 2: " + arrayToArrayList(arrStr));
        System.out.println("Task 2: " + arrayToArrayList(arrInt));
        System.out.println("=======================");

        System.out.println(appleBox.toString());
        System.out.println(appleBox2.toString());
        System.out.println(orangeBox.toString());
        System.out.println("Task 3 (compare to box's): " + appleBox.compare(orangeBox) + "\n=======================");
    }

    static void replaceArray(Object[] arr, int first, int second) {
        Object a = arr[first];
        arr[first] = arr[second];
        arr[second] = a;
        System.out.println("Task 1: " + Arrays.deepToString(arr));
    }

    static <T> ArrayList<T> arrayToArrayList(T... arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }
}
