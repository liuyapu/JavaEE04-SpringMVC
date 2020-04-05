package org.springmvc.class04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springmvc.class04.jdbc.StudentHomeworkJdbc;
import org.springmvc.class04.model.Student;
import org.springmvc.class04.model.TeacherHomework;

import java.util.Date;

/**
 * 添加学生和作业请求
 */

@Controller
@RequestMapping(path = "/add")
public class AddController {

    @RequestMapping(path = "/student")
    public ModelAndView addstudent(String student_id,String student_name){

        ModelAndView modelAndView = new ModelAndView();

        Student s = new Student();
        /**
         * 赋值
         */
        s.setStudentId(Long.parseLong(student_id));
        s.setStudent_name(student_name);
        s.setStudent_password(student_id);
        s.setCreateTime(new Date());

        Boolean result = StudentHomeworkJdbc.addStudent(s);
        if(result) {
            System.out.println("学生添加成功");
           modelAndView.setViewName("/WEB-INF/pages/successadds");
        }else{
            System.out.println("学生添加失败");
            modelAndView.setViewName("/WEB-INF/pages/failedadds");
        }
        return modelAndView;
    }

    @RequestMapping(path = "/homework")
    public ModelAndView addhomework(String homework_id,String title,String content){
        ModelAndView modelAndView = new ModelAndView();

        TeacherHomework sh = new TeacherHomework();
        /**
         * 赋值
         */
        sh.setHomework_id(Long.parseLong(homework_id));
        sh.setHomeworkTitle(title);
        sh.setHomeworkContent(content);
        sh.setCreateTime(new Date());
        sh.setUpdateTime(new Date());

        Boolean result = StudentHomeworkJdbc.addTeacherHomework(sh);
        if(result) {
            System.out.println("作业添加成功");
            modelAndView.setViewName("/WEB-INF/pages/successaddh");
        }else{
            System.out.println("作业添加失败");
            modelAndView.setViewName("/WEB-INF/pages/failedaddh");
        }
        return modelAndView;
    }
}
