package com.LoginAndRegisterPage.SpringBootProject;



import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		
		User user=new User();
		user.setEmail("Rahull@gamil.com");
		user.setPassword("chanti121");
		user.setFirstName("Chanti");
		user.setLastName("C");
		user.setPhoneNumber("1234567890");
		user.setGender("mail");
		
		User savedUser= repo.save(user);
		
	User existUser=	entityManager.find(User.class, savedUser.getId());
	
	assertThat(existUser.getEmail()).isEqualTo(user.getEmail());


	}

}
