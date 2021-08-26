package com.redirection.url.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redirection.url.repository.UrlRepository;

@Service
public class UrlService {

	@Autowired
	private UrlRepository urlRepository;
	
	public String getFullUrlFromShortUrl(String shortUrl) {
		
		String urlToMatch="",searchString="",url="";
		
		int lastIndexOfSlash = shortUrl.lastIndexOf('/');
		
		if(lastIndexOfSlash != -1) {
			urlToMatch = shortUrl.substring(0,lastIndexOfSlash);
			searchString = shortUrl.substring(lastIndexOfSlash+1, shortUrl.length());
			url = urlRepository.getFullUrlFromShortUrl(urlToMatch);
		}
		
		if(url.isEmpty() || url == null )
			return null;
		
		return url+searchString;
	}
}
