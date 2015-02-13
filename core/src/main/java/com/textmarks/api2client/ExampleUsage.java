package com.textmarks.api2client;

import java.util.*;
import java.io.*;
import java.net.*;
import org.json.*;


/**
 * TextMarks V2 API Client Library Example Usage.
 */
public class ExampleUsage {
	/**
	 * Example code to demonstrate how you might call the API.
	 */
	public void exampleTextMarksUsage()
	{
		try
		{
			TextMarksV2APIClient tmapi;
			Map<String,Object> msoParams;
			JSONObject joResp;

			/*// Most basic echo test:
			System.out.println("Echo test...");
			tmapi = new TextMarksV2APIClient();
			msoParams = new HashMap(); 
			msoParams.put("str", "Hello World");
			joResp = tmapi.call("Test", "echo", msoParams);
			System.out.println("Response: " + joResp.getJSONObject("body").getString("echo"));

			// Check a keyword status:
			System.out.println("Keyword status test...");
			tmapi = new TextMarksV2APIClient();
			msoParams = new HashMap(); 
			tmapi.setApiKey("example_com__418cf4e3");
			msoParams.put("keyword", "DEMOVIP531");
			joResp = tmapi.call("Anybody", "keyword_status", msoParams);
			System.out.println("Keyword Status Code: " + joResp.getJSONObject("body").getString("status"));*/

			/*//Invite a user to join a TextMark group:
			System.out.println("Invite a user to join a TextMark group test...");
			tmapi = new TextMarksV2APIClient();
			msoParams = new HashMap(); 
			tmapi.setApiKey("example_com__418cf4e3");
			msoParams.put("tm", "DEMOVIP531");
			msoParams.put("user", "5103033904");
			joResp = tmapi.call("Anybody", "invite_to_group", msoParams);
			System.out.println("Done.");*/

			// Telephone protection consumer act..
			// Broadcast a message to a TextMark group:
			// DEMOVIP531 TO 41411 
			// replied y to it
			System.out.println("Broadcasting a message to a TextMark group test...");
			tmapi = new TextMarksV2APIClient();
			msoParams = new HashMap(); 
			tmapi.setApiKey("example_com__418cf4e3");
			tmapi.setAuthUser("mesarava"); // (or my TextMarks phone#)
			tmapi.setAuthPass("xengtiz2");
			msoParams.put("tm", "DEMOVIP531");
			msoParams.put("msg", "This is an alert sent from the Java API Client. Did it work???");
			msoParams.put("to", "4085719076");
			joResp = tmapi.call("GroupLeader", "send_one_message", msoParams);
			System.out.println("Done.");
		}
		catch (TextMarksV2APIClientException e) {
			System.out.println("Whoops... Exception caught!");
			System.out.println("Error code: " + e.getCode());
			System.out.println("Exception: " + e.toString());
		}
		catch (Exception ex) {
			System.out.println("Exception cought:\n"+ ex.toString());
		}
	}

	/** 
	 * Main. 
	 */
	public static void main(String[] args) {
		ExampleUsage eg = new ExampleUsage();
		eg.exampleTextMarksUsage();
	}
}