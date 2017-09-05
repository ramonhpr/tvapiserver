import static spark.Spark.*;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TVMazeAPIAdapter adapter = new TVMazeAPIAdapter();
		path("/search", () -> {
			
			get("/shows/:name", "application/json", (req, res) -> {
				res.type("application/json");
				return adapter.getSearchShow(req.params(":name"));
			}, new JSONTransformer());
			
			get("/people/:name", "application/json", (req, res) -> {
				res.type("application/json");
				return adapter.getSearchPeople(req.params(":name"));
			},new JSONTransformer());
		});
		
		path("/shows", () -> {
			
			get("", "application/json", (req, res) -> {
				res.type("application/json");
				return adapter.getShows();
			},new JSONTransformer());
			
			get("/:id", "application/json", (req, res) -> {
				res.type("application/json");
				return adapter.getShow(req.params(":id"));
			},new JSONTransformer());
		});
	}

}
