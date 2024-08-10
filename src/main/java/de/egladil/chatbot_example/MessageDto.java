// =====================================================
// Project: chatbot-example
// (c) Heike Winkelvoß
// =====================================================
package de.egladil.chatbot_example;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

/**
 * MessageDto
 */
public class MessageDto {

	@JsonProperty
	@NotBlank
	private String message;

	public String getMessage() {

		return message;
	}

	public void setMessage(final String question) {

		this.message = question;
	}

}
