package site;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController{
  private final AtomicLong counter = new AtomicLong();

  @RequestMapping("/blog")
  public Blog blog(@RequestParam(value="id",defaultValue = "0") int id){
    return new Blog(id, "test", "this is a test blog");
  }

}
