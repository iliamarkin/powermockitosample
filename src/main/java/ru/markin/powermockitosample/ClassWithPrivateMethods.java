package ru.markin.powermockitosample;

public class ClassWithPrivateMethods {

    /**
     * Calls {@link ClassWithPrivateMethods#execute()} as many times as specified
     * in <code>times</code> parameter.
     *
     * @param times - times to call {@link ClassWithPrivateMethods#execute()}
     */
    public void callPrivateMethod(int times) {

        final int countOfCalls = Integer.valueOf(System.getenv("COUNT_OF_CALLS"));

        for (int i = 0; i < countOfCalls; i++) {
            execute();
        }
    }

    private void execute() {
        //do nothing
    }
}
