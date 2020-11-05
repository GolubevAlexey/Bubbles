/**
 * Bubbles
 * 
 * Язык программирования: Java
 * 
 * @author © Golubev Alexey 2020
 * @version 1.0
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

class Bubbles<T extends List> {

	/** Поле - список значений массива*/
	private T bubbles;

	public static void main(String [] args) {
	
		Random random = new Random();
		List list = new ArrayList<Integer>();
		System.out.println("Source of array:");
		for(int i = 0; i < 100; i ++) {
			int v = random.nextInt(100);
			list.add(v);
			System.out.print(v + ", ");
		}
		
		Bubbles v = new Bubbles(list, new Comparison<Integer>() {
			//сортирует только в одну сторону, поэтому boolean
			public boolean compare(Integer t1, Integer t2) {
				if(t1 > t2) 
					return true;
				else 
					return false;
			}
		});
		
		System.out.println("\nResult:");
			
		list = v.getResult();
		for(Object o: list) {
			System.out.print(o + ",");
		}
		
	}
	
	public Bubbles(T t, Comparison comparable) {
		
		if(t == null)
			throw new NullPointerException("Null for Null");
		bubbles = t;
		int size = t.size();
		for(int i = 0; i < size; i++)
		for(int j = i + 1; j < size; j++) {		
			if(comparable.compare(t.get(i),t.get(j))) {
				Object e = t.get(i);
				t.set(i, t.get(j));
				t.set(j, e);
			}
		}

		
	}
	
	/**
	* Функция возвращает отсортированный список {@link Bubbles#bubbles}
	* @return сортированный список
	*/
	public T getResult() {
		return bubbles;
	}
	
	
	interface Comparison<T> { //Comparatorable 
		public boolean compare(T t1, T t2);
	}
}
