package dev.project.paymentservice.service.paymentgetway;

import org.springframework.stereotype.Service;

@Service
public class StripeGetway implements PaymentGetway{
    @Override
    public String generatePaymentLink() {
        return "";
    }
}
