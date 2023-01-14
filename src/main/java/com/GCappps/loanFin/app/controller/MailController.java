package com.GCappps.loanFin.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.GCappps.loanFin.app.model.Emailattach;
import com.GCappps.loanFin.app.model.EnquiryDetails;
import com.GCappps.loanFin.app.model.SimpleMail;
import com.GCappps.loanFin.app.responce.BaseResponce;
import com.GCappps.loanFin.app.serviceI.MailServiceI;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin("*")
@RestController
@RequestMapping("/GCappps")
public class MailController {
	
	@Autowired
	MailServiceI mailService;
	
	
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	@PostMapping("/sendmail")
	public String sendmail(@RequestBody SimpleMail mail)
	{
		try {
			mailService.sendmail(mail);
			return "Mail sent successfully!!!";
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "Problem in sending mail";
		}
		
	}
	
	@PostMapping("/sendattachmentmail")
	public String sendtp(@RequestPart(value="attachment") MultipartFile attachment,@RequestPart(value = "emailattach") String emailattach)
	{
		ObjectMapper om=new ObjectMapper();
		try {
			String filename=attachment.getOriginalFilename(); 
			Emailattach email=om.readValue(emailattach,Emailattach.class);
			Emailattach eattch=new Emailattach();
			eattch.setToEmail(email.getToEmail());
			eattch.setSubject(email.getSubject());
			eattch.setText(email.getText());
			eattch.setAttachment(attachment.getBytes());
			mailService.sendattachment(eattch,filename);
			return "Mail sent successfully!!!";
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "Problem in sending mail";
		}
	}
	
		
	@PostMapping("/cibilstatus")
	public String sendcibilstatus(@RequestBody EnquiryDetails enquiryDetails)
	{
		try {
			mailService.sendcibilstatus(enquiryDetails);
			return "Mail sent successfully!!!";
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "Problem in sending mail";
		}
		
	}
		
	
	
	
	
	

}
