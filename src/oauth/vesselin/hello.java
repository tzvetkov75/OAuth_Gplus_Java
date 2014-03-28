package oauth.vesselin;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class hello {

	String text="test text";

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	
}
