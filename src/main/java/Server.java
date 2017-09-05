import static spark.Spark.*;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TVMazeAPIAdapter adapter = new TVMazeAPIAdapter();
		
		path("/search", () -> {
			get("/show/:name", (req, res) -> 		adapter.getSearchShow(req.params(":name")));
			get("/people/:name", (req, res) -> 	adapter.getSearchPeople(req.params(":name")));
		});
		
		path("/shows", () -> {
			get("", (req, res) -> 		adapter.getShows());
			get("/:id", (req, res) -> 	adapter.getShow(req.params(":id")));
		});
	}

}
