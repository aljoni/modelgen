package uk.aljoni.modelgen.generator.redux;

import lombok.RequiredArgsConstructor;
import uk.aljoni.modelgen.IndentUtil;
import uk.aljoni.modelgen.generator.FieldListGenerator;
import uk.aljoni.modelgen.generator.FunctionGenerator;
import uk.aljoni.modelgen.generator.ModelGenerator;
import uk.aljoni.modelgen.generator.generic.GenericFunctionGenerator;
import uk.aljoni.modelgen.model.Model;

@RequiredArgsConstructor
public final class ReduxModelGenerator implements ModelGenerator {
    private final Model model;

    @Override
    public String generate() {
        final StringBuilder sb = new StringBuilder();

        final FieldListGenerator fieldListGenerator = new ReduxFieldListGenerator(model);
        final FunctionGenerator constructorGenerator = new ReduxConstructorGenerator(model);

        sb.append("@immutable\n");

        sb.append("class ");
        sb.append(model.getName());
        sb.append(" {\n");

        sb.append(IndentUtil.indent(fieldListGenerator.generate(), 1));
        sb.append('\n');

        sb.append(IndentUtil.indent(constructorGenerator.generate(), 1));
        sb.append('\n');

        sb.append(IndentUtil.indent(
                GenericFunctionGenerator.builder()
                        .name("copyWith")
                        .returnType(model.getName())
                        .fields(model.getFields())
                        .isInline(true)
                        .ignoreKeys(true)
                        .ignoreRequired(true)
                        .build().generate(),
                1
        ));

        sb.append("}");

        return sb.toString();
    }
}
