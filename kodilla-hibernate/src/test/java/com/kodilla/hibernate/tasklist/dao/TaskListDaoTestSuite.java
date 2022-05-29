package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    void testFindByListName() {
        TaskList taskList = new TaskList("Zadanie", "ToDo");

        taskListDao.save(taskList);
        String result = taskList.getListName();
        List<TaskList> readTaskName = taskListDao.findByListName(result);

        assertEquals(1, readTaskName.size());

        taskListDao.deleteAll();
    }
}
