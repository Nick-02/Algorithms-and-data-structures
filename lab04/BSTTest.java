import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class BSTTest {
    private BSTNode bst;
    private Map<Integer, String> map;

    @Before
    public void setUp() {
        bst = new BSTNode();
        map = new HashMap<>();
        List<Integer> keys = new ArrayList<>();

        int start_num = 3;
        int end_num = start_num + 20;

        for (int i = start_num; i < end_num; i++) {
            keys.add(i);
        }

        Collections.shuffle(keys);

        for (int key : keys) {
            String value = "Value: " + key;
            map.put(key, value);
        }
    }

    @After
    public void tearDown() {
        bst = null;
        map.clear();
        map = null;
    }

    @Test
    public void insertElements() {
        fill();
        int count1 = map.size();
        int count2 = bst.getNodeCount();
        Assert.assertEquals(count1, count2);
    }

    @Test
    public void searchExistingElements() {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int key = entry.getKey();
            String expected_value = entry.getValue();
            bst.insert(key, expected_value);
            String actual_value = bst.search(key);
            Assert.assertEquals(expected_value, actual_value);
        }
    }

    @Test
    public void searchNotExistingElement() {
        String actual_value = bst.search(-1);
        Assert.assertNull(actual_value);
    }

    @Test
    public void insertUpdateElements() {
        fill();
        int remove_key = map.keySet().stream().skip(map.size() / 2).findFirst().orElse(null);
        map.remove(remove_key);
        bst.remove(remove_key);
        String new_value = "New value: ";
        bst.insert(remove_key, new_value);
        Assert.assertEquals(new_value, bst.search(remove_key));
        int existing_key = map.keySet().stream().findFirst().orElse(null);
        String updated_value = "Updated value: ";
        bst.insert(existing_key, updated_value);
        Assert.assertEquals(updated_value, bst.search(existing_key));
        int expected_count = map.size() + 2;
        int actual_count = bst.getNodeCount();
        Assert.assertEquals(expected_count, actual_count);
        Assert.assertEquals(updated_value, bst.search(existing_key));
    }

    @Test
    public void removeElement() {
        fill();
        int remove_key = map.keySet().stream().skip(map.size() / 2).findFirst().orElse(null);
        map.remove(remove_key);
        bst.remove(remove_key);
        int expected_count = map.size();
        int actual_count = bst.getNodeCount();
        Assert.assertEquals(expected_count, actual_count);
        Assert.assertNull(bst.search(remove_key));
    }

    private void fill() {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int key = entry.getKey();
            String value = entry.getValue();
            bst.insert(key, value);
        }
    }
}
