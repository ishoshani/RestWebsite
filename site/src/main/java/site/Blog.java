package site;

public class Blog{
  public final int id;
  public final String title;
  public final String body;
  public Blog(int id, String title, String body){
    this.id = id;
    this.title = title;
    this.body = body;
  }
  public int getId(){
    return id;
  }
  public String getTitle(){
    return title;
  }
  public String getBody(){
    return body;
  }
}
