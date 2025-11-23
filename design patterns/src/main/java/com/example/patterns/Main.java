package com.example.patterns;

import com.example.patterns.objectpool.Pool;
import com.example.patterns.datamapper.User;
import com.example.patterns.datamapper.UserMapper;
import com.example.patterns.specification.*;
import com.example.patterns.nullobject.*;
import com.example.patterns.plugin.App;
import com.example.patterns.plugin.GreetPlugin;
import com.example.patterns.plugin.SumPlugin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Pool<StringBuilder> pool = new Pool<>(StringBuilder::new, 2);
    StringBuilder a = pool.acquire();
    pool.release(a);

    UserMapper mapper = new UserMapper();
    mapper.insert(new User(1, "alex"));
    User u = mapper.find(1);

    List<Person> users = Arrays.asList(new Person(20,"US"), new Person(16,"US"), new Person(25,"CA"));
    Spec<Person> spec = new AgeSpec(18).and(new CountrySpec("US"));
    List<Person> result = users.stream().filter(spec::isSatisfiedBy).collect(Collectors.toList());

    Repository repo = new DefaultRepo();
    Saver saver = new Saver();
    saver.save(repo, new ConsoleLogger());
    saver.save(repo, new NullLogger());

    App app = new App();
    app.use(new GreetPlugin());
    app.use(new SumPlugin());
    String g = app.callGreet("bob");
    int s = app.callSum(2,3);
    System.out.println(g + " " + s + " " + (u != null) + " " + result.size());
  }
}
