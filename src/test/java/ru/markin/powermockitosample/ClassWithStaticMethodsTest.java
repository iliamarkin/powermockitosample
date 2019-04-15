package ru.markin.powermockitosample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.VerificationModeFactory;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ClassWithStaticMethods.class, ClassToMock.class})
@PowerMockIgnore("javax.management.*")
public class ClassWithStaticMethodsTest {

    private static final int WANTED_NUMBER_OF_INVOCATIONS = 5;

    public ClassWithStaticMethodsTest() {
        MockitoAnnotations.initMocks(this);
        PowerMockito.mockStatic(System.class);
        PowerMockito.mockStatic(ClassToMock.class);
    }

    @Before
    public void before() throws Exception {
        PowerMockito.when(System.getenv("COUNT_OF_CALLS")).thenReturn(String.valueOf(WANTED_NUMBER_OF_INVOCATIONS));
        PowerMockito.doNothing().when(ClassToMock.class, "execute");
    }

    @Test
    public void testUseSystemGetenvUsesDataFromEnvironmentVariables() {
        ClassWithStaticMethods.useSystemGetenv();
        PowerMockito.verifyStatic(System.class);
    }

    @Test
    public void testUseSystemGetenvCallsClassToMockNTimes() {
        ClassWithStaticMethods.useSystemGetenv();
        PowerMockito.verifyStatic(ClassToMock.class, VerificationModeFactory.times(WANTED_NUMBER_OF_INVOCATIONS));
    }
}
