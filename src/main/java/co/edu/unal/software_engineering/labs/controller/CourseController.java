package co.edu.unal.software_engineering.labs.controller;

import co.edu.unal.software_engineering.labs.model.Course;
import co.edu.unal.software_engineering.labs.pojo.CoursePOJO;
import co.edu.unal.software_engineering.labs.service.AssociationService;
import co.edu.unal.software_engineering.labs.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unal.software_engineering.labs.model.Association;
import co.edu.unal.software_engineering.labs.repository.AssociationRepository;
import java.util.List;


@RestController
public class CourseController{

    private final CourseService courseService;
    private AssociationService associationService;

    public CourseController( CourseService courseService, AssociationService associationService ){
        this.courseService = courseService;
        this.associationService = associationService;
    }

    @PostMapping( value = {"/profesor/cursos"} )
    public ResponseEntity<Void> createCourse( @RequestBody CoursePOJO coursePojo ){
        Course course = courseService.mapperCourseEntity( coursePojo );
        if( !courseService.isRightCourse( course ) ){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
        courseService.save( course );
        return new ResponseEntity<>( HttpStatus.CREATED );
    }

    @GetMapping( value = {"/cursosPorId/{user_id}"})
    public List<Association> cursosporid(@PathVariable Integer user_id) {
    List<Association> association = associationService.findByuser(user_id);
        // if( !courseService.isRightCourse( course ) ){
        //     return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        // }
        // courseService.save( course );
        return association;
    
        }

}