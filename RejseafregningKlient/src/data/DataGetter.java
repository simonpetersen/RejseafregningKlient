package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
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

	public String putUrl(String url, String urlParameters) throws IOException 
	{
		String resp = null;

		URL newURL = new URL(url);

		HttpURLConnection conn = (HttpURLConnection) newURL.openConnection();
		conn.setReadTimeout(10000);
		conn.setConnectTimeout(15000);
		conn.setRequestMethod("PUT");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setDoInput(true);
		conn.setDoOutput(true);

		String requestBody = urlParameters.toString();
		byte[] outputBytes = requestBody.getBytes();
		OutputStream output = conn.getOutputStream();
		output.write(outputBytes);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line = "";
		StringBuilder responseOutput = new StringBuilder();

		while((line = br.readLine()) != null)
		{
			responseOutput.append(line);
		}

		resp = responseOutput.toString();

		output.close();

		return resp;
	}
}
