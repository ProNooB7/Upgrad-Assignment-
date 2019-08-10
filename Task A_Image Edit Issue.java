import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public void deleteOrEditImage(Image image){
try{  
  String id  = inage.getId(); // some serial id 
  String owner = image.getModifiedBy();
  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
   String currentUser = auth.getName();
  if(owner.equals(currentUser)){ 
    log.info("User can delete the image with id" + id);
     display(image);
      makeChanages(image)
   }
  else{
   return "Only the owner of the image can edit the image";
  }
 catch(final Exception ex){ 
   display(image);
   System.out.println("ex.getMessage");
  }
}

public void makeChanges(Image image){
 // changes to the image here 
 }
