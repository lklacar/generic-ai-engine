package com.lukaklacar.aiengine;

import com.lukaklacar.aiengine.ai.ArtificialIntelligence;
import com.lukaklacar.aiengine.graph.Graph;
import com.lukaklacar.aiengine.util.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {

        System.out.println("Reading directory");
        String s = FileUtil.readDirectory("data/bbc/politics").replace('\n', ' ');
        List<StringElement> items = List.of(s.split(" ")).stream().filter(string -> !string.isEmpty()).map(StringElement::new).collect(Collectors.toList());

        System.out.println("Training");
        Graph<StringElement> graph = new Graph<>(items);
        graph.build();

        System.out.println("Generating");
        ArtificialIntelligence<StringElement> ai = new ArtificialIntelligence<>(graph);
        List<StringElement> res = new ArrayList<>(ai.generate(1000));
        System.out.println(res.stream().map(StringElement::getValue).collect(Collectors.joining(" ")));

    }
}
