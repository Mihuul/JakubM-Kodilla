package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testTaskAdd(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        List<String>doneList = board.getDoneList().getTask();
        doneList.add("Clean your room");

        List<String>inProgressList = board.getInProgressList().getTask();
        inProgressList.add("Do dishes");

        List<String>toDoList = board.getToDoList().getTask();
        toDoList.add("Buy a dog food");

        //Then
        System.out.println("Done: " + Arrays.toString(doneList.toArray()));
        System.out.println("In progress : " + Arrays.toString(inProgressList.toArray()));
        System.out.println("To do : " + Arrays.toString(toDoList.toArray()));

    }
}
