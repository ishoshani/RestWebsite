package site;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Blog{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  public long id;
  public String title;
  public int month;
  public int year;
  public Date created_at;
  public Date updated_at;

  public Blog(long id, String title, int month, int year, Date created_at, Date updated_at){
    this.id = id;
    this.title = title;
  }
  public long getId(){
    return id;
  }
  public void setId(long id){
    this.id = id;
  }
  public String getTitle(){
    return title;
  }
  public void setTite(String title){
    this.title = title;
  }

}
