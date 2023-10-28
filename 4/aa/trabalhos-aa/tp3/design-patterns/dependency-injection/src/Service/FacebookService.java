package Service;

public class FacebookService implements MessageService {
	
	@Override
	public void sendMessage(String message) {
		System.out.println("Facebook: " + message);
	}
}