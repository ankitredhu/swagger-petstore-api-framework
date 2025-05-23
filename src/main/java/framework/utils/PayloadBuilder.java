package framework.utils;

import framework.pojo.Pet;

public class PayloadBuilder {

    public static Pet buildPetPayload(long id, String name, String status) {
        return new Pet(id, name, status);
    }
}
