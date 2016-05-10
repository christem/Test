package demo.base.c7Collection.s3;

import java.util.TreeSet;

/**
 * Description: <br/>
 * Copyright (C), 2005-2008, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
class R2 implements Comparable {
	int count;

	public R2(int count) {
		this.count = count;
	}

	public String toString() {
		return "R2(count����:" + count + ")";
	}

	public boolean equals(Object obj) {
		if (obj instanceof R2) {
			R2 r = (R2) obj;
			if (r.count == this.count) {
				return true;
			}
		}
		return false;
	}

	public int compareTo(Object obj) {
		R2 r = (R2) obj;
		if (this.count > r.count) {
			return 1;
		} else if (this.count == r.count) {
			return 0;
		} else {
			return -1;
		}
	}
}

public class TestTreeSet2 {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet();
		ts.add(new R2(5));
		ts.add(new R2(-3));
		ts.add(new R2(9));
		ts.add(new R2(-2));
		// ��ӡTreeSet���ϣ�����Ԫ�����������е�
		System.out.println(ts);
		// ȡ����һ��Ԫ��
		R2 first = (R2) ts.first();
		// Ϊ��һ��Ԫ�ص�count���Ը�ֵ
		first.count = 20;
		// ȡ�����һ��Ԫ��
		R2 last = (R2) ts.last();
		// Ϊ���һ��Ԫ�ص�count���Ը�ֵ���뵹���ڶ���Ԫ��count������ͬ
		last.count = -2;
		// �ٴ����count������TreeSet���Ԫ�ش�������״̬�������ظ�Ԫ��
		System.out.println(ts);
		// ɾ�����Ա��ı��Ԫ�أ�ɾ��ʧ��
		ts.remove(new R2(-2));
		System.out.println(ts);
		// ɾ������û�иı��Ԫ�أ�ɾ���ɹ�
		ts.remove(new R2(5));
		System.out.println(ts);
	}
}
