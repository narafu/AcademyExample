package review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Re0428_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set set1 = new HashSet();
		List list1 = new ArrayList();
		Map map1 = new HashMap();

		Set<NoticeView> set2 = new HashSet<NoticeView>();
		List<NoticeView> list2 = new ArrayList<NoticeView>();
		Map map2 = new HashMap(); // Map은 제네릭이 안되는구나.
		
		/*
		 * Set/List/Map 인터페이스
		 * 	- 공통점은 가변배열
		 *  - 차이점은 식별자
		 *  	- Set
		 *  		- 식별자가 없다
		 *  		- 값으로 구분한다.
		 *  		- 열거한다. 입력순서와 출력순서가 같지 않다.
		 *  		- 중복되지 않는다.
		 *  		- 인덱스가 공유되기에 set을 직접 갖지 않는다.
		 *  		- 가장 많이 사용하는 클래스는  HashSet()
		 *  	- List
		 *  		- 식별자는 순서(인덱스)
		 *  		- 중복이 된다.
		 *  		- 배열을 대체할 때 주로 사용
		 *  		- 가장 많이 사용하는 클래스는 ArrayList()
		 *  
		 *  	- Map
		 *  		- 식별자는 사용자가 부여한 키
		 *  		- 키는 중복되지 않는다. 데이터는 중복된다.
		 *  		- 임시객체 쓸 때 주로 사용
		 *  		- 가장 많이 사용하는 클래스는 HashMap()
		 */

	}

}
