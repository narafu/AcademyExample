package com.newlecture.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Program {

	public static void main(String[] args) {

//		�ݷ���(Collection) : ���̺귯��
//			: ���̺귯���� ����ϴ� ����� �˸� �ȴ�.
//		 	: (����)�迭 <-> �����迭

		Set set = new HashSet(); // set�� �ĺ��ڴ� ����. �� ��ü�� �ĺ����̴�.
		List list = new ArrayList(); // list�� �ĺ��ڴ� ����
		Map map = new HashMap(); // map�� �ĺ��ڴ� ����ڰ� ������ Ű(key)

		
//		< set >
		set.add(3);
		set.add(4);
		set.add(3);
		set.add(4);
		// set�� �ĺ��ڴ� ��
		// ������ �����ϱ⿡ 2��
		// set�� �� �� �ִ�. get�� �� ����. : set.get(0) X;
		// �ĺ��� ���� ���� �ִ� ���� '����'�Ѵ�. ���Ŵ� �ĺ��ڰ� �ʿ����. �ִ� ���� ���� ����ϸ� �ȴ�.
		// set�� �Է¼����� ��¼����� ���� �ʴ�.

		// �������� ������ �ݷ����� ���� set�� ���� ���� �ʴ´�. (������: iterator)
		//// ��Ƽ�����忡�� ������ �ݷ����� �����ϰ� �Ǹ� �Ҿ����� ��ȸ�� �� �� �ִ�. (�ε����� �����Ǳ⿡..)
		////// �ε����� �����帶�� ���� ���� �Ͽ� �������Ѿ� �Ѵ�.
		Iterator it = set.iterator(); // iterator : �����ϱ� ���� �ε����� �߱��ϴ� ����
		while (it.hasNext())
			System.out.println(it.next()); // ���� ������.
		System.out.println("---------- 1 ----------");

		it = set.iterator(); // ������ �ε����� ���� �߱�
		while (it.hasNext())
			System.out.println(it.next());
		System.out.println("---------- 2 ----------");

		// for-each
		//// �ĺ��ڸ� �ŷ����� �ʰ�, ó������ ������ �� ����Ѵ�.
		for (Object n : set)
			System.out.println(n);
		System.out.println("---------- 3 ----------");

		Set set1 = new HashSet();
		set1.add(new Exam());
		set1.add(new Exam(20, 30, 40));
//		set.add("hello");
//		set.add(234.55);

		for (Object n : set1) {
			Exam exam = (Exam) n;
			System.out.println(exam.total());
		}
		System.out.println("---------- 4 ----------");

		Set<Exam> set2 = new HashSet<Exam>(); // Exam ���� �޵���. - ���׸�(Generic):"�����̵� �� �� �ִ�"
		set2.add(new Exam());
		set2.add(new Exam(20, 30, 40));
//		set2.add("hello");
		for (Exam exam : set2) {
			System.out.println(exam.total());
		}
		System.out.println("---------- 5 ----------");

//		< list >
		list.add(3);
		list.add(4);
		list.add(3);
		list.add(4);
		// list�� �ĺ��ڴ� ����
		// ������ �����ϱ⿡ 4��
		// �迭�� ��ü�ؼ� �ַ� ����Ѵ�.

//		< map >
		map.put("id", 1);
		map.put("title", "hello");
		map.put("hit", 0);
		// map�� �ĺ��ڴ� ����ڰ� ������ Ű(key)
		// �ߺ��� ���� ������� �ʴ´�. ('Ű'�� �ߺ��� �� ���� ������)
		// �ӽð�ü�� �� �� �ַ� ����Ѵ�.

//		System.out.println(list.get(0));

	}

//	�ݷ���(Collection) : ���̺귯��
//	(����)�迭 <-> �����迭
//	�����迭�� ����(Set, List, Map)
//	������ ��������, �ĺ����� ����
//	Set�� �ĺ��ڴ�? (X) �� == �ĺ���
////	=> �ߺ����ſ����� ���� ���
//	List�� �ĺ��ڴ�? index
////	=> �迭�� ��ü���� ���� ���
//	Map�� �ĺ��ڴ�? ���� ������ �÷� ��
////	=> ��ü������ ��ü�ϴ� �ӽ� ��ü�� ���� ���

//	�ĺ��ڿ� ������� �����͸� ��ȸ�ϴ� ����� �ʿ伺
////	Iterable �������̽�(iterator())
////	"index", hasNext(), next(); => index�� ����ȭ
////////	�����忡 ������ ���Ÿ� ���ؼ� => iterator()�� ���ؼ� index�� ����ȭ

//  �����ϴ� �����Ͱ� ��ü�� ��쿡 ..
//// 	�� ����� ����ϴ� ������� ������ ��ȯ�ؾ߸� �ϴ� �������� �ִ�.
////	���� ���� ��ȯ���� ġ������ ������ �߻��Ѵ�. - ���Ѿ��� �ƹ� �ڷ����̳� �� �ް� �ȴ�. -> ���׸�
	
}
