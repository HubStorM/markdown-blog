package com.framex.blog.blog;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author lijie
 * @date 2018/5/5 23:07
 * @description
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
	
	@Autowired
	private BlogRepository blogReposity;
	
    @RequestMapping("/getAll")
    String getAll(){
    	List<Blog> list = blogReposity.findAll();
        return JSONArray.fromObject(list).toString();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    String get(@PathVariable(name = "id") String id){
    	Optional<Blog> blog = blogReposity.findById(id);
        return JSONObject.fromObject(blog.get()).toString();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    String delete(@PathVariable(name = "id") String id){
    	blogReposity.deleteById(id);
        return "";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes="application/json")
    String save(@RequestBody String request){
    	JSONObject json = JSONObject.fromObject(request);
    	Object id = json.get("id");
    	Blog blog = null;
    	if(id == null){
    		blog = new Blog();
    		blog.setCreateTime(new Date());
    		blog.setTitle(json.getString("title"));
    		blog.setMarkdownContent(json.getString("data"));
    	}
    	else{
    		blog = blogReposity.findById(id.toString()).get();
    		blog.setTitle(json.getString("title"));
    		blog.setMarkdownContent(json.getString("data"));
    		blog.setModifyTime(new Date());
    	}
    	blogReposity.save(blog);
        return "";
    }
    
}
