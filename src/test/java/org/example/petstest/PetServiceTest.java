package org.example.petstest;


import org.example.basetest.BaseTest;
import org.example.entities.Pet;
import org.example.steps.PetServiceSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PetServiceTest extends BaseTest {
    private final String expectedStatus = "available";

    @Test
    public void getPetByIdTest() {
        List<Pet> petsByStatus = PetServiceSteps.getPetsByStatus(expectedStatus);

        Long expectedId     = petsByStatus.get(0).getId();
        String expectedName = petsByStatus.get(0).getName();

        Pet pet = PetServiceSteps.getPetById(expectedId);

        Assert.assertEquals(pet.getId(), expectedId, "The found ID: " + pet.getId() + " \t\t\t - does not match with: " + expectedId);
        Assert.assertEquals(pet.getName(), expectedName, "The found pet name is: " + pet.getName() + " \t\t\t - does not match with: " + expectedName);
        Assert.assertEquals(pet.getStatus(), expectedStatus, "The status of the found pet is: " + pet.getStatus() + " \t\t\t - does not match with: available");

        int petStatusCode = PetServiceSteps.getPetStatusCodeById(expectedId);
        Assert.assertEquals(petStatusCode, 200, "The received status " + petStatusCode + " code does not match the expected status code: 200");
    }

    @Test
    public void getPetsByStatusTest () {
        List<Pet> petsByStatus = PetServiceSteps.getPetsByStatus(expectedStatus);

        for (Pet byStatus : petsByStatus) {
            Assert.assertEquals(byStatus.getStatus(), expectedStatus, "The pet is unavailable.");
        }
        Assert.assertNotEquals(petsByStatus.size(), 0, "No pets have been found");
    }

    @Test
    public void postPetTest() {
        Pet expectedPet = createPet();
        Pet actualPet = PetServiceSteps.createPet(expectedPet);

        int receivedStatusCode = PetServiceSteps.getPetStatusCodeById(actualPet.getId());

        Assert.assertEquals(receivedStatusCode, 201, "The received status code: " + receivedStatusCode + "\t - should be: 201");
        Assert.assertEquals(actualPet.getName(), expectedPet.getName(), "The found pet is not the expected pet.");
    }
}
