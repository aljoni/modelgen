package uk.aljoni.modelgen.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class Field {
    private final String name;
    private final String type;
    private boolean key;
    private boolean required;
}
