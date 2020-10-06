package lvl3.lesson_1;

import lvl3.lesson_1.Fruit;

public class Orange extends Fruit {

    public Orange() {
        super(1.5f);
    }

    @Override
    public String toString() {
        return "Orange{" +
                "weight=" + weight +
                '}';
    }
}
