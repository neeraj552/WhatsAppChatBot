# 🤖 WhatsApp ChatBot (Java + Spring Boot + Firebase)

A backend chatbot built using **Java**, **Spring Boot**, and **Firebase Firestore**, integrated with **Meta's WhatsApp Business Cloud API**. This bot can automatically reply to WhatsApp messages, log chats to Firebase, and support REST API message sending.

---

## 🚀 Features

- 🔁 Auto-reply to WhatsApp messages
- 📩 Send WhatsApp messages via REST API
- 🔗 Integrated with WhatsApp Cloud API (Meta)
- 🔐 Uses token-based secure API access
- 💾 Stores message history in Firebase Firestore
- ⚙️ Webhook support for real-time responses

---

## 🛠️ Tech Stack

| Tech        | Purpose                      |
|-------------|------------------------------|
| Java        | Backend development          |
| Spring Boot | REST APIs & Webhook handling |
| Firebase    | Storing chat messages        |
| WhatsApp API| Cloud messaging              |
| Ngrok       | Local webhook testing        |

---

## 📁 Project Structure

```shell
src/
├── main/
│   ├── java/com/whatsappbot/
│   │   ├── controller/
│   │   │   └── WebhookController.java
│   │   ├── service/
│   │   │   └── ChatService.java
│   │   ├── config/
│   │   │   └── FirebaseConfig.java
│   └── resources/
│       ├── application.properties
│       └── (firebase-service-account.json) — [ignored]
