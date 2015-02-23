package com.twilio.apiclient;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
 
import java.util.ArrayList;
import java.util.List;
 

public class TwilioClient {

		// Find your Account Sid and Token at twilio.com/user/account
	  public static final String ACCOUNT_SID = "AC99123029ab28e14a87ff3db519031269";
	  public static final String AUTH_TOKEN = "229776490682dab52047265e4bcd8639";
	 
	  public static void main(String[] args) throws TwilioRestException {
	    TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
	    // Build a filter for the MessageList
	    List<NameValuePair> params = new ArrayList<NameValuePair>();
	    params.add(new BasicNameValuePair("Body", "Amit, I love you :)"));
	    //params.add(new BasicNameValuePair("To", "+14085719076"));
	    params.add(new BasicNameValuePair("To", "+14085719076"));
	    params.add(new BasicNameValuePair("From", "+16509008927"));
	 
	    MessageFactory messageFactory = client.getAccount().getMessageFactory();
	    Message message = messageFactory.create(params);
	    System.out.println(message.getSid());
	  }
}
