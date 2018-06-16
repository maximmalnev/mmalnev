package ru.job4j.set;

public class SimpleSetH<E> {

    private int size, modCoefficient;
    private E[] elements;

    public SimpleSetH(int size) {
        this.size = size;
        this.modCoefficient = size;
        elements = (E[]) new Object[size];
    }

    boolean add(E e) {
        boolean result = false;
        int hNum = (Math.abs(e.hashCode())) % modCoefficient;
        if (elements[hNum] == null) {
            elements[hNum] = e;
            result = true;
        } else {
            for (int i = hNum; i < size; i++) {
                if (elements[i] == null) {
                    elements[i] = e;
                    result = true;
                    break;
                }
                if (i == size - 1 && elements[i] != null) {
                    size += 100;
                    E[] elementsTmp = (E[]) new Object[size];
                    System.arraycopy(elements, 0, elementsTmp, 0, elements.length);
                    elements = elementsTmp;
                    elements[i + 1] = e;
                    break;
                }
            }
        }
        return result;
    }

    boolean contains(E e) {
        boolean result = false;
        int hNum = (Math.abs(e.hashCode())) % modCoefficient;
        if (elements[hNum] != null && elements[hNum].equals(e)) {
            result = true;
        } else {
            for (int i = hNum + 1; i < size; i++) {
                if (elements[i] == null) {
                    break;
                } else if (elements[i].equals(e)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    boolean remove(E e) {
        boolean result = false;
        int hNum = (Math.abs(e.hashCode())) % modCoefficient;
        if (elements[hNum] != null && elements[hNum].equals(e)) {
            elements[hNum] = null;
            result = true;
        } else {
            for (int i = hNum + 1; i < size; i++) {
                if (elements[i] == null) {
                    break;
                } else if (elements[i].equals(e)) {
                    elements[i] = null;
                    result = true;
                    break;
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        SimpleSetH simSet = new SimpleSetH<String>(4);

        String string1 = "language1";
        String string2 = "language2";
        String string3 = "language3";
        String string4 = "language4";
        String string5 = "language5";


        simSet.add(string1);
        simSet.add(string2);
        simSet.add(string3);
        simSet.add(string4);
        simSet.add(string5);
        simSet.remove(string4);



        System.out.println(simSet.contains(string4));
        System.out.println(simSet.contains(string5));
    }

}
