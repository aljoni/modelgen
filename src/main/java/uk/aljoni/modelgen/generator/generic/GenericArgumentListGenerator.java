package uk.aljoni.modelgen.generator.generic;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import uk.aljoni.modelgen.generator.ArgumentListGenerator;
import uk.aljoni.modelgen.model.Field;

import java.util.List;

@Builder
public final class GenericArgumentListGenerator implements ArgumentListGenerator {
    private final boolean properties;
    private final boolean multiLine;
    private final boolean ignoreKeys;
    private final boolean ignoreRequired;
    private final List<Field> fields;

    @Override
    public String generate() {
        final StringBuilder sb = new StringBuilder();

        sb.append('{');
        if (multiLine) {
            sb.append('\n');
        }

        for (int i = 0; i < fields.size(); ++i) {
            Field field = fields.get(i);

            if (field.isKey() && ignoreKeys) continue;

            if (multiLine) {
                sb.append("  ");
            }

            if ((field.isRequired() || field.isKey()) && !ignoreRequired) {
                sb.append("@required ");
            }

            if (properties) {
                sb.append("this.");
            } else {
                sb.append(field.getType());
                sb.append(' ');
            }
            sb.append(field.getName());

            if (multiLine) {
                sb.append(",\n");

            } else if (i < fields.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append('}');

        return sb.toString();
    }
}
