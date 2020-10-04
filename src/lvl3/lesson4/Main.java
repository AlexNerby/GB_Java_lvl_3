package lvl3.lesson4;

public class Main {

    static Object mon = new Object();
    static volatile char letter = 'A';

    public static void main(String[] args) {
        new Thread(new Letter('A', 'B')).start();
        new Thread(new Letter('B', 'C')).start();
        new Thread(new Letter('C', 'A')).start();
    }

    static class Letter implements Runnable {
        private char letter;
        private char nextLetter;

        public Letter(char letter, char nextLetter) {
            this.letter = letter;
            this.nextLetter = nextLetter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                synchronized (mon) {
                    try {
                        while (Main.letter != letter)
                            mon.wait();
                        System.out.print(letter);
                        Main.letter = nextLetter;
                        mon.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}