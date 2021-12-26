package com.example.workflow.Service;

import com.example.workflow.Model.Project;
import com.example.workflow.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    private int projectId;

    public List<Project> findAllProject(){
        return this.projectRepository.findAll();
    }

    public Project addProject(Project project) {
        return this.projectRepository.save(project);
    }

    public void setChosenProjectId(int id) {
        this.projectId = id;
    }

    public boolean checkProjectIfValid() {
        return this.projectRepository.findById(this.projectId).get().isAvailable();
    }

    public void setProjectAsInvalid(int id) {
        this.projectRepository.findById(id).get().setAvailable(false);
    }

    public int getSelectedProject() {
        return this.projectId;
    }
}
