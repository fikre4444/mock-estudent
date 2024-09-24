package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Staff;
import com.example.demo.domain.Student;
import com.example.demo.enums.GenderEnum;
import com.example.demo.enums.RoleEnum;
import com.example.demo.repository.StaffRepository;
import com.example.demo.repository.StudentRepository;
import com.github.javafaker.Faker;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private StaffRepository staffRepo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner startup() {

		return args -> {
			// createStudents(50);
			// createStaff(40);
			// createStudents(100);
			System.out.println("Running");
		};

	}

	public void createStaff(int amount) {
		Faker faker = new Faker();
		String[] departments = {
				"Mechanical Engineering",
				"Chemical Engineering",
				"Industrial Engineering",
				"Civil Engineering",
				"Electrical Engineering"
		};

		for (int i = 0; i < amount; i++) {
			String firstName = faker.name().firstName();
			String lastName = faker.name().lastName();
			String email = firstName + lastName + generateRandom(2) + "@gmail.com";
			String username = "eitm/ur" + generateRandom(6) + "/" + generateRandom(2);
			String password = "1234";
			int forGender = generateFromRange(1, 2);
			GenderEnum gender = forGender == 1 ? GenderEnum.MALE : GenderEnum.FEMALE;
			RoleEnum role = RoleEnum.ROLE_STAFF;
			String department = departments[generateFromRange(0, 4)];
			Float courseLoad = (float) generateFromRange(3, 9);

			Staff staff = Staff.builder()
					.firstName(firstName)
					.lastName(lastName)
					.email(email)
					.username(username)
					.password(password)
					.gender(gender)
					.role(role)
					.department(department)
					.courseLoad(courseLoad)
					.build();

			staffRepo.save(staff);

		}
	}

	public void createStudents(int amount) {
		Faker faker = new Faker();
		String[] departments = {
				"Mechanical Engineering",
				"Chemical Engineering",
				"Industrial Engineering",
				"Civil Engineering",
				"Electrical Engineering"
		};

		for (int i = 0; i < amount; i++) {
			String firstName = faker.name().firstName();
			String lastName = faker.name().lastName();
			String email = firstName + lastName + generateRandom(2) + "@gmail.com";
			String username = "eitm/ur" + generateRandom(6) + "/" + generateRandom(2);
			String password = "1234";
			int forGender = generateFromRange(1, 2);
			GenderEnum gender = forGender == 1 ? GenderEnum.MALE : GenderEnum.FEMALE;
			RoleEnum role = RoleEnum.ROLE_STUDENT;
			String department = departments[generateFromRange(0, 4)];
			String stream = "going";
			Float grade = generateFloatBetween(2.3f, 4.00f);

			Student student = Student.builder()
					.firstName(firstName)
					.lastName(lastName)
					.email(email)
					.username(username)
					.password(password)
					.gender(gender)
					.role(role)
					.department(department)
					.stream(stream)
					.grade(grade)
					.build();

			studentRepo.save(student);
		}
	}

	public String generateRandom(int length) {
		String result = generateFromRange(1, 9) + "";
		for (int i = 0; i < length - 1; i++) {
			result += generateFromRange(0, 9) + "";
		}
		return result;
	}

	public int generateFromRange(int starting, int ending) {
		return (starting + (int) (Math.random() * (ending - starting + 1)));
	}

	public static float generateFloatBetween(float min, float max) {
		return (float) (Math.round((min + (Math.random() * (max - min))) * 100) / 100.0);
	}

}
