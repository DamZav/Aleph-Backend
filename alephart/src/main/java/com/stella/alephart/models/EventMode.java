package com.stella.alephart.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class EventMode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_event_mode;
	private String mode_name;
	
}
