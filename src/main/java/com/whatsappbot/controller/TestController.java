package com.whatsappbot.controller;
import com.whatsappbot.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/firebase")
    public String testFirebase() {
        chatService.testFirebaseWrite();
        return "Firebase write attempted. Check console or Firebase dashboard.";
    }
}
