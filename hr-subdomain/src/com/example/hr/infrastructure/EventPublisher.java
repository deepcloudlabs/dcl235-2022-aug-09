package com.example.hr.infrastructure;

import com.example.hr.domain.event.EventBase;

public interface EventPublisher {

	void publish(EventBase event);

}
