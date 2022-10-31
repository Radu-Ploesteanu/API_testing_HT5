package org.example.service;

import io.restassured.response.Response;
import org.example.service.uritemplate.UriTemplate;

public class PetService extends CommonService {

    private PetService() {}

    private static PetService instance;

    public static PetService getInstance() {
        if (instance == null) {
            instance = new PetService();
        }
        return instance;
    }

    public Response getRequest(UriTemplate uri, Long id) {
        return super.getRequest(uri.getUri(id));
    }

    public Response getRequest(UriTemplate uri, String status) {
        return super.getRequest(uri.getUri(status));
    }

    public Response postRequest(UriTemplate uri, Object body) {
        return super.postRequest(uri.getUri(), body);
    }
}
