package com.order.GUI.Impl;

/**
 *����ӿ�
 */
public interface RobotInterface{
	final int DEFAULT_WIDTH = 800;
	final int DEFAULT_HEIGHT = 450;

	void welcome();
	
	void leave();
	
	void orderList(boolean wrong);

	void orderDetails(String type_id, int operate);
	
	void confirmOrder();
}
