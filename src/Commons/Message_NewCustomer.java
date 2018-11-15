package Commons;

import java.util.ArrayList;

public class Message_NewCustomer extends Message {
    private static final String ELEMENT_NAME = "name";
	private static final String ELEMENT_AGE = "age";

    private String name;
    private Integer age;
    
    public Message_NewCustomer() {
    	super();
    }

	@Override
	protected void receiveAttributes(ArrayList<NameValue> pairs) {
		this.name = findAttribute(pairs, ELEMENT_NAME);
		this.age = Integer.parseInt(findAttribute(pairs, ELEMENT_AGE));
	}    
	
	@Override
	protected void sendAttributes(ArrayList<NameValue> pairs) {
		pairs.add(new NameValue(ELEMENT_NAME, this.name));
		pairs.add(new NameValue(ELEMENT_AGE, Integer.toString(this.age)));
	}
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
