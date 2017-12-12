package bbb;

public class User {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int hashCode(){
		return name.hashCode();
	}
	
    public boolean equals(Object obj) {
    	
    	if (obj == null) {
			return false;
		}
    	
    	User u = (User)obj;
    	if (u.getName().equals(this.getName())) {
			return true;
		}
    	return false;
    }
}
