package ru.job4j.ood.ocp;

public class NotificationSender {
    public void sendNotification(String notificationType, String message) {
        if (notificationType.equals("Email")) {
            System.out.println("Sending email: " + message);
        } else if (notificationType.equals("SMS")) {
            System.out.println("Sending SMS: " + message);
        } else if (notificationType.equals("Push")) {
            System.out.println("Sending push notification: " + message);
        }
    }
}
