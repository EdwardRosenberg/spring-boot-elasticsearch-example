package example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "user")
public class User {

	@Id
	private String id;
	
	@Field(type = FieldType.Text)
	private String firstName;
	
	@Field(type = FieldType.Text)
	private String lastName;
	
	@Field(type = FieldType.Keyword)
	private UserType userType;

	public User() {
	}

	public User(String id, String firstName, String lastName, UserType userType) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userType = userType;
	}

	public User(String firstName, String lastName, UserType userType) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userType = userType;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
}