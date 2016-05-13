package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

public class DataGetter {
	
	public String stringFromUrl(String url) throws IOException {
		InputStream is = new URL(url).openStream();
	    BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	    StringBuilder sb = new StringBuilder();
	    String nl = rd.readLine();
	    while (nl != null) {
	      sb.append(nl + "\n");
	      nl = rd.readLine();
	    }
	    return sb.toString();
	}

}
