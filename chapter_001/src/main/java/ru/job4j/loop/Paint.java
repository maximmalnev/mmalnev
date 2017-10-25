package ru.job4j.loop;
/**
 * PaintClass.
 */
public class Paint {
    /**
     * Piramid.
     * @param h - высота пирамиды
     * @return  - строковое представление пирамиды
     */
    public String piramid(int h) {
        StringBuilder builder = new StringBuilder();
        String separator = System.getProperty("line.separator");
        for (int i = 1; i <= h; i++) {
            for (int j = 0; j < (h - i); j++) {
                builder.append(" ");
            }
            for (int j = 0; j < (i * 2 - 1); j++) {
                builder.append("^");
            }
            for (int j = 0; j < (h - i); j++) {
                builder.append(" ");
            }
            builder.append(separator);
        }
        return builder.toString();
    }
}
