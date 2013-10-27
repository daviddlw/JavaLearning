package david.annotation;

public class PasswordUtils {

	@UseCase(id = 88, description = "password must contains at least one numeric.")
	public boolean validatePassword(String password) {
		return password.matches("\\w*\\d\\w*");
	}
	
	@UseCase(id = 88)
	public String encryptPassword(String password) {
		return new StringBuilder(password).reverse().toString();
	}
}
