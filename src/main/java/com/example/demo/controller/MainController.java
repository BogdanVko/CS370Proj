package com.example.demo.controller;

import com.example.demo.dto.Teacher;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class MainController {

    private int count = 1;
    private ArrayList<Teacher> list = new ArrayList<>();
    {
        list.add(new Teacher("vk.com", "Bogdan", count++));
    }

    @PutMapping("/teachers")
    public ArrayList<Teacher> changeTeacher(@RequestBody Teacher teacher) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == teacher.getId()) {
                list.set(i, teacher);
            }

        }
        return list;
    }

    @DeleteMapping("/teachers")
    public ArrayList<Teacher> deleteTeacher(@RequestParam Integer id) {

        list.removeIf(teacher -> teacher.getId() == id);

        return list;
    }

    @PostMapping("/teachers")
    public ArrayList<Teacher> addTeacher(@RequestBody Teacher teacher) {

        teacher.setId(++count);
        list.add(teacher);

        return list;
    }

    @GetMapping("/teacher")
    public Teacher getTeacher(@RequestParam Integer id) {
        for (Teacher teacher : list) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }

        return null;
    }

    @GetMapping("/teachers")
    public ArrayList<Teacher> getAllTeachers() {
        System.out.println("Get request called. Accessed array " + list.toString());

        return list;
    }


}
