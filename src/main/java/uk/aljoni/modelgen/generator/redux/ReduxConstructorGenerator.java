package uk.aljoni.modelgen.generator.redux;

import lombok.RequiredArgsConstructor;
import uk.aljoni.modelgen.generator.FunctionGenerator;
import uk.aljoni.modelgen.generator.generic.GenericArgumentListGenerator;
import uk.aljoni.modelgen.model.Model;

@RequiredArgsConstructor
public final class ReduxConstructorGenerator implements FunctionGenerator {
    private final Model model;

    @Override
    public String generate() {
        final StringBuilder sb = new StringBuilder();

        sb.append("const ");
        sb.append(model.getName());
        sb.append("(");
        sb.append(GenericArgumentListGenerator.builder()
                .fields(model.getFields())
                .multiLine(true)
                .properties(true)
                .build().generate());
        sb.append(");");

        return sb.toString();
    }
}
