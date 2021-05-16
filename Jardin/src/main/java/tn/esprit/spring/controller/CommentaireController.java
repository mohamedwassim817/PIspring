package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.model.Commentaire;
import tn.esprit.spring.service.CommentaireServiceImp;
//http://localhost:8085/ProjectMVC/servlet/api/comment
@RequestMapping("api/comment")
@RestController
public class CommentaireController {
	  @Autowired
	  CommentaireServiceImp comment;
	
	
	//http://localhost:8085/ProjectMVC/servlet/api/comment/getCommentList  
    @GetMapping("/getCommentList")
     public List<Commentaire> getcommentList() {
        return comment.findAll();
     }
    
    
    
  //http://localhost:8085/ProjectMVC/servlet/api/comment/addComment  
    @PostMapping("/addComment")
    @ResponseBody
    public Commentaire addCategory(@RequestBody Commentaire c) {
    	Commentaire cat=comment.create(c);
     return  cat;
       }
    
    
//http://localhost:8085/ProjectMVC/servlet/api/comment/updateComment 
   @PutMapping("/updateComment")
   @ResponseBody
    public Commentaire updteCategory(@RequestBody Commentaire c) {
      return comment.update(c);  
       }
   
   
// http://localhost:8081/SpringMVC/servlet/api/comment/removeComment/{comment-id}
    @DeleteMapping("/removeComment/{comment-id}")
    @ResponseBody
    public void removecomment(@PathVariable("comment-id") int commentId) {
     comment.delete(commentId);
 }
    
  

}
