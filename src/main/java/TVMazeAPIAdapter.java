import java.net.URL;
import java.nio.charset.Charset;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.yamj.api.common.http.DigestedResponse;
import org.yamj.api.common.http.DigestedResponseReader;
import org.yamj.api.common.http.SimpleHttpClientBuilder;

public class TVMazeAPIAdapter {
	// HTTP Status codes
    private static final int HTTP_STATUS_300 = 300;
    private static final int HTTP_STATUS_500 = 500;
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String BASE_URL = "http://api.tvmaze.com/";
    private static final String DELIMITER_FIRST = "?";
    private static final String DELIMITER_SUBSEQUENT = "&";
    private final Charset charset;
	
    private final HttpClient httpClient;
    
    public TVMazeAPIAdapter() {
        this.httpClient = new SimpleHttpClientBuilder().build();
        this.charset = Charset.forName(DEFAULT_CHARSET);
    }
	
    
    public String getSchedule() {
    	DigestedResponse response = null;
		try {
			HttpGet httpGet = new HttpGet(new URL(BASE_URL+"schedule").toURI());
			httpGet.addHeader("accept", "application/json");
			
			
			response = DigestedResponseReader.requestContent(httpClient, httpGet, charset);
			if (response.getStatusCode() >= HTTP_STATUS_500) {
	    		System.out.println("Deu erro 500");
	    	} else if (response.getStatusCode() >= HTTP_STATUS_300) {
	    		System.out.println("deu erro 300");
	    	}
			
		} catch (URISyntaxException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return response.getContent();
    	
    	
    }
	
}
