package Tochko.LeverXCourse.service;

import java.util.List;

public interface CommonService<T> {
    void save(T t);
    T get(Integer id);
    List<T> listAll();
}
