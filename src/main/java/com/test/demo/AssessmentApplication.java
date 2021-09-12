package com.test.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.test.demo.payload.response.Student;

@SpringBootApplication
public class AssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssessmentApplication.class, args);
		Student s1 = new Student(10001,"Selva",31);
		Student s2 = new Student(10002,"Karthiga",26);
		Student s3 = new Student(10003,"Balaji",27);
		Student s4 = new Student(10004,"Anitha",25);
		Student s5 = new Student(10005,"Mani",21);
		List<Student> studList = Arrays.asList(s1,s2,s3,s4,s5);
		System.out.println(studList.stream().filter(s->s.getName().contains("ni")).collect(Collectors.toList()));
		System.out.println(studList.stream().filter(s->s.getAge()>25).collect(Collectors.toList()));
		System.out.println(studList.stream().filter(s->s.getAge()>25).sorted(Comparator.comparing(Student :: getAge)).collect(Collectors.toList()));
		System.out.println(studList.stream().filter(s->s.getAge()>25).sorted(Comparator.comparing(Student :: getAge).reversed()).collect(Collectors.toList()));
		System.out.println(studList.stream().collect(Collectors.summarizingInt(Student :: getAge)).getSum());
		System.out.println(studList.stream().collect(Collectors.summingInt(Student :: getAge)).intValue());
		System.out.println(studList.stream().collect(Collectors.maxBy(Comparator.comparing(Student :: getAge))));
		System.out.println(studList.stream().map(s->s.getName()).collect(Collectors.joining(",")));
	}

}
