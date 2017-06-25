package site;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Calendar;
import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/blog")
public class BlogController{

  private final AtomicLong counter = new AtomicLong();
  @Autowired
  private BlogRepository blogRepository;


  @RequestMapping(value = "/add")
  public @ResponseBody String addNewBlog(@RequestParam String title, @RequestParam String body){
    Calendar today = Calendar.getInstance();
    int month = today.get(today.MONTH);
    int year = today.get(today.YEAR);
    Blog n = new Blog();
    n.title = title;
    n.month= month;
    n.year = year;
    n.body = body;
    blogRepository.save(n);
    return "Saved";
  }
  @RequestMapping(value = "/edit")
  public @ResponseBody String EditBlog(@RequestParam String title, @RequestParam String body, @RequestParam long id){
    Blog updated = blogRepository.findOne(id);
    updated.title = title;
    updated.body = body;
    blogRepository.save(updated);
    return "Saved";
  }
  @RequestMapping(value = "/find")
  public @ResponseBody Blog findBlog(@RequestParam long id){
    return blogRepository.findOne(id);
  }

  @RequestMapping(value = "/all")
  public @ResponseBody Iterable<Blog> getAll(){
    return blogRepository.findAll();
  }

}
