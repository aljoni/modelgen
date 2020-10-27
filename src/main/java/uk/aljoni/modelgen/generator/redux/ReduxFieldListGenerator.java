package uk.aljoni.modelgen.generator.redux;

import lombok.RequiredArgsConstructor;
import uk.aljoni.modelgen.generator.FieldListGenerator;
import uk.aljoni.modelgen.model.Field;
import uk.aljoni.modelgen.model.Model;

@RequiredArgsConstructor
public final class ReduxFieldListGenerator implements FieldListGenerator {
    private final Model model;

    @Override
    public String generate() {
        final StringBuilder sb = new StringBuilder();

        for (Field field : model.getFields()) {
            sb.append("final ");
            sb.append(field.getType());
            sb.append(' ');
            sb.append(field.getName());
            sb.append(";\n");
        }

        return sb.toString();
    }
}
