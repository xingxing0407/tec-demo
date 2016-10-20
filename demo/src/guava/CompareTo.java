package guava;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;

/**
 * guava 排序器
 * @author zhouxing
 *
 */
public class CompareTo {
	
	class Foo{
		Foo(String sortBy,String notSortBy){
			this.sortedBy = sortBy;
			this.notSortBy = notSortBy;
		}
		String sortedBy;
		String notSortBy;
	}
	
	public void sort(){
		ArrayList<Foo> list = new ArrayList<Foo>();
		Foo foo = new Foo("4","a");
		list.add(foo);
		Foo foo1 = new Foo("2","b");
		list.add(foo1);
		Foo foo2 = new Foo("1","c");
		list.add(foo2);
		Foo foo3 = new Foo("4","d");
		list.add(foo3);
		
		Ordering<Foo> ordering = Ordering.natural().nullsFirst().onResultOf(new Function<Foo,String>(){
			public String apply(Foo foo){
				return foo.sortedBy;
			}
		});
		List<Foo> sortedCopy = ordering.sortedCopy(list);//返回一个指定元素作为排序副本
		System.out.println(sortedCopy);
	}

	
	/**
	 * guava 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompareTo compareTo = new CompareTo();
		compareTo.sort();
	}
	
	/**　　reverse(): 返回与当前Ordering相反的排序:
	*　　nullsFirst(): 返回一个将null放在non-null元素之前的Ordering，其他的和原始的Ordering一样；
	*　　nullsLast()：返回一个将null放在non-null元素之后的Ordering，其他的和原始的Ordering一样；
	*　　compound(Comparator)：返回一个使用Comparator的Ordering，Comparator作为第二排序元素，例如对bug列表进行排序，先根据bug的级别，再根据优先级进行排序；
	*　　lexicographical()：返回一个按照字典元素迭代的Ordering；
	*　　onResultOf(Function)：将function应用在各个元素上之后, 在使用原始ordering进行排序；
	*　　greatestOf(Iterable iterable, int k)：返回指定的第k个可迭代的最大的元素，按照这个从最大到最小的顺序。是不稳定的。
	*　　leastOf(Iterable<E> iterable,int k)：返回指定的第k个可迭代的最小的元素，按照这个从最小到最大的顺序。是不稳定的。
	*　　isOrdered(Iterable)：是否有序，Iterable不能少于2个元素。
	*　　isStrictlyOrdered(Iterable)：是否严格有序。请注意，Iterable不能少于两个元素。
	*　　sortedCopy(Iterable)：返回指定的元素作为一个列表的排序副本。
	*/

}
