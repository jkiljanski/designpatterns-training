package biz.craftware;

import biz.craftware.domain.farm.Cattle;
import biz.craftware.domain.farm.Chicken;
import biz.craftware.domain.farm.Farm;
import biz.craftware.domain.farm.food.Egg;
import biz.craftware.domain.farm.food.Milk;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateFarmTest extends PatternsSpringTest {

    @Autowired
    FarmFactory farmFactory;

    Cattle milkProducer;
    Chicken eggProducer;

    @Test
    public void createsMilkBreakfast() {
        //given

        //when
        List<Milk> milks = milkProducer.retrieveMilk();

        //then
        assertThat(milks).hasSize(1);
    }

    @Test
    public void createsEggBreakfast() {
        //given

        //when
        List<Egg> eggs = eggProducer.retrieveEggs();

        //then
        assertThat(eggs).hasSize(3);
    }

    @Test
    public void createsMixedBreakfast() {
        //given

        //when
        List<Object> breakfast = null;
        
        //then
        assertThat(breakfast).isOfAnyClassIn(Egg.class, Milk.class);
    }



}
