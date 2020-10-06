package lvl3.lesson_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private ArrayList<T> list;
    private int valFruit;

    public Box(T fruit, int valFruit) {
        this.valFruit = valFruit;
        if (valFruit > 0) {
            list = new ArrayList<>(Arrays.asList(fruit));
            for (int i = 1; i < valFruit; i++) {
                list.add(fruit);
            }
        }
    }

    public float getWeightBox() {
        float a = 0.0f;
        try {
            for (T o : list) {
                a += o.getWeight();
            }
        } catch (NullPointerException e) {
            System.out.println(toString() + " is empty");
            e.printStackTrace();
        }
        return a;
    }

    public boolean compare(Box<? extends Fruit> fruits) {
        return Math.abs(this.getWeightBox() - fruits.getWeightBox()) < 0.00001;
    }

    public void addFruit(T fruit, int num) {
        for (int i = 1; i < num; i++) {
            list.add(fruit);
        }
        valFruit += num;
    }

    @Override
    public String toString() {
        return "Task 3: \nBox{" +
                "fruit=" + list +
                "\nvalFruit=" + valFruit +
                "}\n=======================";
    }

    public void replaceFruit(Box<T> box) {
        for (T o : box.list) {
            list.add(o);
        }
        valFruit += box.valFruit;
        box.valFruit = 0;
        box.list.clear();
    }
}
