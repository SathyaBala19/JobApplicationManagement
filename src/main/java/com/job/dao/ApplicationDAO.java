package com.job.dao;

import java.util.List;
import com.job.model.Application;

public interface ApplicationDAO {
    void addApplication(Application app);
    List<Application> getAllApplications();
    Application getApplicationById(int id);
    void updateApplication(Application app);
    void deleteApplication(int id);
}