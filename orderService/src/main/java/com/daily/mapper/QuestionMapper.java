package com.daily.mapper;

import com.daily.domain.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangjiangtao
 * @date 2017/12/28
 **/
public interface QuestionMapper {

    int batchInsert(@Param("list") List<Question> list);
}
