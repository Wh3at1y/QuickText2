package com.example.smon7958.quicktext2;

import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.telephony.SmsManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author Emily Orton Sydney Nemelka
 */
public class SendTextActivity extends Activity {
 // Declaration section
    private EditText smsMessageField;
    private EditText smsNumberField;
    private Button sendSMSButton;
    private Button emilyNumber;
    private Button samNumber;
    private String setSamNumber;
    private String setEmilyNumber;
    private Button randomButton;
    private ArrayList<String> randomMessage;

    @Override
    // onCreate method, calls the message field, sets sam and Emily's number. Calls a random method.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        randomMessage = new ArrayList<String>();
        buildRandomMessage();
        smsMessageField = (EditText) findViewById(R.id.textMessage);
        smsNumberField = (EditText) findViewById(R.id.userNumber);
        sendSMSButton = (Button) findViewById(R.id.sendSMSButton);
        setSamNumber = "8018797527";
        setEmilyNumber = "8012050112";
        randomButton = (Button) findViewById(R.id.randomButton);

        emilyNumber = (Button) findViewById(R.id.emilyButton);
        samNumber = (Button) findViewById(R.id.samButton);

        setupListeners();
    }

    /**
     * Creates the messages being used for the randomButton.
     */
    private void  buildRandomMessage() {
        randomMessage.add("Hello there ^.^");
        randomMessage.add("Clubbin' time =^-^=");
        randomMessage.add("I am the SEAL ⊙ω⊙");
        randomMessage.add("Gotta be FRESH o.O");
        randomMessage.add("KKK");
        randomMessage.add("Whatter THOOOOOOOOOOOSE??????");
        randomMessage.add("Why not WOBAFUAT");
        randomMessage.add("Count Duko SODUKU");
        randomMessage.add("LEDELLEDELLEDELLEEE");
        randomMessage.add("Can you feel it now MR CRABS???? (・ω<)");

    }

    private String randomMessage(){

            String randomTopic = "";
            int random = (int) (Math.random() * randomMessage.size());
            randomTopic = randomMessage.get(random);
            return randomTopic;

    }

    /**
     * Sets up the listeners for the sendSMSButton, randomButton, contact and rhe message widgets.
     */
    private void setupListeners() {
        sendSMSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View currentView) {
                try {
                    String contact = smsNumberField.getText().toString();
                    String message = smsMessageField.getText().toString();
                    sendSMS(contact, message);

                    Toast.makeText(currentView.getContext(), "message was sent", Toast.LENGTH_SHORT).show();
                } catch (Exception currentExeption) {
                    Toast.makeText(currentView.getContext(), "message was not sent", Toast.LENGTH_LONG).show();
                    Toast.makeText(currentView.getContext(), currentExeption.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

        });
        randomButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View currentView)
            {
               smsMessageField.setText(randomMessage());
            }
        });

        emilyNumber.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View currentView)
            {
                smsNumberField.setText(setEmilyNumber);
            }
        });

        samNumber.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View currentView)
            {
                smsNumberField.setText(setSamNumber);
            }
        });
    }

    private void sendSMS(String messageAddress, String messageContent) {
        SmsManager mySMSManager = SmsManager.getDefault();
        mySMSManager.sendTextMessage(messageAddress, null, messageContent, null, null);
    }
}
