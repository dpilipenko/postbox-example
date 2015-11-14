

import java.io.IOException;
import java.io.InputStream;

import org.subethamail.smtp.TooMuchDataException;

import com.dpilipenko.postbox.IListener;

public class PostBoxExampleListener implements IListener {

	public boolean accept(String from, String recipient) {
		return true; // accept all messages
	}

	public void deliver(String from, String recipient, InputStream data) throws TooMuchDataException, IOException {
		log("Received a message from: [" + from + "] intended for: [" + recipient + "]");
	}
	
	private void log(String msg) {
		System.out.println(LOGPREFIX + msg);
	}
	private static final String LOGPREFIX = "[PostBox] - ";
}
