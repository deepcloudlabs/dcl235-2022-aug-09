package com.example.hr.domain.event;

import java.time.ZonedDateTime;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public abstract class EventBase {
	private static final AtomicLong ID = new AtomicLong(0);
	private final String eventId;
	private final long sequenceId;
	private final ZonedDateTime timestamp;
	private final long epochTime;
	
	public EventBase() {
		eventId = UUID.randomUUID().toString();
		sequenceId = nextSequenceId();
		timestamp = ZonedDateTime.now();
		epochTime = timestamp.toEpochSecond();
	}

	private long nextSequenceId() {
		return ID.getAndIncrement();
	}

	public String getEventId() {
		return eventId;
	}

	public long getSequenceId() {
		return sequenceId;
	}

	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

	public long getEpochTime() {
		return epochTime;
	}

	@Override
	public String toString() {
		return "EventBase [eventId=" + eventId + ", sequenceId=" + sequenceId + ", timestamp=" + timestamp
				+ ", epochTime=" + epochTime + "]";
	}
	
}
