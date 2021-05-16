package tn.esprit.spring.controller;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;


import javax.servlet.http.Part;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tn.esprit.spring.model.Actualite;
import tn.esprit.spring.service.ActualiteServiceImp;


@Controller(value = "UploadFileController") // Name of the bean in Spring IoC
@ELBeanName(value = "UploadFileController")// Name of the bean used by JSF
@Join(path = "/", to = "/vue.jsf")
public class UploadFileController {
	
	public UploadFileController(Part file, String folder, String cin, ActualiteServiceImp ac) {
		super();
		this.file = file;
		this.folder = folder;
		this.cin = cin;
		this.ac = ac;
	}
	
	public UploadFileController(){
		
	}

	private Part file;
	private String folder1 = "./imgeUpload\\";
	//    D:\\PIspring\\Jardin\\src\\main\\webapp\\resources\\imageUpload\\
	private String folder="D:\\PIspring\\Jardin\\src\\main\\webapp\\resources\\imageUpload\\";
	private String cin;
	
	

	@Autowired
	ActualiteServiceImp ac;
	
	public void upload()  {
		//Ajout Localement du fichier
	/*	Scanner s = new Scanner(file.getInputStream());
		String filecontent =s.useDelimiter("\\A").next();
		s.close();
		System.out.println(filecontent);
		Files.write(Paths.get("C:\\"+file.getSubmittedFileName()), filecontent.getBytes(), StandardOpenOption.CREATE);*/
			       
		try (InputStream input = file.getInputStream()) {
			String fileName = file.getSubmittedFileName();
			 Files.copy(input, new File(folder, fileName).toPath());} 
		catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		

	}
	/*
	*/
	
	
	
	public File gatData(){
	String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("./imageUpload/")
			.path(file.getSubmittedFileName()).toUriString();
		   cin = fileDownloadUri;
		   Actualite D = new Actualite();
			//DS.ajouterDossier(D);
		 //  DS.ajouterDossier(new Dossier(cin));
		return null;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	
	

}
