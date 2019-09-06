package biz.craftware.domain.shipping;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentLinkedQueue;

@Component
public class Magazine {

	private ConcurrentLinkedQueue<Parcel> queue = new ConcurrentLinkedQueue<>();

	public void putPackage(Parcel aParcel){
		queue.add(aParcel);
	}

	public Parcel getOldestPackage(){
		return queue.poll();
	}

}
