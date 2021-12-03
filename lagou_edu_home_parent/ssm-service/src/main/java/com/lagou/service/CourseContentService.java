package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;

import java.util.List;

/**
 * @author xyf
 * @date 2021/11/25 20:20
 * @description
 */
public interface CourseContentService {

    /*
        根据课程id查询关联的章节信息及章节信息关联的课时信息
     */
    public List<CourseSection> findSectionAndLessonByCourseId(Integer courseId);

    /*
        回显章节对应的课程信息
     */
    public Course findCourseByCourseId(Integer courseId);

    /*
        新增章节信息
     */
    public void saveSection(CourseSection courseSection);

    /*
        更新章节信息
     */
    public void updateSection(CourseSection courseSection);

    /*
        修改章节状态
    */
    public void updateSectionStatus(Integer id,Integer status);

    /*
        新增课时信息
     */
    public void saveLesson(CourseLesson courseLesson);

    /*
        更新课时信息
     */
    public void updateLesson(CourseLesson courseLesson);

}
