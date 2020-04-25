package com.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

import javax.xml.bind.JAXBContext;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

@Provider
@Consumes(value = { "application/vnd-account", "application/vnd-student" })
public class CommonBodyReader implements MessageBodyReader<Common> {

	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		return (mediaType.toString().equals("application/vnd-account")
				|| mediaType.toString().equals("application/vnd-student"));
	}

	public Common readFrom(Class<Common> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {
		// TODO Auto-generated method stub
		Common myBean = new Common();

		// JAXBContext jaxbContext = JAXBContext.newInstance(Common.class);
		try {
			InputStreamReader isr = new InputStreamReader(entityStream, StandardCharsets.UTF_8);
			BufferedReader br = new BufferedReader(isr);
			String studnetName = br.readLine();
			Gson gson = new Gson();
			if (mediaType.toString().equals("application/vnd-account")) {
				// JsonReader reader = new JsonReader(new StringReader(studnetName));
				// reader.setLenient(true);
				Account account = gson.fromJson(studnetName, Account.class);
				myBean.setAccount(account);
			} else {
				Student student = gson.fromJson(studnetName, Student.class);
				myBean.setStudent(student);
			}
			// myBean.setName(studnetName);
			// myBean = (Common) jaxbContext.createUnmarshaller().unmarshal(entityStream);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return myBean;
	}

}
