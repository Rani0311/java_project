package dev.project.paymentservice.service;

import dev.project.paymentservice.service.paymentgetway.paymentGetWaySelector;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private paymentGetWaySelector paymentGetWaySelector;

    public PaymentService(paymentGetWaySelector paymentGetWaySelector)
    {
        this.paymentGetWaySelector=paymentGetWaySelector;
    }


    public String generatePaymentLink()
    {
        return paymentGetWaySelector.getPaymentGetway().generatePaymentLink();
    }
}
