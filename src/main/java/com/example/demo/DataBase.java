package com.example.demo;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBase {
    Map<String, String> wordStore;
    List<Dog> dogTable;

    public DataBase()
    {
        wordStore = new HashMap<>();
        wordStore.put("Sachin", "Sachin is a great batsman. He has scored 30k+ runs");
        wordStore.put("Gates", "Gates is a great person. He has more than 80bn USD");

        dogTable = new ArrayList<>();
        dogTable.add(new Dog(1, "abc", 5, "image/dog/tommy"));
        dogTable.add(new Dog(2, "def", 6, "image/dog/tommy"));
        dogTable.add(new Dog(3, "abc", 7, "image/dog/tommy"));
    }

    public String getInfoAboutWord(String word)
    {
        return wordStore.get(word);
    }

    public List<Dog> getAllDogs()
    {
        return dogTable;
    }

    public List<Dog> getDogsByBreed(String breed)
    {
        List<Dog> resultList = new ArrayList<>();

        for (Dog dog : dogTable)
        {
            if (dog.getBreed().equals(breed))
                resultList.add(dog);
        }

        return resultList;
    }

    public Dog getDogById(int id)
    {
        for (Dog dog : dogTable)
            if (dog.getId() == id)
                return dog;
        return null;
    }
}
