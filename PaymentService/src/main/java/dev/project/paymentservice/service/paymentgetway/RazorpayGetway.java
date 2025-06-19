package dev.project.paymentservice.service.paymentgetway;

import com.razorpay.PaymentLink;
import org.springframework.stereotype.Service;
import org.json.JSONObject;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;


@Service
public class RazorpayGetway implements PaymentGetway {


    @Override
    public String generatePaymentLink() {
        try {
            RazorpayClient razorpay = new RazorpayClient("rzp_test_KlImo19YEtkZ7Z", "XmAcmRsdcVZ9jy9g0b96PawH");
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount", 1000);
            paymentLinkRequest.put("currency", "INR");
            paymentLinkRequest.put("accept_partial", false);

            paymentLinkRequest.put("expire_by", 1715184876);
            paymentLinkRequest.put("reference_id", "TS19890012");
            paymentLinkRequest.put("description", "Payment for policy no #23456");

            JSONObject customer = new JSONObject();
            customer.put("name", "+918767877735");
            customer.put("contact", "kapil Kumar");
            customer.put("email", "kapil.kumar@example.com");
            paymentLinkRequest.put("customer", customer);

            JSONObject notify = new JSONObject();
            notify.put("sms", true);
            notify.put("email", true);
            paymentLinkRequest.put("notify", notify);


            paymentLinkRequest.put("callback_url", "https://google.com/");
            paymentLinkRequest.put("callback_method", "get");

            PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
            return payment.toString();
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        return  null;
    }
}
