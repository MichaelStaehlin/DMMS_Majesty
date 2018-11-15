package Commons;

import java.util.ArrayList;

public class Message_NewCustomerAccepted extends Message {
    private static final String ELEMENT_NAME = "name";

    private String name;
    
    public Message_NewCustomerAccepted() {
    	super();
    }

	@Override
	protected void receiveAttributes(ArrayList<NameValue> pairs) {
		this.name = findAttribute(pairs, ELEMENT_NAME);
	}    
	
	@Override
	protected void sendAttributes(ArrayList<NameValue> pairs) {
		pairs.add(new NameValue(ELEMENT_NAME, this.name));
	}
     
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
