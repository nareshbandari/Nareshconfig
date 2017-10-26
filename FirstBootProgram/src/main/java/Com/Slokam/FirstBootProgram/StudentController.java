package Com.Slokam.FirstBootProgram;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
	Logger  logger=Logger.getLogger(StudentController.class);
	@Autowired
	private StudentService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<StudentPojo> saveStudent(@RequestBody StudentPojo sPojo){
		ResponseEntity<StudentPojo> responseEntity=null;
		try {
			
			responseEntity=new ResponseEntity<>(HttpStatus.OK);
			service.saveStudent(sPojo);
		} catch (DuplicateNameException e) {
		
			responseEntity=new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return responseEntity;
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public StudentPojo getStudentById(Integer id){
		logger.debug("The method started here....+getStudentById");
		StudentPojo std=service.getStudentById(id);
		logger.debug("The student id ...."+std.getId());
		if(std!=null){
			logger.debug("The student id is available in DataBase....");
		}
		logger.debug("Mehod ending here....");
		return std;
	}
	
	@RequestMapping(value="/all",method=RequestMethod.POST)
	public void saveStudents(@RequestBody List<StudentPojo> students){
		service.saveStudents(students);
	}
	
	
	@RequestMapping (value="/all",method=RequestMethod.GET)
	public List<StudentPojo>getAllStudents(){
		return service.getAllStudents();
	}
  @RequestMapping (method=RequestMethod.DELETE)
  public void deleteStudent(Integer id){
 	service.deleteStudent(id);
  }
}
