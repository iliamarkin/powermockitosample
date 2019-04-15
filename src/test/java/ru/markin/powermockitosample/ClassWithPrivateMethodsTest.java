package ru.markin.powermockitosample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.verification.VerificationModeFactory;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.Method;

@RunWith(PowerMockRunner.class)
public class ClassWithPrivateMethodsTest {

    @Test
    public void testCallPrivateMethod() throws Exception {

        final ClassWithPrivateMethods spy = PowerMockito.spy(new ClassWithPrivateMethods());

        final Method execute = PowerMockito.method(ClassWithPrivateMethods.class, "execute");
        PowerMockito.doNothing().when(spy, execute).withNoArguments();

        final int wantedNumberOfInvocations = 4;
        spy.callPrivateMethod(wantedNumberOfInvocations);

        PowerMockito.verifyPrivate(spy, VerificationModeFactory.times(wantedNumberOfInvocations))
                .invoke(execute);
    }
}
