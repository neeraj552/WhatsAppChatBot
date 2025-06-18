package com.whatsappbot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChatService {

    @Value("${whatsapp.api.url}")
    private String apiUrl;

    @Value("${whatsapp.token}")
    private String token;

    public void processIncoming(Map<String, Object> payload) {
        try {
            String from = extractSender(payload);
            String message = extractText(payload);
            String responseText = "You said: " + message;

            sendMessage(from, "You said: " + message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String to, String text) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> message = new HashMap<>();
        message.put("messaging_product", "whatsapp");
        message.put("to", to);
        message.put("type", "text");
        message.put("text", Map.of("body", text));

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(message, headers);

        try {
            rest.postForEntity(apiUrl, entity, String.class);
        } catch (Exception e) {
            System.err.println("Error sending message: " + e.getMessage());
        }
    }

    private String extractSender(Map<String, Object> payload) {
        try {
            Map<String, Object> entry = ((List<Map<String, Object>>) payload.get("entry")).get(0);
            Map<String, Object> changes = ((List<Map<String, Object>>) entry.get("changes")).get(0);
            Map<String, Object> value = (Map<String, Object>) changes.get("value");
            List<Map<String, Object>> messages = (List<Map<String, Object>>) value.get("messages");
            Map<String, Object> message = messages.get(0);
            return message.get("from").toString();
        } catch (Exception e) {
            return null;
        }
    }

    private String extractText(Map<String, Object> payload) {
        try {
            Map<String, Object> entry = ((List<Map<String, Object>>) payload.get("entry")).get(0);
            Map<String, Object> changes = ((List<Map<String, Object>>) entry.get("changes")).get(0);
            Map<String, Object> value = (Map<String, Object>) changes.get("value");
            List<Map<String, Object>> messages = (List<Map<String, Object>>) value.get("messages");
            Map<String, Object> message = messages.get(0);
            Map<String, Object> text = (Map<String, Object>) message.get("text");
            return text.get("body").toString();
        } catch (Exception e) {
            return null;
        }
    }
    public void testFirebaseWrite() {
        try {
            Firestore db = FirestoreClient.getFirestore();

            Map<String, Object> data = new HashMap<>();
            data.put("message", "Hello from WhatsApp Bot!");
            data.put("timestamp", System.currentTimeMillis());

            db.collection("testCollection").add(data);
            System.out.println("✅ Successfully wrote to Firebase Firestore!");
        } catch (Exception e) {
            System.err.println("❌ Firebase test failed: " + e.getMessage());
        }
    }
}

