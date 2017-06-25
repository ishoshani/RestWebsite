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
  public String body;
  public int month;
  public int year;

  public long getId(){
    return id;
  }
  public void setId(long id){
    this.id = id;
  }
  public String getTitle(){
    return title;
  }
  public String getBody(){
    return body;
  }
  public void setTitle(String title){
    this.title = title;
  }
  public void setBody(String body){
    this.body = body;
  }
  public int getMonth(){
    return month;
  }
  public void setMonth(int month){
    this.month=month;
  }
  public int getYear(){
    return year;
  }
  public void setYear(int year){
    this.year=year;
  }

}
