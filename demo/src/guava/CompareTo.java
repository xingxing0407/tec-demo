package guava;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;

/**
 * guava ������
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
		List<Foo> sortedCopy = ordering.sortedCopy(list);//����һ��ָ��Ԫ����Ϊ���򸱱�
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
	
	/**����reverse(): �����뵱ǰOrdering�෴������:
	*����nullsFirst(): ����һ����null����non-nullԪ��֮ǰ��Ordering�������ĺ�ԭʼ��Orderingһ����
	*����nullsLast()������һ����null����non-nullԪ��֮���Ordering�������ĺ�ԭʼ��Orderingһ����
	*����compound(Comparator)������һ��ʹ��Comparator��Ordering��Comparator��Ϊ�ڶ�����Ԫ�أ������bug�б���������ȸ���bug�ļ����ٸ������ȼ���������
	*����lexicographical()������һ�������ֵ�Ԫ�ص�����Ordering��
	*����onResultOf(Function)����functionӦ���ڸ���Ԫ����֮��, ��ʹ��ԭʼordering��������
	*����greatestOf(Iterable iterable, int k)������ָ���ĵ�k���ɵ���������Ԫ�أ���������������С��˳���ǲ��ȶ��ġ�
	*����leastOf(Iterable<E> iterable,int k)������ָ���ĵ�k���ɵ�������С��Ԫ�أ������������С������˳���ǲ��ȶ��ġ�
	*����isOrdered(Iterable)���Ƿ�����Iterable��������2��Ԫ�ء�
	*����isStrictlyOrdered(Iterable)���Ƿ��ϸ�������ע�⣬Iterable������������Ԫ�ء�
	*����sortedCopy(Iterable)������ָ����Ԫ����Ϊһ���б�����򸱱���
	*/

}
