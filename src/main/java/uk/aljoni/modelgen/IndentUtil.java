package uk.aljoni.modelgen;

import java.util.Scanner;

public final class IndentUtil {
    public static String indent(final String source, final int level) {
        final Scanner scanner = new Scanner(source);
        final StringBuilder sb = new StringBuilder();

        while (scanner.hasNextLine()) {
            sb.append("  ".repeat(level));
            sb.append(scanner.nextLine());
            sb.append('\n');
        }

        return sb.toString();
    }
}
