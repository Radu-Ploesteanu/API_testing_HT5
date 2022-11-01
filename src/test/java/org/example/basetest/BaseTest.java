package org.example.basetest;

import org.example.entities.Pet;

import java.util.Random;

public class BaseTest {

    protected Pet createPet() {
        return new Pet()
                .setId(generateNewId())
                .setName("Dodger")
                .setStatus("active");
    }

    protected Long generateNewId() {
        Random random = new Random();
        long id = random.nextLong();

        while (id < 0) {
            id = id * (-1);
        }
        return id;
    }
}
