package biz.craftware;

import biz.craftware.domain.farm.Cattle;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    public void providesSingletonEverytime() {
        //given

        //when
        Cattle singleton = HolyCow.getInstance();
        Cattle singletonReference = HolyCow.getInstance();

        //then
        assertThat(singleton).isSameAs(singletonReference);

    }
}
