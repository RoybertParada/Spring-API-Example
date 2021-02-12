package com.dbacess.example.app.web;

import com.dbacess.example.app.domain.InstructorDTO;
import com.dbacess.example.app.domain.service.InstructorDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/api/instructors")
public class InstructorController {
    @Autowired
    private InstructorDomainService instructorDomainService;

    @GetMapping("/all")
    public ResponseEntity<List<InstructorDTO>> getAll(){
        return new ResponseEntity<>(instructorDomainService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{instructorId}")
    public ResponseEntity<InstructorDTO> getInstructor(@PathVariable Long instructorId){
        return instructorDomainService.getInstructor(instructorId)
                .map(instructor -> new ResponseEntity<>(instructor, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<InstructorDTO> getByNombre(@PathVariable("name") String name) {
        return instructorDomainService.findByNombre(name)
                .map(instructor -> new ResponseEntity<>(instructor, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<InstructorDTO> save(@RequestBody InstructorDTO instructor) {
        return new ResponseEntity<>(instructorDomainService.save(instructor), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long courseId) {
        if (instructorDomainService.delete(courseId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
