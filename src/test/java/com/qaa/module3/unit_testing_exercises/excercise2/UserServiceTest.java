package com.qaa.module3.unit_testing_exercises.excercise2;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qaa.module3.unit_testing_exercises.exercise2.UserService;

public class UserServiceTest {
    private UserService service;

    @BeforeEach
    void setUp() throws Exception {
		service = new UserService();
    }

    @AfterEach
	void tearDown() throws Exception {
		service = null;
	}

    @Test
	void loginValidDetails() {
		// Arrange
		String username = "bobby", password = "Codes1";
		String expected = username;
		service.register(username, password);
		
		// Act
		String actual = service.login(username, password);
		
		// Assert
		Assertions.assertEquals(expected, actual);
	}

    @Test
	void registerNullUsername() {
		// Arrange
		String username = null, password = "Codess";
		String expected = "Username must not be null";
		
		try {
			// Act
			service.register(username, password);
			fail("Expected an IllegalArgumentException due to null username.");
		} catch (IllegalArgumentException iae) {
			// Assert
			Assertions.assertEquals(expected, iae.getMessage());
		}
	}

    @Test
	void registerWhitespaceUsername() {
		// Arrange
		String username = "     ", password = "Codess";
		String expected = "Username must not be whitespace only";
		
		try {
			// Act
			service.register(username, password);
			fail("Expected an IllegalArgumentException due to whitespace username.");
		} catch (IllegalArgumentException iae) {
			// Assert
			Assertions.assertEquals(expected, iae.getMessage());
		}
	}

    @Test
	void registerNullPassword() {
		// Arrange
		String username = "bobby", password = null;
		String expected = "Password must not be null";
		
		try {
			// Act
			service.register(username, password);
			fail("Expected an IllegalArgumentException due to null password.");
		} catch (IllegalArgumentException iae) {
			// Assert
			Assertions.assertEquals(expected, iae.getMessage());
		}
	}

    @Test
	void registerWhitespacePassword() {
		// Arrange
		String username = "bobby", password = "     ";
		String expected = "Password must not be whitespace only";
		
		try {
			// Act
			service.register(username, password);
			fail("Expected an IllegalArgumentException due to whitespace password.");
		} catch (IllegalArgumentException iae) {
			// Assert
			Assertions.assertEquals(expected, iae.getMessage());
		}
	}

    @Test
	void registerInvalidusernameShort() {
		// Arrange
		String username = "bob", password = "Codes12";
		String expected = "Username must contain at least 4 characters";
		
		try {
			// Act
			service.register(username, password);
			fail("Expected an IllegalArgumentException due to short number of characters.");
		} catch (IllegalArgumentException iae) {
			// Assert
			Assertions.assertEquals(expected, iae.getMessage());
		}
	}

    @Test
	void registerInvalidPasswordShort() {
		// Arrange
		String username = "bobby", password = "Code1";
		String expected = "Password must contain at least 6 characters";
		
		try {
			// Act
			service.register(username, password);
			fail("Expected an IllegalArgumentException due to short number of characters.");
		} catch (IllegalArgumentException iae) {
			// Assert
			Assertions.assertEquals(expected, iae.getMessage());
		}
	}

    @Test
void registerInvalidDuplicateUsername() {
    // Arrange
    String username = "bobby";
    String password = "Codes1";
    String expected = "Username already exists";
    
    // Act
    service.register(username, password);
    
    try {
        //Act
        service.register(username, password);
        fail("Expected an IllegalArgumentException for duplicate username.");
    } catch (IllegalArgumentException iae) {
        //Assert
        Assertions.assertEquals(expected, iae.getMessage());
    }
}


    @Test
	void registerInvalidPasswordNoUpperCase() {
		// Arrange
		String username = "bobby", password = "codes1";
		String expected = "Password must contain at least 1 uppercase character";
		
		try {
			// Act
			service.register(username, password);
			fail("Expected an IllegalArgumentException due to missing uppercase character.");
		} catch (IllegalArgumentException iae) {
			// Assert
			Assertions.assertEquals(expected, iae.getMessage());
		}
	}

    @Test
	void registerInvalidPasswordNoLowercase() {
		// Arrange
		String username = "bobby", password = "CODES1";
		String expected = "Password must contain at least 1 lowercase character";
		
		try {
			// Act
			service.register(username, password);
			fail("Expected an IllegalArgumentException due to missing lowercase character.");
		} catch (IllegalArgumentException iae) {
			// Assert
			Assertions.assertEquals(expected, iae.getMessage());
		}
	}

    @Test
	void registerInvalidPasswordNoNumbers() {
		// Arrange
		String username = "bobby", password = "Codess";
		String expected = "Password must contain at least 1 number character";
		
		try {
			// Act
			service.register(username, password);
			fail("Expected an IllegalArgumentException due to missing number character.");
		} catch (IllegalArgumentException iae) {
			// Assert
			Assertions.assertEquals(expected, iae.getMessage());
		}
	}

    @Test
	void loginNullDetails() {
		// Arrange
		String username = null, password = "Codes1";
		String expected = "Username and password must not be null";


        try {
			// Act
		    service.login(username, password);
			fail("Expected an IllegalArgumentException due to null username.");
		} catch (IllegalArgumentException iae) {
			// Assert
			Assertions.assertEquals(expected, iae.getMessage());
		}
	}

    @Test
	void loginEmptyDetails() {
		// Arrange
		String username = "    ", password = "     ";
		String expected = "Username and password must not be empty";

        try {
			// Act
		    service.login(username, password);
			fail("Expected an IllegalArgumentException due to empty username / password.");
		} catch (IllegalArgumentException iae) {
			// Assert
			Assertions.assertEquals(expected, iae.getMessage());
		}
	}

    @Test
	void loginIncorrectUsername() {
		// Arrange
		String username = "bobby", password = "Codes1", incorrectUsername = "Robert";
		String expected = "Invalid username supplied";
		service.register(username, password);

        try {
			// Act
		    service.login(incorrectUsername, password);
			fail("Expected an IllegalArgumentException due to incorrect username.");
		} catch (IllegalArgumentException iae) {
			// Assert
			Assertions.assertEquals(expected, iae.getMessage());
		}
	}

    @Test
	void loginIncorrectPassword() {
		// Arrange
		String username = "bobby", password = "Codes1", incorrectPassword = "Codes2";
		String expected = "Invalid password supplied";
		service.register(username, password);

        try {
			// Act
		    service.login(username, incorrectPassword);
			fail("Expected an IllegalArgumentException due to incorrect password.");
		} catch (IllegalArgumentException iae) {
			// Assert
			Assertions.assertEquals(expected, iae.getMessage());
		}
	}

}
