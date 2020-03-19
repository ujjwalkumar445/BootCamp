package com.example.storage2_exercise;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class EmViewModel extends AndroidViewModel {

    private EmployeeDatabase employeeDatabase;
    private EmployeeDao employeeDao;
    private LiveData<List<Employee>> allEmployees;

    private String TAG = this.getClass().getSimpleName();
    public EmViewModel(@NonNull Application application) {
        super(application);
//fetching the instance of database
        employeeDatabase = EmployeeDatabase.getInstance(application);
        employeeDao = employeeDatabase.employeeDao();
        allEmployees = employeeDao.getAllEmployees();
    }

    /**
     * Insert employee
     */

    void insert(Employee employee) {
        new InsertEmployeeAsyncTask(employeeDao).execute(employee);
    }

    /**
     * Update employee
     */

    void update(Employee employee) {
        new UpdateEmployeeAsyncTask(employeeDao).execute(employee);
    }

    /**
     * delete employee
     */

    void delete(Employee employee) {
        new DeleteEmployeeAsyncTask(employeeDao).execute(employee);
    }

    /**
     * Insert employee AsyncTask
     */

    private static class InsertEmployeeAsyncTask extends AsyncTask<Employee, Void, Void> {
        private EmployeeDao employeeDao;

        private InsertEmployeeAsyncTask(EmployeeDao employeeDao) {
            this.employeeDao = employeeDao;
        }

        @Override
        protected Void doInBackground(Employee... employees) {
            employeeDao.insert(employees[0]);
            return null;
        }
    }

    /**
     * Update employee AsyncTask
     */

    private static class UpdateEmployeeAsyncTask extends AsyncTask<Employee, Void, Void> {
        private EmployeeDao employeeDao;

        private UpdateEmployeeAsyncTask(EmployeeDao employeeDao) {
            this.employeeDao = employeeDao;
        }

        @Override
        protected Void doInBackground(Employee... employees) {
            employeeDao.update(employees[0]);
            return null;
        }
    }

    /**
     * Delete employee AsyncTask
     */

    private static class DeleteEmployeeAsyncTask extends AsyncTask<Employee, Void, Void> {
        private EmployeeDao employeeDao;

        private DeleteEmployeeAsyncTask(EmployeeDao employeeDao) {
            this.employeeDao = employeeDao;
        }

        @Override
        protected Void doInBackground(Employee... employees) {
            employeeDao.delete(employees[0]);
            return null;
        }
    }
    /**
     * Return all employee
     */

    LiveData<List<Employee>> getAllEmployees() {
        return allEmployees;
    }


}
