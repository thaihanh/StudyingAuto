package Exercise2.main;

import Exercise1.entity.Student;
import Exercise2.entity.Duration;
import Exercise2.entity.Job;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadJSon {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Job job1 = new Job("ITHS", new Duration("2016-01-01 00:00:00","2016-02-28 00:00:00"),"Database teacher",
                "Teacher for a Database course");
        Job job2 = new Job("GU", new Duration("2016-06-01 00:00:00", "2016-12-31 00:00:00"), "Database teacher",
                "Lecturer for an introductory Java course etc");
        Job job3 = new Job("Yrgo", new Duration("2017-01-01 00:00:00", "2017-01-01 00:00:00"), "Java teacher",
                "Teacher for a Java course");

        List<Job> jobs = new ArrayList<>();
        jobs.add(job1);
        jobs.add(job2);
        jobs.add(job3);

        String json1 = gson.toJson(jobs);
        System.out.println(json1);



        String json2 = "[{\"employer\":\"ITHS\",\"duration\":{\"start\":\"2016-01-01 00:00:00\",\"end\":\"2016-02-28 00:00:00\"}," + "\"title\":\"Database teacher\","
                + "\"description\":\"Teacher for a Database course\"}," +
                "{\"employer\":\"GU\"," + "\"duration\":{\"start\":\"2016-06-01 00:00:00\",\"end\":\"2016-12-31 00:00:00\"},\"title\":\"Database teacher\","
                + "\"description\":\"Lecturer for an introductory Java course etc\"}," +
                "{\"employer\":\"Yrgo\",\"duration\":{\"start\":" + "\"2017-01-01 00:00:00\",\"end\":\"2017-01-01 00:00:00\"},\"title\":\"Java teacher\"," +
                "\"description\":\"Teacher for a Java course\"}]";
        Job[] arr = gson.fromJson(json2, Job[].class);
        List<Job> ls = Arrays.asList(arr);
        ls.forEach(job -> System.out.println(job));
        }
    }
