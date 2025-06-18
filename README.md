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
```
## 🏃 How to Run This Backend Locally

### 📦 Prerequisites

- ✅ Java 17+ installed  
- ✅ Maven or Gradle installed  
- ✅ Verified WhatsApp test number (via Meta Developer Console)  
- ✅ Firebase project with service account key (base64 encoded)  
- ✅ Ngrok for local webhook testing (optional)

---

## 🔒 Security Best Practices

- ✅ `.gitignore` includes sensitive files like `firebase-service-account.json`
- ✅ Firebase credentials are passed via environment variable (`FIREBASE_CREDENTIALS_BASE64`)
- ❌ Do not commit secrets to GitHub — GitHub will block the push
- 🔁 Rotate keys immediately if you accidentally commit one

---

## ✨ Future Enhancements

- 💬 Dialogflow or GPT-based smart replies  
- 📊 Admin dashboard for chat analytics  
- 📎 Support for images, audio, and file messaging  
- ☁️ Cloud deployment support (Render, Railway, or AWS)

---

## 🙋‍♂️ Author

**Neeraj Sharma**

- 🔗 GitHub: [https://github.com/neeraj552](https://github.com/neeraj552)  
- 🔗 LinkedIn: [https://www.linkedin.com/in/neeraj-sharma-a16678221/](https://www.linkedin.com/in/neeraj-sharma-a16678221/)

---

> ⭐ Feel free to fork, star, and contribute to this project!
