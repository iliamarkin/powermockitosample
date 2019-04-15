package ru.markin.powermockitosample;

public class ClassWithStaticMethods {

    /**
     * Calls {@link ClassToMock#execute()} as many times as specified
     * in environment variables as <code>COUNT_OF_CALLS</code> parameter.
     */
    public static void useSystemGetenv() {

        final int countOfCalls = Integer.valueOf(System.getenv("COUNT_OF_CALLS"));

        for (int i = 0; i < countOfCalls; i++) {
            ClassToMock.execute();
        }
    }
}
