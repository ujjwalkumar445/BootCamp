package com.example.storage2_exercise;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Employee.class ,version = 1)
public abstract class EmployeeDatabase extends RoomDatabase {

    //now we will have to add the list of database access object that we will use
    public abstract EmployeeDao employeeDao();
    private static EmployeeDatabase instance;

    /*
    setting up room - database
    creating the instance of database
     */

    static synchronized EmployeeDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    EmployeeDatabase.class,"Employee_databse")
                   .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    /**
     * Callback to populate random data
     */

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    /**
     * Populate random data to the database
     */

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private EmployeeDao employeeDao;

        private PopulateDbAsyncTask(EmployeeDatabase db) {
            this.employeeDao = db.employeeDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            employeeDao.insert(new Employee("vibhav", "1234567890", "Delhi"));
            employeeDao.insert(new Employee("Divyansh", "2341573456", "Gurugram"));
            employeeDao.insert(new Employee("bharat", "2346464748", "Delhi"));
            employeeDao.insert(new Employee("Aman", "0238483823", "Haryana"));
            return null;
        }
    }
}
