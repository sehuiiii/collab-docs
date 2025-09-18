package com.dgsw.collabdocs.controller;

import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    private final SimpMessagingTemplate template;

    public WebSocketController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/edit/{docId}")
    public void editDocument(@DestinationVariable Long docId, @Payload String content) {
        // 실시간 편집 브로드캐스트
        template.convertAndSend("/topic/doc/" + docId, content);
    }
}
