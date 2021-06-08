package biz.craftware;

import biz.craftware.domain.farm.Cattle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.verify;

public class CattleForPurposesTest extends PatternsSpringTest {

    @Autowired
    private CattleHandler cattleHandler;

    @Autowired
    private CattleRegistration cattleRegistration;

    static Object[][] cowsWithPurpose() {
        return new Object[][]{

                {new Cattle(800, Cattle.Sex.BULL),
                        (VerifyRegistration) (r, c) -> verify(r).registerCowForMeat(c)},

                {new Cattle(500, Cattle.Sex.BULL),
                        (VerifyRegistration) (r, c) -> verify(r).registerBullForBreed(c)},

                {new Cattle(200, Cattle.Sex.COW),
                        (VerifyRegistration) (r, c) -> verify(r).registerCowForMilk(c)},

                {new Cattle(300, Cattle.Sex.COW),
                        (VerifyRegistration) (r, c) -> verify(r).registerCowForMilk(c)},

                {new Cattle(400, Cattle.Sex.COW),
                        (VerifyRegistration) (r, c) -> verify(r).registerCowForBreed(c)},

                {new Cattle(500, Cattle.Sex.COW),
                        (VerifyRegistration) (r, c) -> verify(r).registerCowForMeat(c)},

        };
    }

    @MethodSource("cowsWithPurpose")
    @ParameterizedTest
    public void registerCowWithPurpose(Cattle cattle, VerifyRegistration verifyRegistration) {
        //given

        //when
        cattleHandler.handleCow(cattle);

        //then
        verifyRegistration.verify(cattleRegistration, cattle);

    }

    public interface VerifyRegistration {
        void verify(CattleRegistration cattleRegistration, Cattle cattle);
    }
}
