package java;

import java.util.Arrays;

public class EnumDemo {

    public enum State {ACTIVE, USER_WON, AI_WON, DRAW}

    ;

    public enum Currency {
        PENNY(1), NICKLE(5), DIME(10), QUARTER(25);

        private int value;

        private Currency(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(State.values()));

        System.out.println(State.ACTIVE);
        System.out.println(State.DRAW);

        System.out.println(Arrays.toString(Currency.values()));
        System.out.println(Currency.DIME);
        System.out.println(Currency.valueOf("PENNY"));
    }

}
