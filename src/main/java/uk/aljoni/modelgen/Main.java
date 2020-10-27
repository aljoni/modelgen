package uk.aljoni.modelgen;

import uk.aljoni.modelgen.generator.ModelGenerator;
import uk.aljoni.modelgen.generator.redux.ReduxModelGenerator;
import uk.aljoni.modelgen.model.Field;
import uk.aljoni.modelgen.model.Model;

public final class Main {
    public static void main(final String... args) {
        final Model test = new Model("Person");

        test.getFields().add(Field.builder()
                .name("id")
                .type("String")
                .key(true)
                .build());
        test.getFields().add(Field.builder()
                .name("forename")
                .type("String")
                .required(true)
                .build());
        test.getFields().add(Field.builder()
                .name("surname")
                .type("String")
                .build());

        final ModelGenerator modelGenerator = new ReduxModelGenerator(test);
        System.out.println(modelGenerator.generate());
    }
}
