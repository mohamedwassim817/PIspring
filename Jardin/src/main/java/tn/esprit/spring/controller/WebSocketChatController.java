/*package tn.esprit.spring.controller;

import org.springframework.messaging.handler.annotation.*;

import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.domain.WebSocketChatMessage;

@Controller
public class WebSocketChatController {

	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/javainuse")
	public WebSocketChatMessage sendMessage(@Payload WebSocketChatMessage webSocketChatMessage) {
		return webSocketChatMessage;
	}

	@MessageMapping("/chat.newUser")
	@SendTo("/topic/javainuse")
	public WebSocketChatMessage newUser(@Payload WebSocketChatMessage webSocketChatMessage,
			SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", webSocketChatMessage.getSender());
		return webSocketChatMessage;
	}

}
*/