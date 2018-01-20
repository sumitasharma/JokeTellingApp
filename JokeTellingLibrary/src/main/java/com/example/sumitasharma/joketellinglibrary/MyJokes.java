package com.example.sumitasharma.joketellinglibrary;

import java.util.ArrayList;
import java.util.Arrays;

public class MyJokes {
    private static final ArrayList<String> jokesArrayList =
            new ArrayList<String>(Arrays.asList("You know why you never see elephants hiding up in trees... Because they're really good at it.",
                    "What's the difference between a guitar and a fish. You can't tuna fish.",
                    "What is red and smells like blue paint?. Red paint",
                    "What do you get from a pampered cow? Spoiled milk.",
                    "What do you call bears with no ears? B.",
                    "Did you hear about the hungry clock? It went back four seconds.",
                    "Why dont blind people skydive? Because it scares the crap out of their dogs.",
                    "What do you call a baby monkey? A Chimp off the old block."));

    public String getJokes() {
        int upperLimit = jokesArrayList.size();
        int jokeIndex = (int) Math.floor(Math.random() * upperLimit);
        return jokesArrayList.get(jokeIndex);
    }

}
