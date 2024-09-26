package com.developer.comu.post.query.service;

import com.developer.common.exception.CustomException;
import com.developer.common.exception.ErrorCode;
import com.developer.comu.post.query.dto.ComuPostResponseDTO;
import com.developer.comu.post.query.mapper.ComuPostMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ComuPostQueryService {

    //    private final SqlSessionTemplate sqlSessionTemplate;
    private final SqlSession sqlSession;

    // 커뮤니티 게시글 전체 조회
    @Transactional(readOnly = true)
    public List<ComuPostResponseDTO> selectAllComuPost(Integer page) {
        int offset = (page - 1) * 10;

        List<ComuPostResponseDTO> comuPostList = sqlSession.getMapper(ComuPostMapper.class).selectAllComuPost(offset);

        return comuPostList;
    }


    //커뮤니티 게시글 코드로 조회
    @Transactional(readOnly = true)
    public ComuPostResponseDTO selectComuPostByCode(Long comuPostCode) {

        ComuPostResponseDTO comuPostResponseDTO = sqlSession.getMapper(ComuPostMapper.class).selectComuPostByCode(comuPostCode);

        if(comuPostCode == null) {
            throw new CustomException(ErrorCode.NOT_FOUND_POST);
        }

        return comuPostResponseDTO;
    }
}