package Com.Slokam.FirstBootProgram;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<StudentPojo, Integer> {
public List<StudentPojo> findByName(String name);
}
