package Com.Slokam.FirstBootProgram;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentdao;
	
    public void saveStudent(StudentPojo spojo) throws DuplicateNameException {
    	List<StudentPojo> list=studentdao.findByName(spojo.getName());
    	if(list.size()>0){
    		throw new DuplicateNameException();
    	}
	 studentdao.save( spojo);
 }
public StudentPojo getStudentById(Integer id){
	
	return studentdao.findOne(id);
	}

public void saveStudents(@RequestBody List<StudentPojo> students){
	studentdao.save(students);
}

public List<StudentPojo>getAllStudents(){
	return studentdao.findAll();
}

 public void deleteStudent(Integer id){
	 studentdao.delete(id);
 }
 
}
