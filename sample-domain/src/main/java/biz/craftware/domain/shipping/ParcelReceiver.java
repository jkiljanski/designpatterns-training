package biz.craftware.domain.shipping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParcelReceiver {

	private final Magazine magazine;

	@Autowired
	public ParcelReceiver(Magazine magazine) {
		this.magazine = magazine;
	}

	public Parcel obtain(){
		return magazine.getOldestPackage();
	}
}
