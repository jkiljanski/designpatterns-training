package biz.craftware;

import biz.craftware.domain.farm.Cattle;
import biz.craftware.domain.shipping.Parcel;
import biz.craftware.domain.shipping.ParcelReceiver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class ShippingCowTest {


    @Autowired
    private CowSender cowSender;

    @Autowired
    private ParcelReceiver parcelReceiver;

    @Test
    public void cowWillBeSendInBox() {
        //given
        Cattle cow = new Cattle(450, Cattle.Breed.ANGUS, Cattle.Color.BROWN);
        cow.setName("Mucka");

        //when
        cowSender.sendCow(cow);
        Parcel receivedPackage = parcelReceiver.obtain();

        //then
        assertThat(receivedPackage.getWeight()).isEqualTo(450);
        assertThat(receivedPackage.getSize()).isEqualTo(Parcel.Size.HUGE);
        assertThat(receivedPackage.getLabel()).isEqualTo("Package with Mucka inside.");
        assertThat(receivedPackage.knockKnock()).isEqualTo("Muuuuuuuuuu");

    }
}
