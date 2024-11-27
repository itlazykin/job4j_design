package ru.job4j.ood.dip;

public class Notification {
    private final EmailService emailService;

    public Notification(EmailService emailService) {
        this.emailService = emailService;
    }

    public void notify(String message) {
        emailService.sendEmail(message);
    }
}

class EmailService {
    public void sendEmail(String message) {
        System.out.println("Sending email: " + message);
    }
}


