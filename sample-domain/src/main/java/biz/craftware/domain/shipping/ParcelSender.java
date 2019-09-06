package biz.craftware.domain.shipping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParcelSender {

	private final Magazine magazine;

	@Autowired
	public ParcelSender(Magazine magazine) {
		this.magazine = magazine;
	}

	public void send(Parcel pack){
		magazine.putPackage(pack);
	}
}
