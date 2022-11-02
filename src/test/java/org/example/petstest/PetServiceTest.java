package org.example.petstest;


import org.example.basetest.BaseTest;
import org.example.entities.DeleteResponse;
import org.example.entities.Pet;
import org.example.steps.PetServiceSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PetServiceTest extends BaseTest {
    private final String expectedStatus = AVAILABLE;
    private final List<Pet> petsByStatus = PetServiceSteps.getPetsByStatus(expectedStatus);

    private final Pet expectedPet = createPet(expectedStatus);
    private final Long id = expectedPet.getId();
    private final String name = expectedPet.getName();
    private final Pet actualPet = PetServiceSteps.postNewPet(expectedPet);


    @Test
    public void createPetTest() {
        int receivedStatusCode = PetServiceSteps.getPetStatusCodeById(actualPet.getId());

        Assert.assertEquals(receivedStatusCode, 200, "The received status code: " + receivedStatusCode + "\t - should be: 200");
        Assert.assertEquals(actualPet.getName(), expectedPet.getName(), "The found pet is not the expected pet.");
    }

    @Test(dependsOnMethods = "createPetTest")
    public void getPetByIdTest() {

        Pet pet = PetServiceSteps.getPetById(id);

        Assert.assertEquals(pet.getId(), id, "The found ID: " + pet.getId() + " \t\t\t - does not match with: " + id);
        Assert.assertEquals(pet.getName(), name, "The found pet name is: " + pet.getName() + " \t\t\t - does not match with: " + name);
        Assert.assertEquals(pet.getStatus(), expectedStatus, "The status of the found pet is: " + pet.getStatus() + " \t\t\t - does not match with: available");

        int petStatusCode = PetServiceSteps.getPetStatusCodeById(id);
        Assert.assertEquals(petStatusCode, 200, "The received status " + petStatusCode + " code does not match the expected status code: 200");
    }

    @Test
    public void getPetsByStatusTest () {

        for (Pet byStatus : petsByStatus) {
            Assert.assertEquals(byStatus.getStatus(), expectedStatus, "The pet is unavailable.");
        }
        Assert.assertNotEquals(petsByStatus.size(), 0, "No pets have been found");
    }

    @Test(dependsOnMethods = "getPetByIdTest")
    public void deletePetByIdTest() {
        DeleteResponse response = PetServiceSteps.deletePetById(expectedPet.getId());

        Assert.assertEquals(
                response.getMessage(),
                expectedPet.getId().toString(),
                "The two ID's do not match. The Pet created for deletion was not deleted."
        );
    }
}
