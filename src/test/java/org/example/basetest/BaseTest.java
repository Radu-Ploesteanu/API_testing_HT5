package org.example.basetest;

import org.example.entities.Pet;

import java.util.Random;

public class BaseTest {
    protected Long ID;
    protected String AVAILABLE = "available";
    protected String PENDING = "pending";
    protected String SOLD = "sold";

    protected Pet createPet(String status) {
        return new Pet()
                .setId(generateNewId())
                .setName("Dodger")
                .setStatus(status);
    }

    protected Long generateNewId() {
        Random random = new Random();
        ID = random.nextLong();

        while (ID < 0) {
            ID = ID * (-1);
        }
        return ID;
    }
}
