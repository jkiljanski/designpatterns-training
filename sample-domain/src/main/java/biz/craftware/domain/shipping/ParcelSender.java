package biz.craftware.domain.shipping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParcelSender {

	private final Warehouse warehouse;

	@Autowired
	public ParcelSender(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public void send(Parcel pack){
		warehouse.putPackage(pack);
	}
}
