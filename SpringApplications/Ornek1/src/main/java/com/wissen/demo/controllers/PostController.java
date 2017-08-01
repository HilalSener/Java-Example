package com.wissen.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wissen.demo.models.Post;

@RestController
public class PostController {
	@RequestMapping("/getDummy")
	public Post getDummy()
	{
		Post p = new Post(-1, "Deneme Post", "Bu post yalandan oluşturuldu.");
		return p;
	}
}
