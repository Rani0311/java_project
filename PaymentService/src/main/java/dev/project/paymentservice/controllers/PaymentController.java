package dev.project.paymentservice.controllers;

import dev.project.paymentservice.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    PaymentService paymentService;

    public PaymentController(PaymentService paymentService)
    {
        this.paymentService=paymentService;
    }

    @PostMapping("/payments")
    public  String initiatepayment()
    {
        return  paymentService.generatePaymentLink();

    }
}
