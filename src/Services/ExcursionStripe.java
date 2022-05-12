/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Excursionreservation;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Token;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author amani
 */
import java.util.HashMap;
import java.util.Map;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Token;

public class ExcursionStripe {

    public boolean payer(int reservation_Id, String cardnum, String email, String mois, String annee, String cvc) {
        boolean is_paid = false;
        //Excursionreservation reservation = new Excursionreservation();
        ExcursionreservationService res = new ExcursionreservationService();
        Excursionreservation reservation = res.findById(reservation_Id);
        System.out.println("reservation"+reservation.toString());
        Integer prix = Integer.valueOf(reservation.getPrix()) * 100;

        Stripe.apiKey = "sk_test_mLMoZHfAcbpkQvsduWMj9fMA001uf2QBWv";
//client
        Map<String, Object> customerMap = new HashMap<String, Object>();
        customerMap.put("email", email);
        try {
            //create card token
            Map<String, Object> card = new HashMap<>();
            card.put("number", cardnum);
            card.put("exp_month", mois);
            card.put("exp_year", annee);
            card.put("cvc", cvc);
            Map<String, Object> paramsTOKEN = new HashMap<>();
            paramsTOKEN.put("card", card);
            Token token = Token.create(paramsTOKEN);

            //create cutomer
            Customer customer = Customer.create(customerMap);
            //paiement
            Map<String, Object> paramsEMAIL = new HashMap<>();
            paramsEMAIL.put("email", customer.getEmail());
            Map<String, Object> paramsC = new HashMap<>();
            paramsC.put("amount", prix);
            paramsC.put("currency", "eur");
            paramsC.put("source", token.getId());
            paramsC.put("receipt_email", customer.getEmail());
            //créer charge dans stripe         
            Charge charge = Charge.create(paramsC);

            //add customer to charge       
            Map<String, Object> params3 = new HashMap<>();
            params3.put("customer", customer.getId());
            Charge updatedCharge = charge.update(params3);
            String status = charge.getStatus();
            System.out.println("status=" + status);
            if ("succeeded".equals(status)) {
                is_paid = true;
            }
        } catch (StripeException e) {
            //e.printStackTrace();
            e.getMessage();
            is_paid = false;
        }

        return is_paid;
    }
}
