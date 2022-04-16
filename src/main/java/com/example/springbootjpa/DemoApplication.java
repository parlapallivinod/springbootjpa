package com.example.springbootjpa;

import com.example.springbootjpa.entity.Course;
import com.example.springbootjpa.entity.Department;
import com.example.springbootjpa.entity.Student;
import com.example.springbootjpa.repository.CourseRepository;
import com.example.springbootjpa.repository.DepartmentRespository;
import com.example.springbootjpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	DepartmentRespository departmentRespository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		studentRepository.deleteAll();
		courseRepository.deleteAll();
		departmentRespository.deleteAll();

		Department mathDepartment = new Department();
		mathDepartment.setName("Mathematics");

		Course probabilityCourse = new Course();
		probabilityCourse.setName("Probability");
		probabilityCourse.setDepartment(mathDepartment);

		Course statisticsCourse = new Course();
		statisticsCourse.setName("Statistics");
		statisticsCourse.setDepartment(mathDepartment);

		Set<Course> setCourses1 = new HashSet<>();
		setCourses1.add(probabilityCourse);
		setCourses1.add(statisticsCourse);

		mathDepartment.setCourses(setCourses1);
		departmentRespository.save(mathDepartment);


		Department physicsDepartment = new Department();
		physicsDepartment.setName("Physics");

		Course thermodynamicsCourse = new Course();
		thermodynamicsCourse.setName("Thermodynamics");
		thermodynamicsCourse.setDepartment(physicsDepartment);

		Course electricityCourse = new Course();
		electricityCourse.setName("Electricity");
		electricityCourse.setDepartment(physicsDepartment);

		Set<Course> setCourses2 = new HashSet<>();
		setCourses2.add(thermodynamicsCourse);
		setCourses2.add(electricityCourse);

		physicsDepartment.setCourses(setCourses2);
		departmentRespository.save(physicsDepartment);

		Student vinodStudent = new Student();
		vinodStudent.setName("vinod");
		vinodStudent.setCourses(setCourses1);

		Student maheshStudent = new Student();
		maheshStudent.setName("mahesh");
		maheshStudent.setCourses(setCourses1);

		studentRepository.save(vinodStudent);
		studentRepository.save(maheshStudent);
	}
}
