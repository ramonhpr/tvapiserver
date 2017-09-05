import static spark.Spark.*;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TVMazeAPIAdapter adapter = new TVMazeAPIAdapter();
		String list = adapter.getSchedule();
		get("/hello", (req, res) -> list);

	}

}
