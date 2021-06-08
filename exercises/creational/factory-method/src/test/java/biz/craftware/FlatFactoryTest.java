package biz.craftware;

import biz.craftware.domain.farm.Cattle;
import biz.craftware.domain.farm.other.api.FarmInfoRepository;
import biz.craftware.simple.CowFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class FlatFactoryTest extends PatternsSpringTest {

    @Autowired
    private FarmInfoRepository farmInfoRepositoryMock;


    @Autowired
    private CowFactory cowFactory;


    @Test
    public void createsByCallingFactory() {
        //given
        given(farmInfoRepositoryMock.getOwnerSign()).willReturn("training sign");

        //when
        Cattle cattle = cowFactory.createCowWithMark();

        //then
        assertThat(cattle)
                .hasFieldOrPropertyWithValue("sex", Cattle.Sex.COW)
                .hasFieldOrPropertyWithValue("ownersMark", "training sign");
    }


}
