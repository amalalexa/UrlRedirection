package com.redirection.url.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.redirection.url.service.UrlService;
import com.redirection.url.view.UrlView;

@RestController
@CrossOrigin(origins = "http://localhost:8090")
public class UrlController {

	@Autowired
	private UrlService urlService;
	
	@PostMapping("/shortUrl")
	public String redirectToFullUrl(@RequestBody UrlView urlView) throws URISyntaxException
	{
		//RedirectView redirectView = new RedirectView();
		
		String fullUrl = urlService.getFullUrlFromShortUrl(urlView.getShortUrl());
		
		return fullUrl;
		
		/*List<String> requestHeader = new ArrayList<String>();
		requestHeader.add("Content-Type");
		
		
		URI yahoo = new URI("http://localhost:8090");
	    HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setLocation(yahoo);
	    httpHeaders.setAccessControlAllowOrigin("http://localhost:8090");
	    return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);*/
	}
}
