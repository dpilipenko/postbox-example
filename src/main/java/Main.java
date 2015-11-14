

import java.io.IOException;
import java.util.Properties;

import postbox.PostBox;
import postbox.interfaces.IListener;

public class Main {

	public static void main(String[] args) {
		final int port = getPort();
		final IListener[] listeners = { new PostBoxExampleListener() };
		PostBox.run(port, listeners);
	}
	
	private static int getPort() {
		String val = getPostProperties().getProperty("postbox.port");
		Integer port = new Integer(0);
		try{
			port = Integer.parseInt(val);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return port;
	}
	
	private static Properties getPostProperties() {
		final Properties props = new Properties();
		try {
			props.load(Main.class.getClassLoader().getResourceAsStream("postbox.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}

}
