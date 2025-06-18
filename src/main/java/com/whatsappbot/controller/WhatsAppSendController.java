package com.whatsappbot.controller;
import com.whatsappbot.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/whatsapp")
public class WhatsAppSendController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/send")
    public String sendMessage(
            @RequestParam String to,
            @RequestParam String text) {

        chatService.sendMessage(to, text);
        return "✅ Message sent to " + to;
    }
}

