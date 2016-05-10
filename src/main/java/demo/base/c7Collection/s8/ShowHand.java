package demo.base.c7Collection.s8;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
public class ShowHand {
	// �������Ϸ���֧�ֶ��ٸ����
	private final int PLAY_NUM = 5;
	// �����˿��Ƶ����л�ɫ����ֵ��
	// �����ĸ��������ַ������ڿ���̨��ӡ������, �ݻ� , ���� , ����
	private String[] types = { "\4  ", "\5  ", "\3  ", "\6  " };
	private String[] values = { "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"J", "Q", "K", "A" };
	// card��һ����Ϸ��ʣ�µ��˿���
	private List<String> cards = new LinkedList<String>();
	// �������е����
	private String[] players = new String[PLAY_NUM];
	// ����������ϵ��˿���
	private List<String>[] playersCards = new List[PLAY_NUM];

	/**
	 * ��ʼ���˿��ƣ�����52���˿��ƣ�����ʹ��shuffle���������ǰ����˳������
	 */
	public void initCards() {
		for (int i = 0; i < types.length; i++) {
			for (int j = 0; j < values.length; j++) {
				cards.add(types[i] + values[j]);
			}
		}
		// �������
		Collections.shuffle(cards);
	}

	/**
	 * ��ʼ�����,Ϊÿ����ҷ����û���
	 */
	public void initPlayer(String... names) {
		if (names.length > PLAY_NUM || names.length < 2) {
			// У������������˴�ʹ���쳣���Ƹ�����
			System.out.println("�����������");
			return;
		} else {
			// ��ʼ������û���
			for (int i = 0; i < names.length; i++) {
				players[i] = names[i];
			}
		}
	}

	/**
	 * ��ʼ��������ϵ��˿��ƣ���ʼ��Ϸʱÿ��������ϵ��˿���Ϊ�գ� ����ʹ��һ������Ϊ0��LinkedList����ʾ��
	 */
	public void initPlayerCards() {
		for (int i = 0; i < players.length; i++) {
			if (players[i] != null && !players[i].equals("")) {
				playersCards[i] = new LinkedList<String>();
			}
		}
	}

	/**
	 * ���ȫ���˿��ƣ��÷���û��ʵ�����ã�����������
	 */
	public void showAllCards() {
		for (String card : cards) {
			System.out.println(card);
		}
	}

	/**
	 * ���˿���
	 * 
	 * @param first
	 *            �����ɸ�˭
	 */
	public void deliverCard(String first) {
		// ����ArrayUtils�������search��������ѯ��ָ��Ԫ���������е�����
		int firstPos = ArrayUitls.search(players, first);
		// ���θ�λ�ڸ�ָ�����֮���ÿ��������˿���
		for (int i = firstPos; i < PLAY_NUM; i++) {
			if (players[i] != null) {
				playersCards[i].add(cards.get(0));
				cards.remove(0);
			}
		}
		// ���θ�λ�ڸ�ָ�����֮ǰ��ÿ��������˿���
		for (int i = 0; i < firstPos; i++) {
			if (players[i] != null) {
				playersCards[i].add(cards.get(0));
				cards.remove(0);
			}
		}
	}

	/**
	 * ���������ϵ��˿��� ʵ�ָ÷���ʱ��Ӧ�ÿ���ÿ����ҿ��������˵ĵ�һ���ƣ����˴�û�����Ӹù���
	 */
	public void showPlayerCards() {
		for (int i = 0; i < PLAY_NUM; i++) {
			// ������Ҳ�Ϊ��ʱ
			if (players[i] != null) {
				// ������
				System.out.print(players[i] + " �� ");
				// �������������ϵ��˿���
				for (String card : playersCards[i]) {
					System.out.print(card + "\t");
				}
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		ShowHand sh = new ShowHand();
		System.out.println(Arrays.toString(sh.types));
		sh.initPlayer("�������", "�����");
		sh.initCards();
		sh.initPlayerCards();
		// ������������˿��ƣ�û��ʵ������
		sh.showAllCards();
		System.out.println("---------------");
		// �����"�����"��ʼ����
		sh.deliverCard("�����");
		sh.showPlayerCards();
		/*
		 * ����ط���Ҫ���Ӵ���: 1.�������������ע. 2.��������Ƿ��ע? 3.��Ϸ�Ƿ�ֻʣһ�����?����ǣ�����ʤ���ˡ�
		 * 4.����Ѿ������һ���˿��ƣ�����Ҫ�Ƚ�ʣ����ҵ������С.
		 */
		// �ٴδ�"�������"��ʼ����
		sh.deliverCard("�������");
		sh.showPlayerCards();
	}
}