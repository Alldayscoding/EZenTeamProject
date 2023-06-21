package com.ezen.controller;

import com.ezen.action.Action;

//Handler Mapping
public class ActionFactory {
    private  static ActionFactory instance = new ActionFactory();
    private ActionFactory(){}
    public static ActionFactory getInstance(){
        return instance;
    }
    public Action getAction(String command) {
        Action action = null;

/*
        if(command.equals("board_list")) {
            action = new BoardListAction();
        } else if(command.equals("board_add")){
            action = new BoardAddAction();
        } else if(command.equals("board_write_form")){
            action = new BoardWriteAction();
        }else if(command.equals("board_write")){
            action = new BoardWriteForm();
        }else if(command.equals("board_view")){
            action = new BoardViewAction();
        }else if(command.equals("board_check_pass_form")) {
            action = new BoardCheckPassForm();
  
        /*
        * else if (equals.("board_update")
        * action = new BoardUpdateAction();
        * */
        return action;
    }
}
