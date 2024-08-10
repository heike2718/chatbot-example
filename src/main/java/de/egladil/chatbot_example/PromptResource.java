// =====================================================
// Project: chatbot-example
// (c) Heike Winkelvoß
// =====================================================
package de.egladil.chatbot_example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * PromptResource
 */
@Path("chatbot")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PromptResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(PromptResource.class);

	@Inject
	Bot bot;

	@POST
	public Response sendQuestion(@Valid final MessageDto question) {

		String answer = bot.chat(question.getMessage());
		MessageDto responsePayload = new MessageDto();
		responsePayload.setMessage(answer);

		LOGGER.info("question={}", question.getMessage());
		LOGGER.info("answer={}", answer);

		return Response.ok(responsePayload).build();
	}

}
