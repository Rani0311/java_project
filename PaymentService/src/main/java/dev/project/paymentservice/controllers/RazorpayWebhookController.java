package dev.project.paymentservice.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RazorpayWebhookController {
    @PostMapping("/webhook")
    public  void paymentDone(@RequestBody Object object)
    {

    }
}
