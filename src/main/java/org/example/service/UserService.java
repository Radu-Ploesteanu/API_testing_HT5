package org.example.service;

import io.restassured.response.Response;
import org.example.service.uritemplate.UriTemplate;

public class UserService extends CommonService {

    private UserService() {
//        private constr
//        it will not allow to create the instance of the class with a simple default constructor;
    }

    private static UserService instance;

    // Singleton antipattern:
//          - it has 2 responsabilities: creates and returns
//          - saves instance of itself
    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public Response getRequest(UriTemplate uri) {
        return super.getRequest(uri.getUri());
    }

    public Response getRequest(UriTemplate uri, int id) {
        return super.getRequest(uri.getUri(id));
    }

    public Response postRequest(UriTemplate uri, Object body) {
        return super.postRequest(uri.getUri(), body);
    }

    public void deleteRequest(UriTemplate uri, int id) {
        super.deleteRequest(uri.getUri(id));
    }
}
