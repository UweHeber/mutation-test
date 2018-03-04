package it.heber.sandbox.mutationtest;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ServiceTests {

    @Test
    public void testAdd001() throws Exception {
        final Service service = new Service();
        final int add = service.add(1, 1);
        Assertions.assertThat(add)
        .isNegative()
        .isEqualTo(-2);
    }
    
    @Test
    public void testAdd002() throws Exception {
        final Service service = new Service();
        final int add = service.add(2, 2);
        Assertions.assertThat(add)
        .isPositive()
        .isEqualTo(4);
    }
}