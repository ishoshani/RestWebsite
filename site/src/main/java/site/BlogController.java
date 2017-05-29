package site;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Calendar;
import java.util.Date;
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


  @RequestMapping("/add")
  public @ResponseBody String addNewBlog(@RequestParam String title){
    Date currentDate = new Date();
    Calendar today = Calendar.getInstance();
    int month = today.get(today.MONTH);
    int year = today.get(today.YEAR);
    Blog n = new Blog(counter.incrementAndGet(),title,month,year,currentDate,currentDate);
    blogRepository.save(n);
    return "Saved";
  }
  @RequestMapping("/find")
  public @ResponseBody Blog findBlog(@RequestParam long id){
    return blogRepository.findOne(id);
  }


  @RequestMapping("/all")
  public @ResponseBody Iterable<Blog> getAll(){
    return blogRepository.findAll();
  }

}
