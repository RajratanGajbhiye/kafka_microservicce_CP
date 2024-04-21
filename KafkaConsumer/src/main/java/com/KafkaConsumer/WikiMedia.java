package com.KafkaConsumer;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="wiki_media_data")
public class WikiMedia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	@Column(columnDefinition = "LONGTEXT")
	private String eventData;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the eventData
	 */
	public String getEventData() {
		return eventData;
	}

	/**
	 * @param eventData the eventData to set
	 */
	public void setEventData(String eventData) {
		this.eventData = eventData;
	}

	
}
