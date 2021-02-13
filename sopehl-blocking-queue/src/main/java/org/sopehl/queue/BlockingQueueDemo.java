package org.sopehl.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {

	public static void main(String[] args) {
		List<String> countries = Arrays.asList("TR", "USA", "RUS", "BRA");
		BlockingQueue<String> queue1 = new ArrayBlockingQueue<String>(5, false, countries);
		
		try {
			queue1.put("AZ");
			// when we add new element like queue1.put("CAN"), putting the element is waiting for queue that is polled.
			// maybe we can offer the element to add.
			boolean success = queue1.offer("CAN", 2000, TimeUnit.MILLISECONDS);
			if(!success) {
				System.out.println("Blocking queue is full to add new element and time elapsed.");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			System.out.println(queue1 + " / size : " + queue1.size());
		}
		
		try {
			// if queue is empty, it is wait to retrieve and remove the head of the element of queue.
		    String head = queue1.take();
		    System.out.println("Head element: " + head);
		    
		    String polledElement = queue1.poll(2000, TimeUnit.MILLISECONDS);
		    if(polledElement != null) {
		    	System.out.println("Polled element: " + polledElement);
		    }
		    
		    BlockingQueue<String> queue2 = new ArrayBlockingQueue<String>(5);
		    String polledElement2 = queue2.poll(2000, TimeUnit.MILLISECONDS);
		    if(polledElement2 == null) {
		    	System.out.println("Queue2 is empty to poll element");
		    }
		    
		    //Arrays.asList throws the 'java.lang.UnsupportedOperationException' exception
		    List<String> countryList = new ArrayList<String>(Collections.singletonList("JAP"));
		    // it removes the all elements from queue1 and add element them to countryList arrayList.
		    queue1.drainTo(countryList);
		    
		    System.out.println("country list: " + countryList);
		    System.out.println("country queue: " + queue1);
		} catch (InterruptedException ie) {
		    ie.printStackTrace();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		System.out.println("<<----------------------------------------------------------->>");
		System.out.println("End of Application");
	}
	
}
