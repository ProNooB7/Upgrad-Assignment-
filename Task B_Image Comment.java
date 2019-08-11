import javax.persistence.*;
import lombok.*;

@Data
@Entity // it will tell JPA to create table 'Comment' with following attributes
public class Comment{  
@Id
@GeneratedValue(strategy = GeneratedType.AUTO)
private int id;
private String text;
@Creationtimestamp
private LocalDate createdDate;
@JoinColumn
@OneToMany // each commnet will be assocaiated with single user only
privater User user;
@JoinColumn
@OneToMany  // one connect for one image only
private Image image;
}
/*--------------------------------------------------------------------------------------------------------------------*/
// Controller class to support comments on image 
@Controller
public class CommentController{
  @Autowired
  CommentDAO dao;
 private static Comment comment;
 private static Image image;

  @RequestMapping(value = "/image/{imageid}/{imageTitle}/comments", method = RequestMethod.POST)
  public void addComment(Image image){
   String cmnt = "Wow what a pic bro !!";
    comment.text = cmnt;
    comment.user = image.getCurrentUser();
   this.image = image ;
    dao.insertComment(comment);
   return "viewImage"
   }

  @RequestMapping(value = "/viewImage");
  public Image showImage(){
  return this.iamge;
   }
 
 }

public class CommentDAO{
 Jdbctemplate template;
 public void setTemplate(Jdbc template){
  this.template = template;
  }
public void insertComment(Comment comment){
  String query = "insert into Image(comment, current_user, modified_on )values ("" + comment.text + "," + comment.user + "," + comment.createdDate) where comment.image = image ;
  template.update(query)
  }
}
