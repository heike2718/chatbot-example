package de.egladil.chatbot_example;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.enterprise.context.SessionScoped;

@RegisterAiService(retrievalAugmentor = AugmentorExample.class)
@SessionScoped
public interface Bot {

	@SystemMessage("""
		You are an AI named Bob answering questions about astronomy.
		      Your response must be polite, use the same language as the question, and be relevant to the question.

		When you don't know, respond that you don't know the answer and suggest to consult the Web.
		""")
	String chat(@UserMessage String question);
}
