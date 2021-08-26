package com.redirection.url.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redirection.url.repository.UrlRepository;

@Service
public class UrlService {

	@Autowired
	private UrlRepository urlRepository;
	
	public String getFullUrlFromShortUrl(String shortUrl) {
	
		return urlRepository.getFullUrlFromShortUrl(shortUrl);
	}
}
