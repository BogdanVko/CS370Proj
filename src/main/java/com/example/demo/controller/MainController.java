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
        list.add(new Teacher("facebook.com", "Alec", count++));
        list.add(new Teacher("myspace.org", "Tor", count++));
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
        System.out.print("Delete called ");
        Boolean isFound = false;


        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                isFound = true;
                System.out.println(list.get(i).getName() + " was removed.");
                list.remove(i);
                
            }
        }
        if(!isFound){
            System.out.println("That ID doesn't exist! Tutor not found, aborting.");
        }

        return list;
    }

    @PostMapping("/teachers")
    public ArrayList<Teacher> addTeacher(@RequestBody Teacher teacher) {
        System.out.println("Added 1 tutor to the list. Total amount now is " + count);
        teacher.setId(++count);
        list.add(teacher);

        return list;
    }

    @GetMapping("/teacher")
    public Teacher getTeacher(@RequestParam Integer id) {
        System.out.print("Get single tutor called ");
        for (Teacher teacher : list) {
            if (teacher.getId() == id) {
                System.out.println(teacher.getName() + " was found.");
                return teacher;
            }
        }

        return null;
    }

    @GetMapping("/teachers")
    public ArrayList<Teacher> getAllTeachers() {
        System.out.println("Get request called. Accessed array " + list.toString());
        System.out.println(Thread.currentThread().getName());
        return list;
    }


}
