package biz.craftware.domain.shipping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParcelReceiver {

	private final Warehouse warehouse;

	@Autowired
	public ParcelReceiver(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Parcel obtain(){
		return warehouse.getOldestPackage();
	}
}
