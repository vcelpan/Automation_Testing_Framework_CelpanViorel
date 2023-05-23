package ProductsAPI.petstore.utils;

public enum RestEndpoint {
    USER("/user", false),
    USER_USERNAME("/user/{username}", true);

    private String endpoint;
    private boolean hasVariable;

    RestEndpoint(String path, boolean hasVariable) {
        this.endpoint = path;
        this.hasVariable = hasVariable;
    }

    public String getEndpoint(){
        return endpoint;
    }

    public String getVariable(){
        int startInd = endpoint.indexOf('{');
        int endInd = endpoint.indexOf('}');

        return endpoint.substring(startInd, endInd+1);
    }
}
