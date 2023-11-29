package bagu.CollectionsTest;

import java.util.*;
import java.util.stream.Collectors;

public class MapTest {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        List<Integer> integerList = Arrays.stream(arr).boxed().collect(Collectors.toList());

    }
}
