package com.order.menu;

import java.util.ArrayList;

/**
 * �ѵ��ƷĿ¼
 */
public class OrderMenu {

	private ArrayList<Integer> order;        //�û���Ĳ�Ʒ��id���������������

	public void init(){
		order = new ArrayList<Integer>();
	}
	
	public ArrayList<Integer> getOrder(){
		if(order==null){
			init();
		}
		return this.order;
	}
}
