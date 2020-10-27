package uk.aljoni.modelgen.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public final class Model {
    private final String name;
    private List<Field> fields = new ArrayList<>();
}