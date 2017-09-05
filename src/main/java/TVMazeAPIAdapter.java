import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.yamj.api.common.http.DigestedResponse;
import org.yamj.api.common.http.DigestedResponseReader;
import org.yamj.api.common.http.SimpleHttpClientBuilder;

public class TVMazeAPIAdapter {
	// HTTP Status codes
    private static final int HTTP_STATUS_300 = 300;
    private static final int HTTP_STATUS_500 = 500;
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String BASE_URL = "http://api.tvmaze.com/";

    private final Charset charset;
	
    private final HttpClient httpClient;
    
    public TVMazeAPIAdapter() {
        this.httpClient = new SimpleHttpClientBuilder().build();
        this.charset = Charset.forName(DEFAULT_CHARSET);
    }
	
    private Object getResponse(HttpGet httpGet)
    {
    	DigestedResponse response = null;
    	JSONArray json = null;
    	JSONObject jsonObj = null;
		try {
			
			httpGet.addHeader("accept", "application/json");
			
			response = DigestedResponseReader.requestContent(httpClient, httpGet, charset);
			if (response.getStatusCode() >= HTTP_STATUS_500) {
	    		System.out.println("Deu erro 500");
	    	} else if (response.getStatusCode() >= HTTP_STATUS_300) {
	    		System.out.println("deu erro 300");
	    	}
			String content = response.getContent();
			if (content.charAt(0) == '[') {
				json = new JSONArray(content);
				return json;
			} else if (content.charAt(0) == '{') {
				jsonObj = new JSONObject(content);
				return jsonObj;
			}
			
		} catch (IOException | JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
    }
    
    
    public JSONArray getSearchShow(String query) {
    	HttpGet httpGet = null;
		try {
			httpGet = new HttpGet(new URL(BASE_URL+"/search/shows?q=:"+query).toURI());
		} catch (MalformedURLException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (JSONArray) getResponse(httpGet);
    }
    
    public JSONArray getSearchPeople(String query) {
    	HttpGet httpGet = null;
		try {
			httpGet = new HttpGet(new URL(BASE_URL+"/search/people?q=:"+query).toURI());
		} catch (MalformedURLException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (JSONArray) getResponse(httpGet);
    }

	public JSONArray getShows() {
		HttpGet httpGet = null;
		try {
			httpGet = new HttpGet(new URL(BASE_URL+"/shows").toURI());
		} catch (MalformedURLException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return (JSONArray) getResponse(httpGet);
	}
	
	public JSONObject getShow(String id) {
		HttpGet httpGet = null;
		try {
			httpGet = new HttpGet(new URL(BASE_URL+"/shows/"+id).toURI());
		} catch (MalformedURLException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (JSONObject) getResponse(httpGet);
	} 
	
}
