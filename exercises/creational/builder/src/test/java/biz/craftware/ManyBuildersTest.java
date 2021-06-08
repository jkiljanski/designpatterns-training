package biz.craftware;

import biz.craftware.breed.Breeder;
import biz.craftware.breed.EnchancedCattleBuilder;
import biz.craftware.breed.SimpleCattleBuilder;
import biz.craftware.domain.farm.Cattle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ManyBuildersTest {


    private Breeder breeder;
    private Cattle mother;

    @BeforeEach
    public void setUp() {
        breeder = new Breeder();
        mother = new Cattle(500, Cattle.Breed.ABONDANCE, Cattle.Color.STRIPED);
        mother.setName("Betty");
    }

    @Test
    public void breedWithSimpleBuilder() {
        //given

        //when
        Cattle child = breeder.breed(mother, new SimpleCattleBuilder());

        //then
        assertThat(child).isNotNull();
        assertThat(child.getBreed()).isEqualTo(Cattle.Breed.ABONDANCE);
        assertThat(child.getColor()).isEqualTo(Cattle.Color.STRIPED);
        assertThat(child.getWeight()).isEqualTo(50);
        assertThat(child.getName()).isEqualTo("child of Betty");

    }

    @Test
    public void breedWithEnchancedBuilder() {
        //given

        //when
        Cattle child = breeder.breed(mother, new EnchancedCattleBuilder());

        //then
        assertThat(child).isNotNull();
        assertThat(child.getBreed()).isEqualTo(Cattle.Breed.ABONDANCE);
        assertThat(child.getColor()).isEqualTo(Cattle.Color.STRIPED);
        assertThat(child.getWeight()).isEqualTo(55);
        assertThat(child.getName()).isEqualTo("enhanced child of Betty");

    }
}
