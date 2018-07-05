package com.RestAssuredAutomation.test;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;



/*import io.restassured.RestAssured;
import io.restassured.response.Response;*/

public class CRUDoperations {

	@Test
	public void getTest()
	{
		Response resp=RestAssured.get("http://localhost:3000/posts");
		int stcode=resp.getStatusCode();
		System.out.println(stcode);
		String respbody=resp.asString();
		System.out.println(respbody);
		Assert.assertEquals(stcode, 200);
	}
	
	@Test
	public void postTest()
	{
		RequestSpecification req = RestAssured.given();
		//we are using given bcz we hav to give certain specifications like body we need json format we hav to select
		req.header("content-Type","application/json");
		JSONObject jobj=new JSONObject();
		jobj.put("id", "15");
		jobj.put("title", "API");
		jobj.put("author","sravs");
		req.body(jobj.toString());
		//this body is for to send the body in postmantool in raw
		Response resp = req.post("http://localhost:3000/posts");
		int stcode=resp.getStatusCode();
		System.out.println(stcode);
		String respbody=resp.asString();
		System.out.println(respbody);
		Assert.assertEquals(stcode, 201);
	}
	
	
	/*@Test
	public void putTest()
	{
		RequestSpecification req = RestAssured.given();
		//we are using given bcz we hav to give certain specifications like body we need json format we hav to select
		req.header("content-Type","application/json");
		JSONObject jobj=new JSONObject();
		jobj.put("id", "15");
		jobj.put("title", "API");
		jobj.put("date", "5 july");
		req.body(jobj.toString());
		//this body is for to send the body in postmantool in raw
		Response resp = req.put("http://localhost:3000/posts/15");
		int stcode=resp.getStatusCode();
		System.out.println(stcode);
		String respbody=resp.asString();
		System.out.println(respbody);
		Assert.assertEquals(stcode, 200);
	}*/
	
	/*@Test
	public void patchTest()
	{
		RequestSpecification req = RestAssured.given();
		//we are using given bcz we hav to give certain specifications like body we need json format we hav to select
		req.header("content-Type","application/json");
		JSONObject jobj=new JSONObject();
		jobj.put("date", "31 july");
		req.body(jobj.toString());
		//this body is for to send the body in postmantool in raw
		Response resp = req.patch("http://localhost:3000/posts/15");
		int stcode=resp.getStatusCode();
		System.out.println(stcode);
		String respbody=resp.asString();
		System.out.println(respbody);
		Assert.assertEquals(stcode, 200);
	}*/
	
	@Test
	public void deleteTest()
	{
		RequestSpecification req = RestAssured.given();
		//we are using given bcz we hav to give certain specifications like body we need json format we hav to select
		Response resp = req.delete("http://localhost:3000/posts/11");
		int stcode=resp.getStatusCode();
		System.out.println(stcode);
		Assert.assertEquals(stcode, 200);
	}
}
