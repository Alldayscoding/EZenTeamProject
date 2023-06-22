package com.ezen.controller;

import com.ezen.action.AboutAction;
import com.ezen.action.Action;
import com.ezen.action.EventAction;
import com.ezen.action.FAQAction;
import com.ezen.action.MainAction;
import com.ezen.action.ProductAction;
import com.ezen.action.ProductListAction;
import com.ezen.action.ReviewAction;
import com.ezen.action.UserCheckAction;

//Handler Mapping
public class ActionFactory {
	private  static ActionFactory instance = new ActionFactory();
	private ActionFactory(){}
	public static ActionFactory getInstance(){
		return instance;
	}
	public Action getAction(String command) {
		Action action = null;

		if(command.equals("main")) {
			action = new MainAction();
		} else if(command.equals("product")){
			action = new ProductAction();
		} else if(command.equals("event")){
			action = new EventAction();
		}else if(command.equals("review")){
			action = new ReviewAction();
		}else if(command.equals("faq")){
			action = new FAQAction();
		}else if(command.equals("about")) {
			action = new AboutAction();
		}else if(command.equals("product_list")) {
            action = new ProductListAction();
        }else if(command.equals("login")) {
        	action = new UserCheckAction();
        }
		return action;
	}
}