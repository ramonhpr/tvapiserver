import java.net.URL;
import java.net.MalformedURLException;
import org.apache.http.client.HttpClient;
import org.yamj.api.common.http.DigestedResponse;
import org.yamj.api.common.http.DigestedResponseReader;

public class TVMazeAPIAdapter {
	// HTTP Status codes
    private static final int HTTP_STATUS_300 = 300;
    private static final int HTTP_STATUS_500 = 500;
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String BASE_URL = "http://api.tvmaze.com/";
    private static final String DELIMITER_FIRST = "?";
    private static final String DELIMITER_SUBSEQUENT = "&";
    
    // OPTIONS API
    public static final String OPTION_SCHEDULE = "schedule";
    public static final String OPTION_SEARCH = "search";
    public static final String OPTION_SHOWS = "show";
    public static final String OPTION_PEOPLE = "people";
    
	
    private final HttpClient httpClient;
    
    public TvMazeApi() {
        this.httpClient = new HttpClient();
        this.charset = Charset.forName(DEFAULT_CHARSET);
    }
	
    
    private String get(String request) {
    	final HttpGet httpGet = new HttpGet(new URL(BASE_URL+request).toURI());
    	httpGet.addHeader("accept", "application/json");
    	
    	final DigestedResponse response = DigestedResponseReader.requestContent(httpClient, httpGet, charset);
    	
    	if (response.getStatusCode() >= HTTP_STATUS_500) {
    		System.out.println("Deu erro 500");
    	} else if (response.getStatusCode() >= HTTP_STATUS_300) {
    		System.out.println("deu erro 300");
    	}
    }
	
}
