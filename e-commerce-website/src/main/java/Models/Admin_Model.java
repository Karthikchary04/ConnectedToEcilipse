package Models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin_Model
{
	@Id
   private String Username;
   private String Password;

public String getUsername() {
	return Username;
}

public void setUsername(String username) {
	Username = username;
}

public String getPassword() {
	return Password;
}

public void setPassword(String password) {
	Password = password;
}
   
}
