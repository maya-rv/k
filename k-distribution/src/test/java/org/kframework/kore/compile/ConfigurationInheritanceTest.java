// Copyright (c) 2015-2016 K Team. All Rights Reserved.

package org.kframework.kore.compile;

import org.junit.Test;
import org.kframework.attributes.Source;
import org.kframework.definition.Module;
import org.kframework.kore.K;
import org.kframework.parser.ProductionReference;
import org.kframework.unparser.AddBrackets;
import org.kframework.unparser.KOREToTreeNodes;
import org.kframework.utils.KoreUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ConfigurationInheritanceTest {
    @Test
    public void simpleTest() throws URISyntaxException, IOException {
        String filename = "/compiler-tests/configuration-inheritance.k";
        KoreUtils utils = new KoreUtils(filename, "C", "C", false);
        System.out.println(utils.compiledDef.executionModule().sentences().mkString("\n"));

        K kResult = utils.stepRewrite(utils.getParsed("x", Source.apply("generated by " + getClass().getSimpleName())), Optional.<Integer>empty());

        Module unparsingModule = utils.getUnparsingModule();

        String actual = KOREToTreeNodes.toString(new AddBrackets(unparsingModule).addBrackets((ProductionReference) KOREToTreeNodes.apply(KOREToTreeNodes.up(unparsingModule, kResult), unparsingModule)));

        assertEquals("Execution failed", "<t> <k> foo </k> <b> x </b> </t>", actual);
    }
}
