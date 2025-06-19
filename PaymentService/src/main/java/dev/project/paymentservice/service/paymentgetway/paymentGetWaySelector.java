package dev.project.paymentservice.service.paymentgetway;

import org.springframework.stereotype.Service;

@Service
public class paymentGetWaySelector {
    private  RazorpayGetway razorpayGetway;
    private StripeGetway stripeGetway;
    public paymentGetWaySelector(RazorpayGetway razorpayGetway ,StripeGetway stripeGetway)
    {
       this.razorpayGetway=razorpayGetway;
       this.stripeGetway=stripeGetway;
    }
    public  PaymentGetway getPaymentGetway()
    {
        return razorpayGetway;
    }
}
