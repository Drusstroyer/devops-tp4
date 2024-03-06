package datastruct;

import static org.junit.Assert.*;

import org.junit.Test;


import datastruct.MyUnsortedList;

// implemented tests sdjhqsjkdhqsjkdhk
public class MyUnsortedListTest {

	
	@Test 
	public void testListEmpty() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		assertTrue("new list to be empty",list.isEmpty());
		list.append(6);
		assertFalse("list has 1 element",list.isEmpty());
		list.remove(0);
		assertTrue("new list had 1element now 0",list.isEmpty());
		
	}

	
	@Test(timeout = 5000)
	public void testListSize() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		assertTrue("new list to be empty",list.size()==0);
		list.append(6);
		assertTrue("new list to be empty",list.size()==1);
		
		list.remove(0);
		assertFalse("list has 0 element",list.size()==1);
		
		// Extra random tests just to implement the timeout 
		
		for(int i=0;i<1000;i++) {
			list.append(i);
			assertTrue("list being appended through for loop",list.size()==i+1);
		}
		
		for(int i=999;i>=0;i--) {
			list.remove(i);
            System.err.println("value i : "+ i);
            System.err.println("Value size list : " + list.size());
			assertTrue("list being shrinked through for loop",list.size()==i);
		}
		
		
	}
	
	
	@Test
    public void testEmptyList() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void testAppend() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        list.append(1);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
    }

    @Test
    public void testPrepend() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        list.prepend(1);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
    }

    @Test
    public void testInsert() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
        list.insert(4, 1);
        assertEquals(4, list.size());
        assertEquals((Integer)4, list.remove(1));
    }

    @Test
    public void testPop() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
        assertEquals((Integer)1, list.pop());
        assertEquals(2, list.size());
    }

    @Test
    public void testPopLast() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
        assertEquals((Integer)3, list.popLast());
        assertEquals(2, list.size());
    }

    @Test
    public void testRemove() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
        assertEquals((Integer)2, list.remove(1));
        assertEquals(2, list.size());
    }

    @Test
    public void testSize() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
        assertEquals(3, list.size());
        list.append(4);
        assertEquals(4, list.size());
        list.prepend(0);
        assertEquals(5, list.size());
        list.remove(2);
        assertEquals(4, list.size());
    }
    
    @Test
    public void testEquals() {
        UnsortedList<Integer> list1 = MyUnsortedList.of(1, 2, 3);
        UnsortedList<Integer> list2 = MyUnsortedList.of(1, 2, 3);
        assertEquals(list1, list2);
    }

    @Test
    public void testNotEquals() {
        UnsortedList<Integer> list1 = MyUnsortedList.of(1, 2, 3);
        UnsortedList<Integer> list2 = MyUnsortedList.of(1, 2, 4);
        assertNotEquals(list1, list2);
    }

    @Test
    public void testToString() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
        assertEquals("MyUnsortedList { size = 3, [1, 2, 3] }", list.toString());
    }



    /* THIS PART OF CODE WILL NOW TEST THAT THE CORRECT EXCEPTIONS ARE THROWN */

    @Test(expected = EmptyListException.class)
    public void testPopEmptyList() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        list.pop(); //Trying to pop on an empty list
    }

    @Test(expected = EmptyListException.class)
    public void testPopLastEmptyList() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        list.popLast(); // Trying to popLast on an empty list
    }

    /*
     * For the 2 functions popLast() and remove() it might be wiser to throw an EmptyListException instead of a outOfBoundIndex as it is more explanatory
     * and relevant for the user
     * UPDATE: this was now implemented we find out that it was actually a bug within the implementation of the user, as the documentation says it should
     * throw an EmptyListException and not IndexOutOfBounds
     */

    @Test(expected = EmptyListException.class)
    public void testRemoveEmptyList() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        list.remove(0); // Trying to remove on an empty list
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertInvalidPosition() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
        list.insert(4, 5); // Trying to insert in an invalid position
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveInvalidPosition() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
        list.remove(5); // Trying to remove in an invalid position
    }

    
}


