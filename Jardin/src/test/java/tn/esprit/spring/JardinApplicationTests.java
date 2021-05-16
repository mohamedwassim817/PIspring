package tn.esprit.spring;

import java.text.SimpleDateFormat;

import org.junit.*;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.ParseException;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.model.Category;
import tn.esprit.spring.service.CategoryServiceImp;
@RunWith(SpringRunner.class)
@SpringBootTest
 public class JardinApplicationTests  {
	@Autowired
	CategoryServiceImp ac;
SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
	@Test
	public void contextLoads() throws ParseException {
		ac.create(new Category(4,"ffffffff"));
	}

}
