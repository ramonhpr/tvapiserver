import spark.ResponseTransformer;

public class JSONTransformer implements ResponseTransformer {

    @Override
    public String render(Object model) {
        return model.toString();
    }

}