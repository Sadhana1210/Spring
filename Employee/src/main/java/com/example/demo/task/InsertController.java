package com.example.demo.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InsertController {
@Autowired
TaskService ts;
@PostMapping("insert")
public String insert(@RequestBody Pojo p) {
	int op=ts.insert(p);
	if(op==10) {
		return "give proper field name";
	}
	else if(op==1){
		return "Data inserted"; 
	}
	else {
		return "not inserted";
	}
}
@PostMapping("update111")
public String update(@RequestBody Pojo p) {
	int op=ts.update(p);
	try {
	if(op>0) {
		return "Data updated"+p.getId()+p.getFieldvalue()+p.getValue();
	}
	else {
		return "not updated";
	}}catch(Exception e) {
		return "exe"+e+" "+p.getId()+p.getFieldvalue()+p.getValue();
	}
}
@PostMapping("delete")
public String delete(@RequestBody Pojo p) {
	int op=ts.delete(p);
	if(op>0) {
		return "Data deleted";
	}
	else {
		return "not deleted";
	}

}
@PostMapping("selectall")
public List selectall() {
	return ts.selectall();
}
@PostMapping("select")
public List select(@RequestParam int id) {
	
	List l=ts.select(id);
return l;
	
}
@PostMapping("selectlike")
public List selectlike(@RequestBody Pojo p) {
	
	
	List lo=ts.selectLike(p);
	return lo;
}
@PostMapping("selectrolike")
public List selectrolike(@RequestBody Pojo p) {
	List lo=ts.selectrolike(p);
	return lo;
}
}
