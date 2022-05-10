package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Qualifier("toDo")
    @Autowired
    TaskList list;

    @Qualifier("inProgress")
    @Autowired
    TaskList list2;

    @Qualifier("done")
    @Autowired
    TaskList list3;

    @Bean
    public Board getBoard(){
        return new Board(list,list2,list3);
    }

    @Bean(name = "toDo" )
    @Scope("prototype")
    public TaskList getToDoList(){
        return new TaskList();
    }

    @Bean(name = "inProgress" )
    @Scope("prototype")
    public TaskList getInProgressList(){
        return new TaskList();
    }

    @Bean(name = "done" )
    @Scope("prototype")
    public TaskList getDoneList(){
        return new TaskList();
    }
}
