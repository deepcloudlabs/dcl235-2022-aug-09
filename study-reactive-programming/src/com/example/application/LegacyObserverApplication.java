package com.example.application;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

import com.example.event.TradeEvent;

@SuppressWarnings("deprecation")
public class LegacyObserverApplication {

	public static void main(String[] args) {
		var events = List.of(
		   new TradeEvent("orcl",100,100),
		   new TradeEvent("orcl",101,200),
		   new TradeEvent("orcl",102,200),
		   new TradeEvent("ibm",100,100),
		   new TradeEvent("msft",100,100)
		);
        var observable = new TradeEventObservable();
        Observer slowObserver = (o,event) -> {
        	try { TimeUnit.SECONDS.sleep(5); }catch (Exception e) {}
        	System.out.println("Slow observer has processed the event (%s)".formatted(event));
        };
        Observer fastObserver = (o,event) -> {
        	System.out.println("Fast observer has processed the event (%s)".formatted(event));        	
        };
        observable.addObserver(slowObserver);
        observable.addObserver(fastObserver);
        // events.forEach( event -> observable.notifyObservers(event));
        events.forEach( observable::notifyObservers );
	}

}

@SuppressWarnings("deprecation")
class TradeEventObservable extends Observable {

	@Override
	public void notifyObservers(Object event) {
		setChanged();
		super.notifyObservers(event);
	}
	
}