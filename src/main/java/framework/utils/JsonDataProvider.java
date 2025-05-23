package framework.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import framework.pojo.Pet;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;

public class JsonDataProvider {

    @DataProvider(name = "addPetData")
    public Object[][] getAddPetData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("src\\main\\resources\\testdata\\addPetData.json");
        Pet[] pets = mapper.readValue(file, Pet[].class);

        Object[][] testData = new Object[pets.length][1];
        for (int i = 0; i < pets.length; i++) {
            testData[i][0] = pets[i];
        }
        return testData;
    }
}
