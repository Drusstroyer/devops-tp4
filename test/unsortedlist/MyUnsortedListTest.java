package unsortedlist;

import static org.junit.Assert.*;

import org.junit.Test;

import datastruct.MyUnsortedList;
import datastruct.UnsortedList;

public class MyUnsortedListTest {

	@Test
	public void test_empty() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void test_equals() {
		UnsortedList<Integer> list = MyUnsortedList.of(1);
		UnsortedList<Integer> list2 = MyUnsortedList.of();
		list2.append(1);
		assertTrue(list.equals(list2));
	}
	
	@Test
	public void test_append_pop() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.append(1);
		UnsortedList<Integer> list2 = MyUnsortedList.of(1);
		assertTrue(list.equals(list2));
		list.pop();
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void test_pop_last() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,2,3,4,5,6);
		list.popLast();
		UnsortedList<Integer> list2 = MyUnsortedList.of(1,2,3,4,5);
		assertTrue(list.equals(list2));
		
	}
	
	@Test
	public void test_remove() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,2,3,4,5,6);
		list.remove(3);
		UnsortedList<Integer> list2 = MyUnsortedList.of(1,2,3,5,6);
		assertTrue(list.equals(list2));
		
	}
	@Test
	public void test_prepend() {
		UnsortedList<Integer> list = MyUnsortedList.of(2,3,4,5,6);
		list.prepend(1);
		UnsortedList<Integer> list2 = MyUnsortedList.of(1,2,3,4,5,6);
		assertTrue(list.equals(list2));
		
	}
}
