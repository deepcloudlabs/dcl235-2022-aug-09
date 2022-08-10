package com.example.application;

import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import com.example.event.TradeEvent;

public class ReactiveApplication {

	public static void main(String[] args) {
		System.err.println("Application is just started.");		
		var events = List.of(
		   new TradeEvent("orcl",100,100),
		   new TradeEvent("orcl",101,200),
		   new TradeEvent("orcl",102,200),
		   new TradeEvent("ibm",100,100),
		   new TradeEvent("msft",100,100)
		);
		try(var publisher = new SubmissionPublisher<TradeEvent>();) {
			TransformProcessor<TradeEvent, TradeVolumeEvent> volumeMapper = 
					// new TransformProcessor<>( tradeEvent -> new TradeVolumeEvent(tradeEvent));
				new TransformProcessor<>( TradeVolumeEvent::new );
			publisher.subscribe(volumeMapper);
			volumeMapper.subscribe(new FastSubscriber());
			volumeMapper.subscribe(new SlowSubscriber());
			events.forEach(publisher::submit);			
		} 
		try {
			TimeUnit.SECONDS.sleep(30);
		} catch (Exception e) {
		}
		System.err.println("Application is done.");		
	}

}

class SlowSubscriber implements Flow.Subscriber<TradeVolumeEvent> {

	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		System.err.println("SlowSubscriber has just subscribed to the event!");
		this.subscription = subscription;
		this.subscription.request(1);
	}

	@Override
	public void onNext(TradeVolumeEvent tradeEvent) {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {
		}
		System.err.println("SlowSubscriber has processed the event: " + tradeEvent);
		this.subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		System.err.println("SlowSubscriber has failed: " + throwable.getMessage());
	}

	@Override
	public void onComplete() {
		System.err.println("SlowSubscriber has just completed!");
	}

}

class FastSubscriber implements Flow.Subscriber<TradeVolumeEvent> {

	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		System.err.println("FastSubscriber has just subscribed to the event!");
		this.subscription = subscription;
		this.subscription.request(1);
	}

	@Override
	public void onNext(TradeVolumeEvent tradeEvent) {
		System.err.println("FastSubscriber has processed the event: " + tradeEvent);
		this.subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		System.err.println("FastSubscriber has failed: " + throwable.getMessage());
	}

	@Override
	public void onComplete() {
		System.err.println("FastSubscriber has just completed!");
	}

}

class TransformProcessor<T, R> extends SubmissionPublisher<R> implements Flow.Processor<T, R> {

	private Function<T, R> function;
	private Flow.Subscription subscription;

	public TransformProcessor(Function<T, R> function) {
		super();
		this.function = function;
	}

	@Override
	public void onSubscribe(Flow.Subscription subscription) {
		this.subscription = subscription;
		subscription.request(1);
	}

	@Override
	public void onNext(T item) {
		submit(function.apply(item));
		subscription.request(1);
	}

	@Override
	public void onError(Throwable t) {
		t.printStackTrace();
	}

	@Override
	public void onComplete() {
		close();
	}
}

record TradeVolumeEvent(String symbol, double price, double quantity,double volume) {

	public TradeVolumeEvent(TradeEvent tradeEvent) {
		this(tradeEvent.symbol(),tradeEvent.price(),tradeEvent.quantity(),tradeEvent.price()*tradeEvent.quantity());
	}
}