package coderising.array;

import com.coderising.array.ArrayUtil;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zt on 2017/2/27.
 */
public class ArrayUtilTest {

    private ArrayUtil arrayUtil = null;

    @Before
    public void setUp() {
        arrayUtil = new ArrayUtil();
    }

    @Test
    public void testReverseArray() {
        int[] a = {7, 9, 30, 3};
        int[] expectedReversedA = {3, 30, 9, 7};
        Assert.assertArrayEquals(expectedReversedA, arrayUtil.reverseArray(a));
        int[] b = {7, 9, 30, 3, 4};
        int[] expectedReversedB = {4, 3, 30, 9, 7};
        Assert.assertArrayEquals(expectedReversedB, arrayUtil.reverseArray(b));
    }

    @Test
    public void testRemoveZero() {
        int oldArr[] = {1, 3, 4, 5, 0, 0, 6, 6, 0, 5, 4, 7, 6, 7, 0, 5};
        int[] expected = {1, 3, 4, 5, 6, 6, 5, 4, 7, 6, 7, 5};
        Assert.assertArrayEquals(expected, arrayUtil.removeZero(oldArr));
    }

    @Test
    public void testJoin() {
        int[] array = {3, 8, 9};
        String seperator = "-";
        String joinedString = arrayUtil.join(array, seperator);
        Assert.assertEquals("3-8-9", joinedString);
    }

}
