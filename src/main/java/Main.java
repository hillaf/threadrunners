public class Main {

    public static void main(String [ ] args) {

        (new Runner("Ann")).start();
        (new Runner("Bill")).start();
        (new Runner("Charlie")).start();

        for (int i = 0; i < 10; i++) {
            new Car().start();
        }
    }
}

