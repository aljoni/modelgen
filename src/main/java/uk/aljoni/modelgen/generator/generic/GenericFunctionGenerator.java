package uk.aljoni.modelgen.generator.generic;

import lombok.Builder;
import uk.aljoni.modelgen.IndentUtil;
import uk.aljoni.modelgen.generator.FunctionGenerator;
import uk.aljoni.modelgen.model.Field;

import java.util.List;

@Builder
public final class GenericFunctionGenerator implements FunctionGenerator {
    private final String name;
    private final String returnType;
    private final List<Field> fields;
    private final String body;
    private final boolean isStatic;
    private final boolean isAsync;
    private final boolean isInline;
    private final boolean ignoreKeys;
    private final boolean ignoreRequired;

    @Override
    public String generate() {
        final StringBuilder sb = new StringBuilder();

        if (isStatic) sb.append("static ");
        if (isAsync) sb.append("Future<");
        sb.append(returnType);
        if (isAsync) sb.append(">");
        sb.append(' ');
        sb.append(name);
        sb.append('(');
        sb.append(GenericArgumentListGenerator.builder()
                .fields(fields)
                .properties(false)
                .ignoreKeys(ignoreKeys)
                .ignoreRequired(ignoreRequired)
                .multiLine(fields.size() >= 3)
                .build().generate());
        sb.append(')');
        if (isAsync) sb.append(" async");

        if (isInline) {
            sb.append(" => ");
            if (body != null) sb.append(body);
            sb.append(';');
        } else {
            sb.append(" {\n");
            if (body != null) sb.append(IndentUtil.indent(body, 1));
            sb.append("}");
        }

        return sb.toString();
    }
}
