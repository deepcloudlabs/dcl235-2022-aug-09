package com.example.hr.domain.event;

import com.example.hr.domain.DomainEvent;
import com.example.hr.domain.TcKimlikNo;

@DomainEvent
public class EmployeeFiredEvent extends EventBase {
	private final TcKimlikNo kimlikNo;

	public EmployeeFiredEvent(TcKimlikNo kimlikNo) {
		this.kimlikNo = kimlikNo;
	}

	public TcKimlikNo getKimlikNo() {
		return kimlikNo;
	}

	@Override
	public String toString() {
		return "EmployeeHiredEvent [kimlikNo=" + kimlikNo + ", getEventId()=" + getEventId() + ", getSequenceId()="
				+ getSequenceId() + ", getTimestamp()=" + getTimestamp() + ", getEpochTime()=" + getEpochTime() + "]";
	}	
	
}
