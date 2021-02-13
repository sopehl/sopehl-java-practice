package com.sopehl.synchronous;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

/**
 * It provides exchanging the information between threads in the thread-safe manner.
 *
 * There are only two functions we need to know, take(), put(), the functions,
 * both of them are blocking. If you want to put data, another thread must listen to queue
 * to take the data/information. If you want to take data, another thread must put the data/information
 * to queue. If you want to put data to the queue and if there is no another thread which is listening
 * to the queue to take the data. You cannot put data to the queue and vice versa.
 */
public class SynchronousQueueDemo {

	private static List<String> names = new ArrayList<>();

	public static void main(String[] args) {

		names.add("O");
		names.add("N");
		names.add("M");
		names.add("K");
		names.add("X");

		SynchronousQueue<String> syncQueue = new SynchronousQueue<>();
		Runnable consumer = () -> {
			try {
				// if queue is empty, it wait to element in head of queue added by the producer-thread.
				while (true) {
					String received = syncQueue.take();
					System.out.println("received data: " + received);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Runnable producer = () -> {
			try {
				// add the elements, if any consumer thread is not taking the element
				// then it will wait until any consumer-thread is taking item.
				// that's why its name is synchronous queue, consumer and producer must be sync.
				for (String item : names) {
					syncQueue.put(item);
					System.out.println("Published: " + item);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		new Thread(producer, "producer-thread").start();
		// Put the Thread sleep in this line. You'll notice that
		// put() method is waiting in the line 38 to get any signal(.take())
		// from consumer thread in run time.
		new Thread(consumer, "consumer-thread").start();
	}
}
