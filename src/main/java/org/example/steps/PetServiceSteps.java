package org.example.steps;

import org.example.entities.Pet;
import org.example.service.PetService;

import java.util.List;

import static org.example.service.uritemplate.PetServiceUri.*;

public class PetServiceSteps {

    private static final PetService PET_SERVICE = PetService.getInstance();

    public static Pet getPetById(Long id) {
        return PET_SERVICE
                .getRequest(PET_BY_ID, id)
                .as(Pet.class);
    }

    public static Integer getPetStatusCodeById(Long id) {
        return PET_SERVICE
                .getRequest(PET_BY_ID, id)
                .statusCode();
    }

    public static List<Pet> getPetsByStatus (String status) {
        return PET_SERVICE
                .getRequest(PETS_BY_STATUS, status)
                .jsonPath()
                .getList("", Pet.class);
    }

    public static Pet createPet(Pet expectedPet) {
        return PET_SERVICE
                .postRequest(PETS, expectedPet)
                .as(Pet.class);
    }
}
