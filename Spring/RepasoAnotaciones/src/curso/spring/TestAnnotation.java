package curso.spring;

import java.lang.reflect.Field;
import java.util.Iterator;

import curso.spring.annotation.FieldCase;
import curso.spring.annotation.Input;
import curso.spring.entities.StringType;
import curso.spring.entities.User;

public class TestAnnotation {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		testInputAnnotation();
		
	}
	
	
	private static void testInputAnnotation() throws IllegalArgumentException, IllegalAccessException{
		User user = new User();
		user.setUserName("edd1978");
		user.setPassword("abcdef12345");
		
		Field[] fields = user.getClass().getDeclaredFields();
		Input fieldInput = fields[0].getAnnotation(Input.class);
		if(fields[0].get(user).toString().length() < fieldInput.min()) {
			System.out.println("Error de validación. La longitud del campo debe contener mínimo " + fieldInput.min() + " caracteres.");
		} else if(fields[0].get(user).toString().length() > fieldInput.max()) {
			System.out.println("Error de validación. La longitud del campo debe contener máximo " + fieldInput.max() + " caracteres.");
		} else {
			System.out.println("Validación del campo es correcta");
		}
		
		
		for(Field field : fields) {
			if(String.class.equals(field.getType()) && field.getDeclaredAnnotation(FieldCase.class) != null) {
				FieldCase fieldCase = fields[0].getDeclaredAnnotation(FieldCase.class);
				if(fieldCase.caseType().equals(StringType.UPPERCASE)) {
					System.out.println(field.getName() +  " " + field.get(user).toString().toUpperCase());
				}else if(fieldCase.caseType().equals(StringType.LOWERCASE)) {
					System.out.println(field.getName() +  " " + field.get(user).toString().toLowerCase());
				}
			}			
		}	
	}
	
}
