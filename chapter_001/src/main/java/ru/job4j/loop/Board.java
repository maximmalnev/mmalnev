package ru.job4j.loop;
/**
 * BoardClass.
 */
public class Board {
    /**
     * PaintFunction.
     * @param width - ширина поля
     * @param height - высота поля
     * @return - доска в виде строки
     */
    public String paint(int width, int height) {
        StringBuilder builder = new StringBuilder();
        String separator = System.getProperty("line.separator");
        for (int i = 0; i < height; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < width; j++) {
                    if (j % 2 == 0) {
                        builder.append("x");
                    } else {
                        builder.append(" ");
                    }
                }
            } else {
                for (int j = 0; j < width; j++) {
                    if (j % 2 == 0) {
                        builder.append(" ");
                    } else {
                        builder.append("x");
                    }
                }
            }

            builder.append(separator);
        }
        return builder.toString();
    }
}
