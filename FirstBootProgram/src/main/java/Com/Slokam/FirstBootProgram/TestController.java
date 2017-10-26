package Com.Slokam.FirstBootProgram;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("test")
	public String Test()
	{
		System.out.println("heloooo");
		return "home";
	}
	@RequestMapping("getStudentData")
	public StudentPojo getStudentData(){
		StudentPojo pojo=new StudentPojo(1,"naresh",23,"mca",1234L);
		return pojo;
	}

}
