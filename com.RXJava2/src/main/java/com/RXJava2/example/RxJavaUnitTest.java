package com.RXJava2.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import hu.akarnokd.rxjava2.async.AsyncObservable;
import io.reactivex.Observable;

public class RxJavaUnitTest {

	String result = "";
	
//	public void main(String args[]) {
//		
//	
//	}

	// Simple subscription to a fix value
	@Test
	public void returnAValue() {
		result = "";

//		Observable<String> observer = Observable.just("Hello");// provides datas
//		observer.subscribe(s -> result = s);
//		assertTrue(result.equals("Hello"));
		
//		AtomicInteger counter = new AtomicInteger();
//		Callable<Integer> callable = () -> counter.incrementAndGet();
//		
//		Observable<Integer> source = Observable.fromCallable(callable);
//		 
//		for (int i = 1; i < 5; i++) {
//		    source.test()
//		      .awaitDone(5, TimeUnit.SECONDS)
//		      .assertResult(i);
//		    assertEquals(i, counter.get());
//		}
//		
//		Observable<Integer> source2 = AsyncObservable.start(callable);
//		
//		for (int i = 1; i < 5; i++) {
//			source2.test()
//		      .awaitDone(5, TimeUnit.SECONDS)
//		      .assertResult(1);
//		    assertEquals(1, counter.get());
//		}
		
		
		Runnable task = () -> {
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Hello " + threadName);
		};

		task.run();

		Thread thread = new Thread(task);
		thread.start();
		System.out.println("Done!");

		
		
		
		
//		ExecutorService executor = Executors.newSingleThreadExecutor();
//		Future<Integer> future = executor.submit(callable);
	}

//	Observable<Todo> todoObservable = Observable.create(new ObservableOnSubscribe<Todo>() {
//		@Override
//		public void subscribe(ObservableEmitter<Todo> emitter) throws Exception {
//			try {
//				List<Todo> todos = RxJavaUnitTest.this.getTodos();
//				for (Todo todo : todos) {
//					emitter.onNext(todo);
//				}
//				emitter.onComplete();
//
//			} catch (Exception e) {
//
//				emitter.onError(e);
//			}
//		}
//	});

}

//class Todo {
//	public String id;
//	public String nom;
//	
//	public List<Todo> getTodos() {
//		return new ArrayList<Todo>();
//	}
//}
