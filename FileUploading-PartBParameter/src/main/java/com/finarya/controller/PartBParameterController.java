package com.finarya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.finarya.entity.Document;
import com.finarya.service.IPartBParameterService;

@Controller
@RequestMapping("/partbparam")
public class PartBParameterController {
	
	@Autowired
	private IPartBParameterService service;
	
	
	@GetMapping("/showUpload")
	public String showUploadPage() {
		return "UploadFilePage";
	}
	
	@PostMapping("/upload")
	public String saveDocument(@RequestParam MultipartFile docOb,Model map) {
		try {
			Document doc = new Document();
			doc.setFName(docOb.getOriginalFilename());
			doc.setDocOb(docOb.getBytes());
			service.saveDocument(doc);
			map.addAttribute("message","FILE UPLOADED SUCCESSFULLY!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "UploadFilePage";
	}
}
