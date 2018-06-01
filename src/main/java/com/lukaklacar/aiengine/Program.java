package com.lukaklacar.aiengine;

import com.lukaklacar.aiengine.ai.ArtificialIntelligence;
import com.lukaklacar.aiengine.graph.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {

        String s = "The 1988 Atlantic hurricane season was a moderately active season that proved costly and deadly, with 15 tropical cyclones directly affecting land. The season officially began on June 1, 1988, and lasted until November 30, 1988, although activity began on May 30 when a tropical depression developed in the Caribbean Sea. The June through November dates conventionally delimit the period of each year when most tropical cyclones form in the Atlantic basin. The first cyclone to attain tropical storm status was Alberto on August 8, nearly a month later than usual.[1] The final storm of the year, Tropical Storm Keith, became extratropical on November 24." +
                "The season produced 19 tropical depressions of which 12 attained tropical storm status. One tropical storm was operationally classified as a tropical depression but was reclassified in post-analysis. Five tropical cyclones reached hurricane status of which three became major hurricanes reaching Category 3 on the Saffir-Simpson Hurricane Scale." +
                "" +
                "The most notable cyclone of the season was Hurricane Gilbert, which at the time was the strongest Atlantic hurricane on record. The hurricane tracked through the Caribbean Sea and the Gulf of Mexico and caused devastation in Mexico and many island nations, particularly Jamaica. Its passage caused $2.98 billion in damage (1988 USD)[nb 1] and more than 300 deaths, mostly in Mexico. Hurricane Joan, striking Nicaragua as a Category 4 hurricane, caused about US$1.87 billion in damage and more than 200 deaths. The hurricane crossed into the eastern Pacific Ocean and was reclassified as Tropical Storm Miriam.";

        List<StringElement> items = List.of(s.split(" ")).stream().map(StringElement::new).collect(Collectors.toList());

        Graph<StringElement> graph = new Graph<>(items);
        graph.build();

        ArtificialIntelligence<StringElement> ai = new ArtificialIntelligence<>(graph);

        List<StringElement> res = new ArrayList<>(ai.generate(1000));

        System.out.println(res.stream().map(StringElement::getValue).collect(Collectors.joining(" ")));

    }
}
